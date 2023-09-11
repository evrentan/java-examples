import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

public interface TurkiyeCityService {

    List<String> getTurkeyCities() throws NoSuchElementException, IOException, InterruptedException;
}
