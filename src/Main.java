//
// Andoni Roque - Programación III - 2022
// TUP - UTN - FRBB
//

import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) {
        System.out.println("Java Rol TUP");
        System.out.println("Welcome: ");
        String input = "0";
        ArrayList<Personaje> party_1 = new ArrayList();
        ArrayList<Personaje> party_2 = new ArrayList();

        File logs = new File("logs.txt");

        try {
            if (logs.createNewFile()) {
                System.out.println("Logs file created: " + logs.getName() + ".");
                System.out.println("Current Working Directory: " + System.getProperty("user.dir"));
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error ocurred.");
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter("logs.txt");

        // Menú
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

                    // Crear Personajes Manualmente.

                    // Generar 3 personajes por jugador
                    for (int i = 0; i < 3; i++) {
                        party_1.add(GenerarPersonajes());
                    }


                    System.out.println("Press enter to continue...");
                    input = scanner.nextLine();

                    System.out.println("Create second party... press enter.");
                    input = scanner.nextLine();

                    for (int i = 0; i < 3; i++) {
                        party_2.add(GenerarPersonajes());
                    }

                    System.out.println("-------------------------------");
                    writer.write("-------------------------------\n");
                    System.out.println("Combat will start soon.");
                    writer.write("Combat will start soon.\n");
                    System.out.println("-------------------------------");
                    writer.write("-------------------------------\n");
                    System.out.println("Press Enter to continue...");
                    input = scanner.nextLine();

                    int i = 1; // Número de rounds.

                    while (party_1.size() > 0 && party_2.size() > 0) {
                        Combate(party_1, party_2, i, writer);
                    }

                    if (party_1.isEmpty()) {
                        System.out.println("Press Enter to continue...");
                        input = scanner.nextLine();
                        System.out.println("-------------------------------");
                        writer.write("-------------------------------\n");
                        System.out.println("CONGRATULATIONS PLAYER 2 - YOU'VE WON THE IRON THRONE.");
                        writer.write("CONGRATULATIONS PLAYER 2 - YOU'VE WON THE IRON THRONE.\n");
                        System.out.println("-------------------------------");
                        writer.write("-------------------------------\n");
                        System.out.println("^  ^  ^");
                        writer.write("^  ^  ^\n");
                        System.out.println("|V * V|");
                        writer.write("|V * V|\n");
                        System.out.println("|_____| ");
                        writer.write("|_____|\n");
                        writer.close();
                    } else {
                        System.out.println("Press Enter to continue...");
                        input = scanner.nextLine();
                        System.out.println("-------------------------------");
                        writer.write("-------------------------------\n");
                        System.out.println("CONGRATULATIONS PLAYER 1 - YOU'VE WON THE IRON THRONE.");
                        writer.write("CONGRATULATIONS PLAYER 1 - YOU'VE WON THE IRON THRONE.\n");
                        System.out.println("-------------------------------");
                        writer.write("-------------------------------\n");
                        System.out.println("^  ^  ^");
                        writer.write("^  ^  ^\n");
                        System.out.println("|V * V|");
                        writer.write("|V * V|\n");
                        System.out.println("|_____| ");
                        writer.write("|_____|\n");
                        writer.close();
                    }

                    party_1.clear();
                    party_2.clear();


                } else if (input.equals("2")) {

                    // Crear personajes aleatoriamente.

                    for (int i = 0; i < 3; i++) {
                        party_1.add(GenerarPeronsajesAleatorios());
                        party_2.add(GenerarPeronsajesAleatorios());
                    }

                    System.out.println("-------------------------------");
                    System.out.println("|          Party 1            |");
                    System.out.println("-------------------------------");
                    writer.write("-------------------------------\n");
                    writer.write("|          Party 1            |\n");
                    writer.write("-------------------------------\n");
                    MostrarParty(party_1);

                    System.out.println("Press enter to continue...");
                    input = scanner.nextLine();

                    System.out.println("-------------------------------");
                    System.out.println("|          Party 2            |");
                    System.out.println("-------------------------------");
                    writer.write("-------------------------------\n");
                    writer.write("|          Party 2            |\n");
                    writer.write("-------------------------------\n");
                    MostrarParty(party_2);

                    System.out.println("Press enter to continue...");
                    input = scanner.nextLine();

                    int i = 1; // Número de rounds.

                    while (party_1.size() > 0 && party_2.size() > 0) {
                        Combate(party_1, party_2, i, writer);
                    }

                    if (party_1.isEmpty()) {
                        System.out.println("Press Enter to continue...");
                        input = scanner.nextLine();
                        System.out.println("-------------------------------");
                        System.out.println("CONGRATULATIONS PLAYER 2 - YOU'VE WON THE IRON THRONE.");
                        System.out.println("-------------------------------");
                        writer.write("-------------------------------\n");
                        writer.write("CONGRATULATIONS PLAYER 2 - YOU'VE WON THE IRON THRONE.\n");
                        writer.write("-------------------------------\n");
                        System.out.println("^  ^  ^");
                        writer.write("^  ^  ^\n");
                        System.out.println("|V * V|");
                        writer.write("|V * V|\n");
                        System.out.println("|_____|");
                        writer.write("|_____|\n");
                        writer.close();
                    } else {
                        System.out.println("Press Enter to continue...");
                        input = scanner.nextLine();
                        System.out.println("-------------------------------");
                        System.out.println("CONGRATULATIONS PLAYER 1 - YOU'VE WON THE IRON THRONE.");
                        System.out.println("-------------------------------");
                        writer.write("-------------------------------\n");
                        writer.write("CONGRATULATIONS PLAYER 1 - YOU'VE WON THE IRON THRONE.\n");
                        writer.write("-------------------------------\n");
                        System.out.println("^  ^  ^");
                        writer.write("^  ^  ^\n");
                        System.out.println("|V * V|");
                        writer.write("|V * V|\n");
                        System.out.println("|_____|");
                        writer.write("|_____|\n");
                        writer.close();
                    }

                    party_1.clear();
                    party_2.clear();

                } else if (input.equals("3")) {
                    // TODO: mostrar logs.
                    // Mostrar Logs
                    writer.close();
                    try {
                        Scanner reader = new Scanner(logs);
                        while (reader.hasNextLine()) {
                            String data = reader.nextLine();
                            System.out.println(data);
                        }
                        reader.close();
                    } catch (FileNotFoundException e){
                        System.out.println("File not found.");
                        e.printStackTrace();
                    }


                } else if (input.equals("4")) {

                    // Borrar logs.
                    writer.close();
                    System.out.println("Are you sure you want to delete the logs?");
                    System.out.println("1 - YES");
                    System.out.println("2 - Cancel.");
                    input = scanner.nextLine().toUpperCase();

                    if(input.equals("1") || input.equals("YES")) {
                        if (logs.exists()) {
                            if (logs.delete()) {
                                System.out.println("Logs file deletated successfully.");
                            } else {
                                System.out.println("Unable to delte the file.");
                            }
                        } else {
                            System.out.println("File doesn't exist.");
                        }
                    }

                } else if (!input.equals("5")) {
                    System.out.println("You shall not pass!!");
                }

                System.out.println("Press Enter to exit...");
                scanner.nextLine();


            }
        } catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }



    public static Personaje GenerarPersonajes() {
        // TODO: limitar skill points
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
            System.out.println("     4. Cancel");
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
            } else if (tipo.equals("4") || tipo.equals("EXIT")) {
                break; // TODO: exit loop correctly
            } else {
                System.out.println("Please enter a valid option...");
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

        Personaje character1 = null;

        if(tipo.equals("Humano")) {
            character1 = new Humano(10,100,name, str, dex, def, spd, tipo);
        } else if (tipo.equals("Elfo")) {
            character1 = new Elfo(10, 100,name, str, dex, def, spd, tipo);
        } else if (tipo.equals("Orco")) {
            character1 = new Orco(10, 100, name, str,dex, def, spd, tipo);
        } else {
            System.out.println("ERROR");
        }

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

    public static List<Personaje> ElegirPartyAtaca(ArrayList<Personaje> party_1,ArrayList<Personaje>party_2) {
        Random random = new Random();
        int first_attacker = random.nextInt(2) + 1;

        if (first_attacker == 1) {
            return party_1;
        } else {
            return party_2;
        }
    }

    public static Personaje ElegirPersonaje(ArrayList<Personaje> party) {
        Random random = new Random();
        int jugador = random.nextInt(party.size());
        return party.get(jugador);
    }

    public static void Combate(ArrayList<Personaje> party_1, ArrayList<Personaje> party_2, int i, Writer writer) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        ArrayList <Personaje> first_attacker = (ArrayList<Personaje>) ElegirPartyAtaca(party_1, party_2);
        ArrayList<Personaje> second_attacker;

        if (first_attacker.equals(party_1)) {
            System.out.println("First party attacks first.");
            writer.write("First party attacks first.\n");
            second_attacker = party_2;
        } else {
            System.out.println("Second party attacks first");
            writer.write("Second party attacks first\n");
            second_attacker = party_1;
        }

        System.out.println("-------------------------------");
        writer.write("-------------------------------\n");
        Personaje attacker = ElegirPersonaje(first_attacker);
        Personaje defender = ElegirPersonaje(second_attacker);
        System.out.println(">>>" + attacker.name + " attacks first.");
        writer.write(">>>" + attacker.name + " attacks first.\n");
        System.out.println("<<<" + defender.name + " will defend.");
        writer.write("<<<" + attacker.name + " will defend.\n");

        while(i < 7 && attacker.getHealth() > 0 && defender.getHealth() > 0) {
            System.out.println("-------------------------------");
            writer.write("-------------------------------\n");
            System.out.println("Round: " + i);
            writer.write("Round: " + i + "\n");
            System.out.println("-------------------------------");
            writer.write("-------------------------------\n");

            if (attacker instanceof Humano ) {
                double danio = ((Humano) attacker).ataque_humano(defender);
                System.out.println(attacker.name + " attacks with: " + danio + " points to " + defender.name + ".");
                writer.write(attacker.name + " attacks with: " + danio + " points to " + defender.name + ".\n");
                defender.health_update(danio);
                System.out.println("Press Enter to continue...");
                input = scanner.nextLine();
                System.out.println("La salud del atacante: " + attacker.getHealth() + ".");
                System.out.println("La salud del defensor: " + defender.getHealth() + ".");
                writer.write("La salud del atacante: " + attacker.getHealth() + ".\n");
                writer.write("La salud del defensor: " + defender.getHealth() + ".\n");
                System.out.println("Press Enter to continue...");
                input = scanner.nextLine();
            } else if (attacker instanceof Orco) {
                double danio = ((Orco) attacker).ataque_orco(defender);
                System.out.println(attacker.name + " attacks with: " + danio + " points to " + defender.name + ".");
                writer.write(attacker.name + " attacks with: " + danio + " points to " + defender.name + ".\n");
                defender.health_update(danio);
                System.out.println("Press Enter to continue...");
                input = scanner.nextLine();
                System.out.println("La salud del atacante: " + attacker.getHealth() + ".");
                System.out.println("La salud del defensor: " + defender.getHealth() + ".");
                writer.write("La salud del atacante: " + attacker.getHealth() + ".\n");
                writer.write("La salud del defensor: " + defender.getHealth() + ".\n");
                System.out.println("Press Enter to continue...");
                input = scanner.nextLine();
            } else if (attacker instanceof Elfo) {
                double danio = ((Elfo) attacker).ataque_elfo(defender);
                System.out.println(attacker.name + " attacks with: " + danio + " points to " + defender.name + ".");
                writer.write(attacker.name + " attacks with: " + danio + " points to " + defender.name + ".\n");
                defender.health_update(danio);
                System.out.println("Press Enter to continue...");
                input = scanner.nextLine();
                System.out.println("La salud del atacante: " + attacker.getHealth() + ".");
                System.out.println("La salud del defensor: " + defender.getHealth() + ".");
                writer.write("La salud del atacante: " + attacker.getHealth() + ".\n");
                writer.write("La salud del defensor: " + defender.getHealth() + ".\n");
                System.out.println("Press Enter to continue...");
                input = scanner.nextLine();
            }

            if (defender.getHealth() < 0) {
                System.out.println("-------------------------------");
                writer.write("-------------------------------\n");
                System.out.println(attacker.name + " won!!! ");
                writer.write(attacker.name + " won!!! \n");
                System.out.println("-------------------------------");
                writer.write("-------------------------------\n");
                if (party_1.contains(defender)) {
                    party_1.remove(defender);
                } else {
                    party_2.remove(defender);
                }
                break;
            } else if (attacker.getHealth() < 0){
                System.out.println("-------------------------------");
                writer.write("-------------------------------\n");
                System.out.println(defender.name + " won!!!");
                writer.write(defender.name + " won!!! \n");
                System.out.println("-------------------------------");
                writer.write("-------------------------------\n");
                if (party_1.contains(attacker)) {
                    party_1.remove(attacker);
                } else {
                    party_2.remove(attacker);
                }
                break;
            }
            if(party_1.size() <= 0) {
                break;
            } else if (party_2.size() <= 0) {
                break;
            }

            i++;

            System.out.println("-------------------------------");
            writer.write("-------------------------------\n");
            System.out.println("Round: " + i);
            writer.write("Round: " + i + "\n");
            System.out.println("-------------------------------");
            writer.write("-------------------------------\n");

            System.out.println(">>> Now " + defender.name + " attacks.");
            writer.write(">>> Now " + defender.name + " attacks.\n");
            System.out.println("<<< " + attacker.name + " will defend.");
            writer.write("<<< " + attacker.name + " will defend. \n");

            if (defender instanceof Humano ) {
                double danio = ((Humano) defender).ataque_humano(attacker);
                System.out.println(defender.name + " attacks with: " + danio + " points to " + attacker.name + ".");
                writer.write(defender.name + " attacks with: " + danio + " points to " + attacker.name + ".\n");
                attacker.health_update(danio);
                System.out.println("Press Enter to continue...");
                input = scanner.nextLine();
                System.out.println("La salud del atacante: " + defender.getHealth() + ".");
                System.out.println("La salud del defensor: " + attacker.getHealth() + ".");
                writer.write("La salud del atacante: " + defender.getHealth() + ".\n");
                writer.write("La salud del defensor: " + attacker.getHealth() + ".\n");
                System.out.println("Press Enter to continue...");
                input = scanner.nextLine();
            } else if (defender instanceof Orco) {
                double danio = ((Orco) defender).ataque_orco(attacker);
                System.out.println(defender.name + " attacks with: " + danio + " points to " + attacker.name + ".");
                writer.write(defender.name + " attacks with: " + danio + " points to " + attacker.name + ".\n");
                attacker.health_update(danio);
                System.out.println("Press Enter to continue...");
                input = scanner.nextLine();
                System.out.println("La salud del atacante: " + defender.getHealth() + ".");
                System.out.println("La salud del defensor: " + attacker.getHealth() + ".");
                writer.write("La salud del atacante: " + defender.getHealth() + ".\n");
                writer.write("La salud del defensor: " + attacker.getHealth() + ".\n");
                System.out.println("Press Enter to continue...");
                input = scanner.nextLine();
            } else if (defender instanceof Elfo) {
                double danio = ((Elfo) defender).ataque_elfo(attacker);
                System.out.println(defender.name + " attacks with: " + danio + " points to " + attacker.name + ".");
                writer.write(defender.name + " attacks with: " + danio + " points to " + attacker.name + ".\n");
                attacker.health_update(danio);
                System.out.println("Press Enter to continue...");
                input = scanner.nextLine();
                System.out.println("La salud del atacante: " + defender.getHealth() + ".");
                System.out.println("La salud del defensor: " + attacker.getHealth() + ".");
                writer.write("La salud del atacante: " + defender.getHealth() + ".\n");
                writer.write("La salud del defensor: " + attacker.getHealth() + ".\n");
                System.out.println("Press Enter to continue...");
                input = scanner.nextLine();
            }
            if (defender.getHealth() < 0) {
                System.out.println("-------------------------------");
                writer.write("-------------------------------\n");
                System.out.println(attacker.name + " won!!! ");
                writer.write(attacker.name + " won!!!\n");
                System.out.println("-------------------------------");
                writer.write("-------------------------------\n");
                if (party_1.contains(defender)) {
                    party_1.remove(defender);
                } else {
                    party_2.remove(defender);
                }
                break;
            } else if (attacker.getHealth() < 0){
                System.out.println("-------------------------------");
                writer.write("-------------------------------\n");
                System.out.println(defender.name + " won!!!");
                writer.write(defender.name + " won!!!\n");
                System.out.println("-------------------------------");
                writer.write("-------------------------------\n");
                if (party_1.contains(attacker)) {
                    party_1.remove(attacker);
                } else {
                    party_2.remove(attacker);
                }
                break;
            }
            i++;
            System.out.println("-------------------------------");
            writer.write("-------------------------------\n");

            if(party_1.size() <= 0) {
                break;
            } else if (party_2.size() <= 0) {
                break;
            }
        }
    }

    public static Personaje GenerarPeronsajesAleatorios() {

        Random random = new Random();

        int tipo_select = random.nextInt(3);
        String tipo;

        if (tipo_select == 0) {
            tipo = "Humano";
        } else if (tipo_select == 1) {
            tipo = "Orco";
        } else {
            tipo = "Elfo";
        }

        int str = random.nextInt(5) + 1;
        int dex = random.nextInt(5) + 1;
        int def = random.nextInt(5) + 1;
        int spd = random.nextInt(5) + 1;

        Personaje character_1 = null;

        List<NamesHumano> NombresHumanosList = Arrays.asList(NamesHumano.values());
        Collections.shuffle(NombresHumanosList);
        String nameHumano = String.valueOf(NombresHumanosList.get(0));

        List<NamesOrco> NombresOrcosList = Arrays.asList(NamesOrco.values());
        Collections.shuffle(NombresOrcosList);
        String nameOrco = String.valueOf(NombresOrcosList.get(0));

        List<NamesElfo> NombresElfosList = Arrays.asList(NamesElfo.values());
        Collections.shuffle(NombresElfosList);
        String nameElfo = String.valueOf(NombresElfosList.get(0));

        if (tipo.equals("Humano")) {
            character_1 = new Humano(10, 100, nameHumano , str, dex, def, spd, tipo);
        } else if (tipo.equals("Orco")) {
            character_1 = new Orco (10, 100, nameOrco, str, dex, def, spd, tipo);
        } else {
            character_1 = new Elfo(10, 100, nameElfo, str, dex, def, spd, tipo);
        }

        return character_1;
    }

    public static void MostrarParty(ArrayList<Personaje> party) {
        for (Personaje personajes : party) {
            System.out.println("| " + personajes.name + "  -  " + personajes.tipo + ", lvl: " + personajes.level);
            System.out.println("|    Strength: " + personajes.str + ".");
            System.out.println("|    Dexterity: " + personajes.dex + ".");
            System.out.println("|    Defence: " + personajes.def + ".");
            System.out.println("|    Speed: " + personajes.spd + ".");
            System.out.println("-------------------------------");

        }
    }

}
