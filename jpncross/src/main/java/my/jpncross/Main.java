package my.jpnkross;

import my.jpnkross.logick.*;


public class Main {

    public static void main(String[] args) {
        String rows = "5;2;5;2;2";
        String cols = "2;2;5;2;5";

        Brain brain = new Brain(cols, rows);
        brain.start();

    }
}
