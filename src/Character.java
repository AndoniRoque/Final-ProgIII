//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Character {
    protected int health;
    protected int level;
    String name;

    public Character(int level, int health, String name) {
        this.health = health;
        this.level = level;
        this.name = name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected int getHealth() {
        return this.health;
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    protected int getLevel() {
        return this.level;
    }

    protected void setLevel(int level) {
        this.level = level;
    }
}
