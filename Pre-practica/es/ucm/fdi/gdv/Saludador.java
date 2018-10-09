package es.ucm.fdi.gdv;

public class Saludador
{
    public Saludador(String nombre)
    {
        _nombre = nombre;
    }
    public void saludar()
    {
        //Las cadenas en java son inmutables. Por tanto para concatenar
        //Tiene que fusionar las cadenas en otra.
        //Si son 3 cadenas tiene que fusionar 2 de ellas, y luego el 
        //resultado con la 3º
        System.out.println("Hola, " + _nombre + "!");
    }
    private String _nombre;

}