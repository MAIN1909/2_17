import java.util.Random;

class DigitService {
    private static Thread[] formThreads() {
        //todo: form threads from '0 to 9', from 'a to z', from 'A to Z', '/', '_', '.'
        Thread[] out = new Thread[10];
        for (Integer i = 0; i < 10; i++) {
            out[i] = new DigitFormer(i.toString());
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
