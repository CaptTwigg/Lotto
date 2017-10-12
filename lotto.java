import java.util.*;
import java.io.*;

public class lotto {
public static void main(String[] args) throws Exception {
	int secondGame = 0;

	while (play(secondGame)) {                 //Wanna play again loop
		secondGame = 1;
		int[] holdArray = drawNumbers();                // Create new array from drawNumbers method, done so the array is the same in other methods
		int[] holdUserArray = userNumbers();            // Create new array from userNumbers method,				 -||-
		Print(holdUserArray, holdArray, compare(holdArray, holdUserArray));             // Printing drawn nubmers, user nubmers and win
	}
}

public static int[] userNumbers() throws Exception {
	Scanner scan = new Scanner(System.in);
	int number;
	int[] userArray = new int[6];

	System.out.print("Want your own numbers? y/n ");
	String choose = scan.next();

	//If yes user want own numbers, go through loop to get number between 1-20 and check if number is duplicate or already exist
	if (choose.equals("y")) {
		System.out.println("Pick 6 non-identical numbers between 1 to 20");

		for (int i = 0; i < 6; i++) {
			System.out.print("Type a number: ");
			number = scan.nextInt();
			userArray[i] = number;

			if (number < 0 || number > 20) {
				System.out.println("Number is not from 1-20, pick a new");
				i--;
			}
			for (int j = 0; j < i; j++) {
				if (userArray[i] == userArray[j]) {
					System.out.println("Number already exist, pick a new");
					i--;
				}
			}
		}
		PrintStream stream = new PrintStream(new File("numbers.dat")); //if choosen own number write number with space to numbers.dat ex: 1 2 3 4 5 6
		for (int i : userArray) stream.print(i + " ");
	} else {
		Scanner getNumbers = new Scanner(new File("numbers.dat"));              //if !choosen own number get numbers from numbers.dat file and add to array
		for (int i = 0; i < 6; i++) userArray[i] = getNumbers.nextInt();
	}
	Arrays.sort(userArray);
	return userArray;
}

public static int[] drawNumbers() throws Exception {
	Random rand = new Random();             //random object declare
	int[] drawArray = new int [6];          //Array for drawn numbers

	for (int i = 0; i < 6; i++) {
		drawArray[i] = rand.nextInt(20) + 1;    //Add random value between 1-20 to array
		for (int j = 0; j < i; j++) {
			if (drawArray[i] == drawArray[j]) i--;    // check if numbers already exist - if yes jump 1 back in array and add new number
		}
	}
	Arrays.sort(drawArray);         //Sort array for pleasure
	return(drawArray);
}

// Compares numbers in arrays
public static int compare(int[] holdArray, int[] holdUserArray) throws Exception {
	int rightCount = 0;

	for (int i = 0; i < 6; i++) {
		for (int j = 0; j < 6; j++) {
			if (holdUserArray[i] == holdArray[j]) rightCount++; // Counts how many numbers are alike when compared
		}
	}
	return rightCount;
}

// Return a win value
public static String winCheck(int a){
	switch (a) {
	case 0: return "You win " + 0;
	case 1: return "You win " + 10;
	case 2: return "You win " + 20;
	case 3: return "You win " + 30;
	case 4: return "You win " + 40;
	case 5: return "You win " + 50;
	}
	return "You win " + 60;
}

// Print all statitics from lotto
public static void Print(int[] userArray, int[] holdArray, int win) throws Exception {
	System.out.print("Your numbers are: \t");               //Print user numbers
	for (int i : userArray) System.out.printf("%-3d", i);

	System.out.printf("\nDrawn numbers are: \t");           //Print drawn numbers with delay
	for (int i = 0; i < 6; i++) {
		Thread.sleep(1000);
		System.out.printf("%-3d", holdArray[i]);
	}
	System.out.println();
	System.out.println(winCheck(win));              //Prints win amount
}

public static boolean play(int secondGame){
	Scanner scan = new Scanner(System.in);

	if (secondGame == 0) System.out.print("Wanna play? y/n: "); // If first game
	else System.out.print("Wanna play again? y/n: ");       //if !first game
	String answear = scan.next();

	if (!answear.equals("y")) return false; //if ! "y" stop while loop at top
	return true;
}
}
