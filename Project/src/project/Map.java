package project;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Map extends Pane{
    private int[][] map;
    private Position start;
    private ImageView deadblock;
    Rectangle block;
    int x;
    ArrayList<Position> walls = new ArrayList<>(); //created to save position of black walls
    
    public void draw(){
        for(int i = 0; i < getSize();i++){
            for( int j = 0; j < getSize(); j++){
                
                    Rectangle r1 = new Rectangle(i*50, j*50, 50 , 50);
                    r1.setFill(Color.WHITE);
                    r1.setStroke(Color.BLACK);
                    getChildren().add(r1);
                if(map[i][j] == 1){
                    block = new Rectangle(i*50, j*50, 50 , 50);
                    block.setFill(new ImagePattern(new Image("file:C:\\Users\\Lenovo\\Desktop\\smeshariki\\kaktus.jpg")));
                    block.setStroke(Color.BLACK);
                    walls.add(new Position(i,j));
                    getChildren().add(block);
                }
            }
        }
    }
    
    Map(String s)throws Exception{
        Scanner in = new Scanner(new File(s));
        x = in.nextInt();
        map = new int[x][x];
        for(int i = 0 ; i < x; i++){
            for(int j = 0 ; j < x; j++){
                map[j][i] = in.nextInt();
            }
        }
        draw();
    }
    
    public int getSize(){
        return this.x;
    }
    
    public int[][] getMap(){
        return map;
    }
    
    public Position getStartPosition(){
        for(int i = 0; i < x;i++){
            for(int j =0 ;j < x;j++){
                if(map[i][j] == 2)
                    start = new Position(i,j);
            }
        }
        return start;
    }
    
    
}
