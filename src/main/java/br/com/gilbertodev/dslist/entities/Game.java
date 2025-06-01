package br.com.gilbertodev.dslist.entities;

import jakarta.persistence.*;

/**
 * Represents a game entity that is stored in the "tb_game" database table.
 * <p>This entity contains information such as title, genre, platform, score,
 * image URL, and descriptions.</p>
 *
 * @author Gilberto Dev
 */
@Entity
@Table(name = "tb_game")
public class Game {

    /**
     * Unique identifier for the game.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The title of the game.
     */
    private String title;

    /**
     * The release year of the game.
     */
    @Column(name = "game_year")
    private Integer year;

    /**
     * The genre of the game.
     */
    private String genre;

    /**
     * The platforms on which the game is available.
     */
    private String platforms;

    /**
     * The review score of the game.
     */
    private Double score;

    /**
     * URL to the game's cover image.
     */
    private String imgUrl;

    /**
     * A short description of the game.
     */
    @Column(columnDefinition = "TEXT")
    private String shortDescription;

    /**
     * A long, detailed description of the game.
     */
    @Column(columnDefinition = "TEXT")
    private String longDescription;

    /**
     * Default constructor.
     */
    public Game() {
    }

    /**
     * Constructs a game entity with all fields.
     *
     * @param id               the game ID
     * @param title            the game title
     * @param year             the release year
     * @param genre            the genre
     * @param platforms        the platforms
     * @param score            the score
     * @param imgUrl           the image URL
     * @param shortDescription the short description
     * @param longDescription  the long description
     */
    public Game(Long id, String title, Integer year, String genre, String platforms, Double score, String imgUrl,
                String shortDescription, String longDescription) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.platforms = platforms;
        this.score = score;
        this.imgUrl = imgUrl;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }

    /**
     * @return the game ID
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the game ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the game title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the release year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * @param year the release year to set
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * @return the genre of the game
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * @return the platforms
     */
    public String getPlatforms() {
        return platforms;
    }

    /**
     * @param platforms the platforms to set
     */
    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    /**
     * @return the game score
     */
    public Double getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(Double score) {
        this.score = score;
    }

    /**
     * @return the image URL
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * @param imgUrl the image URL to set
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * @return the short description
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * @param shortDescription the short description to set
     */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     * @return the long description
     */
    public String getLongDescription() {
        return longDescription;
    }

    /**
     * @param longDescription the long description to set
     */
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    /**
     * Computes hash code based on game ID.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    /**
     * Compares this game to another based on ID.
     *
     * @param obj the object to compare
     * @return true if both games have the same ID, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Game other = (Game) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Game{" +
               "id=" + id +
               ", title='" + title + '\'' +
               ", year=" + year +
               ", genre='" + genre + '\'' +
               ", platforms='" + platforms + '\'' +
               ", score=" + score +
               ", imgUrl='" + imgUrl + '\'' +
               '}';
    }
}
