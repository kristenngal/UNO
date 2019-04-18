/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package UnoCardGame_Gallagher;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the code 
 * should remember to add themselves as a modifier.
 * @author dancye, 2018
 */
public class Cards {
	
    private String color;
    private int value;
    private int specialValue;
    private boolean special;

    public Cards(int value,String color) {

        this.color = color;
        this.value = value;
        this.specialValue = 0;
        this.special = false;
    }

    public Cards(int specialValue) { 	
        this.color="";
        this.specialValue = specialValue;
        this.value = 0;
        this.special = true;
    }

    public String getColor() {       
        return this.color;
    }

    public int getValue() {
         if(!this.special) {
        return this.value;
        } else {
            return this.specialValue;
        }
    }

    public String toString() {
        String[] card = {" ","","","  "};
        String crd = "";
        for(int i=0;i<card.length;i++) {
            for(int j=0;j<1;j++) {
                if(!this.isSpecial()) {
                    if(i==1) {
                        crd = crd +" "+this.getColor()+" "+" ";
                    } else if(i==2) {
                        crd = crd + " "+this.getValue()+"  "+" ";
                    } else {
                        crd = crd + card[i]+" "; 
                    }
                } else if(this.isSpecial()) {
                    if(i==1) {
                        crd = crd +" "+"+"+this.getValue()+" "+" ";

                    } else {
                        crd = crd + card[i]+" ";
                    }
                }
            }
            crd +="\n";
        }
        return crd;
    }

    public boolean isSpecial() {
        if(special) {
            return true;
        }
        return false;
    }
	
}
