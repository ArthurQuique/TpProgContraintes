package tnsi.tp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CSP {
    private List<Summit> summits;
    private List<Link> links;

    private int nbV = 4; //Nombre de variables
    private int taille = 5; //Taille du domaine
    private double densite = 1; //Densité du csp
    private double durete = 1; //Dureté des contraintes

    /**
     * Création du CSP
     */
    public CSP() {
        this.summits = new ArrayList<>();
        List<int[]> constraints = new ArrayList<>();
        for (int i = 0; i < this.nbV; i++) {
            this.summits.add(new Summit(i + 1, this.taille));
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
            this.links.add(new Link(j + 1, constraints.get(constInd)[0], constraints.get(constInd)[1]));
            constraints.remove(constInd);
            System.out.println(this.links.get(j).toString());
        }
    }

/*
    public void backjumping(int ancI){
        //calculer anc(Vi) pour chaque variable Vi
        Boolean OK;
        int i = 1;
        int dMin = this.summits.get(i).getMin();
        int dMax = this.summits.get(i).getMax();
        //Ii <- anc(Vi)         ???
        while (1 <= i && i <= this.summits.size()){
            int x = dMin + (int)(Math.random() * (dMax - dMin +1));
            OK = false;
            while(OK == false && (dMax-dMin) != 0) {
                x = dMin + (int)(Math.random() * (dMax - dMin +1));
                dMax = dMax - x;
                if(){
                    OK = true;
                }
            }
            if (OK != false){
                backjumping(); //(csp, ???)
                //iprev <- i ; i <- le plus haut dans Ii ; Ii <- Ii u iprev - {Vi}
            }
            else {
                //i <- i + 1; Di* <- i D ; Ii <- anc(Vi)
            }
            if(i == 0)
                System.out.println("Pas de solution.");
            else
                System.out.println(this.summits);
        }
    }
*/
/*
    public void forwardChecking() {

        int i = 1;
        int[] domain = domain(this.summits.get(0));
        List<Integer> newDomain = Arrays.stream(domain).boxed().collect(Collectors.toList());
        while (1 <= i && i <= this.nbV) {
            boolean ok = false;
            while(!ok && newDomain.size() > 0) {
                this.summits.get(i-1).affectToValue();
                this.summits.get(i-1).remove();
                boolean emptyDomain = false;
                for(int k = i; k <= this.nbV; k++) {
                    revise(k,i);
                    if(this.summits.get(k-1).getDomain().size() == 0) emptyDomain = true;
                }
                if(emptyDomain) {
                    for(int k = i; k <= this.nbV; k++) {
                        this.summits.get(k-1).setDomain(Arrays.stream(domain).boxed().collect(Collectors.toList()));
                    }
                }
                else ok = true;
            }
            if(!ok) {
                this.summits.get(i - 1).setDomain(Arrays.stream(domain).boxed().collect(Collectors.toList()));
                this.summits.get(i - 1).setValue(0);
                i--;
            }
            else {
                i++;
            }
        }
        if (i==0) System.out.println("Résultat non trouvé");
        System.out.println(this.summits);
    }

    public void revise(int m, int n) {
        Link linkToWatch = null;
        for(Link l : this.links) {
            if(l.getSummit1() == n && l.getSummit2() == m) {
                linkToWatch = l;
            }
        }
        if(linkToWatch != null) {
            for(int i = 1; i <= this.summits.get(m-1).getMax(); i++) {
                this.summits.get(m-1).affectToValue();
                if(!linkToWatch.constraintRespected(summits)) {
                    this.summits.get(m-1).remove();
                }
            }
        }
    }*/

    /**
     * Regarde si toutes les contraintes sont respectées
     *
     * @return booléen
     */
    public boolean watchConstraints() {
        boolean result = true;
        for (Link l : this.links) {
            if (!l.constraintRespected(this.summits)) {
                result = false;
            }
        }
        return result;
    }

    public void backtracking() {
        int i = 1;
        int[] domain = domain(this.summits.get(0));
        while (1 <= i && i <= nbV) {
            boolean ok = false;
            if (this.summits.get(i - 1).getDomain().size() > 0) {
                this.summits.get(i - 1).affectToValue();
                while (!ok && this.summits.get(i - 1).getDomain().size() > 0) {
                    if (watchConstraints()) {
                        ok = true;
                        this.summits.get(i - 1).remove();
                    } else {
                        this.summits.get(i - 1).remove();
                        if (this.summits.get(i - 1).getDomain().size() > 0) this.summits.get(i - 1).affectToValue();
                    }
                }
            }
            if (!ok) {
                this.summits.get(i - 1).setDomain(Arrays.stream(domain).boxed().collect(Collectors.toList()));
                this.summits.get(i - 1).setValue(0);
                i--;
            } else {
                i++;
            }
        }
        if (i == 0) {
            System.out.println("Non solvable.");
        } else {
            System.out.println("Résultat trouvé !\n" + this.summits);
        }
    }

    public int[] domain(Summit summit) {
        int[] domain = new int[summit.getMax() - summit.getMin() + 1];
        int ind = 0;
        for (int i = summit.getMin(); i <= summit.getMax(); i++) {
            domain[ind] = i;
            ind++;
        }
        return domain;
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