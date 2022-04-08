import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Properties;


public class IMDBReader {

    private String apiKey;

    public IMDBReader() {
        
        try {
            String propertiesFile = "apikey.properties";
            Properties properties = new Properties();
            properties.load(new FileInputStream(propertiesFile));

            this.apiKey = properties.getProperty("API_KEY");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getTop250() {
        HttpResponse response = null;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                                    .uri(new URI("https://imdb-api.com/en/API/Top250Movies/" + this.apiKey))
                                    .GET().build();

            response = client.send(request, BodyHandlers.ofString());
        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return response.body().toString();
    }
}