/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package UnoCardGame_Gallagher;

import java.util.ArrayList;
import java.util.Scanner;


public class Player {
    private ArrayList<Cards> playercards; 
    private String name; //player name

    public Player(String name) {
        playercards = new ArrayList<Cards>();
        this.name = name;
    }

    public int numberOfCards() {
        return playercards.size();
    }

    public ArrayList<Cards> PlayerCards(){
        return playercards;
    }


    public void pickCards(Cards c) {
        playercards.add(c);
    }

    public Cards throwCard(int c) {
        return playercards.remove(c);
    }

    public void sayUno() {
        Scanner s = new Scanner(System.in);
        if (playercards.size()==1){
            System.out.println("Uno");
            System.out.println("Press Enter...");
            s.nextLine();
        }
    }


    public void showCards() {
        String[] card = {" ","",""," "};
        String crd = "";

        for(int i=0;i<card.length;i++) {
            for(int j=0;j<playercards.size();j++) {
                if(!playercards.get(j).isSpecial()) {
                    if(i==1) {
                        crd = crd +" "+playercards.get(j).getColor()+" "+" ";
                    } else if(i==2) {
                        crd = crd + "  "+playercards.get(j).getValue()+"  "+" ";
                    } else {
                        crd = crd + card[i]+" "; 
                    }
                } else if(playercards.get(j).isSpecial()) {
                    if(i==1) {
                        crd = crd +" "+"+"+playercards.get(j).getValue()+"  "+" ";
                    } else {
                        crd = crd + card[i]+" ";
                    }
                }
            }
            crd +="\n";

        }
        System.out.print(crd);
    }

    public void hideCards() {

    String[] card = {" ","",""," "};
        String c = "";
        for(int i=0;i<card.length;i++) {
            for(int j=0;j<playercards.size();j++) {
                c = c + card[i]+" ";
            }
            c+="\n";
        }
        System.out.print(c);
    }

    public boolean hasWon() {
        if(playercards.size()==0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.name;
    }	
}