package com.example.mud;

public interface Command {
    void execute(Player player, GameContext context);
}
