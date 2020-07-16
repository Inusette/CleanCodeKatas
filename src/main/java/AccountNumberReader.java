import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Inna Pirina (<a href="mailto:Inna.Pirina@cas.de">Inna.Pirina@cas.de</a>)
 * @since 10.07.2020
 */
public class AccountNumberReader {

    public static List<Integer> readAccountNumberFile(String fileName){

        List<Integer> accountNumber = new ArrayList<>(9);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){

            Stream<String> lines = bufferedReader.lines();

            String[][] matrix = new String[9][4];

            for (int lineCount = 0; lineCount < 4; lineCount++) {

                String currentLine = bufferedReader.readLine();

                for (int digitCount = 0; digitCount < 9; digitCount++) {
                    if (!currentLine.isEmpty()) {
                        matrix[digitCount][lineCount] = currentLine.substring(0, 2);
                        currentLine = currentLine.substring(0, 2);
                    }
                }
            }




        } catch (IOException e) {
            e.printStackTrace();
        }

        return accountNumber;
    }

    protected static String[][] readAccountNumberLines(String fileName) {

        String[][] matrix = new String[9][3];

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){

            for (int lineCount = 0; lineCount < 4; lineCount++) {
                String currentLine = bufferedReader.readLine();

                if (currentLine.isEmpty()) {
                    break;
                }

                for (int digitCount = 0; digitCount < 9; digitCount++) {
                    matrix[digitCount][lineCount] = currentLine.substring(0, 3);
                    currentLine = currentLine.substring(3);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return matrix;
    }
}
