
package navmaxia;

import java.util.Random;

/**
 *
 * @author Tsok
 */
public class ComputerPlayer extends Player{

    public ComputerPlayer(String name) {
        super(name);
    }
    
    public void placeShips(Field otherField){
        Ship ships[] = new Ship[7];
        
        ships[0] = new AircraftCarrier(otherField);
        ships[1] = new AircraftCarrier(otherField);
        ships[2] = new Destroyer(otherField);
        ships[3] = new Destroyer(otherField);
        ships[4] = new Destroyer(otherField);
        ships[5] = new Submarine(otherField);
        ships[6] = new Submarine(otherField);

        for (Ship s: ships){
            otherField.placeShipRandomly(s, 0, false);
        }            
    }
    public void selectMove(){
        Location loc;
        int col, row;
        Random random = new Random();
        
        col = random.nextInt(getField().getCols());
        row = random.nextInt(getField().getRows());
        char row_str;
        row_str = ((char)row);
        row_str += 'A';
        
        System.out.println("Player " + getName() + " is auto-playing at position: " + row_str + col);
        
        loc = getField().getLocation(row, col);
        getField().processValidMove(loc);
    }
}
