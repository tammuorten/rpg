package org.backend.rpg.entity.characters;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name = "mages")
@DiscriminatorValue("MAGE")
@Getter
public class Mage extends GameCharacter {

    private int mana;
    private int maxMana;
    private int spellPower;
    private String schoolOfMagic;   // FIRE, ICE, ARCANE

    @Override
    public int calculateDamage() {
        return getBaseAttack() + (spellPower * 3);
    }

    @Override
    public String getCharacterType() { return "MAGE"; }

    @Override
    public List<String> getSpecialAbilities() {
        return switch (schoolOfMagic) {
            case "FIRE"   -> List.of("Fireball", "Inferno", "Phoenix Strike");
            case "ICE"    -> List.of("Frost Nova", "Blizzard", "Ice Lance");
            default       -> List.of("Arcane Blast", "Mana Surge");
        };
    }
}
