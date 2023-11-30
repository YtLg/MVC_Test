package com.example.fxml_demo_lab5;


public class HelloModel {

    public int counter = 0;
    private String numBuffer = "";

    // String stuff
    public String getNumberBuffer() {
        return numBuffer;
    }
    public void setNumBuffer(String buttonText) {
        this.numBuffer = buttonText;
    }

    public void appendText(String buttonText){

        numBuffer = numBuffer + buttonText;
    }

    // Number counters
    public int getCounter() {
        return counter;
    }

    public void incrementCounter() {
        this.counter++;
    }
    public void resetCounter(int numInput) {
        this.counter = 0;
    }


}