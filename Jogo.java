package jogodavelha;

/*
    Futuras implementações
    -> Colcor nome e avatar para cada jogador
    -> O jogador podera escolher se quer jogar com um avatar feminino ou masculino
    -> Colocar os botoes do GRID em um Array
    -> Colocar a opção de Jogar Novamente
*/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Jogo extends JFrame implements ActionListener{
    
    ArrayList <JButton> bt = new ArrayList <JButton>();
    private JButton bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9;
    int matrizJogo[][] = new int[3][3];
    JLabel j1, j2, resultado;
    Font fontJogador = new Font("arial", Font.CENTER_BASELINE, 19); //Fonte dos Jogadores
    Font campeao = new Font("verdana", Font.BOLD, 26); // Fonte do ganhador do jogo
    Font xo = new Font("verdana", Font.BOLD, 60);
    int contador = 1;
    
    public Jogo(){
        super("Jogo da Velha - Versão 1.0");
        
        zerarMatriz();
        logicaJogo();
        
    }
    
    public void zerarMatriz(){
        for(int i=0; i<3; i++){
           for(int j=0; j<3; j++){
               matrizJogo[i][j]=0;
           }
        }
    }
    
    public void logicaJogo(){
        
        setLayout(new BorderLayout(0,0));
        
        /****GRID DO JOGO****/
        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(3,3));
        
       
        // Criação de 9 botoes
        /*for(int i=0; i<9; i++){
            bt.add(new JButton(""+i));
            bt.get(i).addActionListener(this);
            grid.add(bt.get(i));
        }*/
        
        
        bt1 = new JButton("");
        bt1.addActionListener(this);
        bt2 = new JButton("");
        bt2.addActionListener(this);
        bt3 = new JButton("");
        bt3.addActionListener(this);
        bt4 = new JButton("");
        bt4.addActionListener(this);
        bt5 = new JButton("");
        bt5.addActionListener(this);
        bt6 = new JButton("");
        bt6.addActionListener(this);
        bt7 = new JButton("");
        bt7.addActionListener(this);
        bt8 = new JButton("");
        bt8.addActionListener(this);
        bt9 = new JButton("");
        bt9.addActionListener(this);
        
        grid.add(bt1);
        grid.add(bt2);
        grid.add(bt3);
        grid.add(bt4);
        grid.add(bt5);
        grid.add(bt6);
        grid.add(bt7);
        grid.add(bt8);
        grid.add(bt9);
        
        
        add(BorderLayout.CENTER, grid);
        
        
        /****Jogador****/
        JPanel panelJogador = new JPanel();
        panelJogador.setLayout(new FlowLayout());
        
        EmptyBorder bordaPanelJogador = new EmptyBorder(0,10,10,25); // Sentido anti-horario
        
        panelJogador.setBorder(bordaPanelJogador);
        
        panelJogador.add(this.jogador1());
        panelJogador.add(this.jogador2());
        
        add(BorderLayout.NORTH, panelJogador);
        
        
        /*RESULTADO DO JOGO*/
        JPanel panelRes = new JPanel();
        panelRes.setLayout(new FlowLayout());
        
        EmptyBorder bordaResultado = new EmptyBorder(15,0,15,0);
        
        resultado = new JLabel("");
        resultado.setFont(campeao);
        resultado.setForeground(Color.green);
        
        panelRes.setBorder(bordaResultado);
        panelRes.add(resultado);
        
        add(BorderLayout.SOUTH, panelRes);
    }
    
    public JLabel jogador1(){
        
        j1 = new JLabel("Jogador 1 - (X)");
        j1.setFont(fontJogador);
        j1.setForeground(Color.BLUE);
        
        return j1;
    }
    
    public JLabel jogador2(){
        
        j2 = new JLabel("");
        j2.setForeground(Color.RED);
        j2.setFont(fontJogador);
        
        return j2;
    }
    
    public int confereResultado(){
        int res=0, j=0;
        
        /****Confere as diagonais****/
        for(int i=0; i<3; i++){
            for(j=0; j<3; j++){
                if(i==j){
                    res+=matrizJogo[i][j];
                }
            }
        }
        
        if(res==3){
            return 1;
        }else if(res==-3){
            return 2;
        }
        
        res=0;
        
        j=2;
        for(int i=0; i<3; i++){
            res+=matrizJogo[i][j];
            j--;
        }
        
        if(res==3){
            return 1;
        }else if(res==-3){
            return 2;
        }
        
        res=0;

        /****Confere as verticais****/
        for(int i=0; i<3; i++){
            res+=matrizJogo[i][0];
        }
        
        if(res==3){
            return 1;
        }else if(res==-3){
            return 2;
        }
        
        res=0;        
        for(int i=0; i<3; i++){
            res+=matrizJogo[i][1];
        }
        
        if(res==3){
            return 1;
        }else if(res==-3){
            return 2;
        }
        
        res=0;
        
        for(int i=0; i<3; i++){
            res+=matrizJogo[i][2];
        }
        
        if(res==3){
            return 1;
        }else if(res==-3){
            return 2;
        }
        
        res=0;
        
        /****Confere as horizontais****/
        for(int i=0; i<3; i++){
            res+=matrizJogo[0][i];
        }
        
        if(res==3){
            return 1;
        }else if(res==-3){
            return 2;
        }
        
        res=0;
        
        for(int i=0; i<3; i++){
            res+=matrizJogo[1][i];
        }
        
        if(res==3){
            return 1;
        }else if(res==-3){
            return 2;
        }
        
        res=0;
        
        
        for(int i=0; i<3; i++){
            res+=matrizJogo[2][i];
        }
        
        if(res==3){
            return 1;
        }else if(res==-3){
            return 2;
        }
        
        res=0;
      
        return -1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        /*for(int i=0; i<9; i++){
            if((e.getSource() == bt.get(i)) && (bt.get(i).getText() =="")){
                if(contador%2 == 0){
                    bt.get(i).setText("X");
                    bt.get(i).setFont(xo);
                    bt.get(i).setForeground(Color.BLUE);
                    j1.setText("");
                    j2.setText("Jogador 2 - (O)");
                    matrizJogo[0][0] = 1;
                }else{
                    bt.get(i).setText("X");
                    bt.get(i).setFont(xo);
                    bt.get(i).setForeground(Color.BLUE);
                    j1.setText("");
                    j2.setText("Jogador 2 - (O)");
                    matrizJogo[0][0] = -1;
                }
            }
        }*/
        
        if(e.getSource() == bt1){
            
           if(bt1.getText() ==""){
                if(contador %2!=0){
                    bt1.setText("X");
                    bt1.setFont(xo);
                    bt1.setForeground(Color.BLUE);
                    j1.setText("");
                    j2.setText("Jogador 2 - (O)");
                    matrizJogo[0][0] = 1;
                }else{
                    bt1.setText("O");
                    bt1.setFont(xo);
                    bt1.setForeground(Color.RED);
                    j2.setText("");
                    j1.setText("Jogador 1 - (X)");
                     matrizJogo[0][0] = -1;
                }
               
               contador++;
           }
           
        }if(e.getSource() == bt2){
            
            if(bt2.getText()==""){
                if(contador %2!=0){
                    bt2.setText("X");
                    bt2.setFont(xo);
                    bt2.setForeground(Color.BLUE);
                    j1.setText("");
                    j2.setText("Jogador 2 - (O)");
                    matrizJogo[0][1] = 1;
                }else{
                    bt2.setText("O");
                    bt2.setFont(xo);
                    bt2.setForeground(Color.RED);
                    j2.setText("");
                    j1.setText("Jogador 1 - (X)");
                    matrizJogo[0][1] = -1;
                }
                
                contador++;
            }
            
        }if(e.getSource() == bt3){
            
            if(bt3.getText()==""){
                if(contador %2!=0){
                    bt3.setText("X");
                    bt3.setFont(xo);
                    bt3.setForeground(Color.BLUE);
                    j1.setText("");
                    j2.setText("Jogador 2 - (O)");
                    matrizJogo[0][2] = 1;
                }else{
                    bt3.setText("O");
                    bt3.setFont(xo);
                    bt3.setForeground(Color.RED);
                    j2.setText("");
                    j1.setText("Jogador 1 - (X)");
                    matrizJogo[0][2] = -1;
                }
                
                contador++;
            }
           
            
        }if(e.getSource() == bt4){
            
            if(bt4.getText()==""){
                if(contador %2!=0){
                    bt4.setText("X");
                    bt4.setFont(xo);
                    bt4.setForeground(Color.BLUE);
                    j1.setText("");
                    j2.setText("Jogador 2 - (O)");
                    matrizJogo[1][0] = 1;
                }else{
                    bt4.setText("O");
                    bt4.setFont(xo);
                    bt4.setForeground(Color.RED);
                    j2.setText("");
                    j1.setText("Jogador 1 - (X)");
                    matrizJogo[1][0] = -1;
                }
           
                contador++;
           }
            
        }if(e.getSource() == bt5){
            
            if(bt5.getText()==""){
                if(contador %2!=0){
                    bt5.setText("X");
                    bt5.setFont(xo);
                    bt5.setForeground(Color.BLUE);
                    j1.setText("");
                    j2.setText("Jogador 2 - (O)");
                    matrizJogo[1][1] = 1;
                }else{
                    bt5.setText("O");
                    bt5.setFont(xo);
                    bt5.setForeground(Color.RED);
                    j2.setText("");
                    j1.setText("Jogador 1 - (X)");
                    matrizJogo[1][1] = -1;
                }
           
                contador++;
            }
            
        }if(e.getSource() == bt6){
            
            if(bt6.getText()==""){
                if(contador %2!=0){
                    bt6.setText("X");
                    bt6.setFont(xo);
                    bt6.setForeground(Color.BLUE);
                    j1.setText("");
                    j2.setText("Jogador 2 - (O)");
                    matrizJogo[1][2] = 1;
                }else{
                    bt6.setText("O");
                    bt6.setFont(xo);
                    bt6.setForeground(Color.RED);
                    j2.setText("");
                    j1.setText("Jogador 1 - (X)");
                    matrizJogo[1][2] = -1;
                }
                
               contador++;
            }
            
        }if(e.getSource() == bt7){
            
            if(bt7.getText()==""){
                if(contador %2!=0){
                    bt7.setText("X");
                    bt7.setFont(xo);
                    bt7.setForeground(Color.BLUE);
                    j1.setText("");
                    j2.setText("Jogador 2 - (O)");
                    matrizJogo[2][0] = 1;
                }else{
                    bt7.setText("O");
                    bt7.setFont(xo);
                    bt7.setForeground(Color.RED);
                    j2.setText("");
                    j1.setText("Jogador 1 - (X)");
                    matrizJogo[2][0] = -1;
                }
           
                contador++;
            }
            
        }if(e.getSource() == bt8){
            
            if(bt8.getText()==""){
                if(contador %2!=0){
                    bt8.setText("X");
                    bt8.setFont(xo);
                    bt8.setForeground(Color.BLUE);
                    j1.setText("");
                    j2.setText("Jogador 2 - (O)");
                    matrizJogo[2][1] = 1;
                }else{
                    bt8.setText("O");
                    bt8.setFont(xo);
                    bt8.setForeground(Color.RED);
                    j2.setText("");
                    j1.setText("Jogador 1 - (X)");
                    matrizJogo[2][1] = -1;
                }
           
                contador++;
            }
            
        }if(e.getSource() == bt9){
            
            if(bt9.getText()==""){
               if(contador %2!=0){
                    bt9.setText("X");
                    bt9.setFont(xo);
                    bt9.setForeground(Color.BLUE);
                    j1.setText("");
                    j2.setText("Jogador 2 - (O)");
                    matrizJogo[2][2] = 1;
                }else{
                    bt9.setText("O");
                    bt9.setFont(xo);
                    bt9.setForeground(Color.RED);
                    j2.setText("");
                    j1.setText("Jogador 1 - (X)");
                    matrizJogo[2][2] = -1;
                }
           
                contador++;
            }
            
        }
        
        if(this.confereResultado() == 1){
            resultado.setText("VENCEDOR: JOGADOR 1");
        }else if(this.confereResultado() == 2){
            resultado.setText("VENCEDOR: JOGADOR 2");
        }
        
    }
    
}
