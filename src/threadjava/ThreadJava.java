package threadjava;

public class ThreadJava implements Runnable {

    private void task1() {
        try {
            Thread.sleep(5000);
            System.out.println("ejecutando tarea 1");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void task2() {
        System.out.println("ejecutando tarea 2");
    }

    @Override
    public void run() {
        this.task1();
        this.task2();
    }
}
