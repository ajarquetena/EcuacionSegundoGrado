package ecuaciones;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class EcuacionesTest {
    @Test
    public void ecuacionSegundoGradoTest(){
        EcuacionSegundoGrado ecuacionSegundoGrado=new EcuacionSegundoGrado(0,0,0);
        Solucion solucion = ecuacionSegundoGrado.resuelve();
        Solucion solucionDeseada = new Solucion();
        solucionDeseada.setInfinitasSoluciones();
        assertEquals(solucionDeseada,solucion);
    }

    @Test
    public void ecuacionSegundoGradoConCDistintoDe0() {
        EcuacionSegundoGrado ecuacionSegundoGrado=new EcuacionSegundoGrado(0,0,20);
        Solucion solucion = ecuacionSegundoGrado.resuelve();
        Solucion solucionDeseada = new Solucion();
        solucionDeseada.setNoTieneSolucion();
        assertEquals(solucionDeseada,solucion);
    }

    @Test
    public void ecuacionSegundoGradoConBDistintoDe0() {
        EcuacionSegundoGrado ecuacionSegundoGrado=new EcuacionSegundoGrado(0,3,20);
        Solucion solucion = ecuacionSegundoGrado.resuelve();
        Solucion solucionDeseada = new Solucion();
        solucionDeseada.setNumeroSoluciones(1);
        solucionDeseada.setPrimeraSolucion(new Complejo(-20.0/3.0,0.0));
        assertEquals(solucionDeseada,solucion);

        ecuacionSegundoGrado=new EcuacionSegundoGrado(0,3,0);
        solucion = ecuacionSegundoGrado.resuelve();
        solucionDeseada = new Solucion();
        solucionDeseada.setNumeroSoluciones(1);
        solucionDeseada.setPrimeraSolucion(new Complejo(0.0, 0.0));
        assertEquals(solucionDeseada,solucion);
    }

    @Test
    public void ecuacionSegundoGradoConADistintoDe0() {
        EcuacionSegundoGrado ecuacionSegundoGrado=new EcuacionSegundoGrado(3,0,-20);
        Solucion solucion = ecuacionSegundoGrado.resuelve();
        Solucion solucionDeseada = new Solucion();
        solucionDeseada.setNumeroSoluciones(2);
        solucionDeseada.setPrimeraSolucion(new Complejo(Math.sqrt(20.0/3.0), 0.0));
        solucionDeseada.setSegundaSolucion(new Complejo(-Math.sqrt(20.0/3.0), 0.0));
        assertEquals(solucionDeseada,solucion);

        ecuacionSegundoGrado=new EcuacionSegundoGrado(3,0,20);
        solucion = ecuacionSegundoGrado.resuelve();
        solucionDeseada = new Solucion();
        solucionDeseada.setNumeroSoluciones(2);
        solucionDeseada.setPrimeraSolucion(new Complejo(0.0, Math.sqrt(20.0/3.0)));
        solucionDeseada.setSegundaSolucion(new Complejo(0.0, -Math.sqrt(20.0/3.0)));
        assertEquals(solucionDeseada,solucion);
    }

    @Test
    public void ecuacionSegundoGradoConAyBDistintoDe0() {
        EcuacionSegundoGrado ecuacionSegundoGrado=new EcuacionSegundoGrado(3,4,-20);
        Solucion solucion = ecuacionSegundoGrado.resuelve();
        Solucion solucionDeseada = new Solucion();
        solucionDeseada.setNumeroSoluciones(2);
        solucionDeseada.setPrimeraSolucion(new Complejo(2, 0.0));
        solucionDeseada.setSegundaSolucion(new Complejo(-10.0/3.0, 0.0));
        assertEquals(solucionDeseada,solucion);

        ecuacionSegundoGrado=new EcuacionSegundoGrado(3,4,20);
        solucion = ecuacionSegundoGrado.resuelve();
        solucionDeseada = new Solucion();
        solucionDeseada.setNumeroSoluciones(2);
        solucionDeseada.setPrimeraSolucion(new Complejo(-2.0/3.0, 2.0*Math.sqrt(14.0)));
        solucionDeseada.setSegundaSolucion(new Complejo(-2.0/3.0, -2.0*Math.sqrt(14.0)));
        assertEquals(solucionDeseada,solucion);
    }
}
