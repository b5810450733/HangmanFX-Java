package GameModel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Random;

public class HangmanController {
    @FXML
    public Label showName,showtext,status;
    @FXML
    public Button enterText;
    @FXML
    public TextField textinput;

    public String wordTouse = "";
    public String[] word = {"football","cat","dog"};
    public String[] vocab;
    public ArrayList<String> under = new ArrayList<>();
    public String inLetter = "";
    public int countTowin = 0;
    public int countTolost = 0;
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
            under.add("_"+"");
 //           under += "_"+" ";
        }
        status.setText("Insert Letter");

    }

    @FXML
    public void sendButton(ActionEvent e){
        if (e.getSource().equals(enterText)){
            hangMancalculate();
        }
    }

    public void hangMancalculate(){
        boolean isTrue = false;
        inLetter = textinput.getText();
        for (int i = 0; i < vocab.length ; i++) {
            if (vocab[i].equals(inLetter)){
                isTrue = true;
            }
        }
        if (isTrue == true){
            countTowin++;
            status.setText("Correct");
        }

    }



}
