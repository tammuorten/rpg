package org.backend.rpg.entity.characters;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "rogues")
@DiscriminatorValue("ROGUE")
@Getter
public class Rogue extends GameCharacter {

    private int flourishPoints;
    private double dexterity;
    private boolean isDualWielding;

    @Override
    public int calculateDamage() {
        return 0;
    }

    @Override
    public String getCharacterType() {
        return "";
    }

    @Override
    public List<String> getSpecialAbilities() {
        return List.of();
    }

}
