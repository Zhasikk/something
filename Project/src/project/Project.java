package project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Project extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        String s = "C:\\Users\\Lenovo\\Desktop\\project\\map0.txt";
        Map map = new Map(s);
        MyPlayer player = new MyPlayer(map);
        
        
        map.setOnKeyPressed(e->{
            switch(e.getCode()){
                case UP: player.moveUp();break;
                case DOWN: player.moveDown();break;
                case LEFT: player.moveLeft();break;
                case RIGHT: player.moveRight();break;
            }
        });
        
        Scene scene = new Scene(map,400,400);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        map.requestFocus();
        
        
        
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
