package org.backend.rpg.dto.characterInfo;

import lombok.Data;
import org.backend.rpg.entity.characters.Mage;
import org.backend.rpg.entity.characters.Spells;

import java.util.Set;
import java.util.stream.Collectors;

@Data
public class MageInfoDTO extends CharacterInfoResponse {
    private int mana;
    private int maxMana;
    private Set<SpellDto> spells;

// ca chiamare con MageInfo mageInfo = newMageInfo.from(mage);
public static MageInfoDTO from(Mage mage) {
    MageInfoDTO dto = new MageInfoDTO();
    mapCommonFields(dto, mage);        // campi comuni dal padre — una riga
    dto.setMana(mage.getMana());
    dto.setMaxMana(mage.getMaxMana());
    dto.setSpells(mage.getSpells().stream()
            .map(SpellDto::from)
            .collect(Collectors.toSet()));
    return dto;
}

}
