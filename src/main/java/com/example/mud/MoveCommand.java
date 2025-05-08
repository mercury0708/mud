package com.example.mud;

public class MoveCommand implements Command {
    private String direction;

    public MoveCommand(String direction) {
        this.direction = direction;
    }

    public void execute(Player player, GameContext context) {
        Room nextRoom = context.getCurrentRoom().getExit(direction);
        if (nextRoom != null) {
            context.setCurrentRoom(nextRoom);
            System.out.println("你移動到了：" + nextRoom.getName());
            System.out.println("你看到：" + nextRoom.getMonster().getName() + "（HP: " + nextRoom.getMonster().getHp() + "）");
            System.out.println("可用方向：" + nextRoom.getExitString());
            if (nextRoom.hasPotion()) {
                System.out.println("有一瓶發光的治療藥水躺在地上。");
            }
        } else {
            System.out.println("無法向這個方向移動！");
        }
    }
}
