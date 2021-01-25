
package navmaxia;

import java.util.InputMismatchException;

/**
 *
 * @author Tsok
 */
public enum ShipDirection {
    HORIZONTAL, VERTICAL;
    
    public static ShipDirection fromString(String dirString){
        if (dirString.equalsIgnoreCase("v")) return VERTICAL;
        else if (dirString.equalsIgnoreCase("h")) return HORIZONTAL;
        
        throw new InputMismatchException("Wrong orientation: " + dirString);
    }
}
