
/**
 * A simple program in which the user plays the game "Rock Paper Scissors" against the computer.
 * 
 * @author alexlacey
 * @version 20170209
 *
 */

import java.util.Scanner; //import the Scanner utility

public class RockPaperScissors {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		boolean keepPlaying = true;
		while (keepPlaying == true) {
			String userChoice = getUserChoice(keyboard); // determine and print the user's choice
			String compChoice = getCompChoice(); // determine and print the computer's choice
			determineWinner(userChoice, compChoice); // determine the winner of the game
			keepPlaying = playAnotherGame(keyboard); // determine whether or not to play another game
		}

		System.out.print("Thanks for playing!");

	}

	private static String getUserChoice(Scanner in) {

		String userChoice = null;
		boolean validInput = false;
		while (validInput == false) {
			System.out.print("Please select one of [R/P/S]: ");
			String userInput = in.next();
			if (userInput.equals("R")) {
				validInput = true;
				userChoice = "Rock";
			} else if (userInput.equals("P")) {
				validInput = true;
				userChoice = "Paper";
			} else if (userInput.equals("S")) {
				validInput = true;
				userChoice = "Scissors";
			} else {
				System.out.println("Please enter a valid character.");
			}
		}
		System.out.println("You chose: " + userChoice);
		return userChoice;

	}

	private static String getCompChoice() {

		int compInt = (int) (3 * Math.random()); // generate an integer between 0 and 2
		String compChoice = null;
		if (compInt == 0) {
			compChoice = "Rock";
		} else if (compInt == 1) {
			compChoice = "Paper";
		} else {
			compChoice = "Scissors";
		}
		System.out.println("I chose: " + compChoice);
		return compChoice;
	}

	private static void determineWinner(String userChoice, String compChoice) {
		if (userChoice.equals("Scissors") && compChoice.equals("Paper") || userChoice.equals("Rock") && compChoice.equals("Scissors")
				|| userChoice.equals("Paper") && compChoice.equals("Rock")) {
			System.out.println(userChoice + " beats " + compChoice + " - you win!");
		} else if (userChoice.equals("Paper") && compChoice.equals("Scissors") || userChoice.equals("Scissors") && compChoice.equals("Rock")
				|| userChoice.equals("Rock") && compChoice.equals("Paper")) {
			System.out.println(compChoice + " beats " + userChoice + " - I win!");
		} else {
			System.out.println("A tie!");
		}
		System.out.println();
	}

	private static boolean playAnotherGame(Scanner in) {
		System.out.print("Would you like to play again [Y/N]? ");
		String userResponse = in.next();
		boolean keepPlaying;
		if (userResponse.equals("Y")) {
			keepPlaying = true;
			System.out.println();
		} else {
			keepPlaying = false;
		}
		return keepPlaying;
	}

}
