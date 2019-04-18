/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package UnoCardGame_Gallagher;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Cards current; // the current card or previously played card or starting card
    private GroupOfCards deck; // the deck of the game
    private ArrayList<Cards> cardpile; //when players throw card, it piles up here. Also, creates a new deck if the current deck is empty
    private Scanner choice;
    private Player p1,p2; //player 1 and 2
    private int pick; 
	
	public Game() {
            deck = new GroupOfCards();
            deck.shuffle();
            current = getStartingCard();
            cardpile = new ArrayList<Cards>();
            cardpile.add(current);
            choice = new Scanner(System.in);
            p1 = new Player("Player 1");
            p2 = new Player("Player 2");
            distributecards();	
	}
        public void game() {
            int turn=0;
            while(!gameOver(p1,p2)) {
                if(turn%2==0) {
                playGame(p1);}
                else {
                playGame(p2);}
                turn++;
            }

	}	
    private void distributecards() {
        for(int i=0;i<10;i++) {
            if(i%2==0) {
                p1.pickCards(deck.getTopCard());
            } else {
                p2.pickCards(deck.getTopCard());
            }
        }
    }
		
	public void playGame(Player p) {
            System.out.println(p+", It is your turn\nThe current card on play is:\n"+current);
            showBoard(p);
            
            if(!hasColor(p) && !hasValue(p) && !hasSpecial(p)) {
                Cards pick=null;	
                System.out.println("You dont have a valid card to play, so you have to pick cards.");
                while(!hasColor(p) && !hasValue(p) && !hasSpecial(p)) {
                    pause();
                    pick = deck.getTopCard();
                    p.pickCards(pick);
                    System.out.println("You picked:\n"+pick);
                }
                System.out.println("You recieved a valid card!");
                pause();
                System.out.println("You have the following cards: ");
                p.showCards();
            }
            System.out.println("Please pick a card:");
            pick = choice.nextInt()-1;           
            while(!isValidChoice(p,pick)) {
                    System.out.println("Invalid pick. Please pick a valid card.");
                    pick = choice.nextInt()-1;
            }
            Cards play = p.throwCard(pick);

            p.sayUno();
            current = play;
            cardpile.add(current);
	}
	
	private boolean hasSpecial(Player p) {
            for(Cards c:p.PlayerCards()) {
                if(c.isSpecial()) {
                    return true;
                }
            }
            return false;
	}

	private boolean isValidChoice(Player p,int choice) {
            if(choice <= p.PlayerCards().size()) {
                if(p.PlayerCards().get(choice).getColor().equals(current.getColor()) || p.PlayerCards().get(choice).getValue()==current.getValue() || p.PlayerCards().get(choice).isSpecial()) {
                    return true;
                }
            }
            return false;
	}
		
	private void pause() {
            System.out.println("Press enter to continue......");
            choice.nextLine();
	}
	
		
	private boolean hasColor(Player p) {
            for(Cards c:p.PlayerCards()) {
                if(c.getColor().equals(current.getColor())) {
                        return true;
                }
            }
            return false;
	}
	
	private boolean hasValue(Player p) {  
            for(Cards c:p.PlayerCards()) {
                if(c.getValue()==current.getValue()) {
                        return true;
                }
            }

            return false;
	}

	private boolean canOverride(Player p) {
            for(Cards c:p.PlayerCards()) {
                if(c.isSpecial()) {
                    if(c.getValue() >= current.getValue()) {
                        return true;
                    }
                }
            }


            return false;
	}
	
	private Cards getStartingCard() {
            Cards temp = deck.peek();
            while(temp.isSpecial()) {
                    deck.shuffle();
                    temp = deck.peek();
            }

            temp = deck.getTopCard();
            return temp;
	}
	
    public boolean gameOver(Player p1,Player p2) {

        if(p1.hasWon()) {
            System.out.println("Player 1 wins");
            return true;
        }

        else if(p2.hasWon()) {
            System.out.println("Player 2 wins");
            return true;
        }

        return false;
    }

    public void showBoard(Player p) {

        if(p.toString().equals("Player 1")) {
            System.out.println("                Player 1");
            p1.showCards();
            p2.hideCards();
            System.out.println("                Player 2");
            System.out.println("");
        } else {
            System.out.println("                Player 1");
            p1.hideCards();
            p2.showCards();
            System.out.println("                Player 2");
            System.out.println("");
        }
    }
}