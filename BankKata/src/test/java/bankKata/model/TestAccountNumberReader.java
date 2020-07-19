package bankKata.model; /**
 * @author Inna Pirina (<a href="mailto:Inna.Pirina@cas.de">Inna.Pirina@cas.de</a>)
 * @since 10.07.2020
 */
import static org.junit.Assert.assertEquals;

import bankKata.model.AccountNumberReader;
import org.junit.Test;

import java.util.List;


public class TestAccountNumberReader {


    @Test
    public void testReadFile() {

        AccountNumberReader accountNumberReader = new AccountNumberReader();

        List<String> fileLines = accountNumberReader.readFileInList("src/example.txt");
        assertEquals(8, fileLines.size());

        List<String[][]> digitShapes = accountNumberReader.parseLinesIntoDigitShapes(fileLines);
        assertEquals(2, digitShapes.size());

        for (String[][] account : digitShapes) {
            for (String[] digitShape : account) {
                for (String shapeLine : digitShape) {
                    System.out.println(shapeLine);
                }
            }
            System.out.println("--------------------------------------");
        }
    }
}