import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * classe de test destinee a verifier le bon fonctionnement des methodes
 */
public class TestLabyrinthe {

    /**
     * test de getChar pour un mur
     */
    @Test
    public void test0_GetCharMur() throws Exception {
        // preparation des donnees
        Labyrinthe laby = Labyrinthe.chargerLabyrinthe("laby\\laby0.txt");

        // methode testee
        char c = laby.getChar(0, 0);

        // verification
        assertEquals(Labyrinthe.MUR, c, "Le caractere devrait etre un mur (X)");
    }

    /**
     * test de getChar pour le PJ
     */
    @Test
    public void test1_getCharPJ() throws Exception {
        // preparation des donnees
        Labyrinthe laby = Labyrinthe.chargerLabyrinthe("laby\\laby0.txt");

        // methode testee
        char c = laby.getChar(2, 3);

        // verification
        assertEquals(Labyrinthe.PJ, c, "Le caractere devrait etre le personnage (P)");
    }

    /**
     * test de getChar pour la Sortie
     */
    @Test
    public void test2_getCharSortie() throws Exception {
        // preparation des donnees
        Labyrinthe laby = Labyrinthe.chargerLabyrinthe("laby\\laby0.txt");

        // methode testee
        char c = laby.getChar(1, 1);

        // verification
        assertEquals(Labyrinthe.SORTIE, c, "Le caractere devrait etre la sortie (S)");
    }

    /**
     * test de getChar pour le vide
     */
    @Test
    public void test3_getCharVide() throws Exception {
        // preparation des donnees
        Labyrinthe laby = Labyrinthe.chargerLabyrinthe("laby\\laby0.txt");

        // methode testee
        char c = laby.getChar(3, 1);

        // verification
        assertEquals(Labyrinthe.VIDE, c, "Le caractere devrait etre vide (.)");
    }

    /**
     * test de getChar pour un mur quand x est negatif
     */
    @Test
    public void test4_getCharMUR_XNegatif() throws Exception {
        // preparation des donnees
        Labyrinthe laby = Labyrinthe.chargerLabyrinthe("laby\\laby0.txt");

        // methode testee
        char c = laby.getChar(-5, 1);

        // verification
        assertEquals(Labyrinthe.MUR, c, "Le caractere devrait etre un mur (X)");
    }
    /**
     * test de getChar pour un mur quand y est negatif
     */
    @Test
    public void test5_getCharMUR_YNegatif() throws Exception {
        // preparation des donnees
        Labyrinthe laby = Labyrinthe.chargerLabyrinthe("laby\\laby0.txt");

        // methode testee
        char c = laby.getChar(2, -5);

        // verification
        assertEquals(Labyrinthe.MUR, c, "Le caractere devrait etre un mur (X)");
    }

    /**
     * test de getChar pour un mur quand x est plus grand que le nombre de ligne du labyrinthe
     */
    @Test
    public void test6_getCharMUR_XSuperieur() throws Exception {
        // preparation des donnees
        Labyrinthe laby = Labyrinthe.chargerLabyrinthe("laby\\laby0.txt");

        // methode testee
        char c = laby.getChar(12, 1);

        // verification
        assertEquals(Labyrinthe.MUR, c, "Le caractere devrait etre un mur (X)");
    }

    /**
     * test de getChar pour un mur quand x est plus grand que le nombre de ligne du labyrinthe
     */
    @Test
    public void test7_getCharMUR_YSuperieur() throws Exception {
        // preparation des donnees
        Labyrinthe laby = Labyrinthe.chargerLabyrinthe("laby\\laby0.txt");

        // methode testee
        char c = laby.getChar(2, 21);

        // verification
        assertEquals(Labyrinthe.MUR, c, "Le caractere devrait etre un mur (X)");
    }

    /**
     * test de getSuivant pour la direction haut
     */
    @Test
    public void test8_getSuivantHaut() throws Exception {
        // preparation des donnees
        Labyrinthe laby = Labyrinthe.chargerLabyrinthe("laby\\laby0.txt");
        int[] res = new int[]{0, 1};

        // methode testee
        int[] suivant = laby.getSuivant(1, 1, Labyrinthe.HAUT);

        // verification
        assertEquals(res[0], suivant[0], "La coordonnee en x du suivant devrait etre de 0");
        assertEquals(res[1], suivant[1], "La coordonnee en y du suivant devrait etre de 1");
    }

    /**
     * test de getSuivant pour la direction bas
     */
    @Test
    public void test9_getSuivantBas() throws Exception {
        // preparation des donnees
        Labyrinthe laby = Labyrinthe.chargerLabyrinthe("laby\\laby0.txt");
        int[] res = new int[]{2, 1};

        // methode testee
        int[] suivant = laby.getSuivant(1, 1, Labyrinthe.BAS);

        // verification
        assertEquals(res[0], suivant[0], "La coordonnee en x du suivant devrait etre de 2");
        assertEquals(res[1], suivant[1], "La coordonnee en y du suivant devrait etre de 1");
    }

