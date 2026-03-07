package org.backend.rpg.entity.characters;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "spells")

public class Spells {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private float manaCost;
    private float baseDamage;
    private int minLevel;
}
