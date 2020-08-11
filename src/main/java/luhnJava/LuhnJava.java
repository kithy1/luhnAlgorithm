package luhnJava;

public class LuhnJava implements LuhnAlgorithm {

    @Override
    public int calculateCheckDigit(String number) {
        String reverseNumber = reverseStringRepresentationOfNumber(number);
        String[] digits = reverseNumber.split("");
        int sumOfDigitsOnOddIndex = 0;
        int sumOfDigitsOnEvenIndex = 0;
        int sumOfAllDigits;

        for (int i = 1; i < digits.length; i += 2) {
            sumOfDigitsOnOddIndex += Integer.parseInt(digits[i]);
        }

        for (int i = 0; i < digits.length; i += 2) {
            int digitOnEvenIndex = Integer.parseInt(digits[i]);
            digitOnEvenIndex *= 2;
            if (digitOnEvenIndex > 9) {
                digitOnEvenIndex = (digitOnEvenIndex % 10) + 1;
            }
            sumOfDigitsOnEvenIndex += digitOnEvenIndex;
        }

        sumOfAllDigits = sumOfDigitsOnEvenIndex + sumOfDigitsOnOddIndex;
        int mod =  sumOfAllDigits % 10;

        return mod == 0 ? 0 : 10 - mod;
    }

    @Override
    public boolean validate(String number) {
        String reverseNumber = reverseStringRepresentationOfNumber(number);
        String[] digits = reverseNumber.split("");
        int sumOfDigitsOnEvenIndex = 0;
        int sumOfDigitsOnOddIndex1 = 0;
        int sumOfAllDigits;

        for (int i = 0; i < digits.length; i += 2) {
            sumOfDigitsOnEvenIndex += Integer.parseInt(digits[i]);
        }

        for (int i = 1; i < digits.length; i += 2) {
            int digitOnOddIndex = Integer.parseInt(digits[i]);
            digitOnOddIndex *= 2;
            if (digitOnOddIndex > 9) {
                digitOnOddIndex = (digitOnOddIndex % 10) + 1;
            }
            sumOfDigitsOnOddIndex1 += digitOnOddIndex;
        }

        sumOfAllDigits = sumOfDigitsOnOddIndex1 + sumOfDigitsOnEvenIndex;
        int mod =  sumOfAllDigits % 10;

        return mod == 0;
    }

    private String reverseStringRepresentationOfNumber(String number) {
        return new StringBuilder(number).reverse().toString();
    }

}
