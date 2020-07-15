import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Inna Pirina (<a href="mailto:Inna.Pirina@cas.de">Inna.Pirina@cas.de</a>)
 * @since 10.07.2020
 */
public class BankMachine {

    public BankMachine() {

        Map<String, Integer> digitShapes = constructDigitShape();

    }

    public List<Integer> readFile(Map<String, Integer> digitShapes, String[]... args) {

        List<Integer> accountNumber = new ArrayList<Integer>(9);




        return accountNumber;
    }

    private Map<String, Integer> constructDigitShape () {

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
/*
        digitShapes.put(6,  " _ "
                                + "|_ "
                                + "|_|");

        digitShapes.put(7,  " _ "
                                + "  |"
                                + "  |");

        digitShapes.put(8,  " _ "
                                + "|_|"
                                + "|_|");

        digitShapes.put(9,  " _ "
                                + "|_|"
                                + " _|");

 */

        return digitShapes;
    }
}
