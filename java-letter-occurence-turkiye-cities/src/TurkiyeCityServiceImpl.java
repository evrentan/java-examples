import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.NoSuchElementException;

public class TurkiyeCityServiceImpl implements TurkiyeCityService {

    private static final String TURKEY_CITIES_URL = "https://turkiyeapi.cyclic.app/api/v1/provinces?fields=name";

    @Override
    public List<String> getTurkeyCities() throws NoSuchElementException, IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(TURKEY_CITIES_URL))
                .build();

        HttpResponse<String> httpResponse = HttpClient.newHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());

        if (httpResponse.statusCode() != 200) {
            throw new NoSuchElementException("Error: " + httpResponse.statusCode());
        }

        TurkiyeCityResponse response = new GsonBuilder().create().fromJson(httpResponse.body(), TurkiyeCityResponse.class);
        return response.getData().stream().map(TurkiyeCityResponseData::getName).toList();
    }
}
