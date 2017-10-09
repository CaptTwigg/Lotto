import java.util.*;
import java.io.*;

public class lotto {
public static void main(String[] args) throws Exception {
	int[] holdArray = drawNumbers();
	// System.out.println("right " + compare());
	System.out.println(winCheck(compare(holdArray)));
}
public static int[] userNumbers() throws Exception {
	Scanner getNumbers = new Scanner(new File("numbers.dat"));     //Read file to get user numbers
	int[] userArray = new int[6];                                  //Create array for lotto numbers with 6 indexes
	for (int i = 0; i < 6; i++) userArray[i] = getNumbers.nextInt();        //Loop through array and add value from numbers.dat file
	Arrays.sort(userArray);         //Sort array for pleasure
	return userArray;
}
public static int compare(int[] holdArray) throws Exception {
	int rightCount = 0;
	for (int i = 0; i < 6; i++) {
		for (int j = 0; j < 6; j++) {
			if (userNumbers()[i] == holdArray[j]) rightCount++;
		}
	}
	System.out.print(Arrays.toString(holdArray));
	return rightCount;
}
public static void noUserDup(){
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
public static void chooseNumbers(){
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
}
