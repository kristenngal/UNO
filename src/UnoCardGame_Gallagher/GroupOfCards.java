/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package UnoCardGame_Gallagher;

import java.util.ArrayList;
import java.util.Collections;

public class GroupOfCards {
    private ArrayList<Cards> deck;
    public GroupOfCards() {
        deck = new ArrayList<Cards>();
        String[] colors = {"red","blue","green","yellow"}; //colors
        int[] numbers = {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,0}; //regular cards
        int[] specialnumbers = {2,2,4,4}; //special cards +2, +2, +4 and +4
        for(String c:colors) { 
            for(int i:numbers) {
                deck.add(new Cards(i,c)); 
            }
        }

        for(int i:specialnumbers) { 
            deck.add(new Cards(i));
        }
    }

    public GroupOfCards(ArrayList<Cards> c) { //overloaded constructor
        deck = c;
    }


    public boolean isEmpty() { //is deck empty?
        if(deck.size()>0) {
            return false;
        }
        return true;
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Cards getTopCard() {
        return deck.remove(deck.size()-1);
    }

    public Cards peek() {
        return deck.get(deck.size()-1);
    }


    public String toString() {
        String deck="";
        for(Cards c:this.deck) {
            deck = deck +c+ " ";
        }
        return deck;
    }		
}