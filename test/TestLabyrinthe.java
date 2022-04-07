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
        int[] res = new int[]{1, 4};
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
}
