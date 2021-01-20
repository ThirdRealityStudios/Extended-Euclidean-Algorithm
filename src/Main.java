import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Main m = new Main();

        int a = 547;
        int b = 23;

        Stack<Equation> results = m.applyAlgorithm(a,b);

        for(Equation equ : results)
        {
            System.out.println(equ);
        }

        Equation gcdEquation = m.getGCD(results);

        System.out.println("gcd: " + gcdEquation.r);
    }

    private Stack<Equation> applyAlgorithm(int a, int c) {

        int eA = a, eC = c;

        Stack<Equation> equations = new Stack<Equation>();

        while(eA != 0 && eC != 0) {
            Equation equ = new Equation(eA, eC);

            equ.resolve();

            equations.push(equ);

            eA = equ.c;
            eC = equ.r;
        }

        return equations;
    }

    // Determines the equation with the greatest common divisor (German: ggT = größter gemeinsamer Teiler).
    // Get the gcd by just accessing r in your equation then.
    private Equation getGCD(Stack<Equation> equations) {

        int firstElementsR = equations.lastElement().r;

        if (firstElementsR != 0) {
            return equations.lastElement();
        } else if (equations.size() > 1) {
            return equations.elementAt(equations.size()-2);
        }

        return null;
    }
}
