package luhnJava;

public class LuhnJava {

    public int calculateCheckDigit(String number){
        String reverseNumber = reverseStringRepresentationOfNumber(number);
        String[] digits = reverseNumber.split("");
        long sumOfDigitsOnOddIndex = 0;
        long sumOfDigitsOnEvenIndex = 0;
        long sumOfAllDigits;

        for ( int i = 1 ; i < digits.length; i += 2) {
           sumOfDigitsOnOddIndex += Integer.parseInt(digits[i]);
        }

        for ( int i = 0 ; i < digits.length; i += 2) {
            int digitOnEvenIndex = Integer.parseInt(digits[i]);
            digitOnEvenIndex *= 2;
            if(digitOnEvenIndex>9){
                digitOnEvenIndex = (digitOnEvenIndex % 10)+1;
            }
            sumOfDigitsOnEvenIndex +=digitOnEvenIndex;
        }

        sumOfAllDigits = sumOfDigitsOnEvenIndex + sumOfDigitsOnOddIndex;
        int modOfSumOfAllDigits = (int) (sumOfAllDigits % 10);

        return modOfSumOfAllDigits==0? 0 : 10-modOfSumOfAllDigits;
    }

    public boolean validate(String number){
        String reverseNumber = reverseStringRepresentationOfNumber(number);
        String[] digits = reverseNumber.split("");
        long sumOfDigitsOnOddIndex = 0;
        long sumOfDigitsOnEvenIndex = 0;
        long sumOfAllDigits;

        for ( int i = 0 ; i < digits.length; i += 2) {
            sumOfDigitsOnOddIndex += Integer.parseInt(digits[i]);
        }

        for ( int i = 1 ; i < digits.length; i += 2) {
            int digitOnEvenIndex = Integer.parseInt(digits[i]);
            digitOnEvenIndex *= 2;
            if(digitOnEvenIndex>9){
                digitOnEvenIndex = (digitOnEvenIndex % 10)+1;
            }
            sumOfDigitsOnEvenIndex +=digitOnEvenIndex;
        }

        sumOfAllDigits = sumOfDigitsOnEvenIndex + sumOfDigitsOnOddIndex;
        int modOfSumOfAllDigits = (int) (sumOfAllDigits % 10);

        return modOfSumOfAllDigits==0;
    }
    private String reverseStringRepresentationOfNumber(String number){
        return new StringBuilder(number).reverse().toString();
    }


    public static void main(String[] args) {
        LuhnJava luhn = new LuhnJava();
        String number = "2255889";
        int checkDigit = luhn.calculateCheckDigit(number);
        System.out.println(checkDigit);
        System.out.println(luhn.validate("353285021741493"));

    }
}
