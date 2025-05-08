package com.example.mud;

public class LookCommand implements Command {
    public void execute(Player p, GameContext c) {
        Room room = c.getCurrentRoom();
        Monster monster = room.getMonster();

        System.out.println("【房間】：" + room.getName());
        System.out.println("【描述】：" + room.getDescription());

        if (monster != null && monster.isAlive()) {
            System.out.println("【怪物】：" + monster.getName() + "（HP: " + monster.getHp() + ")");
        }

        if (room.hasPotion()) {
            System.out.println("【道具】：治療藥水");
        }

        String exits = room.getExitString();
        System.out.println("【出口】：" + (exits.isEmpty() ? "無" : exits));
    }
}
