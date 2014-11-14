/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spreadfiresimulator;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author StaroMoon
 */
public class DrawField extends JPanel{
    EachTree eachtree[][];
    private double sizecell;
    private int numTree;
    Jframe gui;
    
    public void setGui(Jframe gui){
        this.gui = gui;
    }
    
    public DrawField(){
        numTree = 100;
        sizecell = 600/numTree;
        setSize(600,600);
  
    }
    
    
    
    public void update(EachTree[][] eachtree){
        this.eachtree = eachtree;
        repaint();
    }
    
    //@Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i =0; i < getNumTree() ; i++  ){          
           for(int j = 0 ; j < getNumTree() ; j++ ){
               if(eachtree[i][j].getState() == 1 ){
                    g.setColor(Color.green);
               }
               else if(eachtree[i][j].getState() == 2 ){
                   g.setColor(Color.red);
               }
               else if(eachtree[i][j].getState() == 0 ){
                    g.setColor(Color.yellow);
               } 
                //g.setColor(Color.yellow);
                g.fillRect((int)(i*getSizecell()),(int)(j*getSizecell()),(int)(getSizecell()-1),(int)(getSizecell()-1));
           }
       }
    }

    public void reset(){
        eachtree = new EachTree[numTree][numTree];
        for(int i =0; i < numTree ; i++  ){          
            for(int j = 0 ; j < numTree ; j++ ){
                eachtree[i][j] = new EachTree();
                if(i == numTree/2 && j == numTree / 2){
                    eachtree[i][j].setState(2);
                }
                if (i == 0 || j == 0 || i == numTree - 1 || j == numTree - 1) {   // 0 = frame of forest
                    eachtree[i][j].setState(0);    
                }
            }
        }
    }
    
    public void createtreefromprob(){
        eachtree = new EachTree[numTree][numTree];
        for(int i =0; i < numTree ; i++  ){          
            for(int j = 0 ; j < numTree ; j++ ){
                eachtree[i][j] = new EachTree();
                if (i == 0 || j == 0 || i == numTree - 1 || j == numTree - 1) {   // 0 = frame of forest
                    eachtree[i][j].setState(0);    
                }else{
                    if(random(gui.probtree)){
                        if(random(gui.probtreeburn)){
                            eachtree[i][j].setState(2);
                        }else{
                            eachtree[i][j].setState(1);
                        }
                    }else{
                        eachtree[i][j].setState(0);
                    }
                }
            }
        } 
    }
    
    public boolean random(double probB){
        double a = Math.random();
        if(a<probB){
            return true;
        }return false;
    }
    
    public double getSizecell() {
        return sizecell;
    }

    public int getNumTree() {
        return numTree;
    }

    public void setSizecell(double sizecell) {
        this.sizecell = sizecell;
        repaint();
    }

    public void setNumTree(int numTree) {
        this.numTree = numTree;
        reset();
    }
    
    
}