    /**
     * test de getSuivant pour la direction haut
     */
    @Test
    public void test10_getSuivantGauche() throws Exception {
        // preparation des donnees
        Labyrinthe laby = Labyrinthe.chargerLabyrinthe("laby\\laby0.txt");
        int[] res = new int[]{1, 0};

        // methode testee
        int[] suivant = laby.getSuivant(1, 1, Labyrinthe.GAUCHE);

        // verification
        assertEquals(res[0], suivant[0], "La coordonnee en x du suivant devrait etre de 1");
        assertEquals(res[1], suivant[1], "La coordonnee en y du suivant devrait etre de 0");
    }

    /**
     * test de getSuivant pour la direction droite
     */
    @Test
    public void test11_getSuivantDroite() throws Exception {
        // preparation des donnees
        Labyrinthe laby = Labyrinthe.chargerLabyrinthe("laby\\laby0.txt");
        int[] res = new int[]{1, 7};

        // methode testee
        int[] suivant = laby.getSuivant(1, 6, Labyrinthe.DROITE);

        // verification
        assertEquals(res[0], suivant[0], "La coordonnee en x du suivant devrait etre de 1");
        assertEquals(res[1], suivant[1], "La coordonnee en y du suivant devrait etre de 6");
    }

    /**
     * test de getSuivant pour une action inconnue
     */
    @Test
    public void test12_getSuivantActionInconnue() throws Exception {
        // preparation des donnees
        Labyrinthe laby = Labyrinthe.chargerLabyrinthe("laby\\laby0.txt");
        boolean exception = false;

        // methode testee
        try {
            int[] suivant = laby.getSuivant(1, 6, "fsdfsqf");
        } catch (ActionInconnueException e) {
            exception = true;
        }

        // verification
        assertTrue(exception, "Il devrait y avoir une exception de type ActionInconnueException");
    }

    /**
     * test de deplacerPerso pour la direction droite
     */
    @Test
    public void test13_deplacerPersoDroite() throws Exception {
        // preparation des donnees
        Labyrinthe laby = Labyrinthe.chargerLabyrinthe("laby\\laby0.txt");
        int[] res = new int[] {2, 5};

        // methode testee
        laby.deplacerPerso(Labyrinthe.DROITE);

        // verification
        assertEquals(res[0], laby.getPersonnage().getX(),"La coordonnee en x du personnage devrait etre de 2");
        assertEquals(res[1], laby.getPersonnage().getY(),"La coordonnee en y du personnage devrait etre de 5");
    }

    /**
     * test de deplacerPerso pour la direction gauche
     */
    @Test
    public void test14_deplacerPersoGauche() throws Exception {
        // preparation des donnees
        Labyrinthe laby = Labyrinthe.chargerLabyrinthe("laby\\laby0.txt");
        int[] res = new int[] {2, 1};

        // methode testee
        laby.deplacerPerso(Labyrinthe.GAUCHE);

        // verification
        assertEquals(res[0], laby.getPersonnage().getX(),"La coordonnee en x du personnage devrait etre de 2");
        assertEquals(res[1], laby.getPersonnage().getY(),"La coordonnee en y du personnage devrait etre de 1");
    }

    /**
     * test de deplacerPerso pour la direction haut
     */
    @Test
    public void test15_deplacerPersoHaut() throws Exception {
        // preparation des donnees
        Labyrinthe laby = Labyrinthe.chargerLabyrinthe("laby\\laby0.txt");
        int[] res = new int[] {1, 3};

        // methode testee
        laby.deplacerPerso(Labyrinthe.HAUT);

        // verification
        assertEquals(res[0], laby.getPersonnage().getX(),"La coordonnee en x du personnage devrait etre de 1");
        assertEquals(res[1], laby.getPersonnage().getY(),"La coordonnee en y du personnage devrait etre de 3");
    }

    /**
     * test de deplacerPerso pour la direction bas
     */
    @Test
    public void test16_deplacerPersoBas() throws Exception {
        // preparation des donnees
        Labyrinthe laby = Labyrinthe.chargerLabyrinthe("laby\\laby0.txt");
        int[] res = new int[] {3, 3};

        // methode testee
        laby.deplacerPerso(Labyrinthe.BAS);

        // verification
        assertEquals(res[0], laby.getPersonnage().getX(),"La coordonnee en x du personnage devrait etre de 3");
        assertEquals(res[1], laby.getPersonnage().getY(),"La coordonnee en y du personnage devrait etre de 3");
    }

