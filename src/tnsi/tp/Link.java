package tnsi.tp;

public class Link {
    public int id;
    public char constraint;             // > < =
    public int summit1;
    public int summit2;

    public Link(int id, char constraint, int summit1, int summit2) {
        this.id = id;
        this.constraint = constraint;
        this.summit1 = summit1;
        this.summit2 = summit2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getConstraint() {
        return constraint;
    }

    public void setConstraint(char constraint) {
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
}


