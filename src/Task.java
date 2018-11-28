public class Task implements Runnable {

    private Integer i;

    public Task(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    @Override
    public void run() {
        for(int j = 0; j < 100000; j++){
            //todo: more difficult logic
            i = (int)Math.cos(i.doubleValue());
        }
    }
}
