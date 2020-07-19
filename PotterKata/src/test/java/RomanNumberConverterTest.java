import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author Inna Pirina (<a href="mailto:Inna.Pirina@cas.de">Inna.Pirina@cas.de</a>)
 * @since 19.07.2020
 */
public class RomanNumberConverterTest {

    private RomanNumberConverter converter = new RomanNumberConverter();

    @Test
    public void testSplitNumber() {
        List<Integer> result = converter.splitNumberByPower(458);
        Assert.assertEquals(3, result.size());
        Assert.assertTrue(result.contains(400));
        Assert.assertTrue(result.contains(50));
        Assert.assertTrue(result.contains(8));
    }

    @Test
    public void testConvertNumber() {
        String result = converter.convertToRoman(759);
        Assert.assertEquals("DCCLIX", result);
    }
}
