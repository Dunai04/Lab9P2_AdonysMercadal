/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9p2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author adony
 */
public class AdminArchivos {
    public static String leerArchivo(String ruta) {
        String contenido = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido += linea + "\n";
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenido;
    }

    public static void guardarArchivo(String ruta, String contenido) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
            bw.write(contenido);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

