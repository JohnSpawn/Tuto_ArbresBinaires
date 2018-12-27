package john.spawn.hellteam.arbre_binaire;

/**
 * Tutoriel sur les arbres binaires
 * source: http://gallium.inria.fr/~maranget/X/421/poly/arbre-bin.html
 */
class Arbre {

    private int contenu;
    private Arbre arbreDroit;
    private Arbre arbreGauche;

    /**
     * Arbre formé d'un noeud composé de son arbre droit, son arbre gauche et sa racine
     *
     * @param arbreDroit  Arbre droit fils de l'arbre parent
     * @param contenu     Contenu del'arbre parent
     * @param arbreGauche Arbre gauche fils de l'arbre parent
     */
    Arbre(Arbre arbreDroit, int contenu, Arbre arbreGauche) {
        this.arbreDroit = arbreDroit;
        this.contenu = contenu;
        this.arbreGauche = arbreGauche;
    }

    /**
     * Compose un nouvel arbre
     *
     * @param arbreGauche Arbre gauche de l'arbre parent
     * @param contenu     Contenu de l'arbre parent
     * @param arbreDroit  Arbre droit de l'arbre parent
     * @return Arbre composé de son arbre gauche, arbre droit et contenu
     */
    static Arbre composer(Arbre arbreGauche, int contenu, Arbre arbreDroit) {
        return new Arbre(arbreGauche, contenu, arbreDroit);
    }

    /**
     * Récupère la taille de l'arbre
     *
     * @param arbre Arbre parent
     * @return Taille de l'arbre
     */
    static int getTaille(Arbre arbre) {
        if (arbre == null) {
            return 0;
        }
        return 1 + getTaille(arbre.getArbreGauche()) + getTaille(arbre.getArbreDroit());
    }

    /**
     * Parcours de l'arbre côté droit
     *
     * @param arbre Arbre parent
     */
    static void parcoursPrefix(Arbre arbre) {
        if (arbre != null) {
            System.out.println(arbre.getContenu() + " ");
            parcoursPrefix(arbre.getArbreGauche());
            parcoursPrefix(arbre.getArbreDroit());
        }
    }

    /**
     * Parcours de l'arbre milieu
     *
     * @param arbre Arbre parent
     */
    static void parcoursInfix(Arbre arbre) {
        if (arbre != null) {
            parcoursInfix(arbre.getArbreGauche());
            System.out.println(arbre.getContenu());
            parcoursInfix(arbre.getArbreDroit());
        }
    }

    /**
     * Parcours de l'arbre gauche
     *
     * @param arbre Arbre parent
     */
    static void parcoursSuffixe(Arbre arbre) {
        if (arbre != null) {
            parcoursSuffixe(arbre.getArbreGauche());
            parcoursSuffixe(arbre.getArbreDroit());
            System.out.println(arbre.getContenu() + " ");
        }
    }

    /**
     * Recherche d'un élément dans l'arbre
     *
     * @param x     Element a rechercher
     * @param arbre Arbre parent
     * @return Position de l'élément
     */
    static Arbre chercher(int x, Arbre arbre) {
        if (arbre == null || x == arbre.getContenu()) {
            return arbre;
        }
        if (x < arbre.getContenu()) {
            return chercher(x, arbre.getArbreGauche());
        }
        return arbre.getArbreDroit();
    }

    /**
     * Insertion d'une nouvelle clé
     *
     * @param x     Element à insérer
     * @param arbre Arrbe parent
     * @return Nouvel arbre formé
     */
    static Arbre inserer(int x, Arbre arbre) {
        if (arbre == null) {
            return new Arbre(null, x, null);
        }
        if (x < arbre.getContenu()) {
            Arbre arbreb = inserer(x, arbre.getArbreGauche());
            return new Arbre(arbreb, arbre.getContenu(), arbre.getArbreDroit());
        } else if (x > arbre.getContenu()) {
            Arbre arbreb = inserer(x, arbre.getArbreDroit());
            return new Arbre(arbre.getArbreGauche(), arbre.getContenu(), arbreb);
        }
        return arbre;
    }

    /**
     * Suppression d'une clé
     *
     * @param x     Clé à supprimer
     * @param arbre Arbre parent
     * @return Nouvel arbre formé
     */
    static Arbre supprimer(int x, Arbre arbre) {
        if (arbre == null) {
            return arbre;
        }
        if (x == arbre.getContenu()) {
            return supprimerRacine(arbre);
        }
        if (x < arbre.getContenu()) {
            arbre.setArbreGauche(supprimer(x, arbre.getArbreGauche()));
        } else {
            arbre.setArbreDroit(supprimer(x, arbre.getArbreDroit()));
        }
        return arbre;
    }

    /**
     * Suppression de la racine de l'arbre
     *
     * @param arbre Arbre parent
     * @return Nouvel arbre formé
     */
    static Arbre supprimerRacine(Arbre arbre) {
        if (arbre.getArbreGauche() == null) {
            return arbre.getArbreDroit();
        }
        if (arbre.getArbreDroit() == null) {
            return arbre.getArbreGauche();
        }
        Arbre dernierDescendant = dernierDescendant(arbre.getArbreGauche());
        arbre.setContenu(dernierDescendant.getContenu());
        arbre.setArbreGauche(supprimer(dernierDescendant.getContenu(), arbre.getArbreGauche()));
        return arbre;
    }

    /**
     * Calcul du dernier descendant de l'arbre
     *
     * @param arbre Arbre parent
     * @return Dernier descendant de l'arbre
     */
    static Arbre dernierDescendant(Arbre arbre) {
        if (arbre.getArbreDroit() == null) {
            return arbre;
        }
        return dernierDescendant(arbre.getArbreDroit());
    }

    int getContenu() {
        return contenu;
    }

    void setContenu(int contenu) {
        this.contenu = contenu;
    }

    Arbre getArbreDroit() {
        return arbreDroit;
    }

    void setArbreDroit(Arbre arbreDroit) {
        this.arbreDroit = arbreDroit;
    }

    Arbre getArbreGauche() {
        return arbreGauche;
    }

    void setArbreGauche(Arbre arbreGauche) {
        this.arbreGauche = arbreGauche;
    }
}
