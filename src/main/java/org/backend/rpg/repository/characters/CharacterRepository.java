package org.backend.rpg.repository.characters;

import org.backend.rpg.entity.characters.GameCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterRepository extends JpaRepository<GameCharacter, Long> {
    List<GameCharacter> findByOwnerId(Long userId);

    // Personaggio per nome e owner (per evitare duplicati)
    Optional<GameCharacter> findByNameAndOwnerId(String name, Long userId);

    // Usato per la schermata "seleziona personaggio"
    @Query("SELECT c FROM GameCharacter c WHERE c.owner.id = :userId ORDER BY c.level DESC")
    List<GameCharacter> findAllByOwnerOrderedByLevel(@Param("userId") Long userId);
}
