import pt.iscte.guitoo.Color;
import pt.iscte.guitoo.StandardColor;
import pt.iscte.guitoo.board.Board;

public class View {
	Board board;
	Model model;

	View(Model model) {
		this.model = model;
		board = new Board("Brancas Jogam", model.getSize(), model.getSize(), 50);
		board.setBackgroundProvider(this::background);
		board.setIconProvider(this::icon);
		board.addMouseListener(this::click);
		board.addAction("aleatória", this::actionRandom);
		board.addAction("novo", this::actionNew);
		board.addAction("gravar", this::actionSave);
		board.addAction("carregar", this::actionLoad);
	}

	void start() {
		board.open();
	}

	Color background(int line, int col) {
		Position p = new Position(line, col);
		Dama selected = model.getSelectedPiece();
		if ((selected != null && selected.getPosition().equals(p)) && !model.isEmpty(line, col)) {
			return StandardColor.YELLOW;
		}
		if ((line + col) % 2 == 0) {
			return StandardColor.WHITE;
		} else {
			return StandardColor.BLACK;
		}
	}

	String icon(int line, int col) {
		Position p = new Position(line, col);
		Dama[] Damas = model.getDamas();
		for (int i = 0; i < Damas.length; i++) {
			if (Damas[i] != null && Damas[i].getPosition().equals(p)) {
				return Damas[i].getIsBlack() ? "black.png" : "white.png";
			}
		}

		return null;
	}

	void click(int line, int col) {
		model.selectPiece(line, col);
		model.move(line, col);
		board.setTitle(model.getPlayer() ? "Pretas Jogam" : "Brancas Jogam");
		if (model.isGameFinished()) {
			if (model.getBlackCaptured() == model.getWhiteCaptured()) {
				board.showMessage("Empate");
			} else {
				board.showMessage(
						model.getBlackCaptured() > model.getWhiteCaptured() ? "Brancas Ganham" : "Pretas Ganham");
			}
		}
	}

	private void actionRandom() {
		model.randomMove();
		board.setTitle(model.getPlayer() ? "Pretas Jogam" : "Brancas Jogam");
		if (model.isGameFinished()) {
			if (model.getBlackCaptured() == model.getWhiteCaptured()) {
				board.showMessage("Empate");
			} else {
				board.showMessage(
						model.getBlackCaptured() > model.getWhiteCaptured() ? "Brancas Ganham" : "Pretas Ganham");
			}
		}
	}

	private void actionNew() {
		int size = board.promptInt("Tamanho do tabuleiro:");
		int piecesPerPlayer = board.promptInt("Número de peças por jogador");
		Model model = new Model(size, piecesPerPlayer);
		View gui = new View(model);
		gui.start();
	}

	private void actionSave() {
		String filename = board.promptText("Nome do ficheiro:");
		if (filename == null) {
			board.showMessage("Nome de ficheiro inválido");
			return;
		}

		FileSaveLoad.save(filename, model);
		board.showMessage("Ficheiro gravado com sucesso");

	}

	private void actionLoad() {
		String filename = board.promptText("Nome do ficheiro:");
		if (filename == null) {
			board.showMessage("Nome de ficheiro inválido");
			return;
		}
		Model newModel = FileSaveLoad.load(filename);
		if (newModel == null) {
	        board.showMessage("Erro ao carregar o ficheiro.");
		}else {
			board.showMessage("Ficheiro carregado com sucesso");
			View newGui = new View(newModel);
			newGui.start();
		}
	}

	public static void main(String[] args) {
		Model model = new Model();
		View gui = new View(model);
		gui.start();
	}
}