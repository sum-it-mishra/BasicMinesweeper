package com.basics.minesweeper;

public class ValidateMineSweeper {

	private static ValidateMineSweeper validateMinesweeper;

	private ValidateMineSweeper() {
	}

	public static ValidateMineSweeper getInstance() {
		if (validateMinesweeper == null) {
			validateMinesweeper = new ValidateMineSweeper();
		}
		return validateMinesweeper;
	}

	public void validateUserLayout(String mineLayouts) {
		if (mineLayouts.length() == 3) {
			MineSweeper.user_entered_mineField_layout.add(mineLayouts);
		} else {
			System.out.println("Please enter exactly a 3x3 field.");
		}
	}

	public boolean isValidEntryFromUser() {
		return false;
	}

	public boolean isMine(String mineCoordinates) {
		if (MineSweeper.active_mines_coordinates.contains(mineCoordinates)) {
			return true;
		}
		return false;
	}

	public boolean isFlagAndMine() {
		return false;
	}

}
