public class Matrix21 {
    // A matrix of the measurements 2x1, where x is the first line, y the second.

    int x0, x1;

    public Matrix21(int x0, int x1){
        this.x0 = x0;
        this.x1 = x1;
    }

    @Override
    public String toString() {
        String matrixRepresentation = "( " + x0 + " " + x1 + " )";

        return "\n" + matrixRepresentation + "\n";
    }
}
