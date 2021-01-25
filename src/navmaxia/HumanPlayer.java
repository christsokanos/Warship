
package navmaxia;

import java.util.Scanner;

/**
 *
 * @author Tsok
 */
public class HumanPlayer extends Player{

    public HumanPlayer(String name) {
        super(name);
    }
    
    public void placeShips(Field otherField){
        Scanner scanner = new Scanner(System.in);
        int x;
        Ship ships[] = new Ship[7];
        
        ships[0] = new AircraftCarrier(otherField);
        ships[1] = new AircraftCarrier(otherField);
        ships[2] = new Destroyer(otherField);
        ships[3] = new Destroyer(otherField);
        ships[4] = new Destroyer(otherField);
        ships[5] = new Submarine(otherField);
        ships[6] = new Submarine(otherField);
        
        do{
            System.out.println("Player " + getName() + ": enter 1 for automatic placement of ships, 2 for manual placement");
            x = scanner.nextInt();
        }while (x != 1 && x != 2);
        
        if (x == 1){ // automatic
            for (Ship ship: ships){
                otherField.placeShipRandomly(ship, 0, false);
            }            
        }
        else { // manual
            
        }
    }
    
    public void selectMove(){
        Location loc;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Player " + getName());
        System.out.println(getField());
        System.out.println("Player " + getName() + ": enter move");
        String str = scanner.next();

        boolean isCorrectMove = false;
        while (isCorrectMove == false){
            try{
                loc = getField().getLocation(str);
                getField().processValidMove(loc);
                isCorrectMove = true;
            }
            catch (InvalidLocationException e){
                System.out.println(e);
            }
        }
    }
    
}
