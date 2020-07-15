/**
 * @author Inna Pirina (<a href="mailto:Inna.Pirina@cas.de">Inna.Pirina@cas.de</a>)
 * @since 10.07.2020
 */

import org.junit.Test;


public class TestAccountNumberReader {


    @Test
    public void testReadFile() {

        AccountNumberReader.readAccountNumberFile("src/example.txt");

    }
}
