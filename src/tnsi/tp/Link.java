package tnsi.tp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Link {
    private int id;
    private String constraint;             // > < = <= =>
    private Summit summit1;
    private Summit summit2;
    private String[] constraintTab = {">", "<", "=", "<=", ">="};

    public Link(int id, List<Summit> summits) {
        this.id = id;
        this.constraint = constraintTab[(int) (Math.random() * constraintTab.length)];
        List<Summit> newSummits = new ArrayList<>(summits);
        int index = (int) (Math.random() * newSummits.size());
        this.summit1 = newSummits.get(index);
        newSummits.remove(index);
        index = (int) (Math.random() * newSummits.size());
        this.summit2 = newSummits.get(index);
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

    public Summit getSummit1() {
        return summit1;
    }

    public void setSummit1(Summit summit1) {
        this.summit1 = summit1;
    }

    public Summit getSummit2() {
        return summit2;
    }

    public void setSummit2(Summit summit2) {
        this.summit2 = summit2;
    }

    @Override
    public String toString() {
        return "Link{" +
                "id=" + id +
                ", constraint='" + constraint + '\'' +
                ", summit1=" + summit1 +
                ", summit2=" + summit2 +
                '}';
    }
}


