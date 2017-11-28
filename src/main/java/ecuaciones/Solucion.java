package ecuaciones;

public class Solucion {
    private boolean tieneInfinitasSoluciones = false;
    private int numeroSoluciones = 0;
    private Complejo primeraSolucion;
    private Complejo segundaSolucion;

    public void setInfinitasSoluciones() {
        this.tieneInfinitasSoluciones = true;
    }

    public boolean tieneInfinitasSoluciones() {
        return  this.tieneInfinitasSoluciones;
    }

    public void setNoTieneSolucion(){
        this.numeroSoluciones = 0;
    }
    public boolean noTieneSolucion() {
        return this.numeroSoluciones == 0;
    }

    public int numeroSoluciones() {
        return numeroSoluciones;
    }

    public void setNumeroSoluciones(int numeroSoluciones) {
        this.numeroSoluciones = numeroSoluciones;
    }

    public void setPrimeraSolucion(Complejo primeraSolucion) {
        this.primeraSolucion = primeraSolucion;
    }

    public Complejo primeraSolucion() {
        return primeraSolucion;
    }

    public void setSegundaSolucion(Complejo segundaSolucion) {
        this.segundaSolucion = segundaSolucion;
    }

    public Complejo segundaSolucion() {
        return this.segundaSolucion;
    }

    @Override
    public boolean equals(Object otro) {
        Solucion otraSolucion = (Solucion)otro;

        if (this.tieneInfinitasSoluciones != otraSolucion.tieneInfinitasSoluciones)
            return false;
        if (this.numeroSoluciones != otraSolucion.numeroSoluciones)
            return false;
        if (this.numeroSoluciones > 0) {
            if (!this.primeraSolucion.equals(otraSolucion.primeraSolucion))
                return false;
            if (this.numeroSoluciones > 1) {
                if (!this.segundaSolucion.equals(otraSolucion.segundaSolucion))
                    return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String cadenaSalida = "";
        cadenaSalida += "{" +
                "infinitasSoluciones: " + this.tieneInfinitasSoluciones + "; " +
                "numeroSoluciones: " + this.numeroSoluciones;
        if (this.numeroSoluciones > 0) {
            cadenaSalida += "; primeraSolucion: " + this.primeraSolucion.toString();
        }
        if (this.numeroSoluciones > 1) {
            cadenaSalida += "; segundaSolucion: " + this.segundaSolucion.toString();
        }
        cadenaSalida += "}";
        return cadenaSalida;
    }
}
