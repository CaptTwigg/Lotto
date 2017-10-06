import java.util.*;
import java.io.*;

public class lotto {
public static void main(String[] args) throws Exception {
	int[] go = drawNumbers();
	for (int i : go) System.out.println(i);
}
public static int[] userNumbers() throws Exception {
	Scanner getNumbers = new Scanner(new File("numbers.dat"));
	int[] userArray = new int[6];
	for (int i = 0; i < 6; i++) userArray[i] = getNumbers.nextInt();
	return userArray;
}
public static int compare() throws Exception {
	int rightCount = 0;
	for (int i = 0; i < 6; i++) {
		if (userNumbers()[i] == drawNumbers()[i]) rightCount++;
	}
	return rightCount;
}
public static void noUserDup(){
}
public static int[] drawNumbers() throws Exception {
	Random rand = new Random();
	int[] drawArray = new int [6];
	for (int i = 0; i < 6; i++) {
		drawArray[i] = rand.nextInt(20) + 1;
		for (int j = 0; j < i; j++) {
			if (drawArray[i] == drawArray[j]) {
				i--;
			}
		}
	}
	Arrays.sort(drawArray);
	return(drawArray);
}
}
