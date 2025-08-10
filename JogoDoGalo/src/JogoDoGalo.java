public class JogoDoGalo{
	private static final int size = 3;
	private static int[][] matrix;
	private static boolean isPlayerX = true;
	private static int Player_X = 1;
	private static int Player_O = 2;
	
	JogoDoGalo(){
		matrix = new int[size][size];
	}
	public static boolean isPlayerX() {
		return isPlayerX;
	}
	public static void resetPlayer() {
		isPlayerX = true;
	}
	public static int selected(int line, int col) {
		return matrix[line][col];
	}
	public static boolean isValid(int line, int col) {
		if (matrix[line][col] == 0) {
			return true;
		}
		return false;
	}
	public static boolean fullBoard() {
		for (int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if (matrix[i][j] == 0) {
					return false;
				}
			} 
		}
		return true;
	}
	public static void randomPlay() {
		if (fullBoard() == false) {
			int line;
			int col;
			do {
				line = (int)(Math.random() * 3);
				col = (int)(Math.random() * 3)	;
			} while(isValid(line, col) == false);
			move(line,col);
		}
	}
	public static void move(int line, int col) {
		if (isValid(line,col)) {
			matrix[line][col] = (isPlayerX ? Player_X : Player_O);
			isPlayerX = !isPlayerX;
		}
	}
	public static boolean checkCol() {
		int winCol = 0;
		for (int i = 0; i < 3; i++) {
			if (matrix[0][i] == matrix[1][i] && matrix[0][i] == matrix[2][i]) {
				winCol = i;
				return true;
			}
		}
		return false;
	}
	public static boolean checkLin() {
		int winLin = 0;
		for (int i = 0; i < 3; i++) {
			if (matrix[i][0] == matrix[i][1] && matrix[i][0] == matrix[i][2]) {
				winLin = i;
				return true;
			}
		}
		return false;
	}
	public static boolean checkDiag() {
		int winDiag = 0;
		if (matrix[0][0] == matrix[1][1] && matrix[0][0] == matrix[2][2]) {
			winDiag = 1;
			return true;
		}
		if (matrix[0][2] == matrix[1][1] && matrix[0][2] == matrix[2][0]) {
			winDiag = 2;
			return true;
		}
		return false;
	}
	public static void checkWin() {
		if (checkCol() == true ) {
			
		}
	}
}