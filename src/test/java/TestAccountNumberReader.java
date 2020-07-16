/**
 * @author Inna Pirina (<a href="mailto:Inna.Pirina@cas.de">Inna.Pirina@cas.de</a>)
 * @since 10.07.2020
 */

import org.junit.Test;

import java.util.Arrays;


public class TestAccountNumberReader {


    @Test
    public void testReadFile() {

        String[][] digitShapes = AccountNumberReader.readAccountNumberLines("src/example.txt");

        for (String[] digit : digitShapes) {
            System.out.println(digit);
        }

    }
}
