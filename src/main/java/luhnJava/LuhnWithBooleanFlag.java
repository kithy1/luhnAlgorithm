package luhnJava;

public class LuhnWithBooleanFlag implements LuhnAlgorithm {

    @Override
    public int calculateCheckDigit(String number) {
        long sumOfDigits = calculateSumOfBaseDigits(number);
        int mod = (int) (sumOfDigits % 10);

        return mod == 0 ? 0 : 10 - mod;

    }

    @Override
    public boolean validate(String number) {
        int checkDigit = Integer.parseInt(number.substring(number.length() - 1));
        String baseNumber = number.substring(0, number.length() - 1);
        int sumOfBaseDigits = calculateSumOfBaseDigits(baseNumber);
        int sum = sumOfBaseDigits + checkDigit;
        return sum % 10 == 0;
    }

    private int calculateSumOfBaseDigits(String baseNumber) {
        int index = baseNumber.length();
        boolean numberProcessing = true;
        int sum = 0;

        for (; index > 0; index--) {
            if (numberProcessing) {
                int digitOnEvenIndex = Integer.parseInt(baseNumber.substring(index - 1, index));
                digitOnEvenIndex *= 2;
                if (digitOnEvenIndex > 9) {
                    digitOnEvenIndex = (digitOnEvenIndex % 10) + 1;
                }
                sum += digitOnEvenIndex;
                numberProcessing = false;
            } else {
                sum += Integer.parseInt(baseNumber.substring(index - 1, index));
                numberProcessing = true;
            }
        }

        return sum;
    }

}
