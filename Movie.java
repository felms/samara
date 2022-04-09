public class Movie {

    private final String id;
    private final int rank;
    private final String title;
    private final String fullTitle;
    private final int year;
    private final String imgString;
    private final String crew;
    private final double imdbRating;
    private final int imdbRatingCount;

    public Movie(String id, int rank, String title, String fullTitle,
                 int year, String imgString, String crew,
                 double imdbRating, int imdbRatingCount) {

        this.id = id;
        this.rank = rank;
        this.title = title;
        this.fullTitle = fullTitle;
        this.year = year;
        this.imgString = imgString;
        this.crew = crew;
        this.imdbRating = imdbRating;
        this.imdbRatingCount = imdbRatingCount;

    }

    // Lê um 'objeto JSON' e retorna um objeto 'Movie'
    public static Movie parseJsonMovies(String jsonMovie) {
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


    // --------------- Getters
    
    public String getId() {
        return id;
    }

    public int getRank() {
        return rank;
    }

    public String getTitle() {
        return title;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public int getYear() {
        return year;
    }

    public String getImgString() {
        return imgString;
    }

    public String getCrew() {
        return crew;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public int getImdbRatingCount() {
        return imdbRatingCount;
    }

    @Override
    public String toString() {
        return "Movie [id=" + id + ", rank=" + rank + ", title=" + title + ", fullTitle=" + fullTitle +
                "year=" + year + ", imgString=" + imgString + "crew=" + crew +  ", imdbRating=" + imdbRating
                + ", imdbRatingCount=" + imdbRatingCount + "]";
    }


}
