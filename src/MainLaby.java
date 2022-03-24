import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MainLaby {

    public static void main(String[] args) {
        if (args.length > 1){
            System.out.println("Nombre d'argument invalide.");
        } else {
            Labyrinthe laby;
            try {
                laby = Labyrinthe.chargerLabyrinthe(args[0]);
                boolean exit = false;
                Scanner sc = new Scanner(System.in);

                System.out.println(laby);

                while (!laby.etreFini() && !exit){

                    System.out.println("Choisissez une direction (haut, bas, gauche, droite : ");
                    String action = sc.nextLine();

                    if (action.equals("exit")) {
                        exit = true;
                        System.out.println("Vous quittez le jeu");
                    } else {

                        try {
                            laby.deplacerPerso(action);
                            System.out.println(laby);
                        } catch (ActionInconnueException a){
                            System.out.println(a.getMessage());
                        }

                    }
                }

                if (laby.etreFini()) {
                    System.out.println("Vous avez gagné");
                }

            } catch (FileNotFoundException f) {
                System.out.println("Fichier inexistant");
            } catch (FichierIncorrectException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println("Erreur lors du chargement des données");
            }
        }
    }
}
