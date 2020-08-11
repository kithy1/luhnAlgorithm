package luhnJava;

public interface LuhnAlgorithm {

    public int calculateCheckDigit(String number);
    public boolean validate(String number);
}
