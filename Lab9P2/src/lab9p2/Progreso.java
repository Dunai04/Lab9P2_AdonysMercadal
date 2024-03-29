/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9p2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

/**
 *
 * @author adony
 */
public class Progreso extends Thread {
 private JProgressBar barra_Progreso;
    private File archivo;
    private JTextArea area_texto;

    public Progreso(JProgressBar barra_Progreso, File archivo, JTextArea area_texto) {
        this.barra_Progreso = barra_Progreso;
        this.archivo = archivo;
        this.area_texto = area_texto;
    }
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            int totallineas = (int)br.lines().count();
            br.close();
            
            br = new BufferedReader(new FileReader(archivo));
            String linea;
            String contenido = "";
            int lineasleidas = 0;
            while ((linea = br.readLine()) != null) {
                contenido += linea + "\n";
                lineasleidas++;
                int progreso = (int)(((double)lineasleidas / totallineas) * 100);
                barra_Progreso.setValue(progreso);
                Thread.sleep(100);
            }
            br.close();
            area_texto.setText(contenido);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
