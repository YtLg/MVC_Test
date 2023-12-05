package com.example.fxml_demo_lab5;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.List;


public class BlockThing {

    int xPos;
    int yPos;

    int length = 20;

    int speed;

    boolean up,down,left,right;

    Group roott;
    Canvas snCan = new Canvas();

    List<Point2D> bodyPoints = new LinkedList<>();

    public BlockThing(int x, int y, Group root){
        xPos = x;
        yPos = y;
        roott = root;
        root.getChildren().add(snCan);
    }

    public void draw(int x, int y){
        bodyPoints.add(new Point2D(xPos, yPos));

        if (bodyPoints.size() == (this.length + 1))
        {
            bodyPoints.remove(0);
        }

        snCan.setWidth(500); // Set the width based on the size you want
        snCan.setHeight(500); // Set the height based on the size you want


        GraphicsContext gc = snCan.getGraphicsContext2D();
        gc.clearRect(0, 0, snCan.getWidth(), snCan.getHeight()); // Clear the canvas
        gc.setFill(Color.RED);
        gc.fillRect(xPos,yPos,10,10);

        this.drawBody();
        this.move();
    }

    public Canvas getCanvas(){
        return snCan;
    }


    void drawBody(){
        for (int i=0; i < bodyPoints.size() -10; i++)
        {
            Point2D tempPt = bodyPoints.get(i);
            GraphicsContext gc = snCan.getGraphicsContext2D();
            gc.setFill(Color.BLUE);
            gc.fillRect((int)tempPt.getX(), (int)tempPt.getY(),10,10);
        }
    }

    // Point2D are very close together, so it uses the movement speed factor to spread the snake apart.
   /* public void drawBody(GraphicsContext g)
    {
        int length = bodyPoints.size() - 1;

        for (int i = length; i >= speed; i -= speed)
        {
            Point point = bodyPoints.get(i);
            g.drawImage(this.image, point.x, point.y);
        }
    }*/


    public void handle(KeyEvent keyEvent){
        switch(keyEvent.getCode()){
            case UP:
                up = true;
                down = false;
                left = false;
                right = false;
                break;
            case DOWN:
                up = false;
                down = true;
                left = false;
                right = false;
                break;
            case LEFT:
                up = false;
                down = false;
                left = true;
                right = false;

                break;
            case RIGHT:
                up = false;
                down = false;
                left = false;
                right = true;

                break;
            default:

                break;
        }
    }

    public void move()
    {
        // láta kvikindið hreyfa sig
        if (up)
        {
            yPos -= 1;
        } else if (down)
        {
            yPos += 1;
        } else if (left)
        {
            xPos -= 1;
        } else if (right)
        {
            xPos += 1;
        }
    }
}
