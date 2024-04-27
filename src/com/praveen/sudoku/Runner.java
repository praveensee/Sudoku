package com.praveen.sudoku;

import java.util.Random;
import java.util.Scanner;

public class Runner {

	public static Integer[][] mainGrid = new Integer[9][9];

	public static int rowIndex = 0;
	public static int columnIndex = 0;
	public static int retryCount = 0;

	public static void main(String[] args) {

		try {
			buildInitialMatrix();
			int counter = 0;
			boolean won = false;
			boolean displayGrid = true;
			do {
				boolean breakLoop = false;

				Thread.sleep(2500);

				if (displayGrid)
					displayGrid(mainGrid);
				for (int i = 0; i < 9; i++) {
					if (breakLoop)
						break;
					for (int j = 0; j < 9; j++) {
						if (mainGrid[i][j] == 0) {
							rowIndex = i;
							columnIndex = j;
							System.out.print("*** Kindly enter Row-" + (rowIndex + 1) + " & Col-" + (columnIndex + 1)
									+ " Value  : ");
							breakLoop = true;
							break;
						}

					}
				}
				if (!breakLoop)
					won = true;
				Scanner consoleData = new Scanner(System.in);
				String inputData = consoleData.next();
				boolean isValid = validateInputData(inputData);
				displayGrid = false;
				if (isValid) {

					if (isValidSudokuEntry(Integer.parseInt(inputData))) {
						mainGrid[rowIndex][columnIndex] = Integer.parseInt(inputData);
						System.out.println(appreciate[new Random().nextInt(7)] + ". It is a VALID Entry !!!!!!!");
						displayGrid = true;
						retryCount = 0;
					} else {
						System.out.println(regret[new Random().nextInt(7)] + ". It is an INVALID Entry !!!!!!!");
						retryCount++;
					}
				}

				counter++;

			} while (counter < 100 && !won && retryCount < 10);

			if (counter > 97 || !won) {
				System.out.println(
						"======================================================================================");
				System.out.println(
						"@@@@@@ ###### $$$$$$ Too many Attempts : Run the game again again $$$$$$ ###### @@@@@@ ");
				System.out.println(
						"======================================================================================");
			} else {
				System.out.println("===========================================================================");
				System.out.println("@@@@@@ ###### $$$$$$ Congrats. You have WON the Game $$$$$$ ###### @@@@@@ ");
				System.out.println("===========================================================================");
				System.out.println("");
			}
		} catch (InterruptedException e) {
			System.out.println("********Unexpected !!!! Kindly Relaunch the Game");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("********Unexpected !!!! Kindly Relaunch the Game");
			e.printStackTrace();
		}

	}

	public static void displayGrid(Integer[][] inputBoard) {
		System.out.print("        ");
		for (int i = 0; i < 9; i++) {
			if (i == 2 || i == 5) {
				System.out.print("Col-" + (i + 1) + "  |");
			} else if (i == 3 || i == 6) {
				System.out.print(" Col-" + (i + 1) + "  ");
			} else {
				System.out.print("Col-" + (i + 1) + " ");
			}
		}
		System.out.println("");
		System.out.print("        ");
		for (int i = 0; i < 9; i++) {
			if (i == 2 || i == 5) {
				System.out.print("=====  |");
			} else if (i == 3 || i == 6) {
				System.out.print(" =====  ");
			} else {
				System.out.print("===== ");
			}
		}

		System.out.println("");
		for (int i = 0; i < 9; i++) {
			if (i == 3 || i == 6) {
				System.out.print("       ------------------- | ------------------- | -------------------\n");
			}

			System.out.print("Row-" + (i + 1) + "  ");
			for (int j = 0; j < 9; j++) {

				if (j == 0 || j == 3 || j == 6) {
					System.out.print(" (  " + (inputBoard[i][j] == 0 ? ("?") : (inputBoard[i][j] + "")) + "  ");
				} else if (j == 2 || j == 5) {
					System.out.print("  " + (inputBoard[i][j] == 0 ? ("?") : (inputBoard[i][j] + "")) + "  )  | ");
				} else if (j == 8) {
					System.out.print("  " + (inputBoard[i][j] == 0 ? ("?") : (inputBoard[i][j] + "")) + "  )   ");
				} else {
					System.out.print("  " + (inputBoard[i][j] == 0 ? ("?") : (inputBoard[i][j] + "")) + "  ");
				}

			}
			System.out.println("\n");
		}

	}

