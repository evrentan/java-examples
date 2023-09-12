import java.io.IOException;
import java.util.NoSuchElementException;

public class LetterOccurrenceTurkiyeCities {

    public static void main(String[] args) throws NoSuchElementException, IOException, InterruptedException {

        Utils.printLetterOccurrence(new TurkiyeCityServiceImpl().getTurkeyCities());
    }
}