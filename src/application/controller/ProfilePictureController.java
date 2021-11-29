package application.controller;

import application.Main;
import application.model.User;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * The ProfilePictureController class is the primary controller dedicated to the
 * ProfilePicture view of the application. When the ProfilePicture scene is staged,
 * the initialize method sets the 'Current Profile Picture' to display the picture
 * the active User is currently using. The User is then able to choose an alternative
 * image to use, if they wish. Once the changes are saved, the image is saved to the
 * User and they are redirected back to the Dashboard.
 *
 * @author TJ English (pcb408)
 * UTSA CS 3443 - Zodial (Group Project)
 * Fall 2021
 */
public class ProfilePictureController implements EventHandler<MouseEvent> {

    @FXML private Pane profPicPane;
    @FXML private ImageView currProfPic;
    @FXML private RadioButton picRadio1;
    @FXML private RadioButton picRadio2;
    @FXML private RadioButton picRadio3;
    @FXML private RadioButton picRadio4;
    @FXML private RadioButton picRadio5;
    @FXML private RadioButton picRadio6;


    /**
     * Method: handle
     * ----------------
     * Handles the Save Changes event that happens in the view. When the user clicks on
     * either the Save Changes or Cancel option in the view, the handle method will take
     * the user back to the Dashboard. If the User chose Save Changes, the handle method
     * will determine which image option was selected by the user. The method then saves
     * the path to that image to the User before redirecting to the Dashboard.
     *
     *      @param event:   onClick event of a button/hyperlink in the view.
     *
     * Returns: N/A
     */
    @FXML
    @Override
    public void handle(MouseEvent event) {
        try {
            Node clickedOption = (Node) event.getSource();
            if (!clickedOption.getId().equalsIgnoreCase("cancel")) {
                String optionChosen = "";

                for (int i = 1; i <= 6; i++) {
                    RadioButton currentRadio = (RadioButton) event.getSource();
                    boolean isSelected = currentRadio.isSelected();
                    if (isSelected) {
                        optionChosen = currentRadio.getId();
                        break;
                    }
                }

                User.ACTIVE_USER.setProfilePicPath("../../../images/" + optionChosen + "_avatar.png");
            }

            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("../view/Dashboard.fxml")));
            Main.stage.setScene(scene);
            Main.stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method: initialize
     * -----------------
     * Sets the 'Current Profile Picture' to display the picture the active
     * User is currently using.
     *
     * Returns: N/A
     */
    @FXML
    private void initialize() {
        currProfPic.setImage(new Image(User.ACTIVE_USER.getProfilePicPath()));
    }

    /**
     * Method: radioButtonSelector
     * -----------------
     * Sets the selected RadioButton depending on the radio or image option the
     * User has chosen, after clearing any previously-selected radios.
     *
     * Returns: N/A
     */
    @FXML
    private void radioButtonSelector(MouseEvent event) {
        Node optionChosen = (Node) event.getSource();
        int idLength = optionChosen.getId().length();
        int optionNumberChosen = optionChosen.getId().charAt(idLength - 1);

        clearRadioSelections();

        ((RadioButton) profPicPane.lookup("picRadio" + optionNumberChosen)).setSelected(true);
    }

    /**
     * Method: clearRadioSelections
     * -----------------
     * Sets the 'selected' value of all radio buttons to false.
     *
     * Returns: N/A
     */
    private void clearRadioSelections() {
        picRadio1.setSelected(false);
        picRadio2.setSelected(false);
        picRadio3.setSelected(false);
        picRadio4.setSelected(false);
        picRadio5.setSelected(false);
        picRadio6.setSelected(false);
    }
}
