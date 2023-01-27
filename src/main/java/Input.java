import java.util.ArrayList;
import java.util.Scanner;

public class Input {
	private static ArrayList<String> strings = new ArrayList<>();
	private static int tryNum;

	public static ArrayList<String> readNames(){
		Scanner sc = new Scanner(System.in);
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		while(true){
			String input = sc.nextLine();
			if (noExceptionAtStrings(input)) break;
		}
		return strings;
	}

	public static int readNum(){
		Scanner sc = new Scanner(System.in);
		System.out.println("시도할 회수는 몇회인가요?");
		while(true){
			String input = sc.nextLine();
			if(noExceptionAtNum(input)) break;
		}
		return tryNum;
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
			InputException.ifLong(strings, input.split(","));
			return true;
		}catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
			return false;
		}
	}
}
