/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card_raider;

/**
 *
 * @author ce
 */
public class card {
    public int value;
    public char suite;
    
    
    public card(char c,int i)
    {
        value =i;
        suite=c;
    }
    
    public void display()
    {
        System.out.print(suite + "-"+value+" ");
    }
}
