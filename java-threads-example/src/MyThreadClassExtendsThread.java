public class MyThreadClassExtendsThread extends Thread {

  public MyThreadClassExtendsThread(String threadName) {
    super(threadName);
  }

  @Override
  public void run() {
    int amount = 0;
    ThreadManagementUtility.printThreadEnd(this.getClass().getCanonicalName(), Thread.currentThread().getName(), Thread.currentThread().getState());
    ThreadManagementUtility.executeThread(amount, Thread.currentThread().getName(), Thread.currentThread().getState());
    ThreadManagementUtility.printThreadEnd(this.getClass().getCanonicalName(), Thread.currentThread().getName(), Thread.currentThread().getState());
  }
}
