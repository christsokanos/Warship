
package navmaxia;

/**
 *
 * @author Tsok
 */
public class Submarine extends Ship{

    public Submarine(Field field) {
        super(1, 3, 'S', field);
    }
    
    public String getSinkMessage(){
        return "Submarine is sinking";
    }
    public void threaten(){
        
    }
    
}
