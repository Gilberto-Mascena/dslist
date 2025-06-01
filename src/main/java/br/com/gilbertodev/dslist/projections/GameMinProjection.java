package br.com.gilbertodev.dslist.projections;

/**
 * Projection interface used to retrieve a subset of fields from the {@code Game} entity,
 * typically for optimized queries when only minimal game information is needed.
 *
 * <p>This is commonly used with Spring Data JPA projections to map native SQL or JPQL results.</p>
 *
 * @author Gilberto Dev
 * @see br.com.gilbertodev.dslist.entities.Game
 * @see br.com.gilbertodev.dslist.repositories.GameRepository
 */

public interface GameMinProjection {

    /**
     * Returns the ID of the game.
     *
     * @return the game ID
     */
    Long getId();

    /**
     * Returns the title of the game.
     *
     * @return the game title
     */
    String getTitle();

    /**
     * Returns the release year of the game.
     *
     * @return the game year
     */
    Integer getGameYear();

    /**
     * Returns the image URL for the game.
     *
     * @return the image URL
     */
    String getImgUrl();

    /**
     * Returns the short description of the game.
     *
     * @return the short description
     */
    String getShortDescription();

    /**
     * Returns the position of the game within a specific list.
     * This is typically used to order games in custom user-defined lists.
     *
     * @return the game position within the list
     */
    Integer getPosition();
}
