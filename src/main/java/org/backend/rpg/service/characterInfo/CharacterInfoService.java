package org.backend.rpg.service.characterInfo;

import lombok.RequiredArgsConstructor;
import org.backend.rpg.dto.characterInfo.CharacterInfoResponse;
import org.backend.rpg.dto.characterInfo.MageInfoDTO;
import org.backend.rpg.entity.characters.GameCharacter;
import org.backend.rpg.entity.characters.Mage;
import org.backend.rpg.repository.characters.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CharacterInfoService {

    private CharacterRepository characterRepository;


    public CharacterInfoResponse getCharacterInfo(Long characterId) {
        GameCharacter character = characterRepository.findById(characterId)
                .orElseThrow(() -> new IllegalArgumentException("Personaggio non trovato: " + characterId));;

        if (character instanceof Mage mage) {
            return MageInfoDTO.from(mage);
        }
//        altre classi appena le ho fatte

        throw new UnsupportedOperationException(
                "Tipo di personaggio non gestito: " + character.getClass().getSimpleName());
    }

}
