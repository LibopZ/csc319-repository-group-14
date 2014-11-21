/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firesimulator;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
/**
 *
 * @author l3al2ley
 */
public class Draw extends JPanel{
private int[][] areaDraw;
private int size;
    public Draw(int[][] area){
        areaDraw =area;
        size = 500/area.length;
  
}
    @Override
    public void paintComponent(Graphics g){
 
       for(int i =0; i < areaDraw.length ; i++  ){          
           for(int j = 0 ; j < areaDraw.length ; j++ ){
               if(areaDraw[i][j] == 1 ){
                    g.setColor(Color.green);
               }
               else if(areaDraw[i][j] == 2 ){
                   g.setColor(Color.red);
               }
               else if(areaDraw[i][j] == 0 ){
                    g.setColor(Color.yellow);
               } 
       //         g.setColor(Color.yellow);
                g.fillRect(i*size,j*size,size,size);
                revalidate();
                repaint();
                
                
           }
//            
       }
        
        
        
    }
}
