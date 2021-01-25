
package navmaxia;

/**
 *
 * @author Tsok
 */
public class AircraftCarrier extends Ship{

    public AircraftCarrier(Field field) {
        super(5, 5, 'A', field);
    }
    
    public String getSinkMessage(){
        return "Aircraft carrier is sinking";
    }
    public void threaten(){
        
    }
    
}
