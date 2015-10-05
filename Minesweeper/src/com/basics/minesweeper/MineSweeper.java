package com.basics.minesweeper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MineSweeper {
	public static List<String> user_entered_mineField_layout = new ArrayList<String>();
	public static List<String> hidden_mineField_layout = new CopyOnWriteArrayList<String>();
	public static List<String> active_mines_coordinates = new ArrayList<String>();

	public static void displayMineFields() {
		for (String fields : hidden_mineField_layout) {
			System.out.println(fields);
		}
	}
}
