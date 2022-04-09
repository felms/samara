import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    
    public static void main(String[] args) throws IOException {

        // Pega os dados da API e recupera o JSON como uma string
        String json = new IMDBReader().getTop250();

        // "Limpa" a String
        json = json.split("\\[")[1].split("\\]")[0];
        String[] movies = json.split("\\},\\{");


        // Faz o 'parse' dos dados para objetos do tipo 'Movie'
        List<Movie> movieList = Arrays.stream(movies).map(Movie::parseJsonMovies).collect(Collectors.toList());
        movieList.forEach(System.out::println);

        // Cria listas para o atributo
        List<String> titles = movieList.stream().map(Movie::getTitle).collect(Collectors.toList());
        titles.forEach(System.out::println);

    }

}
