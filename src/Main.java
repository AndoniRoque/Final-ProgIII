//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.*;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        System.out.println("Java Rol TUP");
        System.out.println("Welcome: ");
        String input = "0";
        ArrayList<Personaje> party_1 = new ArrayList();
        ArrayList<Personaje> party_2 = new ArrayList();

        while(!input.equals("5")) {
            System.out.println("     1 . Start.");
            System.out.println("     2 . Start with random characters.");
            System.out.println("     3 . Read Log");
            System.out.println("     4 . Delete log");
            System.out.println("     5 . Exit.");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select and press Enter: ");
            input = scanner.nextLine();
            if (input.equals("1")) {
                for(int i = 0; i < 3; i++) {
                    party_1.add(GenerarPersonajes());
                }
                System.out.println("Create second party...");
                for(int i = 0; i < 3; i++) {
                    party_2.add(GenerarPersonajes());
                }
            }




            System.out.println("Press Enter to exit...");
            scanner.nextLine();
        }

    }

    public static Personaje GenerarPersonajes() {

        Scanner scanner = new Scanner(System.in);
        int select_tipo = -1;
        String tipo = "";

        while (select_tipo == -1) {
            System.out.println("----- Character Creation ------");
            System.out.println("-------------------------------");
            System.out.println("Select the type of character it will be: ");

            System.out.println("     1. Humano");
            System.out.println("     2. Orco");
            System.out.println("     3. Elfo");
            tipo = scanner.nextLine().toUpperCase();


            if(tipo.equals("1") || tipo.equals("HUMANO")) {
                tipo = "Humano";
                select_tipo = 1;
            } else if (tipo.equals("2") || tipo.equals("ORCO")) {
                tipo = "Orco";
                select_tipo = 1;
            } else if (tipo.equals("3") || tipo.equals("ELFO")) {
                tipo = "Elfo";
                select_tipo = 1;
            } else {
                System.out.println("Please enter a valid option");
            }
        }


        System.out.println("Enter character's name: ");
        String name = scanner.nextLine();

        System.out.println("Enter character's strength: ");
        int str = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter character's dexterity: ");
        int dex = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter character's defence: ");
        int def = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter character's speed: ");
        int spd = scanner.nextInt();
        scanner.nextLine();

        Personaje character1 = new Personaje(10, 100, name, str, dex, def, spd, tipo);

        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Tu personaje es: " + character1.name + " de tipo: " + character1.tipo + ".");
        System.out.println("Salud: " + character1.health + ". Level: " + character1.level);
        System.out.println("     Strength: " + character1.getStr());
        System.out.println("     Dexterity: " + character1.getDex());
        System.out.println("     Defence: " + character1.getDef());
        System.out.println("     Speed: " + character1.getSpd());
        System.out.println("---------------------------------------------------------------------------");

        // TODO: un ciclo while que le pregunte al usuario si esta conforme con el personaje creado o quiere reingresar los stats.
        System.out.println("Press enter to create another character...");
        scanner.nextLine();

        return character1;
        }
    }

