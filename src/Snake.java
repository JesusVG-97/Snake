
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alu20902426a
 */
public class Snake {
    private List<Node> body;
    private Direction direction;      
    private int remainGrow; 
    
    Food food;
    boolean t;    
    Board board;
    
    public Snake (int numNodes){
        body = new ArrayList<Node>();
        direction = Direction.RIGHT;
        remainGrow = 0;     
        t = false;
        
        for (int i = 0; i < numNodes ; i++){
            body.add(new Node(Config.getInstance().numRows/2, Config.getInstance().numCols/2 -i));
        }
        remainGrow = 0;
        
    }
    
    public List<Node> getBody(){
        return body;
    }
    
    public void setDirection(Direction direction){
        this.direction = direction;
    }
    
    public void paint(Graphics2D g2d, int squareWidth, int squareHeight){        
        boolean firstNode = true;
        Color color;
        
        for (Node node : body){
            if (firstNode){
                color = Color.BLUE;
                firstNode = false;
            } else {
                color = Color.GREEN;
            } 
             Board.drawSquare(g2d, squareWidth, squareHeight, node.getRow(), node.getCol(), color) ;  
        }        
            
    }
    
  public boolean move(Snake snake, Wall wall) {
        switch(direction) {           
            case UP:
                if (detectColide(body.get(0).row, body.get(0).col, snake, wall)) {
                    body.add(0, new Node(body.get(0).row - 1, body.get(0).col));
                    remainGrow();
                } else {
                    return false;
                }
                break;
            case DOWN:
                if (detectColide(body.get(0).row, body.get(0).col, snake, wall)) {
                    body.add(0, new Node(body.get(0).row + 1, body.get(0).col));
                    remainGrow();
                } else {
                    return false;
                }
                break;
            case RIGHT:
                if (detectColide(body.get(0).row, body.get(0).col, snake, wall)) {
                    body.add(0, new Node(body.get(0).row, body.get(0).col + 1));
                    remainGrow();
                } else {
                    return false;
                }
                break;
            case LEFT:
                if (detectColide(body.get(0).row, body.get(0).col, snake, wall)) {
                    body.add(0, new Node(body.get(0).row, body.get(0).col - 1));
                    remainGrow();
                } else {
                    return false;
                }
                break;
            default:
                break;
        }
        return true;
    }
  private void remainGrow() {
        if (remainGrow == 0) {
            body.remove(body.size() - 1);
        } else {
            remainGrow--;
        }
    }
    public Direction getDirection() {
        return direction;
    }
    
    
    public void setRemainGrow(int remainGrow) {
        this.remainGrow = remainGrow;
    }
    
    public boolean detectColide(int row, int col, Snake snake, Wall wall) {
        if (row < 0 || col < 0 || Config.getInstance().numRows <= row || Config.getInstance().numCols <= col) {
            return false;
        }
        boolean firstNode = false;
        for (Node node : body) {
            if (!firstNode) {
                firstNode = true;
            } else {
                if (row == node.getRow() && col == node.getCol()) {
                    return false;
                }
            }
        }
        if (snake != null) {
            for (Node node : snake.getBody()) {
                if (row == node.getRow() && col == node.getCol()) {
                    return false;
                }
            }
        }
        for (Node node : wall.getList()){
            if (row == node.getRow() && col == node.getCol()) {
                    return false;
            }
        }
        return true;
    }
    
   
    
    public boolean eatFood(Food food) {
       
        if (food.row == body.get(0).getRow()&& food.col == body.get(0).getCol()) { 
            if (food.getSpecial()){
                remainGrow=+5;                              
            } else {
                remainGrow=+1;                             
            }           
            return true;
        }       
            return false;
        }    
    public boolean isOnSnake(int row, int col){       
    
      for (Node node : body){
           if (row ==  node.getRow() && col ==  node.getCol()) {              
           
               return true;
               
           }
          
      }
      return false;
    }
     public boolean isTurning() {
        return t;
    }

    public void setTurning(boolean t) {
        this.t = t;
    }    

        

        
     
}
