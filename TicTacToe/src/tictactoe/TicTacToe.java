/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author akshaya
 */
public class TicTacToe extends JFrame {
    JFrame tictactoe = new JFrame ("Tic Tac Toe");
    JButton [][]  cells = new JButton [3][3];
    String turn;
    JLabel whichPlayer;

    
public void resetBoard() //resets board and sets player as Player X
{   
    
    int i,j;
    for(i=0; i <3 ; i++)
    {
        for (j=0;j<3;j++)
        {
            cells[i][j].setText("");
            cells[i][j].setEnabled(true);
        }
    }
    whichPlayer.setText("Player: X");
    turn = "X";
    
   }

public void isGameOver() //checks if any of the two players one
{
    int i, j;
    String [][] boardStatus = new String [3][3];
    
    String message;
    for(i=0; i<3; i++)
    {
        for(j=0;j<3; j++)
        {
            boardStatus[i][j] = cells[i][j].getText();
            
        }
     }
    
   
    
     for(i=0; i <3 ; i++ ) 
     {  //horizontal win
        if(boardStatus[i][0].equals(boardStatus [i][1]) && boardStatus[i][1].equals(boardStatus[i][2]))
        {   
            if(!(boardStatus[i][0].equals("")))
            {
            message = "Game over! " + boardStatus[i][0] + " Won!";
            JOptionPane.showMessageDialog(null, message);
            resetBoard();
            return;
            }
        }
        //vertical win
        else if(boardStatus[0][i].equals(boardStatus [1][i]) && boardStatus[1][i].equals(boardStatus[2][i]) )
         {   
            if(!(boardStatus[0][i].equals("")))
            {
            message = "Game over! " + boardStatus[0][i] + " Won!";
            JOptionPane.showMessageDialog(null, message);
            resetBoard();
            return;
            }
         }  
     }
      //left diagonal win
      if(boardStatus[0][0].equals(boardStatus [1][1]) && boardStatus[1][1].equals(boardStatus[2][2]))
      {   
          if(!(boardStatus[0][0].equals("")))
          {
          message = "Game over! " + boardStatus[0][0] + " Won!";
          JOptionPane.showMessageDialog(null, message);
          resetBoard();
          return;
          }
      }
      //right diagonal win
      else if(boardStatus[0][2].equals(boardStatus [1][1]) && boardStatus[1][1].equals(boardStatus[2][0]))
       {
          if(!(boardStatus[0][2].equals("")))
          {
          message = "Game over! " + boardStatus[0][2] + " Won!";
          JOptionPane.showMessageDialog(null, message);
          resetBoard();
          return;
          }
       }
   
        int flag = 0;
        j=0;
        for(i=0;i<3;i++)
        {
            for(j=0;j<3;j++)
            {
                if(boardStatus[i][j].equals("") )
                    flag = 1;
            }
            
    }
      
      if(flag == 0)
      {
          message = "Game over! "+ " Draw!";
          JOptionPane.showMessageDialog(null, message);
          resetBoard();
      }
    
} 
//Game play - 1 turn
 public void gamePlay(int i, int j)
 {
   String player = getTurn();
   System.out.println("player: "+ player);
   cells[i][j].setText(player);
   cells[i][j].setEnabled(false);
   setTurn();
   whichPlayer.setText("Player: " + turn); 
   isGameOver();
 }

public String getTurn()
{
    return turn;
}

//sets turn to the next player
public void setTurn()
{
    if( turn.equals("X")) turn = "O";
    else
        turn = "X";
}

//initializes the board
public void initializeBoard()
        {   
          
          ActionListener resetBoard = new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e){
              resetBoard();
           }
          };
          
          ActionListener board;
        board = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == cells[0][0])
                {
                    gamePlay(0,0);
                }
                
                else if(e.getSource() == cells[0][1])
                {
                    gamePlay(0,1);
                }
                
                else if(e.getSource() == cells[0][2])
                {
                    gamePlay(0,2);
                }
                else if(e.getSource() == cells[1][0])
                {
                    gamePlay(1,0);
                }
                else if(e.getSource() == cells[1][1])
                {
                    gamePlay(1,1);
                }
                else if(e.getSource() == cells[1][2])
                {
                    gamePlay(1,2);
                }
                else if(e.getSource() == cells[2][0])
                {
                    gamePlay(2,0);
                }
                else if(e.getSource() == cells[2][1])
                {
                    gamePlay(2,1);
                }
                else if(e.getSource() == cells[2][2])
                {
                    gamePlay(2,2);
                }
               
                
            }
        };
            
            
            int i,j;
            this.setSize(400,400);
            BoxLayout boxLayout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS); // top to bottom
            this.setLayout(boxLayout);
            JPanel panel = new JPanel();
            panel.setPreferredSize(new Dimension(300,400));
            whichPlayer = new JLabel ("Player: X");
            JPanel ticpanel = new JPanel(new GridLayout(3,3));
            ticpanel.setPreferredSize(new Dimension(300,300));
            turn = "X";
            
            for(i=0; i<3; i++)
            {
                for (j=0; j<3; j++)
                {
                    cells[i][j] = new JButton();
                    cells[i][j].setText("");
                    ticpanel.add(cells[i][j]);
                    cells[i][j].addActionListener(board);
                    
                }
            }
            JButton reset = new JButton ("Start a new game");
            reset.addActionListener(resetBoard);
            panel.add(whichPlayer);
            panel.add(ticpanel);
            
            panel.add(reset,BorderLayout.SOUTH);
            
            this.add(panel);
            this.setVisible(true);
            this.pack();
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
          
         
        
        
        }

  
          
 
    public static void main(String[] args) {
        
        
        TicTacToe game = new TicTacToe();
        game.initializeBoard();
        
       
    }
    
}
