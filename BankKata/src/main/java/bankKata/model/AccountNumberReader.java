package bankKata.model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class AccountNumberReader {

    public List<List<Integer>> readAccountNumberFile(String fileName) {

        List<List<Integer>> allAccountNumbers = new ArrayList<>();
        List<String> fileLines = readFileInList(fileName);
        List<String[][]> allAccountsInShapes = parseLinesIntoDigitShapes(fileLines);

        for (String[][] currentAccount : allAccountsInShapes) {
            List<Integer> accountNumbers = new ArrayList<>();
            for (String[] numberShape : currentAccount) {
                Optional<Integer> currentNumber = ShapeToNumberTranslator.translateNumber(numberShape);
                if (currentNumber.isPresent()) {
                    accountNumbers.add(currentNumber.get());
                } else {
                    accountNumbers.add(-1);
                }
            }
            allAccountNumbers.add(accountNumbers);
        }
        return allAccountNumbers;
    }

    protected List<String[][]> parseLinesIntoDigitShapes(List<String> lines) {

        List<String[][]> accountShapes = new LinkedList<>();

        String[][] matrix = new String[9][3];
        int lineCount = 0;
        for (String currentLine : lines) {
            if (currentLine.isEmpty()) {
                accountShapes.add(matrix);
                matrix = new String[9][3];
            } else {
                int currentAccountLine = lineCount % 4;
                for (int digitCount = 0; digitCount < 9; digitCount++) {
                    if (currentLine.length() < 3) {
                        currentLine += " "; // to account for the fact that spaces at the end of the line get removed
                    }
                    matrix[digitCount][currentAccountLine] = currentLine.substring(0, 3);
                    currentLine = currentLine.substring(3);
                }
            }
            lineCount++;
        }
        return accountShapes;
    }

    private List<String> readFileInList(String fileName) {
        List<String> fileLines = new ArrayList<>();
        try {
            fileLines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileLines;
    }

}
