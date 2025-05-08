package com.example.mud;

public class AttackCommand implements Command {
    public void execute(Player player, GameContext context) {
        Monster monster = context.getCurrentRoom().getMonster();

        if (monster == null || !monster.isAlive()) {
            System.out.println("這裡沒有怪物可以攻擊！");
            return;
        }

        // 玩家攻擊怪物
        int damage = player.getAttack();
        monster.takeDamage(damage);
        player.addDamage(damage);
        System.out.println("你對 " + monster.getName() + " 造成了 " + damage + " 傷害！");

        // 怪物是否死亡
        if (!monster.isAlive()) {
            player.addKill();
            System.out.println(monster.getName() + " 被擊倒！");
        } else {
            // 怪物反擊
            int monsterDamage = monster.getAttack();
            player.takeDamage(monsterDamage);
            System.out.println(monster.getName() + " 反擊你，造成 " + monsterDamage + " 傷害！");
        }

        // 確保不會顯示負 HP
        int playerHp = Math.max(0, player.getHp());
        int monsterHp = Math.max(0, monster.getHp());

        // 狀態顯示
        System.out.println("\n=== 狀態更新 ===");
        System.out.println("你的 HP：" + playerHp);
        System.out.println(monster.getName() + " HP：" + monsterHp);
        System.out.println("總傷害：" + player.getTotalDamage() + "，擊殺數：" + player.getKillCount());
    }
}
