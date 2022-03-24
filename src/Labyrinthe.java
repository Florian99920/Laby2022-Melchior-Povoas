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

    /**
     * @param x numéro de ligne
     * @param y numéro de colonne
     * @return le caractere correspond aux coordonnes x et y
     */
    char getChar(int x, int y) {
        if (murs[x][y] == true) {
            return MUR;
        } else if ((this.personnage.getX() == x) && (this.personnage.getY() == y)){
            return PJ;
        } else if ((this.sortie.getX() == x) && (this.sortie.getY() == y)) {
            return SORTIE;
        } else{
            return VIDE;
        }
    }


    /**
     * methode qui retorune les coordonnees de la case voisine en fonction de la direction
     *
     * @param x ligne de la case d origine
     * @param y colonne de la case d origine
     * @param action direction dont on veut connaitre les coordonnees
     * @return coordonnees de la case voisine
     * @throws ActionInconnueException exception representant une action non valide
     */
    static int[] getSuivant(int x, int y, String action) throws ActionInconnueException {

        int res[] = new int[2];

        switch (action) {
            case HAUT:
                res[1] = x-1;
                res[2] = y;
                break;
            case BAS:
                res[1] = x+1;
                res[2] = y;
                break;
            case GAUCHE:
                res[1] = x;
                res[2] = y-1;
                break;
            case DROITE:
                res[1] = x;
                res[2] = y+1;
                break;
            default:
                throw new ActionInconnueException("L'action " + action + " n'est pas une action valable.");
        }

        return res;
    }


    /**
     * Methode consistant a deplacer le personnage tant qu'il ne rencontre pas de mur
     * @param action action a realiser
     * @throws ActionInconnueException action inconnue
     */
    void deplacerPerso(String action) throws ActionInconnueException{
        int res[] = this.getSuivant(this.personnage.getX(), this.personnage.getY(), action);
        while (getChar(res[1], res[2]) != MUR) {
            this.personnage.setX(res[1]);
            this.personnage.setY(res[2]);
        }
    }


    /**
     * @return l'affichage du labyrinthe
     */
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < murs.length; i++) {
            for (int j = 0; j < murs[i].length; j++) {
                res.append(this.getChar(i, j));
            }
            res.append("\n");
        }
        return res.toString();
    }


    /**
     * @return vrai si la partie est fini, non sinon
     */
    public boolean etreFini() {
        return ((this.personnage.getX() == this.sortie.getX()) && (this.personnage.getY() == this.sortie.getY()));
    }

    public static Labyrinthe chargerLabyrinthe(String nom) {
        throw new Error("TODO");
    }

}
