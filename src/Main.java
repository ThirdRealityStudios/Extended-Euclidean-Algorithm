import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Main m = new Main();

        int a = 547;
        int b = 23;

        Stack<Equation> results = m.applyAlgorithm(a,b);

        System.out.println(results.lastElement());
    }

    private Stack<Equation> applyAlgorithm(int a, int c) {

        int eA = a, eC = c;

        Stack<Equation> equations = new Stack<Equation>();

        while(eA != 0 && eC != 0)
        {
            Equation equ = new Equation(eA, eC);

            equ.resolve();

            equations.push(equ);

            eA = equ.c;
            eC = equ.r;
        }

        return equations;
    }
}
