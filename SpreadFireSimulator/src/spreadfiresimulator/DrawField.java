package spreadfiresimulator;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author csc319 GROUP # 14
 */
public class DrawField extends JPanel{
    EachTree eachtree[][];
    private double sizetree;
    private int numTree;
    Jframe gui;
    
    
    /*
        Constructor number of tree and size tree at start
    */
    public DrawField(){
        numTree = 100;
        sizetree = 600/numTree;
        setSize(600,600);
  
    }
    
    /*
        Update status of tree then repaint color
    */
    public void update(EachTree[][] eachtree){
        this.eachtree = eachtree;
        repaint();
    }
    
    /*
        Paint color to tree
    */
    //@Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i =0; i < getNumTree() ; i++  ){          
            for(int j = 0 ; j < getNumTree() ; j++ ){
                if(eachtree[i][j].getState() == 1 ){ //If state is one, paint color green which is a tree
                    g.setColor(Color.green);
                }
                else if(eachtree[i][j].getState() == 2 ){ //If state is two, paint color red which is a burning tree
                   g.setColor(Color.red);
                }
                else if(eachtree[i][j].getState() == 0 ){ //If state is zero, paint color yellow which is a emtry tree
                    g.setColor(Color.yellow);
                } 
                g.fillRect((int)(i*getSizetree()),(int)(j*getSizetree()),(int)(getSizetree()-1),(int)(getSizetree()-1));
            } 
        }
    }

    /*
        Create new forest
    */
    public void reset(){
        eachtree = new EachTree[numTree][numTree];
        for(int i =0; i < numTree ; i++  ){          
            for(int j = 0 ; j < numTree ; j++ ){
                eachtree[i][j] = new EachTree();
                if(i == numTree/2 && j == numTree / 2){ // At the middle of forest set as burning tree
                    eachtree[i][j].setState(2);
                }
                if (i == 0 || j == 0 || i == numTree - 1 || j == numTree - 1) {   // At the border set as emtry tree
                    eachtree[i][j].setState(0);    
                }
            }
        }
    }
    
    /*
        Create new forest with probability of amount of tree and amount of buring tree
    */
    public void createtreefromprob(){
        eachtree = new EachTree[numTree][numTree];
        for(int i =0; i < numTree ; i++  ){          
            for(int j = 0 ; j < numTree ; j++ ){
                eachtree[i][j] = new EachTree();
                if (i == 0 || j == 0 || i == numTree - 1 || j == numTree - 1) {   // 0 = frame of forest
                    eachtree[i][j].setState(0);    
                }else{
                    if(random(gui.getProbtree())){
                        if(random(gui.getProbtreeburn())){
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
    
    /*
        Random probability
    */
    public boolean random(double probB){
        double a = Math.random();
        if(a<probB){
            return true;
        }return false;
    }
    
    /*
       Set Jframe 
    */
    public void setGui(Jframe gui){
        this.gui = gui;
    }
    
    /*
        Get size of tree
    */
    public double getSizetree() {
        return sizetree;
    }

    /*
        Get number of tree
    */
    public int getNumTree() {
        return numTree;
    }

    /*
        Set size of tree and create new tree
    */
    public void setSizetree(double sizetree) {
        this.sizetree = sizetree;
        repaint();
    }

    /*
        Set number of tree and create new tree
    */
    public void setNumTree(int numTree) {
        this.numTree = numTree;
        reset();
    }
    
    
}
