package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {
    private final List<Player> players = new ArrayList<>();

    public PlayerController() {
        players.add(new Player(1, "Ciprian"));
        players.add(new Player(2, "Ionut"));
    }

    @GetMapping()
    public List<Player> getPlayers() {
        return players;
    }

    @GetMapping("/count")
    public int countPlayers() {
        return players.size();
    }

    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable("id") int id) {
        return players.stream()
                .filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @PostMapping
    public int createPlayer(@RequestParam String name) {
        int id = 1 + players.size();
        players.add(new Player(id, name));
        return id;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePlayer(
            @PathVariable int id, @RequestParam String name) {
        Player player = findById(id);
        if (player == null) {
            return new ResponseEntity<>(
                    "Player not found", HttpStatus.NOT_FOUND); //or GONE
        }
        player.setName(name);
        return new ResponseEntity<>(
                "Player updated successsfully", HttpStatus.OK);
    }


    private Player findById(int id) {
        for (Player player : players) {
            if(player.getId()==id)
                return player;
        }
        return null;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable int id) {
        Player player = findById(id);
        if (player == null) {
            return new ResponseEntity<>(
                    "Player not found", HttpStatus.GONE);
        }
        players.remove(player);
        return new ResponseEntity<>("Player removed", HttpStatus.OK);
    }
}