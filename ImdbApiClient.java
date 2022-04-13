import java.io.IOException;
import java.net.URISyntaxException;

import java.io.FileInputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.Properties;

public class ImdbApiClient implements APIClient{

    private String apiKey;

    public ImdbApiClient() {
        
        try {
            String propertiesFile = "apikey.properties";
            Properties properties = new Properties();
            properties.load(new FileInputStream(propertiesFile));

            this.apiKey = properties.getProperty("API_KEY");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBody() {
        HttpResponse<String> response = null;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                                    .uri(new URI("https://imdb-api.com/en/API/Top250Movies/" + this.apiKey))
                                    .GET().build();

            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return response.body().toString();
    }
}