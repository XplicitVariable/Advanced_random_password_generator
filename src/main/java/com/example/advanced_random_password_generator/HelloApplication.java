package com.example.advanced_random_password_generator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class HelloApplication extends Application {
    TextField numSpecialChars = new TextField();
    Label numSpecialCharsLabel = new Label("Number of Characters");
    TextField numNumbers = new TextField();
    Label numNumbersLabel = new Label("Number of Numbers");
    TextField numChars = new TextField();
    Label numCharsLabel = new Label("Number of Chars");
    Button generatePassword = new Button("Generate Password");
    Label resultLabel = new Label("Result");
    TextField result = new TextField();

    @Override
    public void start(Stage stage) throws IOException {
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't','u', 'v', 'w', 'x', 'y', 'z'};
        char[] specialChars = {'`', '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '-', '+', '=', '[', ']', '{', '}', '\\', '|', ':', ';', '"', '\'', '<', '>', ',', '.', '/', '?'};
        int numbersNum = 10;
        int lettersNum = 26;
        int specialCharsNum = 32;
        GridPane graphics = new GridPane();
        GridPane.setConstraints(numNumbersLabel, 0,0);
        GridPane.setConstraints(numNumbers, 1,0);
        GridPane.setConstraints(numCharsLabel, 0,1);
        GridPane.setConstraints(numChars, 1,1);
        GridPane.setConstraints(numSpecialCharsLabel, 0,2);
        GridPane.setConstraints(numSpecialChars, 1,2);
        GridPane.setConstraints(resultLabel, 0,3);
        GridPane.setConstraints(result, 1,3);
        GridPane.setConstraints(generatePassword, 0,4);

        generatePassword.setOnAction(e->{
            int numberOfNumbers = Integer.parseInt(numNumbers.getText());
            int numberOfCharacters = Integer.parseInt(numChars.getText());
            int numberOfSpecialCharacters = Integer.parseInt(numSpecialChars.getText());
            Random rand = new Random();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <numberOfNumbers; i++){
                sb.append(numbers[rand.nextInt(numbersNum - 1 +1) +1]);
            }
            for (int a = 0; a <numberOfCharacters; a++){
                sb.append(letters[rand.nextInt(lettersNum -1+1) +1]);
            }
            for (int b = 0; b <numberOfSpecialCharacters; b++){
                sb.append(specialChars[rand.nextInt(specialCharsNum -1+1) +1]);
            }

            List<Integer> places = new ArrayList<>();
            StringBuilder tb = new StringBuilder();
            String message = sb.toString();
            for ( int i = 0; i <sb.length(); i++){
                places.add(i);

            }
            Collections.shuffle(places);
            for (int i = 0; i < places.size(); i++){
                tb.append(message.charAt(places.get(i)));

            }
           result.appendText(tb.toString());
        });

        Scene scene = new Scene(graphics, 320, 240);
        stage.setTitle("Advanced Random Password Generator");
        stage.setScene(scene);
        graphics.getChildren().addAll(result, resultLabel, generatePassword, numSpecialChars, numSpecialCharsLabel, numChars, numCharsLabel, numNumbers, numNumbersLabel);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}