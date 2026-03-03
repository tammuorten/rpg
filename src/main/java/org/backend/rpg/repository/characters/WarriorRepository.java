package org.backend.rpg.repository.characters;

import org.backend.rpg.entity.characters.Warrior;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarriorRepository extends CrudRepository<Warrior, Long> {
    List<Warrior> findByOwnerId(Long userId);

    // Cerca guerrieri con alta armatura (es. per matchmaking)
    List<Warrior> findByArmorRatingGreaterThan(int minArmor);

    // Con scudo equipaggiato
    List<Warrior> findByOwnerIdAndShieldEquippedTrue(Long userId);
}
