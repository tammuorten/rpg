package org.backend.rpg.entity.characters;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "warriors")
@DiscriminatorValue("WARRIOR")
public class Warrior extends GameCharacter {
    private int strength;          // colonne EXTRA nella tabella warriors
    private int armorRating;
    private boolean shieldEquipped;

    @Override
    public int calculateDamage() {
        return getBaseAttack() + (strength * 2) + (shieldEquipped ? 5 : 0);
    }

    @Override
    public String getCharacterType() { return "WARRIOR"; }

    @Override
    public List<String> getSpecialAbilities() {
        return List.of("Shield Bash", "Berserker Rage", "War Cry");
    }
}
