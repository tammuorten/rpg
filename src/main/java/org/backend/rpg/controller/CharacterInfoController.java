package org.backend.rpg.controller;

import lombok.RequiredArgsConstructor;
import org.backend.rpg.dto.characterInfo.CharacterInfoResponse;
import org.backend.rpg.service.characterInfo.CharacterInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/character")
@RequiredArgsConstructor
public class CharacterInfoController {

    private final CharacterInfoService characterInfoService;

    @GetMapping("/{id}")
    public ResponseEntity<CharacterInfoResponse> getCharacterInfo(@PathVariable Long id) {
        return ResponseEntity.ok(characterInfoService.getCharacterInfo(id));
    }
}
