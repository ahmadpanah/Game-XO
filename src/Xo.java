import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Xo {

	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [] [] gameBoard = {{' ' , '|' , ' ' , '|' , ' '},
				{'-' , '+' , '-' , '+' , '-'},
				{' ' , '|' , ' ' , '|' , ' '},
				{'-' , '+' , '-' , '+' , '-'},
				{' ' , '|' , ' ' , '|' , ' '}};
			
		printGameBoard(gameBoard);
		
		while (true) {
			Scanner scan = new Scanner(System.in);

			System.out.println("Enter Your Turn:");
			int playerPos = scan.nextInt();
			while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPositions)) {
				System.out.println("Position taken! Enter Correct one:");
				playerPos = scan.nextInt();
			}
			
			placepiece(gameBoard, playerPos, "player" );
			
			String result = checkWinner();
			if (result.length() > 0) {
				System.out.println(result);
				break;
			}
			
			Random rand = new Random();
			int cpuPos = rand.nextInt(9) + 1;
			while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
				System.out.println("Position taken! Enter Correct one:");
				cpuPos = rand.nextInt(9) + 1;
			}
			placepiece(gameBoard, cpuPos, "cpu" );

			
			printGameBoard(gameBoard);
			
			result = checkWinner();
			if (result.length() > 0) {
				System.out.println(result);
				break;
			}
		}
			
		}
	
	public static void printGameBoard (char [] [] gameBoard) {
		for (char [] row : gameBoard) {
			for (char c : row) {
				System.out.print(c);
			}
			
			System.out.println();
		}
	}
	
	public static void placepiece(char [] [] gameBoard , int pos , String user) {
		
		char symbol = ' ';
		
		if (user.equals("player")) {
			symbol = 'X';
			playerPositions.add(pos);
		} else if (user.equals("cpu")) {
			symbol = 'O';
			cpuPositions.add(pos);
		}
		
		switch (pos) {
		case 1:
			gameBoard [0] [0] = symbol;
			break;
		case 2:
			gameBoard [0] [2] = symbol;
			break;
		case 3:
			gameBoard [0] [4] = symbol;
			break;
		case 4:
			gameBoard [2] [0] = symbol;
			break;
		case 5:
			gameBoard [2] [2] = symbol;
			break;
		case 6:
			gameBoard [2] [4] = symbol;
			break;
		case 7:
			gameBoard [4] [0] = symbol;
			break;
		case 8:
			gameBoard [4] [2] = symbol;
			break;
		case 9:
			gameBoard [4] [4] = symbol;
			break;
		default:
			break;
		}
		
	}
	
	public static String checkWinner() {
		List topRow = Arrays.asList(1 , 2 , 3);
		List midRow = Arrays.asList(4 , 5 , 6);
		List botRow = Arrays.asList(7 , 8 , 9);
		List leftCol = Arrays.asList(1 , 4 , 7);
		List midCol = Arrays.asList(2 , 5 , 8);
		List rightCol = Arrays.asList(3 , 6 , 9);
		List cross1 = Arrays.asList(1 , 5 , 9);
		List cross2 = Arrays.asList(7 , 5 , 3);
		
		List<List> winnig = new ArrayList<List> ();
		winnig.add(topRow);
		winnig.add(midRow);
		winnig.add(botRow);
		winnig.add(leftCol);
		winnig.add(rightCol);
		winnig.add(midCol);
		winnig.add(cross1);
		winnig.add(cross2);
		
		for(List l : winnig) {
			if (playerPositions.containsAll(l)) {
				return "You Won!";
			} else if (cpuPositions.containsAll(l)) {
				return "You Lose";
			} else if (playerPositions.size() + cpuPositions.size() == 9) {
				return "Mosavi";
			}
		}
		return "";
	}

}
