import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainLaby {

    public static void main(String[] args) {
        if (args.length > 1){
            System.out.println("Nombre d'argument invalide.");
        } else {
            Labyrinthe laby;
            try {
                laby = Labyrinthe.chargerLabyrinthe(args[1]);
            } catch (FileNotFoundException f){
                System.out.println("Fichier inexistant");
            }
            while (!laby.etreFini()){
                System.out.println(laby);
                Scanner sc = new Scanner(System.in);
                System.out.println("Choisissez une direction (haut, bas, gauche, droite : ");
                String action = sc.nextLine();
                try {
                    laby.deplacerPerso(action);
                } catch (ActionInconnueException a){
                    System.out.println("Direction inconnu, reessayer :");
                    action = sc.nextLine();
                }
            }
        }
    }
}
