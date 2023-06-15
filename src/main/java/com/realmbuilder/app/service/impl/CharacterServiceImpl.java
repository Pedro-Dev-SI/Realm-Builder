package com.realmbuilder.app.service.impl;

import com.realmbuilder.app.domain.Character;
import com.realmbuilder.app.repository.CharacterRepository;
import com.realmbuilder.app.service.CharacterService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Character}.
 */
@Service
@Transactional
public class CharacterServiceImpl implements CharacterService {

    private final Logger log = LoggerFactory.getLogger(CharacterServiceImpl.class);

    private final CharacterRepository characterRepository;

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public Character save(Character character) {
        log.debug("Request to save Character : {}", character);
        return characterRepository.save(character);
    }

    @Override
    public Character update(Character character) {
        log.debug("Request to update Character : {}", character);
        return characterRepository.save(character);
    }

    @Override
    public Optional<Character> partialUpdate(Character character) {
        log.debug("Request to partially update Character : {}", character);

        return characterRepository
            .findById(character.getId())
            .map(existingCharacter -> {
                if (character.getFirstName() != null) {
                    existingCharacter.setFirstName(character.getFirstName());
                }
                if (character.getSecondName() != null) {
                    existingCharacter.setSecondName(character.getSecondName());
                }
                if (character.getRace() != null) {
                    existingCharacter.setRace(character.getRace());
                }
                if (character.getClass() != null) {
                    existingCharacter.setClass(character.getClass());
                }
                if (character.getDescription() != null) {
                    existingCharacter.setDescription(character.getDescription());
                }

                return existingCharacter;
            })
            .map(characterRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Character> findAll(Pageable pageable) {
        log.debug("Request to get all Characters");
        return characterRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Character> findOne(Long id) {
        log.debug("Request to get Character : {}", id);
        return characterRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Character : {}", id);
        characterRepository.deleteById(id);
    }
}
