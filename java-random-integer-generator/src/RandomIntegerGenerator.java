import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;
import java.util.stream.Collectors;

public class RandomIntegerGenerator {

  public static void main(String[] args)  {
    // select the random pseudorandom number generator (PRNG) algorithm
    final List<String> randomGeneratorFactoryList = RandomGeneratorFactory.all().map(RandomGeneratorFactory::name).sorted().collect(Collectors.toList());
    final String randomGeneratorFactoryName = randomGeneratorFactoryList.get(new Random().nextInt(randomGeneratorFactoryList.size()));

    //create a random generator with the selected algorithm
    final RandomGenerator randomGenerator = RandomGeneratorFactory.of(randomGeneratorFactoryName).create();
    //get the random number bounded to 10
    final int randomInteger = randomGenerator.nextInt(10);

    System.out.println(String.format("Your random integer is %s created by %s algorithm !!!", randomInteger, randomGeneratorFactoryName));
  }
}
