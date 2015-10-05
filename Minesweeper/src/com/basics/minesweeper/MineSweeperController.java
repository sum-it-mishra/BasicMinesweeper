package com.basics.minesweeper;

import java.util.Scanner;

public class MineSweeperController {

	private String playerEnteredMineCoordinates;

	private MineSweeperController() {
	}

	private static MineSweeperController controller;

	public static MineSweeperController getInstance() {
		if (controller == null) {
			controller = new MineSweeperController();
		}
		return controller;
	}

	public void solveMineField() {
		System.out.println("Enter Your Option -->");
		Scanner checkValue = new Scanner(System.in);
		String value = checkValue.next();
		String option = value.substring(0, value.indexOf("("));
		playerEnteredMineCoordinates = value.substring(value.indexOf("(") + 1,
				value.indexOf(")"));
		if (option.equalsIgnoreCase("o")) {
			openMineBlock();
		} else if (option.equalsIgnoreCase("f")) {
			flagMineBlock();
		} else {
			System.out.println("Please Enter a valid option");
		}
	}

	public void openMineBlock() {
		if (!ValidateMineSweeper.getInstance().isMine(
				playerEnteredMineCoordinates)) {
			showUnblockedMineBlocks("o");
		} else {
			System.out
					.println("OOPS !! YOU STEPPED ON A MINE !! \nGAME IS NEVER OVER UNLESS YOU WIN IT... TRY AGAIN ?");
		}
	}

	public void flagMineBlock() {
		showUnblockedMineBlocks("f");
	}

	public void showUnblockedMineBlocks(String option) {
		String xPosition = playerEnteredMineCoordinates.substring(0, 1);
		String yPosition = playerEnteredMineCoordinates.substring(2);
		int xPosCnt = 0;
		for (String mines : MineSweeper.hidden_mineField_layout) {
			if (Integer.valueOf(xPosition) == xPosCnt) {
				int yPosCnt = 0;
				String userInteractingString = "";
				for (char singleBlock : mines.toCharArray()) {
					if (Integer.valueOf(yPosition) == yPosCnt) {
						userInteractingString = userInteractingString + option;
					} else {
						userInteractingString = userInteractingString
								+ String.valueOf(singleBlock);
					}
					yPosCnt++;
				}
				MineSweeper.hidden_mineField_layout.remove(xPosCnt);
				MineSweeper.hidden_mineField_layout.add(xPosCnt,
						userInteractingString);
			}
			xPosCnt++;
		}
		MineSweeper.displayMineFields();
		solveMineField();
	}
}
