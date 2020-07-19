import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * @author Inna Pirina (<a href="mailto:Inna.Pirina@cas.de">Inna.Pirina@cas.de</a>)
 * @since 15.07.2020
 */

public class RomanNumberCalculatorTest {

    private RomanNumberCalculator calculator;

    @Before
    public void before() {
        calculator = new RomanNumberCalculator();
    }

    @Test
    public void testConvertToRoman() {
        String result = calculator.convertToRoman(76);
        assertEquals("LXXVI", result);

        result = calculator.convertToRoman(83);
        assertEquals("LXXXIII", result);

        result = calculator.convertToRoman(21);
        assertEquals("XXI", result);

        result = calculator.convertToRoman(0);
        assertEquals("", result);

        result = calculator.convertToRoman(74);
        assertEquals("LXXIV", result);

        result = calculator.convertToRoman(493);
        assertEquals("CDXCIII", result);
    }

    @Test
    public void testConvertFromRoman() {
        int result = calculator.convertFromRoman("LXXIV");
        assertEquals(74, result);
    }

    @Test
    public void testFindSmallest() {

        int nextSmallest = calculator.findNextSmallest(74);
        assertEquals(50, nextSmallest);

        nextSmallest = calculator.findNextSmallest(1);
        assertEquals(1, nextSmallest);

        nextSmallest = calculator.findNextSmallest(1900);
        assertEquals(1000, nextSmallest);

        nextSmallest = calculator.findNextSmallest(-3);
        assertEquals(-1, nextSmallest);
    }

    @Test
    public void testPattern() {
        boolean result = calculator.testPattern("LLLCCCCLLLLLCCCCXXXXIIII");
        assertFalse(result);

        //result = calculator.testPattern("LXXXIIIIIIIIII");
    }
}
