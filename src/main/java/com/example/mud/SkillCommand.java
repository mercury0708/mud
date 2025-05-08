package com.example.mud;

public class SkillCommand implements Command {
    private String name;

    public SkillCommand(String name) {
        this.name = name;
    }

    public void execute(Player p, GameContext c) {
        if (name.equalsIgnoreCase("fireball")) {
            Skill skill = new FireballSkill();
            skill.use(p, c.getCurrentRoom().getMonster());
        } else {
            System.out.println("未知的技能：" + name);
        }
    }
}
