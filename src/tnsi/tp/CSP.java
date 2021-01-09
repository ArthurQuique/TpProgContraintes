package tnsi.tp;

import java.util.ArrayList;
import java.util.List;

public class CSP {
    private List<Summit> summits;
    private List<Link> links;

    private int nbV = 4; //Nombre de variables
    private int taille = 5; //Taille du domaine
    private double densite = 0.5; //Densité du csp
    private double durete = 1; //Dureté des contraintes

    /**
     * Création du CSP
     */
    public CSP() {
        this.summits = new ArrayList<>();
        List<int[]> constraints = new ArrayList<>();
        for (int i = 0; i < this.nbV; i++) {
            this.summits.add(new Summit(i+1, this.taille));
            for (int j = i + 1; j < this.nbV; j++) {
                int[] constraint = {i + 1, j + 1};
                constraints.add(constraint);
            }
            System.out.println(this.summits.get(i));
        }
        int nbLinks = (int) (Math.ceil(((float) this.nbV * (this.nbV - 1)) / 2 * this.densite));
        this.links = new ArrayList<>();
        for (int j = 0; j < nbLinks; j++) {
            int constInd = (int) (Math.random() * constraints.size());
            this.links.add(new Link(j+1, constraints.get(constInd)[0], constraints.get(constInd)[1]));
            constraints.remove(constInd);
            System.out.println(this.links.get(j).toString());
        }
    }

    public List<Summit> getSummits() {
        return summits;
    }

    public void setSummits(List<Summit> summits) {
        this.summits = summits;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
}

