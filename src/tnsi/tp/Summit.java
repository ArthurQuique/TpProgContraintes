package tnsi.tp;

public class Summit {
    public int id;
    public int value;       //Valeur de l'objet
    public int min;         //Borne inférieure du domaine de définition
    public int max;         //Borne supérieure du domaine de définition
    public int arc1;
    public int arc2;

    public Summit(int id, int value, int min, int max, int arc1, int arc2) {
        this.id = id;
        this.value = value;
        this.min = min;
        this.max = max;
        this.arc1 = arc1;
        this.arc2 = arc2;
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

    public int getArc1() {
        return arc1;
    }

    public void setArc1(int arc1) {
        this.arc1 = arc1;
    }

    public int getArc2() {
        return arc2;
    }

    public void setArc2(int arc2) {
        this.arc2 = arc2;
    }

}


