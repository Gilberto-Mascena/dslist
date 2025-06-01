package br.com.gilbertodev.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Entity representing the relationship between a {@link Game} and a {@link GameList}.
 *
 * <p>This class uses a composite primary key ({@link BelongingPK}) to map the many-to-many
 * association between games and lists, while also storing the position of each game
 * within a list.</p>
 *
 * @author Gilberto Dev
 */
@Entity
@Table(name = "tb_belonging")
public class Belonging {

    /**
     * Composite primary key combining Game and GameList references.
     */
    @EmbeddedId
    private BelongingPK id = new BelongingPK();

    /**
     * Position of the game within the list.
     */
    private Integer position;

    /**
     * Default constructor.
     */
    public Belonging() {
    }

    /**
     * Constructs a {@code Belonging} entity with the specified game, list, and position.
     *
     * @param game     the game to be associated
     * @param list     the game list to which the game belongs
     * @param position the position of the game in the list
     */
    public Belonging(Game game, GameList list, Integer position) {
        id.setGame(game);
        id.setList(list);
        this.position = position;
    }

    /**
     * Returns the composite ID of this belonging.
     *
     * @return the composite ID
     */
    public BelongingPK getId() {
        return id;
    }

    /**
     * Sets the composite ID of this belonging.
     *
     * @param id the new composite ID
     */
    public void setId(BelongingPK id) {
        this.id = id;
    }

    /**
     * Returns the position of the game in the list.
     *
     * @return the position
     */
    public Integer getPosition() {
        return position;
    }

    /**
     * Sets the position of the game in the list.
     *
     * @param position the new position
     */
    public void setPosition(Integer position) {
        this.position = position;
    }

    /**
     * Generates a hash code based on the composite ID.
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
     * Compares this object with another for equality based on the composite ID.
     *
     * @param obj the object to compare
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Belonging other = (Belonging) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Belonging{" +
               "gameId=" + (id != null && id.getGame() != null ? id.getGame().getId() : null) +
               ", listId=" + (id != null && id.getList() != null ? id.getList().getId() : null) +
               ", position=" + position +
               '}';
    }
}
