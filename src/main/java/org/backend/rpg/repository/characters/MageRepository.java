package org.backend.rpg.repository.characters;

import org.backend.rpg.entity.characters.Mage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MageRepository extends CrudRepository<Mage, Long> {
    List<Mage> findByOwnerId(Long userId);

    // Tutti i maghi del fuoco
    List<Mage> findBySchoolOfMagic(String school);

    // Maghi con mana pieno (utili per selezione)
    @Query("SELECT m FROM Mage m WHERE m.mana = m.maxMana AND m.owner.id = :userId")
    List<Mage> findFullManaByOwner(@Param("userId") Long userId);
}