    /**
     * test de deplacerPerso pour une action inconnue
     */
    @Test
    public void test17_deplacerPersoActionInconnue() throws Exception {
        // preparation des donnees
        Labyrinthe laby = Labyrinthe.chargerLabyrinthe("laby\\laby0.txt");
        boolean exception = false;

        // methode testee
        try {
            laby.deplacerPerso("fsdfsqf");
        } catch (ActionInconnueException e) {
            exception = true;
        }

        // verification
        assertTrue(exception, "Il devrait y avoir une exception de type ActionInconnueException");
    }

    /**
     * test du toString
     */
    @Test
    public void test18_toString() throws Exception {
        // preparation des donnees
        Labyrinthe laby = Labyrinthe.chargerLabyrinthe("laby\\laby0.txt");
        String res = "XXXXXXX\nXS....X\nX..P..X\nX.....X\nXXXXXXX\n";

        // methode testee
        String affichage = laby.toString();

        // verification
        assertEquals(res, affichage,"L affichage devrait etre correct");
    }

    /**
     * test etreFini -> Vrai
     */
    @Test
    public void test19_etreFiniVrai() throws Exception {
        // preparation des donnees
        Labyrinthe laby = Labyrinthe.chargerLabyrinthe("laby\\laby0.txt");
        laby.deplacerPerso(Labyrinthe.HAUT);
        laby.deplacerPerso(Labyrinthe.GAUCHE);

        // methode testee
        boolean fini = laby.etreFini();

        // verification
        assertTrue(fini,"Le jeu devrait etre fini");
    }

    /**
     * test etreFini -> Faux
     */
    @Test
    public void test20_etreFiniFaux() throws Exception {
        // preparation des donnees
        Labyrinthe laby = Labyrinthe.chargerLabyrinthe("laby\\laby0.txt");

        // methode testee
        boolean fini = laby.etreFini();

        // verification
        assertTrue(!fini,"Le jeu ne devrait pas etre fini");
    }

    /**
     * test chargerLabyrinthe OK
     */
    @Test
    public void test21_chargerLabyrintheOK() throws Exception {
        // methode testee
        Labyrinthe laby = Labyrinthe.chargerLabyrinthe("laby\\laby0.txt");

        // verification
        assertEquals(5, laby.getNbLignes(),"Le nombre de lignes du labyrinthe devrait etre de 5");
        assertEquals(7, laby.getNbColonnes(),"Le nombre de colonnes du labyrinthe devrait etre de 7");

        assertEquals(2, laby.getPersonnage().getX(),"La coordonnee en x du personnage devrait etre de 2");
        assertEquals(3, laby.getPersonnage().getY(),"La coordonnee en  du personnage devrait etre de 3");

        assertEquals(1, laby.getSortie().getX(),"La coordonnee en x de la sortie devrait etre de 1");
        assertEquals(1, laby.getSortie().getY(),"La coordonnee en x de la sortie devrait etre de 1");
    }

    /**
     * test chargerLabyrinthe avec un nombre de ligne incorrect
     */
    @Test
    public void test22_chargerLabyrinthe_nbLignesIncorrect() throws Exception {
        // preparation des donnees
        boolean exception = false;
        String message = "";
        String res = "nbLignes ne correspond pas";

        // methode testee
        try {
            Labyrinthe laby = Labyrinthe.chargerLabyrinthe("laby\\labyNbLignesIncorrect.txt");
        } catch (FichierIncorrectException e) {
            exception = true;
            message = e.getMessage();
        }

        // verification
        assertTrue(exception, "Il devrait y avoir une erreur dans le chargement du labyrinthe");
        assertEquals(res, message, "Le message d'exception devrait etre correct");
    }

    /**
     * test chargerLabyrinthe avec un nombre de colonne incorrect
     */
    @Test
    public void test23_chargerLabyrinthe_nbColonnesIncorrect() throws Exception {
        // preparation des donnees
        boolean exception = false;
        String message = "";
        String res = "nbColonnes ne correspond pas";

        // methode testee
        try {
            Labyrinthe laby = Labyrinthe.chargerLabyrinthe("laby\\labyNbColonnesIncorrect.txt");
        } catch (FichierIncorrectException e) {
            exception = true;
            message = e.getMessage();
        }

        // verification
        assertTrue(exception, "Il devrait y avoir une erreur dans le chargement du labyrinthe");
        assertEquals(res, message, "Le message d'exception devrait etre correct");
    }

