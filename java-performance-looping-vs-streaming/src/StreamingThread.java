import java.util.concurrent.TimeUnit;

public class StreamingThread implements Runnable{

  @Override
  public void run() {
    RandomIntegerListGenerator randomIntegerListGenerator = RandomIntegerListGenerator.getInstance();
    final long startTime = System.nanoTime();
    randomIntegerListGenerator.getRandomIntegerList().stream().mapToInt(Integer::intValue).sum();
    final long endTime = System.nanoTime();
    System.out.println(String.format("Total elapsed time is %d milliseconds for %s", TimeUnit.NANOSECONDS.toMillis(endTime - startTime), this.getClass().getCanonicalName()));
  }
}
