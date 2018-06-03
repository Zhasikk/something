package project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Game extends Application {
    ImageView img;
    Text t;
    @Override
    public void start(Stage primaryStage) throws Exception{
        String s = "C:\\Users\\Lenovo\\Desktop\\project\\map0.txt";
        Map map = new Map(s);
        MyPlayer player = new MyPlayer(map);
        String[] imgs = {  "file:C:\\Users\\Lenovo\\Desktop\\smeshariki\\q.jpg","_______Q_______",
                           "file:C:\\Users\\Lenovo\\Desktop\\smeshariki\\w.jpg","_______W_______",
                           "file:C:\\Users\\Lenovo\\Desktop\\smeshariki\\e.png","_______E_______",
                           "file:C:\\Users\\Lenovo\\Desktop\\smeshariki\\r.png","_______R_______",
                           "file:C:\\Users\\Lenovo\\Desktop\\smeshariki\\t.jpg","_______T_______"
        };        
        
        VBox vb = new VBox(10);
        HBox hb = new HBox(10);
        vb.getChildren().add(new Text("Select character:"));
        for(int i = 0; i < imgs.length ; i += 2){
            img = new ImageView(imgs[i]);
            img.setFitWidth(60);
            img.setFitHeight(60);
            t = new Text(imgs[i + 1]);
            vb.getChildren().addAll(img , t);
        }
        
        hb.getChildren().addAll(map,vb);
        
        
        
        
        map.setOnKeyPressed(e->{
            switch(e.getCode()){
                case UP: player.moveUp();break;
                case DOWN: player.moveDown();break;
                case LEFT: player.moveLeft();break;
                case RIGHT: player.moveRight();break;
                
                case Q: player.setImage("file:C:\\Users\\Lenovo\\Desktop\\smeshariki\\q.jpg");break;
                case W: player.setImage("file:C:\\Users\\Lenovo\\Desktop\\smeshariki\\w.jpg");break;
                case E: player.setImage("file:C:\\Users\\Lenovo\\Desktop\\smeshariki\\e.png");break;
                case R: player.setImage("file:C:\\Users\\Lenovo\\Desktop\\smeshariki\\r.png");break;
                case T: player.setImage("file:C:\\Users\\Lenovo\\Desktop\\smeshariki\\t.jpg");break;
                
            }
        });
        
        Scene scene = new Scene(hb,550,500);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        map.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public void draw(){
        
    }
    
}