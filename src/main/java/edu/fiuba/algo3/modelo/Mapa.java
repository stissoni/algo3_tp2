package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Hashtable;

import edu.fiuba.algo3.excepciones.EjercitosDeJugadoresDiferentesException;
import edu.fiuba.algo3.excepciones.PaisSinEjercitoException;

public class Mapa {
    private Hashtable<String, Continente> continentes;
    private Hashtable<String, Pais> paises;

    public Mapa(){
        this.paises = new Hashtable<String, Pais>();
        this.continentes = new Hashtable<String, Continente>();
    }

    public ArrayList<Pais> obtenerPaises(){
        return new ArrayList<Pais>(this.paises.values());
    }

    public ArrayList<Pais> obtenerPaisesDe(Jugador unJugador){
        ArrayList<Pais> paisesDelJugador = new ArrayList<Pais>();
        for (Pais pais: this.obtenerPaises()){
            try{
                Jugador jugadorControlando = pais.obtenerJugadorEnControl();
                if (jugadorControlando.sonElMismoJugador(unJugador)){
                    paisesDelJugador.add(pais);
                }
            }
            catch (PaisSinEjercitoException e){
            }
        }
        return paisesDelJugador;
    }

    public ArrayList<Pais> obtenerPaisesNoDe(Jugador unJugador){
        ArrayList<Pais> paisesDelJugador = new ArrayList<Pais>();
        for (Pais pais: this.obtenerPaises()){
            try{
                Jugador jugadorControlando = pais.obtenerJugadorEnControl();
                if (!jugadorControlando.sonElMismoJugador(unJugador)){
                    paisesDelJugador.add(pais);
                }
            }
            catch (PaisSinEjercitoException e){
            }
        }
        return paisesDelJugador;
    }

    public ArrayList<Pais> obtenerPaisesLimitrofesDe(Pais unPais, Jugador unJugador){
        //ArrayList<String> paisesLimitrofes = unPais.obtenerPaisesLimitrofes();
        ArrayList<Pais> paisesLimitrofesAConquistar = new ArrayList<Pais>();
        for (int i = 1; i<unPais.cantidadDePaisesLimitrofe(); i++ ){
            Pais otroPais=this.obtenerUnPais(unPais.obtenerNombrePaisLimitrofe(i));
            try{
                Jugador jugadorControlando = otroPais.obtenerJugadorEnControl();
                if (!jugadorControlando.sonElMismoJugador(unJugador)){
                    paisesLimitrofesAConquistar.add(otroPais);
                }
            }
            catch (PaisSinEjercitoException e){
            }
        }
        return paisesLimitrofesAConquistar;
    }

    public void agregarPais(Pais unPais){
        this.paises.put(unPais.obtenerNombrePais(), unPais);
    }

    public void agregarContinente(Continente unContinente){
        this.continentes.put(unContinente.obtenerNombre(), unContinente);
    }

    public Pais obtenerUnPais(String nombrePais){
        return this.paises.get(nombrePais);
    }

    public Continente obtenerUnContinente(String nombreContinente){
        return this.continentes.get(nombreContinente);
    }

    public void colocarEjercitoEn(String nombrePais, Jugador unJugador, int numeroEjercitos) throws EjercitosDeJugadoresDiferentesException{
        Pais unPais = this.obtenerUnPais(nombrePais);
        Ejercito nuevoEjercito = new Ejercito(numeroEjercitos, unJugador);
        unPais.agregarEjercito(nuevoEjercito);
    }

    public int numeroPaisesControladosPor(Jugador unJugador){
        int numeroPaises = 0;
        for (Pais pais: this.paises.values()){
            if (pais.esDominadoPorJugador(unJugador)){
                numeroPaises = numeroPaises + 1;
            }
        }
        return numeroPaises;
    }

    public int numeroPaises(){
        // For testing purposes.
        return this.paises.size();
    }

    public int numeroContinentes(){
        // for testing purposes.
        return this.continentes.size();
    }
}
