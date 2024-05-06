
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alu20902426a
 */
public class Food extends Node {   
   
    private boolean special;
    
    public Food(Snake snake, boolean special, Wall wall) {        
        super(0,0);
        this.special = special;
        do{
          row = (int) (Math.random()*Config.getInstance().numRows);
          col = (int) (Math.random()*Config.getInstance().numCols);         
        } while (snake.isOnSnake(row, col) || wall.isOnWall(row,col));
        setRow(row);
        setCol(col);
        
    }
    
    
    public void paint(Graphics2D g, int width, int height) {      
      
      if (special){      
          Board.drawSquare(g, width, height, row, col, Color.pink);
      } else {
          Board.drawSquare(g, width, height, row, col, Color.red);
      }
       
    }
    public boolean getSpecial(){
        if (special){
            return true;
        } else {
            return false;
        }
    }
    
}
