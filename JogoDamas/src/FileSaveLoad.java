import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileSaveLoad {

	public static void save(String filename, Model model) {
		String filenametxt = filename + ".txt";
		try {
			PrintWriter writer = new PrintWriter(new File(filenametxt));
			writer.println(model.getSize());
			writer.println(model.getPlayer());
			writer.println(model.getBlackCaptured());
			writer.println(model.getWhiteCaptured());
			int count = 0;
			for (int i = 0; i < model.getDamas().length; i++) {
				if (model.getDamas()[i] != null) {
					count++;
				}
			}
			writer.println(count);
			for (int i = 0; i < model.getDamas().length; i++) {
				if (model.getDamas()[i] != null) {
					writer.print(model.getDamas()[i].getIsBlack() + " ");
					writer.print(model.getDamas()[i].getPosition().getLine() + " ");
					writer.print(model.getDamas()[i].getPosition().getCol() + " ");
					writer.println();
				}
			}
			writer.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not found!");
		}
	}

	public static Model load(String filename) {
		String filenametxt = filename + ".txt";
		try {
			Scanner scanner = new Scanner(new File(filenametxt));
			int size = scanner.nextInt();
			boolean player = scanner.nextBoolean();
			int blackCaptured = scanner.nextInt();
			int whiteCaptured = scanner.nextInt();
			int damasLength = scanner.nextInt();
			Dama[] damas = new Dama[damasLength];
			for (int i = 0; i < damas.length; i++) {
				boolean isBlack = scanner.nextBoolean();
				int line = scanner.nextInt();
				int col = scanner.nextInt();
				Position p = new Position(line, col);
				damas[i] = new Dama(p, isBlack);
			}
			scanner.close();
			return new Model(size, player, blackCaptured, whiteCaptured, damas);

		} catch (FileNotFoundException e) {
			System.err.println("File not found!");
			return null;
		}
	}

}
