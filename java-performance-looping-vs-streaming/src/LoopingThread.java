import java.util.concurrent.TimeUnit;

public class LoopingThread implements Runnable{

  @Override
  public void run() {
    RandomIntegerListGenerator randomIntegerListGenerator = RandomIntegerListGenerator.getInstance();
    final long startTime = System.nanoTime();
    int result = 0;
    for (Integer i : randomIntegerListGenerator.getRandomIntegerList()) {
      result += i;
    }
    final long endTime = System.nanoTime();
    System.out.println(String.format("Total elapsed time is %d milliseconds for %s", TimeUnit.NANOSECONDS.toMillis(endTime - startTime), this.getClass().getCanonicalName()));
  }
}
