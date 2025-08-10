public class Dama {
    private Position position;
    private boolean isBlack;

    public Dama(Position position, boolean isBlack) {
        this.position = position;
        this.isBlack = isBlack;
    }
    
    public Position getPosition() {
    	return position;
    }
    
    public boolean getIsBlack() {
    	return isBlack;
    }
}