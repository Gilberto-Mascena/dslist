package br.com.gilbertodev.dslist.dto;

import br.com.gilbertodev.dslist.entities.GameList;

import java.util.Objects;

/**
 * Data Transfer Object (DTO) that represents a summarized view of a {@link GameList} entity.
 *
 * <p>Used to transfer list information between layers, such as ID and name.</p>
 *
 * @author Gilberto Dev
 * @since 1.0.0
 */
public class GameListDTO {

    /**
     * Unique identifier of the game list.
     */
    private Long id;

    /**
     * Name of the game list.
     */
    private String name;

    /**
     * Default constructor.
     */
    public GameListDTO() {
    }

    /**
     * Constructs a {@code GameListDTO} by copying data from a {@link GameList} entity.
     *
     * @param entity the GameList entity to extract data from
     */
    public GameListDTO(GameList entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    /**
     * Returns the ID of the game list.
     *
     * @return the list ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Returns the name of the game list.
     *
     * @return the list name
     */
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameListDTO that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "GameListDTO{" +
               "id=" + id +
               ", name='" + name + '\'' +
               '}';
    }
}
