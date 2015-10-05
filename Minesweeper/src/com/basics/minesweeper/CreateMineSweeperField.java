package com.basics.minesweeper;

import java.util.Scanner;

public class CreateMineSweeperField {

	private String mineLayouts;

	public void createMineFieldLayout() {
		System.out
				.println("Please Enter a 3x3 mine field e.g.-\n xxm\n xmx\n xxx\n");
		System.out.println("Now Please Enter Your Minefield Details :\n");

		while (MineSweeper.user_entered_mineField_layout.size() < 3) {
			Scanner userValueScanner = new Scanner(System.in);
			mineLayouts = userValueScanner.nextLine();
			ValidateMineSweeper.getInstance().validateUserLayout(mineLayouts);
		}
	}

	public void showHiddenMinefield() {
		System.out
				.println("\n Following are the covered mine fields, to open o(x,y), to put flag f(x,y)");
		int xLocation = 0;
		int yLocation = 0;
		for (String mineFields : MineSweeper.user_entered_mineField_layout) {
			if (mineFields.contains("m")) {
				yLocation = mineFields.indexOf("m");
				MineSweeper.active_mines_coordinates.add(String
						.valueOf(xLocation) + "," + String.valueOf(yLocation));
			}
			xLocation++;
			String newField = mineFields.replace("m", "x");
			MineSweeper.hidden_mineField_layout.add(newField);
		}

		for (String hiddenMineField : MineSweeper.hidden_mineField_layout) {
			System.out.println(hiddenMineField);
		}
	}
}
