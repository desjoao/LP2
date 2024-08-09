class Cup {
    int qnt = 0;

    void changeQnt (int newValue){
        qnt = qnt + newValue;
        System.out.println("The cup has " + qnt + " ml.");
        if (qnt == 100){        
            System.out.println("the cup is full.");  
        }
        else{
            if (qnt > 100){
                System.out.println("the cup overflowed.");            
            }        
        }
    } 
}

class CupDemo{
    public static void main(String[] args){
        // Create a cup and changes it's volume
        Cup cup = new Cup();

        cup.changeQnt(50);
        cup.changeQnt(40);
        cup.changeQnt(15);
    }
}
        
