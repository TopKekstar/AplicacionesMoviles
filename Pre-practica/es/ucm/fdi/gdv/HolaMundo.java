package es.ucm.fdi.gdv; //Integra todo el codigo del .java en un paquete (es como un namespace)
                        //Se declara al principio del documento, antes de declarar nada
                        //La nomenclatura de los paquetes es de tipo URL inverso

                        //tendriamos que meter esta clase dentro de una carpeta gdv, dentro de otra llamada fdi, 
                        //dentro de otra llamada ucm dentro de otra llamada es.
                        //Lo compilaríiamos usando el comando: javac es.ucm.fdi.gdv.HolaMundo
import es.ucm.fdi.gdv;


//Importante que el fichero se llame como la clase del main
public class HolaMundo 
{

    public static void main (String [] args)
    {

        Saludador saludador;
        saludador = new Saludador(args[0]);
        saludador.saludar();
    }

}


/*
    Tipos de Java
    boolean, 
    char (16bits),
    byte, short (16), int(32), long,
    float (32 bits), double (64)

    La conversión de tipos hacia arriba no pone ningún problema
    ej: de short a int. Si es de int a short se queja el compilador
 */



//la notación en Java para interfaces y clases es CamelCase:
//ClasePrueba


//Para métodos se utiliza camelCase
//metodoPrueba

//En java el enlazado se hace en tiempo de ejecución.