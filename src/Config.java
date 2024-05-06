
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alu20902426a
 */



public class Config implements Serializable {
    public  final int numRows = 30;
    public  final int numCols = 40;   
    private static Config instance = null;
    
    
    
    private Config() {        
       
      
    }
    
    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }
    public void showMessage(){
        System.out.println("Hello world!");
    }
    
    
   
    
}
