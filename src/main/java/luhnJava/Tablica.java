package luhnJava;

import java.util.Arrays;

public class Tablica {

    public void splitStringToArray(String s){
        String[] strings = s.split("");
        System.out.println(Arrays.toString(strings));
    }

    public static void main(String[] args) {
        Tablica t = new Tablica();
        t.splitStringToArray("abcd");
    }
}
