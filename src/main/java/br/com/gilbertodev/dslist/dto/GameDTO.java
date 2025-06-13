package br.com.gilbertodev.dslist.dto;

import br.com.gilbertodev.dslist.entities.Game;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

/**
 * Data Transfer Object (DTO) that represents a detailed view of a {@link Game} entity.
 *
 * <p>Used for transferring complete game information across layers.</p>
 *
 * @author Gilberto Dev
 * @since 1.0.0
 */
public class GameDTO {

    /**
     * Unique identifier of the game.
     */
    private Long id;

    /**
     * Title of the game.
     */
    private String title;

    /**
     * Release year of the game.
     */
    private Integer year;

    /**
     * Genre of the game (e.g., Action, RPG).
     */
    private String genre;

    /**
     * Platforms the game is available on (e.g., PC, Xbox).
     */
    private String platforms;

    /**
     * Game score or rating.
     */
    private Double score;

    /**
     * URL to the game image or cover.
     */
    private String imgUrl;

    /**
     * Short description of the game.
     */
    private String shortDescription;

    /**
     * Detailed description of the game.
     */
    private String longDescription;

    /**
     * Default constructor.
     */
    public GameDTO() {
    }

    /**
     * Constructs a {@code GameDTO} by copying properties from a {@link Game} entity.
     *
     * @param entity the Game entity to copy from
     */
    public GameDTO(Game entity) {
        BeanUtils.copyProperties(entity, this);
    }

    /**
     * Returns the ID of the game.
     *
     * @return the game ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the game.
     *
     * @param id the game ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the title of the game.
     *
     * @return the game title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the game.
     *
     * @param title the game title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the release year of the game.
     *
     * @return the release year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Sets the release year of the game.
     *
     * @param year the release year to set
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * Returns the genre of the game.
     *
     * @return the game genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the genre of the game.
     *
     * @param genre the game genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Returns the platforms on which the game is available.
     *
     * @return the game platforms
     */
    public String getPlatforms() {
        return platforms;
    }

    /**
     * Sets the platforms on which the game is available.
     *
     * @param platforms the platforms to set
     */
    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    /**
     * Returns the score or rating of the game.
     *
     * @return the game score
     */
    public Double getScore() {
        return score;
    }

    /**
     * Sets the score or rating of the game.
     *
     * @param score the game score to set
     */
    public void setScore(Double score) {
        this.score = score;
    }

    /**
     * Returns the URL of the game's image.
     *
     * @return the image URL
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * Sets the URL of the game's image.
     *
     * @param imgUrl the image URL to set
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * Returns a short description of the game.
     *
     * @return the short description
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * Sets a short description of the game.
     *
     * @param shortDescription the short description to set
     */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     * Returns a detailed description of the game.
     *
     * @return the long description
     */
    public String getLongDescription() {
        return longDescription;
    }

    /**
     * Sets a detailed description of the game.
     *
     * @param longDescription the long description to set
     */
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameDTO gameDTO)) return false;
        return Objects.equals(id, gameDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "GameDTO{" +
               "id=" + id +
               ", title='" + title + '\'' +
               ", year=" + year +
               ", genre='" + genre + '\'' +
               ", platforms='" + platforms + '\'' +
               ", score=" + score +
               ", imgUrl='" + imgUrl + '\'' +
               ", shortDescription='" + shortDescription + '\'' +
               ", longDescription='" + longDescription + '\'' +
               '}';
    }
}
