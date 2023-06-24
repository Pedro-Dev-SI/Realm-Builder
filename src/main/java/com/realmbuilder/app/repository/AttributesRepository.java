package com.realmbuilder.app.repository;

import com.realmbuilder.app.domain.Attributes;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Attributes entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AttributesRepository extends JpaRepository<Attributes, Long> {}
