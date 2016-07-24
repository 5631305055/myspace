import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Combination {
	private static Scanner scanner;
	public static int[] trank;
	public static String[] arr;
	public static int sumArr;
	public static void main(String[] args) {

		scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		String[] strArray = text.split(" ");

		trank = new int[strArray.length];
		for (int i = 0; i < strArray.length; i++) {
			trank[i] = Integer.parseInt(strArray[i]);
		}
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		arr = new String[strArray.length];
		for(int k=0;k<strArray.length;k++){
			arr[k]=String.valueOf(alphabet[k]);
		}
		for (int i = 0; i < trank.length; i++) {
			combinations2(trank, trank.length-1, i, new int[trank.length-1]);
			//combinations(arr, arr.length-1, i, new String[arr.length-1]);
		}

	}

	static void combinations2(int[] trank2, int len, int startPosition, int[] integers) {
		if (len == 0) {
			int findmin=0;
			for (int i = 1; i <= trank.length; i++) {
				int num =trank[i - 1];
				boolean contains = IntStream.of(integers).anyMatch(x -> x == num);
				if(!contains){
					if(sumArr<=findmin){
				System.out.print(trank[i - 1] + " ");
				System.out.println(Arrays.toString(integers));
				sumArr=IntStream.of(integers).sum();
				System.out.print(" sum :"+(((trank[i - 1]+sumArr)+sumArr))*2+"\n");
					}
				}
			}

			return;
		}
		for (int i = startPosition; i <= trank2.length - len; i++) {
			integers[integers.length - len] = trank2[i];
			combinations2(trank2, len - 1, i + 1, integers);
		}
	}

}