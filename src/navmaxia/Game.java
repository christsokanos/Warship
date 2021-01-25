
package navmaxia;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Tsok
 */
public class Game {
    private int rows, cols;
    private int moves;
    private Player pl1, pl2;
    private Scanner scanner = new Scanner(System.in);
    
    public void init(){
        String str, name;
        
        do {
            System.out.println("Enter rows (10 to 15)");
            rows = scanner.nextInt();
        }while (rows < 10 || rows > 15);
        
        do {
            System.out.println("Enter columns (10 to 15)");
            cols = scanner.nextInt();
        }while (cols < 10 || cols > 15);
        
        
        for (int i = 1 ; i < 3 ; i++){
            do{
                System.out.println("Player " + i + " is human? (y/n)");
                str = scanner.next();
            }while (str.equalsIgnoreCase("y") == false && str.equalsIgnoreCase("n") == false);
            
            System.out.println("Enter name of player " + i);
            name = scanner.next();
            
            if (str.equalsIgnoreCase("y")){
                if (i == 1) pl1 = new HumanPlayer(name);
                else pl2 = new HumanPlayer(name);
            }
            else {
                if (i == 1) pl1 = new ComputerPlayer(name);
                else pl2 = new ComputerPlayer(name);
            }
        }
        
        System.out.println("Enter number of moves of game (0 for infinite)");
        moves = scanner.nextInt();
        
        
        pl1.initField(rows, cols);
        pl2.initField(rows, cols);
        
        
    }
    
    public void placeShips(){
        pl1.placeShips(pl2.getField());
        pl2.placeShips(pl1.getField());
        
        System.out.println(pl1.getField().toStringWithShips());
        System.out.println(pl2.getField().toStringWithShips());
    }
    
    public void play(){
        Random random = new Random();
        Player p1, p2;
        int curr_move;
        String str;
        boolean isCorrectMove;
        Scanner scanner = new Scanner(System.in);
        Location loc;
        
        if (random.nextInt(2) == 0){
            p1 = pl1;
            p2 = pl2;
        }
        else {
            p1 = pl2;
            p2 = pl1;
        }
        
        curr_move = 0;
        while (curr_move < moves){
            curr_move++;
            pl1.selectMove();
            pl2.selectMove();
        }
        
        
    }
    
    public void showResult(){
        System.out.println(" *** END OF GAME ***");
        System.out.println(pl1.getField().toStringWithShips());
        System.out.println(pl2.getField().toStringWithShips());
    }
}
