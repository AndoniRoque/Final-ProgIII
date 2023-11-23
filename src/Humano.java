public class Humano extends Personaje {

    public Humano(int level, int health, String name, int str, int dex, int def, int spd, String tipo) {
        super(level, health, name, str, dex, def, spd, tipo);
    }

    public double ataque_humano(Personaje personaje) {
        double va = this.calcular_VA();
        double ed = this.calcular_ED();
        double pdef = personaje.calcular_PDEF();

        return ((va * ed) - pdef / 500) * 2;
    }

}
