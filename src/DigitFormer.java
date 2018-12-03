import java.util.concurrent.CopyOnWriteArrayList;

public class DigitFormer extends Thread {

    static CopyOnWriteArrayList<String> digits = new CopyOnWriteArrayList<>();

    private String digit;

    DigitFormer(String digit) {
        this.digit = digit;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        digits.add(digit);
    }
}