	public static void buildInitialMatrix() {
		// row 1 - 3, 0, 6, 5, 0, 8, 4, 0, 0
		mainGrid[0][0] = 3;
		mainGrid[0][1] = 0;
		mainGrid[0][2] = 6;
		mainGrid[0][3] = 5;
		mainGrid[0][4] = 0;
		mainGrid[0][5] = 8;
		mainGrid[0][6] = 4;
		mainGrid[0][7] = 0;
		mainGrid[0][8] = 0;

		// row 2 - 5, 2, 0, 0, 0, 0, 0, 0, 0
		mainGrid[1][0] = 5;
		mainGrid[1][1] = 2;
		mainGrid[1][2] = 0;
		mainGrid[1][3] = 0;
		mainGrid[1][4] = 0;
		mainGrid[1][5] = 0;
		mainGrid[1][6] = 0;
		mainGrid[1][7] = 0;
		mainGrid[1][8] = 0;

		// row 3 - 0, 8, 7, 0, 0, 0, 0, 3, 1
		mainGrid[2][0] = 0;
		mainGrid[2][1] = 8;
		mainGrid[2][2] = 7;
		mainGrid[2][3] = 0;
		mainGrid[2][4] = 0;
		mainGrid[2][5] = 0;
		mainGrid[2][6] = 0;
		mainGrid[2][7] = 3;
		mainGrid[2][8] = 1;

		// row 4 - 0, 0, 3, 0, 1, 0, 0, 8, 0

		mainGrid[3][0] = 0;
		mainGrid[3][1] = 0;
		mainGrid[3][2] = 3;
		mainGrid[3][3] = 0;
		mainGrid[3][4] = 1;
		mainGrid[3][5] = 0;
		mainGrid[3][6] = 0;
		mainGrid[3][7] = 8;
		mainGrid[3][8] = 0;

		// row 5 - 9, 0, 0, 8, 6, 3, 0, 0, 5
		mainGrid[4][0] = 9;
		mainGrid[4][1] = 0;
		mainGrid[4][2] = 0;
		mainGrid[4][3] = 8;
		mainGrid[4][4] = 6;
		mainGrid[4][5] = 3;
		mainGrid[4][6] = 0;
		mainGrid[4][7] = 0;
		mainGrid[4][8] = 5;

		// row 6 - 0, 5, 0, 0, 9, 0, 6, 0, 0
		mainGrid[5][0] = 0;
		mainGrid[5][1] = 5;
		mainGrid[5][2] = 0;
		mainGrid[5][3] = 0;
		mainGrid[5][4] = 9;
		mainGrid[5][5] = 0;
		mainGrid[5][6] = 6;
		mainGrid[5][7] = 0;
		mainGrid[5][8] = 0;

		// row 2 - 1, 3, 0, 0, 0, 0, 2, 5, 0
		mainGrid[6][0] = 1;
		mainGrid[6][1] = 3;
		mainGrid[6][2] = 0;
		mainGrid[6][3] = 0;
		mainGrid[6][4] = 0;
		mainGrid[6][5] = 0;
		mainGrid[6][6] = 2;
		mainGrid[6][7] = 5;
		mainGrid[6][8] = 0;

		// row 8 - 0, 0, 0, 0, 0, 0, 0, 7, 4
		mainGrid[7][0] = 0;
		mainGrid[7][1] = 0;
		mainGrid[7][2] = 0;
		mainGrid[7][3] = 0;
		mainGrid[7][4] = 0;
		mainGrid[7][5] = 0;
		mainGrid[7][6] = 0;
		mainGrid[7][7] = 7;
		mainGrid[7][8] = 4;

		// row 9 - 0, 0, 5, 2, 0, 6, 3, 0, 0
		mainGrid[8][0] = 0;
		mainGrid[8][1] = 0;
		mainGrid[8][2] = 5;
		mainGrid[8][3] = 2;
		mainGrid[8][4] = 0;
		mainGrid[8][5] = 6;
		mainGrid[8][6] = 3;
		mainGrid[8][7] = 0;
		mainGrid[8][8] = 0;

	}

	public static boolean validateInputData(String inputData) {

		try {

			System.out.println("inputData : " + inputData);

			if (inputData.trim().length() > 1) {
				System.out.println("*** Kindly key-in a valid Number between 1 - 9");
				return false;
			} else {
				if (Integer.parseInt(inputData) > 0 && Integer.parseInt(inputData) < 10) {
					return true;
				} else {
					System.out.println("*** Kindly key-in a valid Number between 1 - 9");
					return false;
				}
			}

		} catch (NumberFormatException e) {
			System.out.println("*** Kindly key-in a valid Number between 1 - 9");
			return false;
		}

	}

	public static boolean isValidSudokuEntry(int inpuNUmber) {
		for (int i = 0; i < mainGrid.length; i++) {
			if (mainGrid[rowIndex][i] == inpuNUmber) {
				return false;
			}
		}

		for (int j = 0; j < mainGrid.length; j++) {
			if (mainGrid[j][columnIndex] == inpuNUmber) {
				return false;
			}
		}

		int sqrt = (int) Math.sqrt(mainGrid.length);
		int boxRowStart = rowIndex - rowIndex % sqrt;
		int boxColStart = columnIndex - columnIndex % sqrt;

		for (int k = boxRowStart; k < boxRowStart + sqrt; k++) {
			for (int l = boxColStart; l < boxColStart + sqrt; l++) {
				if (mainGrid[k][l] == inpuNUmber) {
					return false;
				}
			}
		}

		return true;
	}

	private static String[] appreciate = { "Great job!!", "Well done!!", "Nice work!!", "Bravo, indeed!!",
			"Excellent job!!", "Superb work!!", "Fantastic job!!" };
	
	private static String[] regret = { "Sorry!!", "Try again!!", "Another shot!!", "One more!!", "Try once!!",
			"Retry please!!", "Keep trying!!" };

}

