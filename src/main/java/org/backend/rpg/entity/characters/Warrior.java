package org.backend.rpg.entity.characters;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "warriors")
@DiscriminatorValue("WARRIOR")
public class Warrior extends GameCharacter {

    private int armorRating;
    private boolean shieldEquipped;


    @Override
    public int calculateDamage() {
        return (getStrength() * 2) + (shieldEquipped ? 5 : 0);
    }

    @Override
    public Set<CharacterAbilities> getSpecialAbilities() {
        return getAbilities();
    }
}
