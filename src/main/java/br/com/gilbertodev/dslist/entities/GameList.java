package br.com.gilbertodev.dslist.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Represents a list of games stored in the "tb_game_list" database table.
 * <p>This entity is used to group games by custom-defined lists, such as genres,
 * favorites, or user-defined categories.</p>
 *
 * @author Gilberto Dev
 * @since 1.0.0
 */
@Entity
@Table(name = "tb_game_list")
public class GameList {

    /**
     * Unique identifier for the game list.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the game list.
     */
    private String name;

    /**
     * Default constructor.
     */
    public GameList() {
    }

    /**
     * Constructs a GameList with the specified ID and name.
     *
     * @param id   the list ID
     * @param name the name of the list
     */
    public GameList(Long id, String name) {
        this.id = id;
        this.name = name;
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
     * Sets the ID of the game list.
     *
     * @param id the list ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the name of the game list.
     *
     * @return the list name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the game list.
     *
     * @param name the list name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Computes hash code based on the list ID.
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
     * Compares this list to another object based on ID.
     *
     * @param obj the object to compare
     * @return true if both lists have the same ID, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GameList other = (GameList) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "GameList{" +
               "id=" + id +
               ", name='" + name + '\'' +
               '}';
    }
}
