package com.example.mud;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerRepository repository;

    public PlayerController(PlayerRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return repository.findAll();
    }

    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        return repository.save(player);
    }
}