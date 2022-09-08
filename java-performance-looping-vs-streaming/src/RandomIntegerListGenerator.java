import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;

public class RandomIntegerListGenerator extends AbstractBaseClass {
  private static RandomIntegerListGenerator randomIntegerListGenerator;
  private List<Integer> randomIntegerList = new ArrayList<>();

  private RandomIntegerListGenerator() throws NoSuchAlgorithmException {
    super();
    generateRandomIntegerList();
  }

  private void generateRandomIntegerList() {
    for(int i = 0; i < NUMBER_OF_INTEGERS; i++) {
      this.randomIntegerList.add(random.nextInt(NUMBER_OF_INTEGERS));
    }
  }

  public static RandomIntegerListGenerator getInstance() {
    try {
      if (Objects.isNull(randomIntegerListGenerator))
        randomIntegerListGenerator = new RandomIntegerListGenerator();
    } catch (NoSuchAlgorithmException exception) {
      logger.log(Level.SEVERE, exception.getMessage());
    }

    return randomIntegerListGenerator;
  }

  public List<Integer> getRandomIntegerList() {
    return this.randomIntegerList;
  }
}
