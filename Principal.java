
package jogodavelha;

import javax.swing.JFrame;

public class Principal {
    
    public static void main(String[] args){
        
        Jogo jogo = new Jogo();
        
        jogo.setSize(600,500);
        jogo.setVisible(true);
        jogo.setLocationRelativeTo(null);
        jogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
