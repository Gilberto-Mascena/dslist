package br.com.gilbertodev.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * Composite primary key class for the {@link Belonging} entity.
 *
 * <p>This class defines a composite key using references to {@link Game} and {@link GameList},
 * representing the many-to-many relationship between games and game lists.</p>
 *
 * @author Gilberto Dev
 */
@Embeddable
public class BelongingPK {

    /**
     * Reference to the game entity.
     */
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    /**
     * Reference to the game list entity.
     */
    @ManyToOne
    @JoinColumn(name = "list_id")
    private GameList list;

    /**
     * Default constructor.
     */
    public BelongingPK() {
    }

    /**
     * Constructs a {@code BelongingPK} with the given game and list.
     *
     * @param game the game entity
     * @param list the game list entity
     */
    public BelongingPK(Game game, GameList list) {
        this.game = game;
        this.list = list;
    }

    /**
     * Returns the game entity.
     *
     * @return the game
     */
    public Game getGame() {
        return game;
    }

    /**
     * Sets the game entity.
     *
     * @param game the game to set
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * Returns the game list entity.
     *
     * @return the list
     */
    public GameList getList() {
        return list;
    }

    /**
     * Sets the game list entity.
     *
     * @param list the list to set
     */
    public void setList(GameList list) {
        this.list = list;
    }

    /**
     * Generates a hash code based on game and list.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((game == null) ? 0 : game.hashCode());
        result = prime * result + ((list == null) ? 0 : list.hashCode());
        return result;
    }

    /**
     * Compares this object to another for equality based on game and list.
     *
     * @param obj the object to compare
     * @return true if both have the same game and list, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BelongingPK other = (BelongingPK) obj;
        if (game == null) {
            if (other.game != null)
                return false;
        } else if (!game.equals(other.game))
            return false;
        if (list == null) {
            if (other.list != null)
                return false;
        } else if (!list.equals(other.list))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "BelongingPK{" +
               "gameId=" + (game != null ? game.getId() : null) +
               ", listId=" + (list != null ? list.getId() : null) +
               '}';
    }
}
