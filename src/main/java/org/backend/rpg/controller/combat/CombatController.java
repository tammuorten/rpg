package org.backend.rpg.controller.combat;

import lombok.RequiredArgsConstructor;
import org.backend.rpg.service.combat.CombatService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/combat")
@RequiredArgsConstructor
public class CombatController {

private final CombatService combatService;



}
