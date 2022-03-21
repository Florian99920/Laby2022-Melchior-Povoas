/** 
 * Squelette de classe labyrinthe
 */
class Labyrinthe{

    /**
     * tableau deux dimensions de booleens
     * stockant les murs du labyrinthe
     */
    private boolean[][] murs;

    /**
     * Represente les coordonnees du personnage
     */
    private Personnage personnage;

    /**
     * Represente les coordonnees de la sortie
     */
    private Sortie sortie;

    /**
     * Represente l'affichage du labyrinthe
     * X pour les MUR
     * P pour le Personnage
     * S pour la SORTIE
     * . pour une case VIDE
     */
    private static final char MUR  = 'X';
    private static final char PJ  = 'P';
    private static final char SORTIE  = 'S';
    private static final char VIDE  = '.';

    /**
     * Represente les actions du joueur
     * haut pour HAUT
     * bas pour BAS
     * gauche pour GAUCHE
     * droite pour DROITE
     */
    private static final String HAUT  = "haut";
    private static final String BAS  = "bas";
    private static final String GAUCHE  = "gauche";
    private static final String DROITE  = "droite";

    char getChar(int x, int y) {
        throw new Error("TODO");
    }


    static int[] getSuivant(int x, int y, String action) {
        throw new Error("TODO");
    }


    void deplacerPerso(String action) throws ActionInconnueException {
        throw new Error("TODO");
    }


    public String toString() {
        throw new Error("TODO");
    }


    public boolean etreFini() {
        throw new Error("TODO");
    }

    public static Labyrinthe chargerLabyrinthe(String nom) {
        throw new Error("TODO");
    }

}
