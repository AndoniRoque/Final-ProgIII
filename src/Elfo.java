public class Elfo extends Personaje {

    public Elfo(int level, int health, String name, int str, int dex, int def, int spd, String tipo) {
        super(level, health, name, str, dex, def, spd, tipo);
    }

    public double ataque_elfo(Personaje personaje){
        double va = this.calcular_VA();
        double ed = this.calcular_ED();
        double pdef = personaje.calcular_PDEF();

        return (((va*ed) - pdef / 500) * 100) * 1.05;
    }
}
