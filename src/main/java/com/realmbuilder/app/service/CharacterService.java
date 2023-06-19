package com.realmbuilder.app.service;

import com.realmbuilder.app.domain.Character;
import com.realmbuilder.app.repository.CharacterRepository;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CharacterService {

    private final Logger log = LoggerFactory.getLogger(CharacterService.class);

    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public Character save(Character character) {
        log.debug("Request to save Character : {}", character);
        return characterRepository.save(character);
    }

    public Character update(Character character) {
        log.debug("Request to update Character : {}", character);
        return characterRepository.save(character);
    }

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
                    existingCharacter.setClassification(character.getClassification());
                }
                if (character.getDescription() != null) {
                    existingCharacter.setDescription(character.getDescription());
                }

                return existingCharacter;
            })
            .map(characterRepository::save);
    }

    @Transactional(readOnly = true)
    public Page<Character> findAll(Pageable pageable) {
        log.debug("Request to get all Characters");
        return characterRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Optional<Character> findOne(Long id) {
        log.debug("Request to get Character : {}", id);
        return characterRepository.findById(id);
    }

    public void delete(Long id) {
        log.debug("Request to delete Character : {}", id);
        characterRepository.deleteById(id);
    }
}
