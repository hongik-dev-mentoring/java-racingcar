import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	private final static int NOT_HAVE_CUSTOM_DELIMITER = -1;

	public static int splitAndSum(String input){
		if(input == null) return 0;
		if(input == "") return 0;
		int sum = 0;
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
		sum = customDelimiter(m);
		if(sum != NOT_HAVE_CUSTOM_DELIMITER) return sum; //custom 지정여부 확인
		return getSum(sum, input.split(",|:"));
	}

	private static int customDelimiter(Matcher m) {
		int sum = 0;
		if (m.find()) {
			String customDelimiter = m.group(1);
			String[] tokens= m.group(2).split(",|:|" + customDelimiter);
			sum = getSum(sum, tokens);
			return sum;
		}
		return NOT_HAVE_CUSTOM_DELIMITER;
	}

	private static int getSum(int sum, String[] tokens) {
		for (String token : tokens) {
			int num;
			num = InputException.getNumOrThrow(token);
			InputException.ifNegativeThenThrow(num);
			sum += num;
		}
		return sum;
	}
}
