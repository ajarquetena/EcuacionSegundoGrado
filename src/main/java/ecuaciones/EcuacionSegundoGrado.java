package ecuaciones;

public class EcuacionSegundoGrado {
    private double coeficienteA;
    private double coeficienteB;
    private double coeficienteC;

    public EcuacionSegundoGrado(double coeficienteA, double coeficienteB, double coeficienteC) {
        this.coeficienteA = coeficienteA;
        this.coeficienteB = coeficienteB;
        this.coeficienteC = coeficienteC;
    }

    private Solucion resuelveTresCoeficientesNulos() {
        Solucion solucion = new Solucion();
        solucion.setInfinitasSoluciones();
        return solucion;
    }

    private Solucion resuelveSoloCDistinto0() {
        Solucion solucion = new Solucion();
        solucion.setNoTieneSolucion();
        return solucion;
    }

    private Solucion resuelveBDistinto0() {
        Solucion solucion = new Solucion();
        solucion.setNumeroSoluciones(1);
        solucion.setPrimeraSolucion(new Complejo(-coeficienteC / coeficienteB, 0.0));
        return solucion;
    }

    private Solucion resuelveADistinto0BIgual0() {
        Solucion solucion = new Solucion();
        solucion.setNumeroSoluciones(2);
        if (coeficienteC <= 0) {
            solucion.setPrimeraSolucion(new Complejo(Math.sqrt(-coeficienteC / coeficienteA), 0.0));
            solucion.setSegundaSolucion(new Complejo(-Math.sqrt(-coeficienteC / coeficienteA), 0.0));
        } else {
            solucion.setPrimeraSolucion(new Complejo(0.0, Math.sqrt(coeficienteC / coeficienteA)));
            solucion.setSegundaSolucion(new Complejo(0.0, -Math.sqrt(coeficienteC / coeficienteA)));
        }
        return solucion;
    }

    public Solucion resuelve() {
        Solucion solucion;

        if (coeficienteC == 0.0 && coeficienteB == 0.0 && coeficienteA == 0.0) {
            return resuelveTresCoeficientesNulos();
        }

        if (coeficienteC != 0.0 && coeficienteB == 0.0 && coeficienteA == 0.0)
            return resuelveSoloCDistinto0();

        if (coeficienteB != 0.0 && coeficienteA == 0.0)
            return resuelveBDistinto0();

        if (coeficienteB == 0)
            return resuelveADistinto0BIgual0();

        return resuelveADistinto0BDistinto0();
    }

    private Solucion resuelveADistinto0BDistinto0() {
        Solucion solucion = new Solucion();

        if (loDeDentroDeLaRaiz() < 0.0) {
            solucion.setNumeroSoluciones(2);
            solucion.setPrimeraSolucion(new Complejo(parteFijaReal(), parteVariableImaginaria()));
            solucion.setSegundaSolucion(new Complejo(parteFijaReal(), -parteVariableImaginaria()));
        } else if (loDeDentroDeLaRaiz() == 0.0) {
            solucion.setNumeroSoluciones(1);
            solucion.setPrimeraSolucion(new Complejo(parteFijaReal(), 0));
        } else {
            solucion.setNumeroSoluciones(2);
            solucion.setPrimeraSolucion(new Complejo(parteFijaReal() + parteVariableReal(), 0));
            solucion.setSegundaSolucion(new Complejo(parteFijaReal() - parteVariableReal(), 0));
        }
        return solucion;
    }

    private double parteVariableImaginaria() {
        return Math.sqrt((4.0 * coeficienteA * coeficienteC) - (coeficienteB * coeficienteB)) / (2.0 * coeficienteA);
    }

    private double parteVariableReal() {
        return Math.sqrt((coeficienteB * coeficienteB) - (4.0 * coeficienteA * coeficienteC)) / (2.0 * coeficienteA);
    }

    private double parteFijaReal() {
        return -coeficienteB / (2.0 * coeficienteA);
    }

    private Double loDeDentroDeLaRaiz() {
        return coeficienteB * coeficienteB - 4.0 * coeficienteA * coeficienteC;
    }


}
