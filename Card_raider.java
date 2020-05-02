/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card_raider;

import static card_raider.player.Total;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Card_raider {

    static List<card> Deck = new LinkedList<>();
    
    static List<card> Table = new LinkedList<>();
    
    static List<card> Prize = new LinkedList<>();
    
    
    static List<player> players = new LinkedList<>();
    
    static List<player> round = new LinkedList<>();
    
    static List<player> leave = new LinkedList<>();
    
    
    
    
    public static void main(String[] args) {
    
        
        
        player p1 = new player(true);
        player p2 = new player();
        player p3 = new player();
        player p4 = new player();
        player p5 = new player();
        player p6 = new player();
        
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        players.add(p5);
        players.add(p6);
   
        
        
   float sum_prize=0;
   float sum_len=0;
   
   reset();
   
   
   
   for(int k=0;k<1;k++){
                   int len =0;
                   char suit=' ';
                   clear();
                   
                    round.add(p1);
                    round.add(p2);
                    round.add(p3);
                    round.add(p4);
                    round.add(p5);
                    round.add(p6);
                   
                   boolean fresh =true;
                  
                   
                   
                   while(!clash())                      
                  { len++;
                       card curr = draw();
                       if(fresh) suit = curr.suite;
                       fresh=false;
                       
                       if(curr.suite==suit)  Prize.add(curr);
                       else Table.add(curr);
                                            
                   
                          System.out.print("Table : ");
                       for(int i=0;i<Table.size();i++) Table.get(i).display();
                       System.out.println();
                       
                       System.out.print("Prize : ");
                       for(int i=0;i<Prize.size();i++) Prize.get(i).display();
                       System.out.println();
                       
     
                       Iterator itr = round.iterator();
                       while(itr.hasNext())
                       {
                           player p = (player) itr.next();
                           if(p.leave(Prize, Table))
                           {
                               leave.add(p);
                               itr.remove();
                           }
                       }
                      split();
                       
                     if(round.isEmpty())
                          break;
                       
                  }                   
                 System.out.println();
                 System.out.println("draw length :" +len);
       
   
   
                  for(int i=0;i<players.size();i++)
                  {
                        System.out.println("p" +players.get(i).Risk +"`s Score : "+ Total(players.get(i).collected)  );
                  }
     
                  
                  if(Deck.size()<20)
                     reset();
               
   }                
     System.out.println("Deck left : "+ Deck.size()); 
      
      
      
    }
    
    
    
    static void reset()
    {
        char[] suits =  {'A','B','C','D'};
        
        Deck = new LinkedList<>();
        Table = new LinkedList<>();
        Prize = new LinkedList<>();
        
        for(int i=0;i<4;i++)
        {
            for(int j=2;j<15;j++)
            {
                Deck.add(new card(suits[i],j));
            }
        }
    }
    
  static void clear()
    {
        Deck.addAll(Table);
        Deck.addAll(Prize);
        
        
        Table = new LinkedList<>();
        Prize = new LinkedList<>();
    }
    
    
    
    
    static boolean clash()
    {
        if(Table.size()<2)
            return false;
        
        for(int i=0;i<Table.size();i++)
        {
            for(int j=0;j<Table.size();j++)
            {
                if(i==j ) continue;
                
                if(Table.get(i).value==Table.get(j).value)
                    return true;
            }
        }
        return false;
    }
    
    
    
    public static card draw()
    {
         return Deck.remove((int) (Math.random()*Deck.size()));
    }
    
    
  
    public static void split()
    {
       
        
        int l = leave.size();
        int p = Prize.size();
       
        
        
        
        if(l==0){leave = new LinkedList<>();return;}
        System.out.println("spliting "+p+" in "+l );
        
        
        int take = p/l;
        System.out.println("each take " + take);
        for(int i=0;i<leave.size();i++)
        {
            System.out.print("p"+leave.get(i).Risk+" leaves with ");
            
            for(int j=0;j<take;j++)
            {
                 card c = Prize.remove((int)Math.random()*Prize.size());
                 c.display();
                 leave.get(i).collected.add(c );
            }
            if(!Table.isEmpty())
            {
                  card c = Table.remove((int)Math.random()*Table.size());
                  System.out.print(" removes ");
                  c.display();
            }
            System.out.println();
        }
        
        leave = new LinkedList<>();
        
    }
    
    
    
    
    
}
