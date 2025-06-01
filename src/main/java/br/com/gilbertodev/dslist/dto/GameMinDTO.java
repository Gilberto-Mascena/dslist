package br.com.gilbertodev.dslist.dto;

import br.com.gilbertodev.dslist.entities.Game;
import br.com.gilbertodev.dslist.projections.GameMinProjection;

import java.util.Objects;

/**
 * Data Transfer Object (DTO) that provides a minimal representation of a {@link Game} entity.
 *
 * <p>Used primarily for listing games with essential attributes like ID, title, year,
 * image URL, and short description.</p>
 *
 * @author Gilberto Dev
 */
public class GameMinDTO {

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
     * URL of the game's image or cover.
     */
    private String imgUrl;

    /**
     * Short description of the game.
     */
    private String shortDescription;

    /**
     * Default constructor.
     */
    public GameMinDTO() {
    }

    /**
     * Constructs a {@code GameMinDTO} from a full {@link Game} entity.
     *
     * @param entity the Game entity to extract data from
     */
    public GameMinDTO(Game entity) {
        id = entity.getId();
        title = entity.getTitle();
        year = entity.getYear();
        imgUrl = entity.getImgUrl();
        shortDescription = entity.getShortDescription();
    }

    /**
     * Constructs a {@code GameMinDTO} from a {@link GameMinProjection} projection.
     * <p>This is useful for optimized database queries.</p>
     *
     * @param projection the projection containing minimal game data
     */
    public GameMinDTO(GameMinProjection projection) {
        id = projection.getId();
        title = projection.getTitle();
        year = projection.getGameYear();
        imgUrl = projection.getImgUrl();
        shortDescription = projection.getShortDescription();
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
     * Returns the title of the game.
     *
     * @return the game title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the release year of the game.
     *
     * @return the game year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Returns the image URL of the game.
     *
     * @return the image URL
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * Returns a short description of the game.
     *
     * @return the short description
     */
    public String getShortDescription() {
        return shortDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameMinDTO that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "GameMinDTO{" +
               "id=" + id +
               ", title='" + title + '\'' +
               ", year=" + year +
               ", imgUrl='" + imgUrl + '\'' +
               ", shortDescription='" + shortDescription + '\'' +
               '}';
    }
}
