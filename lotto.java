import java.util.*;
import java.io.*;

public class lotto {
public static void main(String[] args) throws Exception {
	int[] holdArray = drawNumbers();
	int[] holdUserArray = userNumbers();
	// System.out.println("right " + compare());

	System.out.println(winCheck(compare(holdArray, holdUserArray)));
}

public static int compare(int[] holdArray, int[] holdUserArray) throws Exception {
	int rightCount = 0;
	for (int i = 0; i < 6; i++) {
		for (int j = 0; j < 6; j++) {
			if (holdUserArray[i] == holdArray[j]) rightCount++;
		}
	}
	System.out.print(Arrays.toString(holdArray));
	return rightCount;
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

public static int[] userNumbers() throws Exception {
	Scanner scan = new Scanner(System.in);
	int number;
	int[] userArray = new int[6];

	System.out.print("Want your own numbers? y/n ");
	String choose = scan.next();

	if (choose.equals("y")) {
		System.out.println("Pick a number from 1 to 20");

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
		PrintStream stream = new PrintStream(new File("numbers.dat"));
		for (int i : userArray) stream.print(i + " ");
	} else {
		Scanner getNumbers = new Scanner(new File("numbers.dat"));
		for (int i = 0; i < 6; i++) userArray[i] = getNumbers.nextInt();
	}
	return userArray;
}

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
public static void Print(){
}
}
