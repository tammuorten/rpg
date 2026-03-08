package org.backend.rpg.entity.characters.mage;

import jakarta.persistence.*;
import lombok.Getter;
import org.backend.rpg.entity.characters.GameCharacter;

import java.util.Set;

@Entity
@Table(name = "mages")
@DiscriminatorValue("MAGE")
@Getter
@SuppressWarnings("FieldMayBeFinal")
public class Mage extends GameCharacter {

    private int mana;
    private int maxMana;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "jt_mage_spells",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "spell_id"))
    private Set<Spells> spells;   // FIRE, ICE, ARCANE

    @Override
    public float basicAttack() {
        return getStrength() + (getIntelligence() * 3);
    }



}
