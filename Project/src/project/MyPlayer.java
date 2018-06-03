package project;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class MyPlayer implements Player{
    private Circle ball;
    private Map map;
    private Position position;
    
    public void setImage(String s){
        ball.setFill(new ImagePattern(new Image(s)));
    }
    
    int k = 0;
    public void draw(Position pos,Map map){
       ball = new Circle();
       ball.setRadius(20);
       ball.setFill(Color.RED);
       this.map = map;
       
       if(k == 0)
            position = map.getStartPosition();
       
       ball.setCenterX(position.getX() * 50 + ball.getRadius() + 5);
       ball.setCenterY(position.getY() * 50 + ball.getRadius() + 5); 
       map.getChildren().add(ball);
    }
   
    MyPlayer(Map map){
       draw(getPosition(),map);
    }
    
    public void moveDown(){
        k = 1;
        for(Position p : map.walls)
            if(p.equals(new Position(position.getX(),position.getY() + 1))|| position.getY() == 7)
                return;
        position.setY(position.getY() + 1);
        ball.setCenterX(position.getX() * 50 + ball.getRadius() + 5);
        ball.setCenterY(position.getY() * 50 + ball.getRadius() + 5); 
        map.getChildren().remove(ball);
        map.getChildren().add(ball);
    }
    
    public Position getPosition(){
        return position;
    }
    
    public void moveUp(){
        k = 1;
        for(Position p : map.walls)
            if(p.equals(new Position(position.getX(),position.getY() - 1))|| position.getY() == 0)
                return;
        position.setY(position.getY() - 1);
        ball.setCenterX(position.getX() * 50 + ball.getRadius() + 5);
        ball.setCenterY(position.getY() * 50 + ball.getRadius() + 5); 
        map.getChildren().remove(ball);
        map.getChildren().add(ball);
    }
    
    public void moveLeft(){
        k = 1;
        for(Position p : map.walls)
            if(p.equals(new Position(position.getX() - 1,position.getY()))|| position.getX() == 0)
                return;
        position.setX(position.getX() - 1);
        ball.setCenterX(position.getX() * 50 + ball.getRadius() + 5);
        ball.setCenterY(position.getY() * 50 + ball.getRadius() + 5); 
        map.getChildren().remove(ball);
        map.getChildren().add(ball);
    }
    public void moveRight(){
        k = 1;
        for(Position p : map.walls)
            if(p.equals(new Position(position.getX() + 1,position.getY())) || position.getX() == 7)
                return;
        position.setX(position.getX() + 1);
        ball.setCenterX(position.getX() * 50 + ball.getRadius() + 5);
        ball.setCenterY(position.getY() * 50 + ball.getRadius() + 5); 
        map.getChildren().remove(ball);
        map.getChildren().add(ball);
    }
    
    
}
