
package navmaxia;

/**
 *
 * @author Tsok
 */
public abstract class Ship {
    private final int length;
    private final int points;
    private final char letter;
    private final Field field;
    private Location start;
    private ShipDirection dir;

    public Ship(int length, int points, char letter, Field field) {
        this.length = length;
        this.points = points;
        this.letter = letter;
        this.field = field;
    }

    public int getLength() {
        return length;
    }

    public int getPoints() {
        return points;
    }

    public char getLetter() {
        return letter;
    }

    public Field getField() {
        return field;
    }

    public Location getStart() {
        return start;
    }

    public ShipDirection getDir() {
        return dir;
    }

    public void setStart(Location start) {
        this.start = start;
    }

    public void setDir(ShipDirection dir) {
        this.dir = dir;
    }
    
    public void hit(){
        
    }
    
    public boolean isHit(){
        
        return false;
    }
    
    public boolean isSinking(){
        int row = start.getRow();
        int col = start.getCol();
        
        Location loc;
        
        for (int i = 0 ; i < length ; i++){
            loc = field.getLocation(row, col);
            
            if (this == loc.getShip() && loc.isMarked() == false) return false;
            
            if (dir == ShipDirection.HORIZONTAL){
                col++;
            }
            else {
                row++;
            }
        }

        return true;
    }
    
    public String getHitMessage(){
        return "A ship is hit!";
    }
    
    public abstract String getSinkMessage();
    public abstract void threaten();
    
}
