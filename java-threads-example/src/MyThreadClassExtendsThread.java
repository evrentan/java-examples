public class MyThreadClassExtendsThread extends Thread{
  private int amount = 0;
  private static final int THREAD_SLEEP_IN_MILLIS = 1000;

  public MyThreadClassExtendsThread(String threadName) {
    super(threadName);
  }

  @Override
  public void run() {
    System.out.println(String.format("%s is starting for %s and thread state is %s !!!", this.getClass().getCanonicalName(), Thread.currentThread().getName(), Thread.currentThread().getState()));

    try {
      Thread.sleep(THREAD_SLEEP_IN_MILLIS);
      while (amount < 10) {
        this.increaseValue();
        System.out.println(String.format("**** Value of amount is %d from %s thread and thread status is %s ****", amount, Thread.currentThread().getName(), Thread.currentThread().getState()));
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println(String.format("%s is ending for %s and thread state is %s !!!", this.getClass().getCanonicalName(), Thread.currentThread().getName(), Thread.currentThread().getState()));
  }

  private void increaseValue() {
    amount++;
  }
}
