import java.util.Random;

class DigitService {
    private static Thread[] formThreads() {
        //todo: form threads from '0 to 9', from 'a to z', from 'A to Z', '/', '_', '.'
        Thread[] out = new Thread[65];
        for (Integer i = 0; i < 65; i++) {
            if (i < 10) {
                out[i] = new DigitFormer(i.toString());
            }
            if (i >= 10 && i < 36) {
                out[i] = new DigitFormer(Character.valueOf((char) (i + 55)).toString());
            }
            if (i >= 36 && i < 62) {
                out[i] = new DigitFormer(Character.valueOf((char) (i + 61)).toString());
            }
            if (i == 62) {
                out[i] = new DigitFormer(Character.valueOf((char) (i - 16)).toString());
            }
            if (i == 63) {
                out[i] = new DigitFormer(Character.valueOf((char) (i + 35)).toString());
            }
            if (i == 64) {
                out[i] = new DigitFormer(Character.valueOf((char) (i + 17)).toString());
            }
        }
        return out;
    }
    private static void runThreads(Thread[] threads) {
        for (Thread t : threads) {
            t.start();
        }
    }

    static String formRandomDigit() {
        Thread[] threads = formThreads();
        runThreads(threads);
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String out = DigitFormer.digits.get(new Random().nextInt(10));
        DigitFormer.digits.clear();
        return out;
    }
}
