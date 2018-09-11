package GameModel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Random;

public class HangmanController {
    @FXML
    public Label showName,showtext,status,head,Lhand,Rhand,body,Lleg,Rleg,hinttext,winwinwin;
    @FXML
    public Button enterText,hint,restart;
    @FXML
    public TextField textinput;
    @FXML
    public Pane color;

    public String wordTouse = "";
    public String[] word = {"football","cat","dog","elephant","tree","book","telephone","java","water","candy",
            "facebook","youtube","twitter", "blackpink","dududu","apple","iphone","unix","hangman","comsci"};
    public String[] vocab;
    public ArrayList<String> under = new ArrayList<>();
    public String showWord = "";
    public String inLetter = "";
    public int countTolost = 0;
    public int ran;
    public int countH = 0;
    public int levelstate;
    public String winword ="";

    @FXML
    public void show_Name(String name){
        showName.setText(name);
        restart.setDisable(true);
    }

    public void calWord(){
        showWord = "";
        Random a = new Random();
        ran = a.nextInt(word.length);
        wordTouse = word[ran];
        System.out.println(wordTouse);
        vocab = wordTouse.split("");
        if (vocab.length <= 3){
            levelstate = 1;
            setBG(levelstate);
        }else if(vocab.length >3 && vocab.length <= 6){
            levelstate = 2;
            setBG(levelstate);
        }else if (vocab.length > 6){
            levelstate = 3;
            setBG(levelstate);
        }
        for (int i = 0; i < vocab.length ; i++) {
            under.add("_");
            showWord += "_"+" ";
        }
        showtext.setText(showWord);
        status.setText("Insert Letter");
    }

    @FXML
    public void setBG(int level){ // color of level
        if (level == 1){
            color.setStyle("-fx-background-color: #70d400");
        }else if (level == 2){
            color.setStyle("-fx-background-color: #f6cd00");
        }else if (level == 3){
            color.setStyle("-fx-background-color: #dd0000");
        }
    }

    @FXML
    public void sendButton(ActionEvent e){
        if (e.getSource().equals(enterText)){
            if (textinput.getText().length() > 1){
                status.setStyle("-fx-text-fill: #ff2a00");
                status.setText("Only 1 letter!");
                textinput.clear();
            }else if (textinput.getText().equals("")){
                status.setStyle("-fx-text-fill: black");
                status.setText("Insert Letter");
            }else if (!textinput.getText().equals("")){
                hangMancalculate();
            }
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

        }if (e.getSource().equals(restart)){
            textinput.clear();
            hinttext.setText("");
            restart.setDisable(true);
            head.setText("");
            body.setText("");
            Lhand.setText("");
            Rhand.setText("");
            Lleg.setText("");
            Rleg.setText("");
            textinput.setDisable(false);
            hint.setDisable(false);
            enterText.setDisable(false);
            hinttext.setDisable(false);
            winwinwin.setText("");
            wordTouse = "";
            showWord = "";
            winword = "";
            under.clear();
            countTolost = 0;
            countH = 0;
            calWord();

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
            winword = "";
            showWord = "";
            for (int i = 0; i < under.size() ; i++) {
                showWord += under.get(i)+" ";
                winword += under.get(i);
            }
            showtext.setText(showWord);
            status.setStyle("-fx-text-fill: #00cb00");
            status.setText("Correct!");
            if (winword.equals(wordTouse)){
                status.setText("!!You WIN!!");
                winwinwin.setStyle("-fx-text-fill: #5c8f6a");
                winwinwin.setText("☺");
                textinput.setDisable(true);
                enterText.setDisable(true);
                hint.setDisable(true);
                restart.setDisable(false);
            }
        }if (isTrue == false){
            countTolost++;
            status.setStyle("-fx-text-fill: red");
            status.setText("Wrong!");
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
                showtext.setText(wordTouse);
                textinput.setDisable(true);
                enterText.setDisable(true);
                hint.setDisable(true);
                restart.setDisable(false);
                hinttext.setDisable(true);
            }
        }
        textinput.clear();

    }



}
