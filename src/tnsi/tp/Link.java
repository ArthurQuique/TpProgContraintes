package tnsi.tp;

import java.util.ArrayList;
import java.util.List;

public class Link {
    private int id;
    private String constraint;             // > < = <= =>
    private int summit1;
    private int summit2;
    private String[] constraintTab = {">", "<", "=", "<=", ">="};

    public Link(int id, int summit1, int summit2) {
        this.id = id;
        this.constraint = constraintTab[(int) (Math.random() * constraintTab.length)];
        this.summit1 = summit1;
        this.summit2 = summit2;
    }

    /**
     * Retourne si la contrainte est respectée
     * @param summits
     * @return
     */
    public boolean constraintRespected(List<Summit> summits) {
        int value1 = summits.get(summit1-1).getValue();
        int value2 = summits.get(summit2-1).getValue();
        boolean result = true;
        if(value1 != 0 && value2 != 0) {
            switch (constraint) {
                case ">":
                    result = (value1 > value2);
                    break;
                case "<":
                    result = (value1 < value2);
                    break;
                case "=" :
                    result = (value1 == value2);
                    break;
                case ">=":
                    result = (value1 >= value2);
                    break;
                case "<=":
                    result = (value1 <= value2);
                    break;
                default:
                    break;
            }
        }

        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConstraint() {
        return constraint;
    }

    public void setConstraint(String constraint) {
        this.constraint = constraint;
    }

    public int getSummit1() {
        return summit1;
    }

    public void setSummit1(int summit1) {
        this.summit1 = summit1;
    }

    public int getSummit2() {
        return summit2;
    }

    public void setSummit2(int summit2) {
        this.summit2 = summit2;
    }

    @Override
    public String toString() {
        return "Contrainte " + id + " : V" + summit1 + " " + constraint + " V" + summit2;
    }
}


