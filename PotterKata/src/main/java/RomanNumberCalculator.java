import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Inna Pirina (<a href="mailto:Inna.Pirina@cas.de">Inna.Pirina@cas.de</a>)
 * @since 15.07.2020
 */
public class RomanNumberCalculator {

    TreeMap<Integer, String> numbersToRoman = new TreeMap<>(Map.of(1, "I", 5, "V", 10, "X", 50, "L",
            100, "C", 500, "D", 1000, "M"));

    HashMap<String, Integer> romanToNumbers = new HashMap<>(Map.of("I", 1, "V", 5, "X", 10, "L", 50,
            "C", 100, "D", 500,  "M", 1000));

    public String convertToRoman(int number) {
        int rest = number;
        StringBuilder stringBuilder = new StringBuilder();

        while (rest > 0) {
            int nextSmallest = findNextSmallest(rest);
            stringBuilder.append(numbersToRoman.get(nextSmallest));
            rest -= nextSmallest;
        }
        return stringBuilder.toString();
    }

    public String convertIfNecessary(String draft) {
        return null;
    }

    protected boolean testPattern(String input) {
        System.out.println(input);
        Matcher matcher = Pattern.compile("(X{4}|C{4}|I{4})").matcher(input);
        while (matcher.find()) {
            String foundExpression = matcher.group();
            System.out.println("Group " + foundExpression);
        }
        return true;
    }

    public int convertFromRoman(String romanNumber) {
        return -1;
    }

    protected int findNextSmallest(int number) {
        for (Integer currentKey : numbersToRoman.descendingKeySet()) {
            if (number >= currentKey) {
                return currentKey;
            }
        }
        return -1;
    }

    protected int findNextBiggest(int number) {
        for (Integer currentKey : numbersToRoman.keySet()) {
            if (number <= currentKey) {
                return currentKey;
            }
        }
        return -1;
    }
}
