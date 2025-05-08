package com.example.mud;

public class FireballSkill implements Skill {
    public String getName() { return "fireball"; }
    
    public void use(Player p, Monster m) {
        System.out.println("🔥 你施放了【火球術】！");
        int damage = 40;
        m.takeDamage(damage);
        System.out.println("對 " + m.getName() + " 造成 " + damage + " 傷害！");
        if (!m.isAlive()) {
            System.out.println(m.getName() + " 被你燒成灰燼了！");
        }
    }
}
