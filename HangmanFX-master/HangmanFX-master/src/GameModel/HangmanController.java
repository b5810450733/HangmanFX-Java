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
    public Label showName,showtext,status,head,Lhand,Rhand,body,Lleg,Rleg,hinttext;
    @FXML
    public Button enterText,hint;
    @FXML
    public TextField textinput;

    public String wordTouse = "";
    public String[] word = {"football","cat","dog","elephant","tree","book","telephone","java","water","candy",
            "facebook","youtube","twitter", "blackpink","dududu","apple","iphone","unix","hangman","comsci"};
    public String[] vocab;
    public ArrayList<String> under = new ArrayList<>();
    public String showWord = "";
    public String inLetter = "";
    public int countTowin = 0;
    public int countTolost = 0;
    public int ran;
    public int countH = 0;

    @FXML
    public void show_Name(String name){
        showName.setText(name);
    }

    public void calWord(){
        showWord = "";
        Random a = new Random();
        ran = a.nextInt(word.length);
        System.out.println(ran);
        wordTouse = word[ran];
        System.out.println(wordTouse);
        vocab = wordTouse.split("");
        for (int i = 0; i < vocab.length ; i++) {
            under.add("_");
            showWord += "_"+" ";
        }
        showtext.setText(showWord);
        status.setText("Insert Letter");

    }

    @FXML
    public void sendButton(ActionEvent e){
        if (e.getSource().equals(enterText)){
            hangMancalculate();
        }if (e.getSource().equals(hint)){
            Random r= new Random();
            int h1 = r.nextInt(vocab.length);
            int h2 = r.nextInt(vocab.length);
            if (countH == 0){
                hinttext.setText(vocab[h1]);
                countH++;
                System.out.println(countH);
            }else if(countH == 1){
                hinttext.setText(vocab[h2]);
                countH++;
                hinttext.setDisable(true);
                hint.setDisable(true);
            }

        }
    }

    public void hangMancalculate(){
        boolean isTrue = false;
        inLetter = textinput.getText();
        for (int i = 0; i < vocab.length ; i++) {
            if (vocab[i].equals(inLetter)){
                isTrue = true;
                under.set(i,inLetter);
            }
        }
        if (isTrue == true){
            String winword ="";
            showWord = "";
            for (int i = 0; i < under.size() ; i++) {
                showWord += under.get(i)+" ";
                winword += under.get(i);
            }
            countTowin++;
            showtext.setText(showWord);
            status.setStyle("-fx-text-fill: green");
            status.setText("Correct");
            if (countTowin == 6 || winword.equals(wordTouse)){
                status.setText("!!You WIN!!");
                textinput.setDisable(true);
                enterText.setDisable(true);
                hint.setDisable(true);
            }
        }if (isTrue == false){
            countTolost++;
            status.setStyle("-fx-text-fill: red");
            status.setText("Wrong");
            if (countTolost == 1){
                head.setText("O");
            }if (countTolost== 2){
                body.setText("|");
            }if (countTolost == 3){
                Lhand.setText("/");
            }if (countTolost == 4){
                Rhand.setText("\\");
            }if (countTolost == 5){
                Lleg.setText("/");
            }if (countTolost == 6){
                Rleg.setText("\\");
                status.setText("!!YOU LOST!!");
                textinput.setDisable(true);
                enterText.setDisable(true);
                hint.setDisable(true);
            }
        }
        textinput.clear();

    }



}
