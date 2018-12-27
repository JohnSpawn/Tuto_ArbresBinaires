package john.spawn.hellteam.arbre_binaire;

/**
 * Classe de test
 */
public class Main {

    /**
     * Méthode de test principale
     *
     * @param args
     */
    public static void main(String[] args) {
        new Arbre(
                new Arbre(
                        new Arbre(null, 3, null),
                        5,
                        new Arbre(
                                new Arbre(
                                        new Arbre(null, 6, null),
                                        8,
                                        null
                                ),
                                12,
                                new Arbre(null, 13, null)
                        )
                ),
                20,
                new Arbre(
                        new Arbre(null, 21, null),
                        25,
                        new Arbre(null, 28, null)
                )
        );
    }

}
