import java.util.*;
import java.io.*;

public class lotto {
public static void main(String[] args) throws Exception {
	System.out.println("right " + compare());
	for (int i : drawNumbers()) System.out.printf("%d ", i);
	// System.out.println();
	// for (int i : userNumbers()) System.out.printf("%d ", i);
}
public static int[] userNumbers() throws Exception {
	Scanner getNumbers = new Scanner(new File("numbers.dat"));     //Read file to get user numbers
	int[] userArray = new int[6];                                  //Create array for lotto numbers with 6 indexes
	for (int i = 0; i < 6; i++) userArray[i] = getNumbers.nextInt();        //Loop through array and add value from numbers.dat file
	return userArray;
}
public static int compare() throws Exception {
	int rightCount = 0;
	int[] holdArray = drawNumbers();
	for (int i = 0; i < 6; i++) {
		for (int j = 0; j < 6; j++) {
			if (userNumbers()[i] == holdArray[j]) rightCount++;
		}
	}
	return rightCount;
}
public static void noUserDup(){
}
public static int[] drawNumbers() throws Exception {
	Random rand = new Random();                             //random object declare
	int[] drawArray = new int [6];          //Array for drawn numbers
	for (int i = 0; i < 6; i++) {
		drawArray[i] = rand.nextInt(20) + 1;    //Add random value between 1-20 to array
		for (int j = 0; j < i; j++) {
			if (drawArray[i] == drawArray[j]) {     // check if numbers already exist -- yes jump 1 back in array and add new number
				i--;
			}
		}
	}
	Arrays.sort(drawArray);         //Sort array for pleasure
	return(drawArray);
}
}
