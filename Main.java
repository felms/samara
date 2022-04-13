import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    
    public static void main(String[] args) throws IOException {

        // Pega os dados da API e recupera o JSON como uma string
        APIClient apiClient = new ImdbApiClient();
        String json = apiClient.getBody();

        // Faz o 'parse' e transforma a string em uma lista de filmes
        JsonParser jsonParser = new ImdbMovieJsonParser(json);
        var movieList = jsonParser.parse();
        
        // Gera o HTML
        PrintWriter writer = new PrintWriter("index.html");
        new HTMLGenerator(writer).generate(movieList);
        writer.close();

    }

}
