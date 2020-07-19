package bankKata.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ShapeToNumberTranslator {

    public static Optional<Integer> translateNumber(String[] shape) {

        Map<String, Integer> digitShapes = constructDigitShape();

        String numberShape = String.join("", shape);

        if (digitShapes.containsKey(numberShape)) {
            return Optional.of(digitShapes.get(numberShape));
        }
        return Optional.empty();
    }

    private static Map<String, Integer> constructDigitShape () {

        Map<String, Integer> digitShapes = new HashMap<String, Integer>();
        digitShapes.put(   "   "
                            + "  |"
                            + "  |", 1);

        digitShapes.put(   " _ "
                            + " _|"
                            + "|_ ", 2);

        digitShapes.put(   " _ "
                            + " _|"
                            + " _|", 3);

        digitShapes.put(   "   "
                            + "|_|"
                            + "  |", 4);

        digitShapes.put(   " _ "
                            + "|_ "
                            + " _|", 5);

        digitShapes.put(   " _ "
                            + "|_ "
                            + "|_|", 6);

        digitShapes.put(   " _ "
                            + "  |"
                            + "  |", 7);

        digitShapes.put(   " _ "
                            + "|_|"
                            + "|_|", 8);

        digitShapes.put(   " _ "
                            + "|_|"
                            + " _|", 9);

        return digitShapes;
    }
}
