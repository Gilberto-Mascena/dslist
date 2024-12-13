package br.com.gilbertodev.dslist.service;

import br.com.gilbertodev.dslist.common.GameConstants;
import br.com.gilbertodev.dslist.dto.GameDTO;
import br.com.gilbertodev.dslist.dto.GameMinDTO;
import br.com.gilbertodev.dslist.entities.Game;
import br.com.gilbertodev.dslist.repositories.GameRepository;
import br.com.gilbertodev.dslist.services.GameService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GameServiceTest {

    @InjectMocks
    private GameService service;

    @Mock
    private GameRepository repository;

    @Test
    public void shouldFindAllGames() {
        List<Game> games = List.of(GameConstants.GAME);

        when(repository.findAll()).thenReturn(games);

        List<GameMinDTO> result = service.findAll();

        assertThat(result).isNotEmpty();
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getId()).isEqualTo(GameConstants.GAME.getId());
        assertThat(result.get(0).getTitle()).isEqualTo(GameConstants.GAME.getTitle());
        assertThat(result.get(0).getYear()).isEqualTo(GameConstants.GAME.getYear());
        assertThat(result.get(0).getImgUrl()).isEqualTo(GameConstants.GAME.getImgUrl());
        assertThat(result.get(0).getShortDescription()).isEqualTo(GameConstants.GAME.getShortDescription());
    }

    @Test
    public void shouldFindGameById() {
        when(repository.findById(GameConstants.GAME.getId())).thenReturn(Optional.of(GameConstants.GAME));

        GameDTO result = service.findById(GameConstants.GAME.getId());

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(GameConstants.GAME.getId());
        assertThat(result.getTitle()).isEqualTo(GameConstants.GAME.getTitle());
        assertThat(result.getYear()).isEqualTo(GameConstants.GAME.getYear());
        assertThat(result.getGenre()).isEqualTo(GameConstants.GAME.getGenre());
        assertThat(result.getPlatforms()).isEqualTo(GameConstants.GAME.getPlatforms());
        assertThat(result.getScore()).isEqualTo(GameConstants.GAME.getScore());
        assertThat(result.getImgUrl()).isEqualTo(GameConstants.GAME.getImgUrl());
        assertThat(result.getShortDescription()).isEqualTo(GameConstants.GAME.getShortDescription());
        assertThat(result.getLongDescription()).isEqualTo(GameConstants.GAME.getLongDescription());
    }
}
