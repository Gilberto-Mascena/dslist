package br.com.gilbertodev.dslist.repositories;

import br.com.gilbertodev.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository interface for accessing and managing {@link GameList} entities.
 * <p>Extends {@link JpaRepository} to provide CRUD operations and custom query methods.</p>
 *
 * @author Gilberto Dev
 * @since 1.0.0
 */
public interface GameListRepository extends JpaRepository<GameList, Long> {

    /**
     * Updates the position of a specific game in a given game list.
     * This is used to change the display order of games within a list.
     *
     * @param listId      the ID of the list where the game is located
     * @param gameId      the ID of the game to reposition
     * @param newPosition the new position to assign to the game
     */
    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
    void updateBelongingPosition(@Param("listId") Long listId, @Param("gameId") Long gameId, @Param("newPosition") Integer newPosition);
}
