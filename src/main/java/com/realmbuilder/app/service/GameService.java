package com.realmbuilder.app.service;

import com.realmbuilder.app.domain.Game;
import com.realmbuilder.app.repository.GameRepository;
import java.util.Optional;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Getter
@Setter
public class GameService {

    private final Logger log = LoggerFactory.getLogger(GameService.class);

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game save(Game game) {
        log.debug("Request to save Game : {}", game);
        return gameRepository.save(game);
    }

    public Game update(Game game) {
        log.debug("Request to update Game : {}", game);
        return gameRepository.save(game);
    }

    public Optional<Game> partialUpdate(Game game) {
        log.debug("Request to partially update Game : {}", game);

        return gameRepository
            .findById(game.getId())
            .map(existingGame -> {
                if (game.getTitle() != null) {
                    existingGame.setTitle(game.getTitle());
                }
                if (game.getSubtitle() != null) {
                    existingGame.setSubtitle(game.getSubtitle());
                }
                if (game.getDescription() != null) {
                    existingGame.setDescription(game.getDescription());
                }

                return existingGame;
            })
            .map(gameRepository::save);
    }

    @Transactional(readOnly = true)
    public Page<Game> findAll(Pageable pageable) {
        log.debug("Request to get all Games");
        return gameRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Optional<Game> findOne(Long id) {
        log.debug("Request to get Game : {}", id);
        return gameRepository.findById(id);
    }

    public void delete(Long id) {
        log.debug("Request to delete Game : {}", id);
        gameRepository.deleteById(id);
    }
}
