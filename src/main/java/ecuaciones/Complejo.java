package ecuaciones;

public class Complejo {
    private Double parteReal = 0.0;
    private Double parteImagnaria = 0.0;

    public Complejo(double parteReal, double parteImaginaria) {
        this.parteReal = parteReal;
        this.parteImagnaria = parteImaginaria;
    }

    @Override
    public boolean equals(Object otro) {
        Complejo otroNumero = (Complejo) otro;

        if (Math.abs(this.parteReal - otroNumero.parteReal) < 1e-5 && Math.abs(this.parteImagnaria - otroNumero.parteImagnaria) < 1e-5)
            return true;

        return false;
    }

    @Override
    public String toString() {
        return "{" + this.parteReal + "+" + this.parteImagnaria + "i}";
    }
}
