/**
 * classe Position representant la position de la sortie et du personnage
 */
public class Position {

    /**
     * attributs privées représentant la position
     */
    private int x;
    private int y;

    /**
     * constructeur qui initialise la position
     *
     * @param px numéro de ligne
     * @param py numéro de colonne
     */
    public Position(int px, int py) {
        this.x = px;
        this.y = py;
    }

    /**
     * @return numéro de ligne
     */
    public int getX() {
        return this.x;
    }

    /**
     * @return numéro de ligne
     */
    public int getY() {
        return this.y;
    }
}
