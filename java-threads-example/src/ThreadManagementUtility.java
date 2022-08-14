import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadManagementUtility {

  private ThreadManagementUtility() {
    throw new IllegalStateException("Utility Class");
  }

  private static final int THREAD_SLEEP_IN_MILLIS = 1000;

  private static final Logger logger = Logger.getLogger(ThreadManagementUtility.class.getCanonicalName());

  protected static void printThreadStart(String clazzName, String threadName, Thread.State threadState) {
    System.out.println(String.format("%s is starting for %s and thread state is %s !!!", clazzName, threadName, threadState));
  }

  protected static void printThreadEnd(String clazzName, String threadName, Thread.State threadState) {
    System.out.println(String.format("%s is ending for %s and thread state is %s !!!", clazzName, threadName, threadState));
  }

  protected static void executeThread(int amount, String threadName, Thread.State threadState) {
    try {
      Thread.sleep(THREAD_SLEEP_IN_MILLIS);
      while (amount < 10) {
        amount++;
        System.out.println(String.format("**** Value of amount is %d from %s thread and thread status is %s ****", amount, threadName, threadState));
      }
    } catch (InterruptedException e) {
      logger.log(Level.SEVERE, e.getMessage());
      Thread.currentThread().interrupt();
    }
  }
}
