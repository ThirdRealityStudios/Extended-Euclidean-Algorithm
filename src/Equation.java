public class Equation {

    private static int id;

    private int currentId;

    public int a,b,c,r;

    public Equation(int a, int c) {
        this.a = a;
        this.c = c;

        currentId = id++;
    }

    public void resolve()
    {
        resolveB();
        resolveR();
        recalculateA();
    }

    // To check if the equation was successful..
    private void recalculateA() {
        a = b*c + r;
    }

    public int resolveB(){
        b = a/c;

        return c;
    }

    public int resolveR() {
        r = a - b*c;

        return c;
    }

    @Override
    public String toString() {
        return "(ID#" + currentId + "): a = b * c + r = " + a + " = " + b + " * " + c + " + " + r;
    }
}
