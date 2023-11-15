//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Random;

public class Personaje extends Character {
    public int str;
    public int dex;
    public int def;
    public int spd;
    public String tipo;
    public double poder_disparo;
    public double efectividad_disparo;
    public double valor_ataque;
    public double poder_defensa;

    public Personaje(int level, int health, String name, int str, int dex, int def, int spd, String tipo) {
        super(level, health, name);
        this.str = str;
        this.dex = dex;
        this.def = def;
        this.spd = spd;
        this.tipo = tipo;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getStr() {
        return this.str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getDex() {
        return this.dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getDef() {
        return this.def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getSpd() {
        return this.spd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    public double getPoder_disparo() {
        return poder_disparo;
    }

    public void setPoder_disparo(double poder_disparo) {
        this.poder_disparo = poder_disparo;
    }

    public double getEfectividad_disparo() {
        return efectividad_disparo;
    }

    public void setEfectividad_disparo(double efectividad_disparo) {
        this.efectividad_disparo = efectividad_disparo;
    }

    public double getValor_ataque() {
        return valor_ataque;
    }

    public void setValor_ataque(double valor_ataque) {
        this.valor_ataque = valor_ataque;
    }

    public double getPoder_defensa() {
        return poder_defensa;
    }

    public void setPoder_defensa(double poder_defensa) {
        this.poder_defensa = poder_defensa;
    }

    protected double calcular_PD() {
        return this.dex * str * level;
    }

    protected double calcular_ED() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

    protected double calcular_VA() {
        double poder_disparo = this.calcular_PD();
        double efectividad_disparo = this.calcular_ED();
        return poder_disparo * efectividad_disparo;
    }

    protected double calcular_PDEF() {
        return this.def * this.spd;
    }

    public void health_update(double daño_ataque) {
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
