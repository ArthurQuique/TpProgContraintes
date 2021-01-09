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
    private double densite = 0.5; //Densité du csp
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
    public void backjumping(CSP csp, int ancI){
        //calculer anc(Vi) pour chaque variable Vi
        Boolean OK;
        int i = 1;
        int dMin = csp.summits.get(i).getMin();
        int dMax = csp.summits.get(i).getMax();
        //Ii <- anc(Vi)         ???
        while (1 <= i && i <= csp.summits.size()){
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
                backjumping(csp); //(csp, ???)
                //iprev <- i ; i <- le plus haut dans Ii ; Ii <- Ii u iprev - {Vi}
            }
            else {
                //i <- i + 1; Di* <- i D ; Ii <- anc(Vi)
            }
            if(i == 0)
                return UNSAT; ?? //Absence de solution ; null ? -1 ?
            else
                return assignation courante; ?? //Solution ; i ?
        }
    }*/

    /*
   public void forwardChecking(CSP csp){
       List<Summit> dom = csp.getSummits();
       int i = 1;

       int n = dom.size();
       boolean emptyDomain = false;
       boolean ok;
       while (1 <= i && i <= dom.size()){
           int dMax = dom.get(i).getMax();
           int dMin = dom.get(i).getMin();
           List<Integer> domain = dom.get(i).getDomain();
           List<Integer> domainSave = domain;
           ok = false;

           while (!ok && domain.size() != 0){
               int x = dMin + (int)(Math.random() * (dMax - dMin +1));
               domainSave = domain;
               while(domain.contains(x))
                   domain.remove(x);
               for(int k = i+1; k<=n; k++){
                   revise(k,i,csp);
                   if(dom.get(k) == null) emptyDomain = true;
               }
               if (emptyDomain) domain = domainSave;
               else ok = true;
           }
           if(!ok){
               domain = domainSave;
               i--;
           }
           else i++;
       }
       System.out.println(this.summits);
   }

    public void revise(int m, int n, CSP csp){
       int a;
       int b = 0;
        for(a = m; a <= n;a++){
            if(///){

                System.out.println("Le problème est inconsistant.");
            }
            b++;
        }
    }
*/

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