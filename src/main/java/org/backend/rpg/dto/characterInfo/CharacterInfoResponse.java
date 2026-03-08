package org.backend.rpg.dto.characterInfo;

import jakarta.persistence.*;
import lombok.Data;
import org.backend.rpg.entity.characters.CharacterAbilities;
import org.backend.rpg.entity.characters.GameCharacter;

import java.util.Set;
import java.util.stream.Collectors;

@Data
public abstract class CharacterInfoResponse {


    private Long id;
    private String name;
    private String description;
    private int level;
    private float currentHp;
    private float maxHp;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    public Set<AbilityDto> abilities;

    protected static void mapCommonFields(CharacterInfoResponse dto, GameCharacter character) {
        dto.setId(character.getId());
        dto.setName(character.getName());
        dto.setDescription(character.getDescription());
        dto.setLevel(character.getLevel());
        dto.setCurrentHp(character.getCurrentHp());
        dto.setMaxHp(character.getMaxHp());
        dto.setStrength(character.getStrength());
        dto.setDexterity(character.getDexterity());
        dto.setConstitution(character.getConstitution());
        dto.setIntelligence(character.getIntelligence());
        dto.setWisdom(character.getWisdom());
        dto.setCharisma(character.getCharisma());
        dto.setAbilities(character.getAbilities().stream()
                .map(AbilityDto::from)
                .collect(Collectors.toSet()));
    }
}
