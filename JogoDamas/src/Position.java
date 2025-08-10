public record Position(int line, int col) {
	
	public int getLine() {
		return this.line;
	}
	
	public int getCol() {
		return this.col;
	}
}