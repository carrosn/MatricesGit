/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrices;

import java.awt.Dimension;
import java.util.Random;

/**
 *
 * @author galvez
 */
public class Matriz {

    private int[][] datos;
    private Random rnd = new Random();

    public Matriz(int filas, int columnas, boolean inicializarAleatorio) {
        datos = new int[columnas][];
        for (int i = 0; i < columnas; i++) {
            datos[i] = new int[filas];
            if (inicializarAleatorio) {
                for (int j = 0; j < filas; j++) {
                    datos[i][j] = rnd.nextInt(100);
                }
            }
        }
    }

    public Matriz(Dimension d, boolean inicializarAleatorio) {
        this(d.height, d.width, inicializarAleatorio);
    }

    public Dimension getDimension() {
        return new Dimension(datos.length, datos[0].length);
    }

    public static Matriz sumarDosMatrices(Matriz a, Matriz b) throws DimensionesIncompatibles {
        if (!a.getDimension().equals(b.getDimension())) {
            throw new DimensionesIncompatibles("La suma de matrices requiere matrices de las mismas dimensiones");
        }
        int i, j, filasA, columnasA;
        filasA = a.getDimension().height;
        columnasA = a.getDimension().width;
        Matriz matrizResultante = new Matriz(filasA, columnasA, false);
        for (j = 0; j < filasA; j++) {
            for (i = 0; i < columnasA; i++) {
                matrizResultante.datos[i][j] += a.datos[i][j] + b.datos[i][j];
            }
        }
        return matrizResultante;
    }

    @Override
    public String toString() {
        String ret = "";
        ret += "[\n";
        for (int i = 0; i < getDimension().width; i++) {
            ret += "(";
            for (int j = 0; j < getDimension().height; j++) {
                ret += String.format("%3d", datos[i][j]);
                if (j != getDimension().height - 1) {
                    ret += ", ";
                }
            }
            ret += ")";
            if (i != getDimension().width - 1) {
                ret += ",";
            }
            ret += "\n";
        }
        ret += "]\n";
        return ret;
    }

    public static Matriz invertirMatriz(Matriz a) {

        int filasA = a.getDimension().width;
        int columnasA = a.getDimension().height, i, j;

        Matriz matrizResultante = new Matriz(filasA, columnasA, false);
        for (i = 0; i < columnasA; i++) {
            for (j = 0; j < filasA; j++) {
                matrizResultante.datos[i][j] = a.datos[j][i];

            }

        }
        return matrizResultante;
    }

    public Dimension getDimension2() {
        return new Dimension(datos[0].length, datos.length);
    }

    public static Matriz multiplicarDosMatrices(Matriz a, Matriz b) throws DimensionesIncompatibles {
        if (!a.getDimension2().equals(b.getDimension())) {
            throw new DimensionesIncompatibles("La multiplicación de matrices requiere las columnas de la primera matriz sea igual a las filas de la segunda");
        }
        int i, j, filasA, columnasB;
        filasA = a.getDimension2().height;
        columnasB = b.getDimension().height;
        System.out.println(filasA);
        System.out.println(columnasB);
        Matriz matrizResultante = new Matriz(filasA, columnasB, false);
        for (j = 0; j < filasA; j++) {
            for (i = 0; i < columnasB; i++) {
                matrizResultante.datos[i][j] = a.datos[i][j] * b.datos[i][j];

            }

        }
        return matrizResultante;
    }

}
