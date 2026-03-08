package org.backend.rpg.entity.characters.rogue;

import jakarta.persistence.*;
import lombok.Getter;
import org.backend.rpg.entity.characters.GameCharacter;

import java.util.Set;

@Entity
@Table(name = "rogues")
@DiscriminatorValue("ROGUE")
@Getter
@SuppressWarnings("FieldMayBeFinal")
public class Rogue extends GameCharacter {

    private int flourishPoints;
    private boolean isDualWielding;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "jt_rogue_ability",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "ability_id"))
    private Set<RogueSpecials> rogueAbilities;

    @Override
    public float basicAttack() {
        return 0;
    }


}
