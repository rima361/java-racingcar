package calculator.string;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import calculator.Number;
import calculator.Operation;

public class StringSplitter {

    private static final String DEFAULT_SPLITTER = ",|:";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static String[] split(final String value) {
        final Matcher m = CUSTOM_PATTERN.matcher(value);
        if (m.find()) {
            final String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return value.split(DEFAULT_SPLITTER);
    }

    public static List<Number> extractNumber(final String value) {
        final char[] chars = value.replaceAll(StringSupport.SPACE, StringSupport.EMPTY).toCharArray();
        return IntStream.range(0, chars.length)
                        .filter(i -> Character.isDigit(chars[i]))
                        .mapToObj(i -> String.valueOf(chars[i]))
                        .map(Long::parseLong)
                        .map(Number::new)
                        .collect(Collectors.toList());
    }

    public static List<Operation> extractOperation(String value) {
        final char[] chars = value.replaceAll(StringSupport.SPACE, StringSupport.EMPTY).toCharArray();
        return IntStream.range(0, chars.length)
                        .filter(i -> Operation.isSupportedSymbol(chars[i]))
                        .mapToObj(i -> String.valueOf(chars[i]))
                        .map(Operation::of)
                        .collect(Collectors.toList());
    }

}
