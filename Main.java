import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Main {
    
    public static void main(String[] args) throws IOException {

        // Pega os dados da API e recupera o JSON como uma string
        String json = new ImdbApiClient().getTop250();        

        // Faz o 'parse' e transforma a string em uma lista de filmes
        List<Movie> movieList = new ImdbMovieJsonParser(json).parse();
        
        // Gera o HTML
        PrintWriter writer = new PrintWriter("index.html");
        new HTMLGenerator(writer).generate(movieList);
        writer.close();

    }

}
