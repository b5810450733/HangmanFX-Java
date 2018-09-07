package GameModel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Random;

public class HangmanController {
    @FXML
    public Label showName,showtext,status;
    @FXML
    public Button send;

    public String wordTouse = "";
    public String[] word = {"football","cat","dog"};
    public String[] vocab;
    public String under ="";
    public boolean gameOver = false;

    @FXML
    public void show_Name(String name){
        showName.setText(name);
    }

    public void calWord(){
        Random a = new Random();
        int ran = a.nextInt(word.length);
        System.out.println(ran);
        wordTouse = word[ran];
        System.out.println(wordTouse);
        vocab = wordTouse.split("");
        for (int i = 0; i < vocab.length ; i++) {
            under += "_"+" ";
        }
        showtext.setText(under);
        status.setText("Insert Letter");

    }

    @FXML
    public void sendButton(ActionEvent e){
        if (e.equals(send)){

        }
    }
    
    public void hangMancalculate(){

    }



}
