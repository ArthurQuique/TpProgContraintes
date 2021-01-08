package tnsi.tp;

public class Summit {
    public int id;
    public int value;       //Valeur de l'objet
    public int min;         //Borne inférieure du domaine de définition
    public int max;         //Borne supérieure du domaine de définition
    public int link1;
    public int link2;

    public Summit(int id, int value, int min, int max, int link1, int link2) {
        this.id = id;
        this.value = value;
        this.min = min;
        this.max = max;
        this.link1 = link1;
        this.link2 = link2;
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

    public int getlink1() {
        return link1;
    }

    public void setlink1(int link1) {
        this.link1 = link1;
    }

    public int getlink2() {
        return link2;
    }

    public void setlink2(int link2) {
        this.link2 = link2;
    }

}


