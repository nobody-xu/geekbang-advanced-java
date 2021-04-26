package demo.tasks.bytecode.analysis;

public class Hello {
    public static void main(String[] args) {

        // define variables
        boolean boolean1 = true;
        byte byte2 = 2;
        char char3 = '\u0003';
        short short4 = 4;
        int int5 = 5;
        long long6 = 6L;
        float float7 = 7.0f;
        double double8 = 8.0d;

        // flow control
        if (boolean1) {
            boolean1 = false;
        }

        for (int i = 0; i < 10; i++);


        int add = int5 + short4;
        int sub = int5 - short4;
        int mul = int5 * short4;
        int div = int5 / short4;
    }
}