    /**
     * test chargerLabyrinthe avec un format des nombres de ligne incorrect
     */
    @Test
    public void test24_chargerLabyrinthe_LignesFormatIncorrect() throws Exception {
        // preparation des donnees
        boolean exception = false;
        String message = "";
        String res = "pb num ligne ou colonne";

        // methode testee
        try {
            Labyrinthe laby = Labyrinthe.chargerLabyrinthe("laby\\labyLignesFormatIncorrect.txt");
        } catch (FichierIncorrectException e) {
            exception = true;
            message = e.getMessage();
        }

        // verification
        assertTrue(exception, "Il devrait y avoir une erreur dans le chargement du labyrinthe");
        assertEquals(res, message, "Le message d'exception devrait etre correct");
    }

    /**
     * test chargerLabyrinthe avec un format des nombres de colonne incorrect
     */
    @Test
    public void test25_chargerLabyrinthe_ColonnesFormatIncorrect() throws Exception {
        // preparation des donnees
        boolean exception = false;
        String message = "";
        String res = "pb num ligne ou colonne";

        // methode testee
        try {
            Labyrinthe laby = Labyrinthe.chargerLabyrinthe("laby\\labyColonnesFormatIncorrect.txt");
        } catch (FichierIncorrectException e) {
            exception = true;
            message = e.getMessage();
        }

        // verification
        assertTrue(exception, "Il devrait y avoir une erreur dans le chargement du labyrinthe");
        assertEquals(res, message, "Le message d'exception devrait etre correct");
    }

    /**
     * test chargerLabyrinthe avec un caractere inconnu dans le labyrinthe
     */
    @Test
    public void test26_chargerLabyrinthe_CaractereInconnu() throws Exception {
        // preparation des donnees
        boolean exception = false;
        String message = "";
        String res = "caractere inconnu <D>";

        // methode testee
        try {
            Labyrinthe laby = Labyrinthe.chargerLabyrinthe("laby\\labyCaractereInconnu.txt");
        } catch (FichierIncorrectException e) {
            exception = true;
            message = e.getMessage();
        }

        // verification
        assertTrue(exception, "Il devrait y avoir une erreur dans le chargement du labyrinthe");
        assertEquals(res, message, "Le message d'exception devrait etre correct");
    }

    /**
     * test chargerLabyrinthe avec aucune sortie
     */
    @Test
    public void test27_chargerLabyrinthe_pasSortie() throws Exception {
        // preparation des donnees
        boolean exception = false;
        String message = "";
        String res = "sortie inconnue";

        // methode testee
        try {
            Labyrinthe laby = Labyrinthe.chargerLabyrinthe("laby\\laby_pasSortie.txt");
        } catch (FichierIncorrectException e) {
            exception = true;
            message = e.getMessage();
        }

        // verification
        assertTrue(exception, "Il devrait y avoir une erreur dans le chargement du labyrinthe");
        assertEquals(res, message, "Le message d'exception devrait etre correct");
    }

    /**
     * test chargerLabyrinthe avec deux sorties (ou plus)
     */
    @Test
    public void test28_chargerLabyrinthe_deuxSortie() throws Exception {
        // preparation des donnees
        boolean exception = false;
        String message = "";
        String res = "plusieurs sorties";

        // methode testee
        try {
            Labyrinthe laby = Labyrinthe.chargerLabyrinthe("laby\\laby_deuxSortie.txt");
        } catch (FichierIncorrectException e) {
            exception = true;
            message = e.getMessage();
        }

        // verification
        assertTrue(exception, "Il devrait y avoir une erreur dans le chargement du labyrinthe");
        assertEquals(res, message, "Le message d'exception devrait etre correct");
    }

    /**
     * test chargerLabyrinthe avec aucun personnage
     */
    @Test
    public void test29_chargerLabyrinthe_pasPJ() throws Exception {
        // preparation des donnees
        boolean exception = false;
        String message = "";
        String res = "personnage inconnu";

        // methode testee
        try {
            Labyrinthe laby = Labyrinthe.chargerLabyrinthe("laby\\laby_pasPJ.txt");
        } catch (FichierIncorrectException e) {
            exception = true;
            message = e.getMessage();
        }

        // verification
        assertTrue(exception, "Il devrait y avoir une erreur dans le chargement du labyrinthe");
        assertEquals(res, message, "Le message d'exception devrait etre correct");
    }

    /**
     * test chargerLabyrinthe avec deux personnages (ou plus)
     */
    @Test
    public void test30_chargerLabyrinthe_deuxPJ() throws Exception {
        // preparation des donnees
        boolean exception = false;
        String message = "";
        String res = "plusieurs personnages";

        // methode testee
        try {
            Labyrinthe laby = Labyrinthe.chargerLabyrinthe("laby\\laby_deuxPJ.txt");
        } catch (FichierIncorrectException e) {
            exception = true;
            message = e.getMessage();
        }

        // verification
        assertTrue(exception, "Il devrait y avoir une erreur dans le chargement du labyrinthe");
        assertEquals(res, message, "Le message d'exception devrait etre correct");
    }
}
