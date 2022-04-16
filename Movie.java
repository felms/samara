public class Movie implements Comparable<Movie>, Content{

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

    public String getUrlImage() {
        return imgString;
    }

    public String getCrew() {
        return crew;
    }

    public double getRating() {
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

    @Override
    public int compareTo(Movie o) {
        
        return Double.compare(this.getRating(), o.getRating());
    }


}
