/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card_raider;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ce
 */
public class player {
    
     public float Risk;
     
     public boolean AI;
    
     public List<card> collected;
     
    
    public player()
    {
        collected = new LinkedList<>();
        Risk = (float) (Math.random());
        AI=true;
    }
    
    public player(float i)
    {
        collected = new LinkedList<>();
        Risk = i;
        AI=true;
    }
    
    
    public player(boolean x)
    {
        collected = new LinkedList<>();
        AI=false;
        Risk= 1000;
    }
    
    
    public boolean leave(List<card> prize,List<card> table)
    {
        if(prize.size()==0)return false;
        
        if(AI)
        {
        float sum = (Total(prize)/2f) + (table.size()*3f) - prize.size();
        
        if( (sum - 8 -(10*Risk)   +(Math.random()*2)   >0))
                return true;
        return false;
        }
        else
        {
            System.out.println("do you want to leave");
            Scanner scn = new Scanner(System.in);
            
            return scn.nextBoolean();
        }
    }
    
    
    public static int Total(List<card> c)
    {
        int sum=0;
        for(int i=0;i<c.size();i++)
            sum+=c.get(i).value;
        return sum;
    }
    
    
    
}
