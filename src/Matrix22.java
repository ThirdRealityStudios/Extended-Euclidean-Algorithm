public class Matrix22 {

    // A matrix of the measurements 2x2, where x is the first line, y the second.

    int x0, x1, y0, y1;

    public Matrix22(int x0, int x1, int y0, int y1){
        this.x0 = x0;
        this.x1 = x1;
        this.y0 = y0;
        this.y1 = y1;
    }

    public Matrix21 mulWithMatrix21(Matrix21 factor) {
        Matrix21 copy = new Matrix21(factor.x0, factor.x1);

        copy.x0 = factor.x0 * this.x0 + factor.x1 * this.y0;
        copy.x1 = factor.x0 * this.x1 + factor.x1 * this.y1;

        return copy;
    }

    public Matrix22 mul(int x0, int y0, int x1, int y1) {
        Matrix22 copy = new Matrix22(this.x0, this.x1, this.y0, this.y1);

        copy.x0 = this.x0 * x0 + this.x1 * y0;
        copy.x1 = this.x0 * x1 + this.x1 * y1;

        copy.y0 = this.y0 * x0 + this.y1 * y0;
        copy.y1 = this.y0 * x1 + this.y1 * y1;

        return copy;
    }

    public Matrix22 mul(Matrix22 factor) {

        return mul(factor.x0, factor.y0, factor.x1, factor.y1);
    }

    @Override
    public String toString() {
        String firstLine = "/ " + x0 + " " + x1 + " \\";
        String lastLine = "\\ " + y0 + " " + y1 + " /";

        String margin = "|" + " ".repeat(firstLine.length() >= lastLine.length() ? (firstLine.length() - 2) : (lastLine.length() - 2)) + "|";

        return "\n" + firstLine + "\n" + margin + "\n" + lastLine;
    }
}
