package com.example.mud;

public class UsePotionCommand implements Command {
    public void execute(Player p, GameContext c) {
        Room room = c.getCurrentRoom();
        if (room.hasPotion()) {
            p.takeDamage(-30); // Restore 30 HP
            room.removePotion();
            System.out.println("你喝下治療藥水，回復 30 HP！");
            System.out.println("你的 HP：" + p.getHp());
        } else {
            System.out.println("這裡沒有藥水可以使用！");
        }
    }
}
