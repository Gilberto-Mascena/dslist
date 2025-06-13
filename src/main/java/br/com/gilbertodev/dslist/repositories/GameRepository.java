package br.com.gilbertodev.dslist.repositories;

import br.com.gilbertodev.dslist.entities.Game;
import br.com.gilbertodev.dslist.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repository interface for accessing and managing {@link Game} entities.
 * <p>Extends {@link JpaRepository} to provide standard CRUD operations and custom queries.</p>
 *
 * @author Gilberto Dev
 * @since 1.0.0
 */
public interface GameRepository extends JpaRepository<Game, Long> {

    /**
     * Retrieves a list of minimal game projections associated with a specific game list.
     * <p>This native SQL query joins the {@code tb_game} and {@code tb_belonging} tables to
     * return selected game data sorted by their position within the list.</p>
     *
     * @param listId the ID of the game list
     * @return a list of {@link GameMinProjection} containing selected game fields
     */
    @Query(nativeQuery = true, value = """
            SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
            tb_game.short_description AS shortDescription, tb_belonging.position
            FROM tb_game
            INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
            WHERE tb_belonging.list_id = :listId
            ORDER BY tb_belonging.position
            """)
    List<GameMinProjection> searchByList(Long listId);
}
