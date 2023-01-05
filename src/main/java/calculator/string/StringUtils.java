package calculator.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    private static final String DEFAULT_SPLITTER = ",|:";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    public static final String SPACE = " ";
    public static final String EMPTY = "";


    public static String[] split(final String value) {
        final Matcher m = CUSTOM_PATTERN.matcher(value);
        if (m.find()) {
            final String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return value.split(DEFAULT_SPLITTER);
    }

    public static char[] getChars(final String value) {
        return value.replaceAll(StringUtils.SPACE, StringUtils.EMPTY).toCharArray();
    }

}
