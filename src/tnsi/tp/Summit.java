package tnsi.tp;

import java.util.ArrayList;
import java.util.List;

public class Summit {
    private int id;
    private int value;       //Valeur de l'objet
    private int min;         //Borne inférieure du domaine de définition
    private int max;         //Borne supérieure du domaine de définition
    private List<Integer> domain; // Domaine de définition

    public Summit(int id, int taille) {
        this.id = id;
        this.min = 1;
        this.max = taille;
        this.value = 0;
        this.domain = new ArrayList<>();
        for (int i = this.min; i <= this.max; i++) {
            this.domain.add(i);
        }
    }

    public void affectToValue() {
        this.value = this.domain.get(0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public List<Integer> getDomain() {
        return domain;
    }

    public void setDomain(List<Integer> domain) {
        this.domain = domain;
    }

    public void remove() {
        this.domain.remove(0);
    }

    @Override
    public String toString() {
        return "Summit" + id + " {" +"value=" + value + "domaine=" + domain +
                '}';
    }

}


