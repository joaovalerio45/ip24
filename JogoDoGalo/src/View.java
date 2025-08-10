import pt.iscte.guitoo.Color;
import pt.iscte.guitoo.StandardColor;
import pt.iscte.guitoo.board.Board;

public class View {
	JogoDoGalo model;
	Board board;

	View() {
		model = new JogoDoGalo();
		board = new Board("vez do X", 3, 3, 80);
		board.setIconProvider(this::icon);
		board.addMouseListener(this::click);
		board.setBackgroundProvider(this::background);
		board.addAction("random", this::actionRandom);
		board.addAction("new", this::actionNew);
	}
	String icon(int line, int col) {
		if (JogoDoGalo.selected(line, col) == 1) {
			return "x.png";
		}
		if (JogoDoGalo.selected(line, col) == 2) {
			return "o.png";
		}
		return null;
	}
	void click(int line, int col) {
		JogoDoGalo.move(line,col);
		if(JogoDoGalo.isPlayerX() == true) {
			board.setTitle("vez do X");
		}else {
		board.setTitle("vez do O");
		}
	}
	Color background(int line, int col) {
			return StandardColor.WHITE;
	}
	void actionNew() {
		View gui = new View();
		gui.start();
		JogoDoGalo.resetPlayer();
	}
	void actionRandom() {
		JogoDoGalo.randomPlay();
	}
	void start() {
		board.open();
	}

	public static void main(String[] args) {
		View gui = new View();
		gui.start();
	}
}