import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService e = Executors.newFixedThreadPool(1);
        List<Task> tasks = new LinkedList<>();
        for(int i = 0; i < 1000; i++){
            tasks.add(new Task(i));
        }
        long t1 = System.nanoTime();
        for(Task t : tasks){
            e.execute(t);
        }
        e.shutdown();
        long t2 = System.nanoTime();
        System.out.println((t2-t1)/1000000);
    }
}
