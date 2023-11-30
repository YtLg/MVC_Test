package com.example.fxml_demo_lab5;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class HelloController {

    HelloModel model;

    public void init(HelloModel modelInput)
    {
        this.model = modelInput;
        System.out.println(modelInput.getCounter());

    }

    public HelloModel returner()
    {
        return model;
    }

    @FXML
    private ImageView img;

    @FXML
    private Button call;

    @FXML
    private Button eight;

    @FXML
    private Button five;

    @FXML
    private Button four;

    @FXML
    private Button nine;

    @FXML
    private Button one;

    @FXML
    private Button seven;

    @FXML
    private Button six;

    @FXML
    private Text text;

    @FXML
    private Button three;

    @FXML
    private Button two;

    @FXML
    private Button zero;

    @FXML
    void buttonClickHandler(MouseEvent event) {


        Button sourceButton = (Button) event.getSource();
        String temp = sourceButton.getText();

        model.appendText(temp);
        text.setText(model.getNumberBuffer());
        model.incrementCounter();

        }
    }