import java.util.ArrayList;
import java.util.Scanner;

public class Input {
	private static ArrayList<String> strings = new ArrayList<>();
	private static int tryNum;

	public static void readNames(){
		Scanner sc = new Scanner(System.in);

		while(true){
			String input = sc.nextLine();
			if (noExceptionAtStrings(input) == true) break;
		}

		// for (String string : strings) {
		// 	System.out.println("string = " + string);
		// }
	}

	public static void readNum(){
		Scanner sc = new Scanner(System.in);
		while(true){
			String input = sc.nextLine();
			if(noExceptionAtNum(input) == true) break;
		}
	}

	private static boolean noExceptionAtNum(String input) {
		try{
			InputException.ifEmpty(input);
			InputException.ifNull(input);
			tryNum = Integer.parseInt(input);
			InputException.isPositive(tryNum);
			return true;
		}catch(Exception e){
			System.out.println("숫자를 입력하세요.");
			return false;
		}
	}

	private static boolean noExceptionAtStrings(String input) {
		try{
			InputException.ifNull(input);
			InputException.ifEmpty(input);
			String[] split = input.split(",");
			InputException.ifLong(strings, split);
			return true;
		}catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static void main(String[] args) {
		Input.readNames();
		Input.readNum();
	}

}
