package com.example.fxml_demo_lab5;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class BlockMoveSuper extends Application {



    @Override
    public void start(Stage stage) throws Exception {

        // sets the root and scene
        Group root = new Group();

        BlockThing block = new BlockThing(0, 0, root);

        // creates a new scene and puts the root in it.
        Scene scene = new Scene(root);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                block.handle(keyEvent);
            }
        });

        // sets stage parameters
        stage.setWidth(500);
        stage.setHeight(500);
        stage.setResizable(false);

        // sets the scene to the stage
        stage.setScene(scene);
        stage.show();

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                block.draw(block.xPos, block.yPos);
            }
        };

        animationTimer.start();
    }


        // this shouldn't be run but in case that the start() function fails it will pass the command line arguments
    // to javafx.application.Application  THEN it will run the Application.launch function to attempt to launch it again.
    public static void main(String[] args)
    {
        launch(args);
    }

}
