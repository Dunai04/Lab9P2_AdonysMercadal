/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9p2;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author adony
 */
public class hilofechahora extends Thread {
     private JLabel fecha;
    private JLabel hora;

    public hilofechahora(JLabel hora, JLabel fecha) {
        this.hora = hora;
        this.fecha = fecha;
    }

    public void run() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        while (true) {
            Date ahora = new Date();
            hora.setText(formatoHora.format(ahora));
            fecha.setText(formatoFecha.format(ahora));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
