/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package firesimulator;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Container;
/**
 *
 * @author l3al2ley
 */
public class GUI extends JPanel{
    private Frame jframe;
    private JPanel panel;
    private Container contentPane;
    public GUI(){
        jframe = new Frame();
       // scw=500;
        jframe.setSize(600, 450);
        contentPane = jframe.getContentPane();
        jframe.setContentPane(contentPane);
        //jframe.setResizable(false);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // jFrame.setVisible(true);

    }
    
    public void drawSpreadFire(int[][] area){
        contentPane.removeAll();
        contentPane.add(new Draw(area));
        jframe.setContentPane(contentPane);
        jframe.setVisible(true);
        try{Thread.sleep(50);}
        catch(Exception e){};
        
    }
}
