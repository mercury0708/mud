package com.example.mud;

import java.util.Scanner;

public class GameEngine {
    private GameContext context;
    private Scanner scanner = new Scanner(System.in);

    public GameEngine(GameContext context) {
        this.context = context;
    }

    public void start() {
        while (context.getPlayer().isAlive()) {
            // 檢查是否所有怪物都死了
            if (areAllMonstersDefeated()) {
                System.out.println("🎉 恭喜你擊倒了所有怪物！你贏了！");
                break;
            }

            System.out.println("\n你目前在：" + context.getCurrentRoom().getName());
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("你選擇結束遊戲，再見！");
                break;
            }

            Command command = CommandParser.parse(input);
            if (command != null) {
                command.execute(context.getPlayer(), context);
            } else {
                System.out.println("無效的指令。");
            }
        }

        if (!context.getPlayer().isAlive()) {
            System.out.println("你已死亡，遊戲結束。");
        }
    }

    // 加入這個方法來檢查所有房間的怪物是否都死亡
    private boolean areAllMonstersDefeated() {
        return GameInitializer.getAllRooms().stream()
            .map(Room::getMonster)
            .filter(monster -> monster != null)
            .allMatch(monster -> !monster.isAlive());
    }
}
