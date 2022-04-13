import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ImdbMovieJsonParser implements JsonParser{

    private String json;

    public ImdbMovieJsonParser(String json) {
        this.json = json;
    }

    public List<Movie> parse() {

        // "Limpa" a String
        json = json.split("\\[")[1].split("\\]")[0];
        String[] movies = json.split("\\},\\{");

        // Faz o 'parse' dos dados para objetos do tipo 'Movie'
       return Arrays.stream(movies).map(ImdbMovieJsonParser::parseJsonMovies).collect(Collectors.toList());
    }

    // Lê um 'objeto JSON' e retorna um objeto 'Movie'
    private static Movie parseJsonMovies(String jsonMovie) {
        jsonMovie = jsonMovie.replaceAll("[{}]", "");
        jsonMovie = jsonMovie.replaceAll("^\"|\"$", "");
        String[] items = jsonMovie.split("\",\"");

        String id = "";
        int rank = 0;
        String title = "";
        String fullTitle = "";
        int year = 0;
        String imgString = "";
        String crew = "";
        double imdbRating = 0;
        int imdbRatingCount = 0;

        for (String s : items) {
            String[] item = s.split("\":\"");

            switch (item[0]) {
                case "id":
                    id = item[1];
                    break;
                case "rank":
                    rank = Integer.parseInt(item[1]);
                    break;
                case "title":
                    title = item[1];
                    break;
                case "fullTitle":
                    fullTitle = item[1];
                    break;
                case "year":
                    year = Integer.parseInt(item[1]);
                    break;
                case "image":
                    imgString = item[1];
                    break;
                case "crew":
                    crew = item[1];
                    break;
                case "imDbRating":
                    imdbRating = Double.parseDouble(item[1]);
                    break;
                case "imDbRatingCount":
                    imdbRatingCount = Integer.parseInt(item[1]);
                    break;
            }

        }
        return new Movie(id, rank, title, fullTitle, year, imgString, crew, imdbRating, imdbRatingCount);
    }
    
}
