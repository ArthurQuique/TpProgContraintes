package tnsi.tp;

public class Test {

    public static void main (String[] args) {
    for(int i = 0; i<=10;i++){
        long beginTime = System.currentTimeMillis();

        CSP csp = new CSP();
        csp.backtracking();

        long finishTime = System.currentTimeMillis();
        float seconds = (finishTime - beginTime) / 1000F;
        System.out.println("\nProgramme terminé en " + seconds + " secondes.\n");
    }
    }
}
