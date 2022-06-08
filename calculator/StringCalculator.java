package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    String pattern = "//(.+)\\n(.*)";
    public String[] patternSplit(String param) {
        Matcher m = Pattern.compile(pattern).matcher(param);
        String[] tokens = {""}; // 이런 배열은 초기화를? 이게 맞나..
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = m.group(2).split(customDelimiter);
        } //TODO: match 결과가 없을 때 어떻게 분류?
        return tokens;
    }

    public String[] split(String param) {
        String[] splitedString = {""};
        if (param.contains(":")) {
            splitedString = param.split(":");
        }
        else if (param.contains(",")) {
            splitedString = param.split(",");
        }
        return splitedString;
    }

    public int sumSplitedString(String[] splitedString) {
        int sum = 0;
        for (String str: splitedString){
            int num = Integer.parseInt(str);
            sum += num;
        }
        return sum;
    }

    public int sum(String param) {
        String[] splitedString = {""};
        if (param.matches(pattern)) {
            splitedString = patternSplit(param);
        }
        else {
            splitedString = split(param);
        }
        return sumSplitedString(splitedString);
    }




}
