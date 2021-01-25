
package navmaxia;

/**
 *
 * @author Tsok
 */
public class Navmaxia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Game g = new Game();
        
        g.init();
        g.placeShips();
        g.play();
        g.showResult();
    }
    
}
