/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spreadfiresimulator;

/**
 *
 * @author StaroMoon
 */
public class EachTree {
    public static final int BURN = 2, TREE = 1,EMTRY = 0;
    private int state;
    
    public EachTree(){
        state = TREE;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    
}
