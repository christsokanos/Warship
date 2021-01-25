
package navmaxia;

import java.util.Random;

/**
 *
 * @author Tsok
 */
public class Field {
    private int rows, cols;
    private Location[][] locs;
    private Player player;

    public Field(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        
        locs = new Location[rows][cols];
        
        for (int i = 0 ; i < rows ; i++){
            for (int j = 0 ; j < cols ; j++) locs[i][j] = new Location(i, j);
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
    
    public Location getLocation(int r, int c){
        return locs[r][c];
    }
    
    public Location getLocation(String locString)throws InvalidLocationException{
        int row = locString.toUpperCase().charAt(0) - 'A';
        int col = Integer.parseInt(locString.substring(1)) - 1;
        
        if (row < 0 || row >= rows){
            throw new InvalidLocationException("Wrong location given: " + locString);        
        }
        
        if (col < 0 || col >= cols){
            throw new InvalidLocationException("Wrong location given: " + locString);        
        }
        
        return locs[row][col];
    }
    
    public boolean placeShipRandomly(Ship s, int maxTries, boolean checkMarked){
        int length = s.getLength();
        int row, col, tries;
        ShipDirection dir;
        Random random = new Random();
        Location start;
        boolean result;
        
        tries = 0;
        while (tries < maxTries || maxTries == 0){
            row = random.nextInt(rows);
            col = random.nextInt(cols);
            
            start = locs[row][col];
            
            if (random.nextInt(2) == 0) dir = ShipDirection.HORIZONTAL;
            else dir = ShipDirection.VERTICAL;
            
            tries++;
            
            s.setDir(dir);
            s.setStart(start);
            
            result = placeShip(s, checkMarked);
            if (result == false){
                s.setDir(null);
                s.setStart(null);
            }
            else return true;
        }
        return false;
    }
    
    public boolean placeShip(Ship s, boolean checkMarked){
        int length = s.getLength();
        Location loc = s.getStart();
        int row = loc.getRow();
        int col = loc.getCol();
        ShipDirection dir = s.getDir();
        
        for (int i = 0 ; i < length ; i++){
            if (row >= rows || col >= cols){ // elegxos ektos orion
                return false;
            }
            
            loc = locs[row][col];
            
            if (loc.isEmpty() == false) return false;
            if (checkMarked == true && loc.isMarked() == true) return false;
            
            if (dir == ShipDirection.HORIZONTAL){
                col++;
            }
            else {
                row++;
            }
        }
        
        row = s.getStart().getRow();
        col = s.getStart().getCol();
        
        for (int i = 0 ; i < length ; i++){
            loc = locs[row][col];
            loc.setShip(s);
            
            if (dir == ShipDirection.HORIZONTAL){
                col++;
            }
            else {
                row++;
            }
        }
        return true;
    }
    
    public void removeShip(Ship s){
        
    }
    
    public void processValidMove(Location moveLoc){
        moveLoc.mark();
        
        if (moveLoc.isEmpty()) System.out.println("The sea is beaten!!! (μια τ�?�?πα στο νε�?�?!!!!)");
        else {
            Ship s = moveLoc.getShip();
            
            System.out.println(s.getHitMessage());
            
            if (s.isSinking()) System.out.println(s.getSinkMessage());
        }
    }
    
    public String toString(){
        String s = "     ";
        char row_str = 'A';
        
        for (int i = 0 ; i < cols ; i++){
            if (i + 1 < 9) s += (i+1) + "  ";
            else s += (i+1) + " ";
        }
        
        s += "\n    ";
        for (int i = 0 ; i < cols ; i++) s += "---";
        
        s += "\n";
        for (int i = 0 ; i < rows ; i++){
            s += row_str++ + " |  "; 
            for (int j = 0 ; j < cols ; j++){
                s += locs[i][j];
            }
            s += "\n";
        }
        s += "\n";
        
        return s;
    }
    
    public String toStringWithShips(){
        String s = "    ";
        char row_str = 'A';
        
        for (int i = 0 ; i < cols ; i++){
            if (i + 1 < 9) s += (i+1) + "  ";
            else s += (i+1) + " ";
        }
        
        s += "\n    ";
        for (int i = 0 ; i < cols ; i++) s += "---";
        
        s += "\n";
        for (int i = 0 ; i < rows ; i++){
            s += row_str++ + " |  "; 
            for (int j = 0 ; j < cols ; j++){
                s += locs[i][j].toStringWithShips();
            }
            s += "\n";
        }
        s += "\n";
        
        return s;
    }
}
