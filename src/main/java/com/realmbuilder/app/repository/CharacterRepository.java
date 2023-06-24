package com.realmbuilder.app.repository;

import com.realmbuilder.app.domain.Character;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Character entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {
    Page<Character> findAllByGameId(Pageable pageable, long gameId);
}
