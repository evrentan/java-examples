public class MyThreadClassImplementingRunnable implements Runnable {

  @Override
  public void run() {
    int amount = 0;
    ThreadManagementUtility.printThreadStart(this.getClass().getCanonicalName(), Thread.currentThread().getName(), Thread.currentThread().getState());
    ThreadManagementUtility.executeThread(amount, Thread.currentThread().getName(), Thread.currentThread().getState());
    ThreadManagementUtility.printThreadEnd(this.getClass().getCanonicalName(), Thread.currentThread().getName(), Thread.currentThread().getState());
  }
}
