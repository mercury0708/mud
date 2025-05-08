package com.example.mud;

import java.util.Arrays;
import java.util.List;

public class GameInitializer {
    private static Room forest;
    private static Room temple;

    public static GameContext init() {
        // 建立房間與怪物
        forest = new Room(
            "森林入口",
            "你站在茂密森林的邊緣",
            new Monster("哥布林", 30, 8),
            true
        );

        temple = new Room(
            "神殿大廳",
            "光線從破碎的石窗灑落",
            new Monster("亡靈戰士", 50, 12),
            false
        );

        // 設定出口
        forest.setExit("north", temple);
        temple.setExit("south", forest);

        // 建立玩家
        Player player = new Player("勇者", 100, 15);

        // 回傳初始遊戲上下文
        return new GameContext(player, forest);
    }

    // 提供所有房間，讓 GameEngine 能檢查怪物狀態
    public static List<Room> getAllRooms() {
        return Arrays.asList(forest, temple);
    }
}
