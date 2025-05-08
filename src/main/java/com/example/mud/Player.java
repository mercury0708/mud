package com.example.mud;

import jakarta.persistence.*;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int hp;
    private int attack;
    private int killCount;
    private int totalDamage;

    // 必要的空建構子給 JPA 用
    public Player() {}

    // 遊戲內使用的建構子
    public Player(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.killCount = 0;
        this.totalDamage = 0;
    }

    public boolean isAlive() { return hp > 0; }

    public void takeDamage(int dmg) { hp -= dmg; }

    public int getHp() { return hp; }

    public int getAttack() { return attack; }

    public void addKill() { killCount++; }

    public void addDamage(int dmg) { totalDamage += dmg; }

    public int getKillCount() { return killCount; }

    public int getTotalDamage() { return totalDamage; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public void setHp(int hp) { this.hp = hp; }

    public void setAttack(int attack) { this.attack = attack; }

    public void setKillCount(int killCount) { this.killCount = killCount; }

    public void setTotalDamage(int totalDamage) { this.totalDamage = totalDamage; }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }
}
