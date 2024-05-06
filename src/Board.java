
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
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
public class Board extends javax.swing.JPanel {     
    private Timer timer;
    private Snake snake;
    private Food food; 
    private MyKeyAdapter keyAdapter;
    private boolean gameOver;    
    private scoreBoard score;
    private Wall wall;
    private Snake snake2;
    private JDialog jDialog1;
   
    public Board() {             
        initComponents();
       
        timer = new Timer(200, 
                new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {             
               
                snake.setTurning(false); 
               
               tick();                
               
               
            }
        });
       
    }
    public void initGame() {      
               
        initValues();
      
    }
    public void tick() {   
        
        
              snake.move(null, wall);   
             
              eat();               
              repaint();
               gameOver();
         
            
         
        
    }
    public void initValues(){
        keyAdapter = new MyKeyAdapter();
        snake = new Snake(4);        
        createFood();
        wall = new Wall(2);
        removeKeyListener(keyAdapter);
        addKeyListener(keyAdapter);       
        score.reset();
        timer.start();
        setFocusable(true);
        gameOver = false;  
        
    }
            
    
    @Override
    
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        if (snake != null){
            snake.paint(g2d, getSquareWidth(), getSquareHeight());            
        }
        if (food != null){            
            food.paint(g2d, getSquareWidth(), getSquareHeight());  
        }
        if (wall != null) {
             wall.paint(g2d, getSquareWidth(), getSquareHeight());  
        }            
        
    }
    
    public int getSquareWidth(){
         return getWidth() / Config.getInstance().numCols;
    }    
    
    public int getSquareHeight(){
        return getHeight() / Config.getInstance().numRows;
    }

    public void gameOver(){
        if (!snake.move(null, wall)){
            jDialog1.setVisible(true);
            timer.stop();
        }
    }
    class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (snake.getDirection() != Direction.RIGHT && !snake.isTurning()) {
                        snake.setDirection(Direction.LEFT);   
                        snake.setTurning(true);
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (snake.getDirection() != Direction.LEFT && !snake.isTurning()) {
                        snake.setDirection(Direction.RIGHT);
                        snake.setTurning(true);
                       
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (snake.getDirection() != Direction.DOWN && !snake.isTurning()) {
                        snake.setDirection(Direction.UP);
                        snake.setTurning(true);
                        
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (snake.getDirection() != Direction.UP && !snake.isTurning() ) {
                        snake.setDirection(Direction.DOWN);
                        snake.setTurning(true);
                        
                    }
                    break;
                    //Move Snake 2
                    case KeyEvent.VK_A:
                    if (snake2.getDirection() != Direction.RIGHT && !snake2.isTurning()) {
                        snake2.setDirection(Direction.LEFT);   
                        snake2.setTurning(true);
                    }
                    break;
                case KeyEvent.VK_D:
                    if (snake2.getDirection() != Direction.LEFT && !snake2.isTurning()) {
                        snake2.setDirection(Direction.RIGHT);
                        snake2.setTurning(true);
                       
                    }
                    break;
                case KeyEvent.VK_W:
                    if (snake2.getDirection() != Direction.DOWN && !snake2.isTurning()) {
                        snake2.setDirection(Direction.UP);
                        snake2.setTurning(true);
                        
                    }
                    break;
                case KeyEvent.VK_S:
                    if (snake2.getDirection() != Direction.UP && !snake2.isTurning() ) {
                        snake2.setDirection(Direction.DOWN);
                        snake2.setTurning(true);
                        
                    }
                    
                    break;
                case KeyEvent.VK_P:
                    if (timer.isRunning()) {
                        timer.stop();   
                    } else {
                        timer.start();
                    }
                    break;
                
            }  
          
            repaint();
            Toolkit.getDefaultToolkit().sync();
        }
    }
     
     
     public void eat(){
         if (snake.eatFood(food)){
             if(!food.getSpecial()){                 
                score.incrementScore(1);
                
             } else {                
                score.incrementScore(5);
                
             }
             createFood();
         }
     }
     
     public void createFood(){
         if ((int) (Math.random()*5) == 1){
             food = new Food(snake, true, wall);
         } else {
             food = new Food(snake, false, wall);
         }
     }
     
     public void setScoreBoard(scoreBoard score){
         this.score = score;
     }     
     
    public void setDialog(JDialog jDialog1){
        this.jDialog1 = jDialog1;
    }
              
     
    public static void drawSquare(Graphics2D g, int squareWidth, int squareHeight, int row, int col, Color color){
        int x = col * squareWidth;
        int y = row * squareHeight;       
        g.setColor(color);
        g.fillRect(x + 1, y + 1, squareWidth - 2, squareHeight - 2);
        g.setColor(color.brighter());
        g.drawLine(x, y + squareHeight - 1, x, y);
        g.drawLine(x, y, x + squareWidth - 1, y);
        g.setColor(color.darker());
        g.drawLine(x + 1, y + squareHeight - 1, x + squareWidth - 1, y + squareHeight - 1);
        g.drawLine(x + squareWidth - 1, y + squareHeight - 1, x + squareWidth - 1, y + 1);
  
    }  
     /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();

        jTextField1.setText("jTextField1");

        setBackground(new java.awt.Color(255, 255, 255));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
        
    }//GEN-LAST:event_formKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
