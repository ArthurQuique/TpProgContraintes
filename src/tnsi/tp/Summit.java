package tnsi.tp;

public class Summit {
    private int id;
    private int value;       //Valeur de l'objet
    private int min;         //Borne inférieure du domaine de définition
    private int max;         //Borne supérieure du domaine de définition

    public Summit(int id, int taille) {
        this.id = id;
        this.min = 1;
        this.max = taille;
        this.value = (int) (Math.random() * ((max + 1) - min) + 1);
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

    @Override
    public String toString() {
        return "Summit{" +
                "id=" + id +
                ", value=" + value +
                ", min=" + min +
                ", max=" + max +
                '}';
    }
}


