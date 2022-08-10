public class MyThreadClassImplementingRunnable implements Runnable {

  private int amount = 0;
  private static final int THREAD_SLEEP_IN_MILLIS = 1000;

  @Override
  public void run() {
    System.out.println(String.format("%s is starting for %s !!!", this.getClass().getCanonicalName(), Thread.currentThread().getName()));

    try {
      Thread.sleep(THREAD_SLEEP_IN_MILLIS);
      while (amount < 10) {
        this.increaseValue();
        System.out.println(String.format("**** Value of amount is %d from %s thread ****", amount, Thread.currentThread().getName()));
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println(String.format("%s is ending for %s !!!", this.getClass().getCanonicalName(), Thread.currentThread().getName()));
  }

  private void increaseValue() {
    amount++;
  }
}
