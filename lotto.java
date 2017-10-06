import java.util.*;
import java.io.*;

public class lotto {
public static void main(String[] args) throws FileNotFoundException {
	// PrintStream getNumbers = new PrintStream(new File("numbers.dat"));
	userNumbers();
}
public static void userNumbers() throws FileNotFoundException {
	Scanner getNumbers = new Scanner(new File("numbers.dat"));
	int[] userArray = new int[6];
	for (int i = 0; i < 6; i++) {
		userArray[i] = getNumbers.nextInt();
	}
	for (int i : userArray) {
		System.out.println(i);
	}
}
}
