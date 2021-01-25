
package navmaxia;

/**
 *
 * @author Tsok
 */
public class Destroyer extends Ship{

    public Destroyer(Field field) {
        super(3, 2, 'D', field);
    }
    
    public String getSinkMessage(){
        return "Destroyer is sinking";
    }
    public void threaten(){
        
    }
    
}
