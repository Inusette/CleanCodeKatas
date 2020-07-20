package bankKata.model;

import static org.junit.Assert.assertEquals;
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