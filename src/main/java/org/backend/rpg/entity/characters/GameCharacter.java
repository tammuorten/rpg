package org.backend.rpg.entity.characters;

import jakarta.persistence.*;
import lombok.Getter;
import org.backend.rpg.entity.User;

import java.util.List;

@Entity
@Table(name = "character")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
@Getter
public abstract class GameCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private int level;
    private int currentHp;
    private int maxHp;
    private int baseAttack;
    private int baseDefense;

    @ManyToOne
    private User owner;                      // il personaggio appartiene a un utente

    // metodi polimorfici — ogni sottoclasse li implementa
    public abstract int calculateDamage();
    public abstract String getCharacterType();
    public abstract List<String> getSpecialAbilities();
}
