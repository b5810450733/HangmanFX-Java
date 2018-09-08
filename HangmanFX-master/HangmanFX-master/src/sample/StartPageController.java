package sample;

import GameModel.HangmanController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class StartPageController {
    @FXML
    public TextField username;
    @FXML
    public Button start;

    public void startGame (ActionEvent e){
        start = (Button) e.getSource();
        Stage stage = (Stage) start.getScene().getWindow();
        stage.setResizable(false);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GameModel/hangmanFX.fxml"));
        try {
            stage.setScene(new Scene(loader.load(), 320, 290));
            stage.setTitle("HangMan");
            HangmanController controller = (HangmanController) loader.getController();
            controller.show_Name(username.getText());
            controller.calWord();
            stage.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }


}
