

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Wall {
    
    private List<Node> list;
    
    public Wall(int level) {
        list = new ArrayList<Node>();
        switch (level) {
            case 3: 
                list.add(new Node(12, 5));
                list.add(new Node(12, 6));
                list.add(new Node(12, 7));
                list.add(new Node(12, 8));
                list.add(new Node(13, 5));
                list.add(new Node(13, 6));
                list.add(new Node(13, 7));
                list.add(new Node(13, 8));
                list.add(new Node(14, 5));
                list.add(new Node(14, 6));
                list.add(new Node(14, 7));
                list.add(new Node(14, 8));
                list.add(new Node(15, 5));
                list.add(new Node(15, 6));
                list.add(new Node(15, 7));
                list.add(new Node(15, 8));
            case 2: 
                list.add(new Node(5, 32));
                list.add(new Node(5, 33));
                list.add(new Node(5, 34));
                list.add(new Node(5, 35));
                list.add(new Node(6, 32));
                list.add(new Node(6, 33));
                list.add(new Node(6, 34));
                list.add(new Node(6, 35));
                list.add(new Node(7, 32));
                list.add(new Node(7, 33));
                list.add(new Node(7, 34));
                list.add(new Node(7, 35));
                list.add(new Node(8, 32));
                list.add(new Node(8, 33));
                list.add(new Node(8, 34));
                list.add(new Node(8, 35));
            case 1: 
                list.add(new Node(12, 32));
                list.add(new Node(12, 33));
                list.add(new Node(12, 34));
                list.add(new Node(12, 35));
                list.add(new Node(13, 32));
                list.add(new Node(13, 33));
                list.add(new Node(13, 34));
                list.add(new Node(13, 35));
                list.add(new Node(14, 32));
                list.add(new Node(14, 33));
                list.add(new Node(14, 34));
                list.add(new Node(14, 35));
                list.add(new Node(15, 32));
                list.add(new Node(15, 33));
                list.add(new Node(15, 34));
                list.add(new Node(15, 35));
            case 0: 
                list.add(new Node(5, 5));
                list.add(new Node(5, 6));
                list.add(new Node(5, 7));
                list.add(new Node(5, 8));
                list.add(new Node(6, 5));
                list.add(new Node(6, 6));
                list.add(new Node(6, 7));
                list.add(new Node(6, 8));
                list.add(new Node(7, 5));
                list.add(new Node(7, 6));
                list.add(new Node(7, 7));
                list.add(new Node(7, 8));
                list.add(new Node(8, 5));
                list.add(new Node(8, 6));
                list.add(new Node(8, 7));
                list.add(new Node(8, 8));
            
                break;
            }
        for (int row = 0; row <= Config.getInstance().numRows; row++){
            list.add(new Node(row, Config.getInstance().numCols));
        }
        for (int col = 0; col <= Config.getInstance().numCols; col++){
            list.add(new Node(Config.getInstance().numRows, col));
        }            
        
    }
     public boolean isOnWall(int row, int col){       
    
      for (Node node : list){
           if (row ==  node.getRow() && col ==  node.getCol()) {               
           
               return true;
               
           }
          
      }
      return false;
    }
    public List<Node> getList() {
        return list;
    }
    
    public void paint(Graphics2D g, int width, int height) {
        for (Node node: list) {
            Board.drawSquare(g, width, height, node.row, node.col, Color.black);
        }
    }
    
}
