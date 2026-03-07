package org.backend.rpg.entity.characters;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "mages")
@DiscriminatorValue("MAGE")
@Getter
public class Mage extends GameCharacter {

    private int mana;
    private int maxMana;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "jt_mage_spells",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "spell_id"))


    private Set<Spells> spells;   // FIRE, ICE, ARCANE

    @Override
    public int calculateDamage() {
        return getStrength() + (getIntelligence() * 3);
    }


    @Override
    public Set<CharacterAbilities> getSpecialAbilities() {
        return getAbilities();
    }
}
