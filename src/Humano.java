public class Humano extends Personaje {

    public Humano(int level, int health, String name, int str, int dex, int def, int spd, String tipo) {
        super(level, health, name, str, dex, def, spd, tipo);
    }

    public double ataque(Personaje personaje) {
        double va = calcular_VA();
        double ed =calcular_ED();
        double pdef = calcular_PDEF();

        return ((va*ed)-pdef/500)*100;
    }

}
