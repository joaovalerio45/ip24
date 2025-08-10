public class Model {

	private int size;
	private Dama[] damas;
	private Dama selectedPiece = null;
	private boolean isSelected = false;
	private boolean player = false;
	private int blackCaptured = 0;
	private int whiteCaptured = 0;
	private boolean gameFinished = false;

	Model() {
		this(8, 12);
	}

	Model(int size, int piecesPerPlayer) {
		this.size = size;
		damas = new Dama[2 * piecesPerPlayer];

		int index = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if ((i + j) % 2 != 0 && index < piecesPerPlayer) {
					damas[index++] = new Dama(new Position(i, j), true);
				}
			}
		}
		for (int i = size - 1; i >= 0; i--) {
			for (int j = size - 1; j >= 0; j--) {
				if ((i + j) % 2 != 0 && index < (2 * piecesPerPlayer)) {
					damas[index++] = new Dama(new Position(i, j), false);
				}
			}
		}
	}

	Model(int size, boolean player, int blackCaptured, int whiteCaptured, Dama[] damas) {
		this.size = size;
		this.player = player;
		this.blackCaptured = blackCaptured;
		this.whiteCaptured = whiteCaptured;
		this.damas = damas;

	}

	public int getSize() {
		return size;
	}

	public Dama[] getDamas() {
		return damas;
	}

	public Dama getSelectedPiece() {
		return selectedPiece;
	}

	public boolean getIsSelected() {
		return isSelected;
	}

	public boolean getPlayer() {
		return player;
	}

	public boolean isGameFinished() {
		return gameFinished;
	}

	public int getBlackCaptured() {
		return blackCaptured;
	}

	public int getWhiteCaptured() {
		return whiteCaptured;
	}

	public boolean isEmpty(int line, int col) {
		for (int i = 0; i < damas.length; i++) {
			if (damas[i] != null && damas[i].getPosition().equals(new Position(line, col))) {
				return false;
			}
		}
		return true;
	}

	public void isEnd() {
	    for (int i = 0; i < damas.length; i++) {
	        if (damas[i] != null && damas[i].getIsBlack() == player && hasValidMove(damas[i].getPosition().getLine(), damas[i].getPosition().getCol())) {
	        	gameFinished = false;
	        	return;
	        }
	    }
	    gameFinished = true;
	}


	public Dama getPieceAt(int line, int col) {
		Position p = new Position(line, col);
		for (int i = 0; i < damas.length; i++) {
			if (damas[i] != null && damas[i].getPosition().equals(p)) {
				return damas[i];
			}
		}
		return null;
	}

	public void selectPiece(int line, int col) {
		Position p = new Position(line, col);
		boolean selectCapture = false;
		for (int i = 0; i < damas.length; i++) {
			if (damas[i] != null && damas[i].getIsBlack() == player
					&& canCapture(damas[i].getPosition().getLine(), damas[i].getPosition().getCol())) {
				selectCapture = true;
			}
		}
		if (selectCapture) {
			for (int i = 0; i < damas.length; i++) {
				if (damas[i] != null && damas[i].getPosition().equals(p) && damas[i].getIsBlack() == player
						&& canCapture(damas[i].getPosition().getLine(), damas[i].getPosition().getCol())) {
					isSelected = true;
					selectedPiece = damas[i];
					return;
				}
			}
		} else {
			for (int i = 0; i < damas.length; i++) {
				if (damas[i] != null && damas[i].getPosition().equals(p) && damas[i].getIsBlack() == player) {
					isSelected = true;
					selectedPiece = damas[i];
					return;
				}
			}
		}
	}

	public void capture(Position from, Position to) {
		int line1 = from.getLine();
		int col1 = from.getCol();
		int line2 = to.getLine();
		int col2 = to.getCol();
		if (Math.abs(line1 - line2) == 2 && Math.abs(col1 - col2) == 2) {
			int middleLine = (line1 + line2) / 2;
			int middleCol = (col1 + col2) / 2;

			for (int i = 0; i < damas.length; i++) {
				if (damas[i] != null && damas[i].getPosition().equals(new Position(middleLine, middleCol))) {
					if (damas[i].getIsBlack()) {
						blackCaptured++;
					} else {
						whiteCaptured++;
					}
					damas[i] = null;
				}
			}
		}
	}

	public void move(int line, int col) {
		Position changePosition = new Position(line, col);
		if (isSelected && isValidMove(selectedPiece.getPosition(), changePosition)) {
			for (int i = 0; i < damas.length; i++) {
				if (damas[i] != null && damas[i].getPosition().equals(selectedPiece.getPosition())) {
					damas[i] = new Dama(changePosition, selectedPiece.getIsBlack());
				}
			}
			capture(selectedPiece.getPosition(), changePosition);
			isSelected = false;
			selectedPiece = null;
			player = !player;
			isEnd();
		}
		isEnd();

	}

	public boolean isValidMove(Position from, Position to) {
		int line1 = from.getLine();
		int col1 = from.getCol();
		int line2 = to.getLine();
		int col2 = to.getCol();
		Dama[] canMoveCapture = new Dama[damas.length];
		int x = 0;
		for (int i = 0; i < damas.length; i++) {
			if (damas[i] != null && canCapture(damas[i].getPosition().getLine(), damas[i].getPosition().getCol())
					&& damas[i].getIsBlack() == player) {
				canMoveCapture[x] = damas[i];
				x++;
			}
		}
		if (canMoveCapture[0] != null) {
			for (int i = 0; i < canMoveCapture.length; i++) {
				if (getPieceAt(line1, col1) == canMoveCapture[i] && isEmpty(line2, col2)) {
					if (getPieceAt(line1, col1).getIsBlack() == true) {
						if ((line1 - line2 == -2 && Math.abs(col1 - col2) == 2)) {
							int middleLine = (line1 + line2) / 2;
							int middleCol = (col1 + col2) / 2;
							if (!isEmpty(middleLine, middleCol) && getPieceAt(line1, col1)
									.getIsBlack() != getPieceAt(middleLine, middleCol).getIsBlack()) {
								return true;
							}
						}
					} else {
						if ((line1 - line2 == 2 && Math.abs(col1 - col2) == 2)) {
							int middleLine = (line1 + line2) / 2;
							int middleCol = (col1 + col2) / 2;
							if (!isEmpty(middleLine, middleCol) && getPieceAt(line1, col1)
									.getIsBlack() != getPieceAt(middleLine, middleCol).getIsBlack()) {
								return true;
							}
						}
					}
				}
			}

		} else {
			if (isEmpty(line2, col2)) {
				if (getPieceAt(line1, col1).getIsBlack() == true && player == true) {
					if ((line1 - line2 == -1 && Math.abs(col1 - col2) == 1)) {
						return true;
					}
				} else {
					if ((line1 - line2 == 1 && Math.abs(col1 - col2) == 1)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean hasValidMove(int line, int col) {
		Position p = new Position(line, col);
		Position from = null;
		for (int i = 0; i < damas.length; i++) {
			if (damas[i] != null && damas[i].getPosition().equals(p)) {
				from = damas[i].getPosition();
			}
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				Position to = new Position(i, j);
				if (isValidMove(from, to)) {
					return true;
				}
			}
		}
		return false;
	}
	

//	public boolean canCapture(int line, int col) {
//		for (int i = 0; i < damas.length; i++) {
//			if (damas[i] != null && damas[i].getIsBlack() == player) {
//				for (int j = 0; j < size; j++) {
//					for (int k = 0; k < size; k++) {
//						if(player == true) {
//							if (line - j == 2 && Math.abs(col - k) == 2) {
//								int middleLine = (line + j) / 2;
//								int middleCol = (col + k) / 2;
//								if (!isEmpty(middleLine, middleCol) && isEmpty(j, k)
//										&& getPieceAt(middleLine, middleCol).getIsBlack() != player) {
//									return true;
//								}
//							}
//						}else {
//							if (line - j == -2 && Math.abs(col - k) == 2) {
//								int middleLine = (line + j) / 2;
//								int middleCol = (col + k) / 2;
//								if (!isEmpty(middleLine, middleCol) && isEmpty(j, k)
//										&& getPieceAt(middleLine, middleCol).getIsBlack() != player) {
//									return true;
//								}
//							}
//						}
//					}
//				}
//			}
//		}
//		return false;
//	}

	public boolean canCapture(int line, int col) {
	    Dama dama = getPieceAt(line, col);
	    if (dama == null || dama.getIsBlack() != player) {
	        return false; 
	    }

	    if (player) {
	        if (line + 2 < size) {
	            if (col + 2 < size) { 
	                int middleLine = line + 1;
	                int middleCol = col + 1;
	                if (!isEmpty(middleLine, middleCol) && isEmpty(line + 2, col + 2)
	                        && getPieceAt(middleLine, middleCol).getIsBlack() != player) {
	                    return true;
	                }
	            }
	            if (col - 2 >= 0) {
	                int middleLine = line + 1;
	                int middleCol = col - 1;
	                if (!isEmpty(middleLine, middleCol) && isEmpty(line + 2, col - 2)
	                        && getPieceAt(middleLine, middleCol).getIsBlack() != player) {
	                    return true;
	                }
	            }
	        }
	    } else {
	        if (line - 2 >= 0) {
	            if (col + 2 < size) {
	                int middleLine = line - 1;
	                int middleCol = col + 1;
	                if (!isEmpty(middleLine, middleCol) && isEmpty(line - 2, col + 2)
	                        && getPieceAt(middleLine, middleCol).getIsBlack() != player) {
	                    return true;
	                }
	            }
	            if (col - 2 >= 0) {
	                int middleLine = line - 1;
	                int middleCol = col - 1;
	                if (!isEmpty(middleLine, middleCol) && isEmpty(line - 2, col - 2)
	                        && getPieceAt(middleLine, middleCol).getIsBlack() != player) {
	                    return true;
	                }
	            }
	        }
	    }

	    return false;
	}	

	public void randomMove() {
		Move[] validMoves = new Move[damas.length * 4];
		int index = 0;
		for (int i = 0; i < damas.length; i++) {
			if (damas[i] != null && hasValidMove(damas[i].getPosition().getLine(), damas[i].getPosition().getCol())) {
				Position from = damas[i].getPosition();
				for (int j = 0; j < size; j++) {
					for (int k = 0; k < size; k++) {
						Position to = new Position(j, k);
						if (isValidMove(from, to) && getPieceAt(from.getLine(), from.getCol()).getIsBlack() == player) {
							validMoves[index++] = new Move(from, to);
						}
					}
				}
			}
		}
		if (validMoves[0] != null) {
			int x = (int) (Math.random() * index);
			selectPiece(validMoves[x].getFrom().getLine(), validMoves[x].getFrom().getCol());
			move(validMoves[x].getTo().getLine(), validMoves[x].getTo().getCol());
		}
		isEnd();
	}
}