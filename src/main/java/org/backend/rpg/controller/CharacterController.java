package org.backend.rpg.controller;

import lombok.RequiredArgsConstructor;
import org.backend.rpg.dto.characterInfo.CharacterInfoResponseDto;
import org.backend.rpg.service.character.CharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/character")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterService characterService;

    @GetMapping("/{id}")
    public ResponseEntity<CharacterInfoResponseDto> getCharacterInfo(@PathVariable Long id) {
        return ResponseEntity.ok(characterService.getCharacterInfo(id));
    }
// todo
//    @PostMapping("/characters")
//    public ResponseEntity<CharacterResponse> createCharacter(
//            @RequestBody CreateCharacterRequest request,
//            @AuthenticationPrincipal UserDetails userDetails  // ← Spring lo inietta automaticamente
//    ) {
//        String username = userDetails.getUsername();
//        return ResponseEntity.ok(characterService.createCharacter(request, username));
//    }
}
