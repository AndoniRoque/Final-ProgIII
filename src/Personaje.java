//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Random;

public class Personaje extends Character {
    protected int str;
    protected int dex;
    protected int def;
    protected int spd;
    protected String tipo;
    protected double poder_disparo;
    protected double efectividad_disparo;
    protected double valor_ataque;
    protected double poder_defensa;

    public Personaje(int level, int health, String name, int str, int dex, int def, int spd, String tipo) {
        super(level, health, name);
        this.str = str;
        this.dex = dex;
        this.def = def;
        this.spd = spd;
        this.tipo = tipo;
    }

    protected String getTipo() {
        return this.tipo;
    }

    protected void setTipo(String tipo) {
        this.tipo = tipo;
    }

    protected int getStr() {
        return this.str;
    }

    protected void setStr(int str) {
        this.str = str;
    }

    protected int getDex() {
        return this.dex;
    }

    protected void setDex(int dex) {
        this.dex = dex;
    }

    protected int getDef() {
        return this.def;
    }

    protected void setDef(int def) {
        this.def = def;
    }

    protected int getSpd() {
        return this.spd;
    }

    protected void setSpd(int spd) {
        this.spd = spd;
    }

    protected double getPoder_disparo() {
        return poder_disparo;
    }

    protected void setPoder_disparo(double poder_disparo) {
        this.poder_disparo = poder_disparo;
    }

    protected double getEfectividad_disparo() {
        return efectividad_disparo;
    }

    protected void setEfectividad_disparo(double efectividad_disparo) {
        this.efectividad_disparo = efectividad_disparo;
    }

    protected double getValor_ataque() {
        return valor_ataque;
    }

    protected void setValor_ataque(double valor_ataque) {
        this.valor_ataque = valor_ataque;
    }

    protected double getPoder_defensa() {
        return poder_defensa;
    }

    protected void setPoder_defensa(double poder_defensa) {
        this.poder_defensa = poder_defensa;
    }

    protected double calcular_PD() {
        return this.dex * str * level;
    }

    protected double calcular_ED() {
        Random random = new Random();
        return (random.nextInt(100) + 1) / 100.0;
    }

    protected double calcular_VA() {
        double poder_disparo = this.calcular_PD();
        double efectividad_disparo = this.calcular_ED();
        return poder_disparo * efectividad_disparo;
    }

    protected double calcular_PDEF() {
        return this.def * this.spd;
    }

    protected void health_update(double daño_ataque) {
        setHealth(health - (int)daño_ataque);
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "level=" + level +
                ", health=" + health +
                ", name='" + name + '\'' +
                ", str=" + str +
                ", dex=" + dex +
                ", def=" + def +
                ", spd=" + spd +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
