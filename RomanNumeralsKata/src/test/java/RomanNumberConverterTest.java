import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class RomanNumberConverterTest {

    private RomanNumberConverter converter;

    @Before
    public void before() {
        converter = new RomanNumberConverter();
    }

    @Test
    public void testGetFirstDigit() {
        int number = converter.getFirstDigit(600);
        Assert.assertEquals(6, number);
    }

    @Test
    public void testSplitNumberByPower() {
        List<Integer> result = converter.splitNumberByPower(5);
        Assert.assertEquals(1, result.size());
        Assert.assertTrue(result.contains(5));

        result = converter.splitNumberByPower(99);
        Assert.assertEquals(2, result.size());
        Assert.assertTrue(result.contains(90));
        Assert.assertTrue(result.contains(9));

        result = converter.splitNumberByPower(458);
        Assert.assertEquals(3, result.size());
        Assert.assertTrue(result.contains(400));
        Assert.assertTrue(result.contains(50));
        Assert.assertTrue(result.contains(8));

        result = converter.splitNumberByPower(1999);
        Assert.assertEquals(4, result.size());
        Assert.assertTrue(result.contains(1000));
        Assert.assertTrue(result.contains(900));
        Assert.assertTrue(result.contains(90));
        Assert.assertTrue(result.contains(9));
    }

    @Test
    public void testFindPowerCategory() {
        RomanNumberConverter.PowerCategory powerOne = converter.findPowerCategory(9);
        Assert.assertEquals("I", powerOne.oneSign);

        RomanNumberConverter.PowerCategory powerTen = converter.findPowerCategory(70);
        Assert.assertEquals("X", powerTen.oneSign);

        RomanNumberConverter.PowerCategory powerHundred = converter.findPowerCategory(300);
        Assert.assertEquals("C", powerHundred.oneSign);

        RomanNumberConverter.PowerCategory powerThousand = converter.findPowerCategory(2000);
        Assert.assertEquals("M", powerThousand.oneSign);
    }

    @Test
    public void testBuildRomanNumber() {
        String romanNumber = converter.buildRomanNumber(converter.powerOne, 9);
        Assert.assertEquals("IX", romanNumber);

        romanNumber = converter.buildRomanNumber(converter.powerTen, 4);
        Assert.assertEquals("XL", romanNumber);

        romanNumber = converter.buildRomanNumber(converter.powerHundred, 3);
        Assert.assertEquals("CCC", romanNumber);

        romanNumber = converter.buildRomanNumber(converter.powerThousand, 2);
        Assert.assertEquals("MM", romanNumber);
    }

    @Test
    public void testConvertNumber() {
        String romanNumber = converter.convertToRoman(759);
        Assert.assertEquals("DCCLIX", romanNumber);

        romanNumber = converter.convertToRoman(6);
        Assert.assertEquals("VI", romanNumber);

        romanNumber = converter.convertToRoman(69);
        Assert.assertEquals("LXIX", romanNumber);

        romanNumber = converter.convertToRoman(1991);
        Assert.assertEquals("MCMXCI", romanNumber);
    }
}
