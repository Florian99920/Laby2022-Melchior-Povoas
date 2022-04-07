import java.io.*;

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
     * nombre de lignes du labyrinthe
     */
    private int nbLignes;

    /**
     * nombre de colonnes du labyrinthe
     */
    private int nbColonnes;


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
    public static final char MUR  = 'X';
    public static final char PJ  = 'P';
    public static final char SORTIE  = 'S';
    public static final char VIDE  = '.';

    /**
     * Represente les actions du joueur
     * haut pour HAUT
     * bas pour BAS
     * gauche pour GAUCHE
     * droite pour DROITE
     */
    public static final String HAUT  = "haut";
    public static final String BAS  = "bas";
    public static final String GAUCHE  = "gauche";
    public static final String DROITE  = "droite";

    /**
     * @param x numéro de ligne
     * @param y numéro de colonne
     * @return le caractere correspond aux coordonnes x et y
     */
    char getChar(int x, int y) {
        if (x < 0 || y < 0 || x >= this.nbLignes || y >= this.nbColonnes) {
            return MUR;
        } else if (this.murs[x][y]) {
            return MUR;
        } else if ((this.personnage.getX() == x) && (this.personnage.getY() == y)){
            return PJ;
        } else if ((this.sortie.getX() == x) && (this.sortie.getY() == y)) {
            return SORTIE;
        } else {
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

        int[] res = new int[2];

        switch (action) {
            case HAUT:
                res[0] = x-1;
                res[1] = y;
                break;
            case BAS:
                res[0] = x+1;
                res[1] = y;
                break;
            case GAUCHE:
                res[0] = x;
                res[1] = y-1;
                break;
            case DROITE:
                res[0] = x;
                res[1] = y+1;
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
        int[] res = this.getSuivant(this.personnage.getX(), this.personnage.getY(), action);
        while (this.getChar(res[0], res[1]) != MUR) {
            this.personnage.setX(res[0]);
            this.personnage.setY(res[1]);
            res = this.getSuivant(this.personnage.getX(), this.personnage.getY(), action);
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

    /**
     * @param nom nom du fichier servant à charger le labyrinthe
     * @return Le labyrinthe chargé
     * @throws FileNotFoundException fichier absent ou inexistant
     * @throws IOException erreur lors de la récupération des données
     * @throws NumberFormatException erreur lors de la conversion String en int
     * @throws FichierIncorrectException erreur lors du chargement du labyrinthe
     */
    public static Labyrinthe chargerLabyrinthe(String nom) throws FileNotFoundException,IOException, FichierIncorrectException {

        // initialisation de plusieurs variables
        Labyrinthe laby = new Labyrinthe();
        BufferedReader entree = new BufferedReader(new FileReader(nom));

        try {
            laby.nbLignes = Integer.parseInt(entree.readLine());
            laby.nbColonnes = Integer.parseInt(entree.readLine());
        } catch (NumberFormatException e) {
            throw new FichierIncorrectException("pb num ligne ou colonne");
        }

        laby.murs = new boolean[laby.nbLignes][laby.nbColonnes];

        boolean persoPresent = false;
        boolean sortiePresente = false;
        int testLigne = 0;

        String temp = entree.readLine();

        // tant qu'on atteint pas la fin du fichier
        while (temp != null) {

            // si la ligne n'est pas vide
            if (!temp.isEmpty()) {

                // on ajoute 1 au nombre de ligne lu
                testLigne++;

                // si le nombre de ligne lu est superieur au nombre de ligne du labyrinthe
                if (testLigne > laby.nbLignes) {
                    // alors on envoie l exception que le nombre de ligne ne correspond pas
                    throw new FichierIncorrectException("nbLignes ne correspond pas");

                } else {
                    // si la ligne ne possede pas le meme nombre de caractere que le labyrinthe
                    if (temp.length() != laby.nbColonnes) {
                        //alors on envoie l exception que le nombre de colonnes ne correspond pas
                        throw new FichierIncorrectException("nbColonnes ne correspond pas");

                    } else {

                        // on parcourt les differents caracteres de la ligne
                        for (int i = 0; i < laby.nbColonnes; i++) {
                            char caractere = temp.charAt(i);

                            // switch permettant de determiner la nature du caractere
                            switch (caractere) {
                                case MUR:

                                    laby.murs[testLigne - 1][i] = true;
                                    break;

                                case PJ:

                                    // si un personnage est deja present
                                    if (persoPresent) {
                                        // alors il y a plusieurs personnages
                                        throw new FichierIncorrectException("plusieurs personnages");
                                    } else {
                                        laby.personnage = new Personnage(testLigne - 1, i);
                                        persoPresent = true;
                                    }
                                    break;

                                case SORTIE:

                                    // si la sortie est deja presente
                                    if (sortiePresente) {
                                        // alors il y a plusieurs sortie
                                        throw new FichierIncorrectException("plusieurs sorties");
                                    } else {
                                        laby.sortie = new Sortie(testLigne - 1, i);
                                        sortiePresente = true;
                                    }
                                    break;

                                case VIDE:
                                    break;

                                // si le caractere est inconnu
                                default:
                                    throw new FichierIncorrectException("caractere inconnu <" + caractere + ">");
                            }
                        }
                    }
                }
            }

            // on lit la prochaine ligne
            temp = entree.readLine();

        }

        // si aucun personnage n'est present
        if (!persoPresent) {

            throw new FichierIncorrectException("personnage inconnu");

        // si aucune sortie n'est presente
        } else if (!sortiePresente) {
            throw new FichierIncorrectException("sortie inconnue");
        }

        return laby;

    }

    /**
     * @return le personnage
     */
    public Personnage getPersonnage() {
        return this.personnage;
    }

    /**
     * @return la sortie
     */
    public Sortie getSortie() {
        return this.sortie;
    }

    /**
     * @return nombre de lignes du labyrinthe
     */
    public int getNbLignes() {
        return this.nbLignes;
    }

    /**
     * @return nombre de colonnes du labyrinthe
     */
    public int getNbColonnes() {
        return this.nbColonnes;
    }
}
