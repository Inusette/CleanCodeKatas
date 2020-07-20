import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RomanNumberConverter {

    protected PowerCategory powerOne;
    protected PowerCategory powerTen;
    protected PowerCategory powerHundred;
    protected PowerCategory powerThousand;

    public RomanNumberConverter() {
        powerOne = new PowerCategory("I", "V", "X");
        powerTen = new PowerCategory("X", "L", "C");
        powerHundred = new PowerCategory("C", "D", "M");
        powerThousand = new PowerCategory( "M", null, null);
    }

    public String convertToRoman(int number) {
        if (number <= 0 || number >= 4000) {
            return "Your number is outside the scope. Please insert a number between 1 and 3.999";
        }
        List<Integer> componentList = splitNumberByPower(number);

        Collections.sort(componentList);
        Collections.reverse(componentList);

        StringBuilder builder = new StringBuilder();
        for (Integer component : componentList) {
            PowerCategory powerCategory = findPowerCategory(component);
            component = getFirstDigit(component);
            String romanComponent = buildRomanNumber(powerCategory, component);
            builder.append(romanComponent);
        }
        return builder.toString();
    }

    protected int getFirstDigit(Integer component) {
        return Integer.parseInt(component.toString().substring(0, 1));
    }

    protected String buildRomanNumber(PowerCategory powerCategory, Integer component) {
        String romanSign = "";
        switch (component) {
            case 1:
                romanSign = powerCategory.oneSign;
                break;
            case 2:
                romanSign = powerCategory.oneSign + powerCategory.oneSign;
                break;
            case 3:
                romanSign = powerCategory.oneSign + powerCategory.oneSign + powerCategory.oneSign;
                break;
            case 4:
                romanSign = powerCategory.oneSign + powerCategory.fiveSign;
                break;
            case 5:
                romanSign = powerCategory.fiveSign;
                break;
            case 6:
                romanSign = powerCategory.fiveSign + powerCategory.oneSign;
                break;
            case 7:
                romanSign = powerCategory.fiveSign + powerCategory.oneSign + powerCategory.oneSign;
                break;
            case 8:
                romanSign = powerCategory.fiveSign + powerCategory.oneSign + powerCategory.oneSign + powerCategory.oneSign;
                break;
            case 9:
                romanSign = powerCategory.oneSign + powerCategory.tenSign;
                break;
        }
        return romanSign;
    }

    protected List<Integer> splitNumberByPower(Integer number) {
        char[] numberAsReverseCharArray  = new StringBuilder(number.toString()).reverse().toString().toCharArray();
        List<Integer> componentList = new ArrayList<>();
        for (int i = 0; i < numberAsReverseCharArray.length; i++) {
            componentList.add(Character.getNumericValue(numberAsReverseCharArray[i]) * (int)Math.pow(10, i));
        }
        return componentList;
    }

    protected PowerCategory findPowerCategory(int number) {
        if (number % 1000 == 0) {
            return powerThousand;
        } else if (number % 100 == 0) {
            return powerHundred;
        } else if (number % 10 == 0) {
            return powerTen;
        } else {
            return powerOne;
        }
    }

    protected static class PowerCategory {
        String oneSign;
        String fiveSign;
        String tenSign;

        public PowerCategory (String smallSign, String mediumSign, String largeSign) {
            this.oneSign = smallSign;
            this.fiveSign = mediumSign;
            this.tenSign = largeSign;
        }
    }
}
