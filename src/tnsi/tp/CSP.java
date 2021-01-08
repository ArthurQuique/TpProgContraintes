package tnsi.tp;

import java.util.ArrayList;
import java.util.List;

public class CSP {
    private List<Summit> summits;
    private List<Link> links;

    private int nbV = 4;
    private int taille = 5;
    private double densite = 1;
    private double durete = 1;


    public CSP() {
        this.summits = new ArrayList<>();
        for (int i = 0; i < this.nbV; i++) {
            this.summits.add(new Summit(i+1, this.taille));
        }
        int nbLinks = (int) (Math.ceil((this.nbV * (this.nbV - 1)) / 2 * this.densite));
        this.links = new ArrayList<>();
        for (int j = 0; j < nbLinks; j++) {
            this.links.add(new Link(j+1, this.summits));
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

