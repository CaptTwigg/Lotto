import java.util.*;
import java.io.*;

public class lotto {
public static void main(String[] args) throws FileNotFoundException {
	userNumbers();
	for (int i : userNumbers()) {
		System.out.println(i);
	}
}
public static int[] userNumbers() throws FileNotFoundException {
	Scanner getNumbers = new Scanner(new File("numbers.dat"));
	int[] userArray = new int[6];
	for (int i = 0; i < 6; i++) userArray[i] = getNumbers.nextInt();
	return userArray;
}
}
