import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.logging.Logger;

public abstract class AbstractBaseClass {

  protected static final int NUMBER_OF_INTEGERS = 100000;

  protected final Random random = SecureRandom.getInstanceStrong();

  protected static final Logger logger = Logger.getLogger(AbstractBaseClass.class.getName());

  public AbstractBaseClass() throws NoSuchAlgorithmException {
  }
}
