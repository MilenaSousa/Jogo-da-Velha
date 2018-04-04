/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha;

import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author Milena
 */
public class Teste {
    
    public static void main(String[] args){
        
        ArrayList <JButton> bt = new ArrayList <>();
        
        for(int i=0; i<9; i++){
            bt.add(new JButton(""+i));
        }
        
        
        
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(bt.get(i).getText().equals("1")){
                    System.out.println("deu certo bb"); 
               }
            }
        }
        
    }
    
}
