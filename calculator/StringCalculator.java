package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    String customPattern = "//(.+)\\n(.*)";

    public int sum(String param) {
        if (param == null || param.isEmpty()) {
            return 0;
        }
        return intSum(stringToInts(split(param)));
    }

    private int[] stringToInts(String[] splitedString) {
        int[] numbers = new int[splitedString.length];
        for (int i = 0; i < splitedString.length; i++){
            numbers[i] = toInt(splitedString[i]);
        }
        return numbers;
    }

    private int toInt(String param) {
        int num = Integer.parseInt(param);
        if (num < 0) {
            throw new RuntimeException();
        }
        return num;
    }

    private int intSum(int[] numbers) {
        int sum = 0;
        for (int number: numbers) {
            sum += number;
        }
        return sum;
    }

    private String[] split(String param) {
        Matcher m = Pattern.compile(customPattern).matcher(param);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return param.split("[,:]");
    }





}
