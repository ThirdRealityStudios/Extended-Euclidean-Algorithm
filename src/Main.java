import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Main m = new Main();

        int a = 547;
        int b = 23;

        Stack<Equation> gcdResolvingHistory = m.calculateGCD(a,b);

        for(Equation equ : gcdResolvingHistory) {
            System.out.println(equ);
        }

        Equation gcdEquation = m.lookupGCD(gcdResolvingHistory);
        System.out.println("gcd: " + gcdEquation.r);

        // Here it pre-calculates the last missing results by using matrices.
        // Instead, you could also do it by using "normal" equations but here I just did it this way.
        // If you know roughly how to handle matrices, this approach might be easier for you (at least it is for me).
        // A German example (calculator) you can find here online: https://www.arndt-bruenner.de/mathe/scripts/erweitertereuklid.htm
        // Or here in English: https://www.dcode.fr/extended-gcd
        Matrix22 temporaryMatrixResult = m.calculateMatrix(gcdResolvingHistory);

        // Here it uses the last result to multiply it with (a b) in a matrix (integer values from the beginning).
        Matrix21 finalResult = temporaryMatrixResult.mulWithMatrix21(new Matrix21(a,b));

        System.out.println();
        System.out.println("Final matrix result " + finalResult);
    }

    private Matrix22 calculateMatrix(Stack<Equation> gcdResults){
        Stack<Matrix22> matrices = new Stack<Matrix22>();

        for(Equation equ : gcdResults) {
            matrices.push(new Matrix22(0,1,1,-equ.b));
        }

        Matrix22 result = null;

        for(Matrix22 matrix : matrices) {
            if(result == null){
                result = matrix;
            }
            else{
                result = result.mul(matrix);
            }
        }

        return result;
    }

    private Stack<Equation> calculateGCD(int a, int c) {

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
    // Note! The gcd (r) is always contained in the last equation where r is not 0 (zero).
    private Equation lookupGCD(Stack<Equation> equations) {

        int firstElementsR = equations.lastElement().r;

        if (firstElementsR != 0) {
            return equations.lastElement();
        } else if (equations.size() > 1) {
            return equations.elementAt(equations.size()-2);
        }

        return null;
    }
}
