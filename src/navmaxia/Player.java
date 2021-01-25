
package navmaxia;

/**
 *
 * @author Tsok
 */
public abstract class Player {
    private String name;
    private int score;
    private Field field;
    
    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void initField(int r, int c){
        field = new Field(r, c);
    }
    
    public abstract void placeShips(Field otherField);

    public int getScore() {
        return score;
    }

    public Field getField() {
        return field;
    }
    
    public abstract void selectMove();
}
