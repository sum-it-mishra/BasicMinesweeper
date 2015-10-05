package com.basics.minesweeper;

public class RunMineSweeper {

	public static void main(String args[]) {
		CreateMineSweeperField createMineSweeperField = new CreateMineSweeperField();
		createMineSweeperField.createMineFieldLayout();
		createMineSweeperField.showHiddenMinefield();
		MineSweeperController.getInstance().solveMineField();
	}
}
