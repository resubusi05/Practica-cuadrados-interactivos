/*
Victor Alejandro Escobedo Torres
*/

import javax.swing.*;
import javax.swing.BoxLayout;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.awt.Point;

public class ProgramaRectangulo{
	public static void main(String[] args) {

		String infoEntradaFilas, infoEntradaColumnas;

        // ciclo while para pedir valores hasta que se ingresen numeros enteros positivos
        boolean valoresValidos = false;

        while (!valoresValidos) {
            // se muestran cuadros de dialogo pidiendo el numero de columnas y de filas
            infoEntradaColumnas = JOptionPane.showInputDialog("Introduce el numero de columnas");
            infoEntradaFilas = JOptionPane.showInputDialog("Introduce el numero de filas");

            try {
                // cambiamos el tipo de datos de String a int
                int infoEntradaFilasInt = Integer.parseInt(infoEntradaFilas);
                int infoEntradaColumnasInt = Integer.parseInt(infoEntradaColumnas);

                // verificar que los valores ingresados sean enteros positivos
                if ((infoEntradaFilasInt > 0) && (infoEntradaColumnasInt > 0)) {
                    new MainFrame(infoEntradaFilasInt, infoEntradaColumnasInt);

                    valoresValidos = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Debes ingresar solo numeros enteros positivos.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debes ingresar solo numeros enteros positivos.");
            }
        }
	}

}

/*

⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣠⡤⠤⠤⠤⢤⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠤⠖⠊⠉⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠒⠦⢄⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡠⠖⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠑⠦⣀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠴⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠑⢦⡀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡴⣉⡤⠖⠊⡏⢉⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢫⠉⢱⠦⣄⡀⠙⢦⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⢠⠏⡞⠁⠀⣠⢞⡵⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠳⡜⣇⠀⠙⢆⠈⢧⠀⠀
⠀⠀⠀⠀⠀⠀⠀⢠⠋⠀⢧⡠⣾⡵⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⢞⣧⠀⢸⠂⠀⣧⠀
⠀⠀⠀⠀⠀⠀⠀⡟⠀⠀⠀⠙⠉⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡇⠀⠀⠀⠀⠀⠀⠈⠛⠒⠋⠀⠀⢸⠀
⠀⠀⠀⠀⠀⠀⢸⠁⠀⠀⠀⠀⢠⠄⠀⠀⠀⠀⢠⢷⠀⠀⠀⠀⠀⠀⠀⠀⡄⠀⣸⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢨⠀
⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⡆⠀⠀⢀⠀⠀⢸⠈⢇⠀⢰⠀⠀⠀⠀⠀⡇⢠⠃⢻⠀⢀⡔⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀
⠀⠀⠀⠀⠀⠀⠈⡆⠀⠀⠀⠀⡇⠀⠀⠈⡵⠦⡼⠶⢾⣷⣸⣧⠀⠀⠀⣸⣧⣯⡶⣾⡴⡏⢀⣄⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀
⠀⠀⠀⠀⠀⠀⠀⢧⠀⠀⠀⠀⡇⠀⠀⡼⠁⠀⣀⣀⡀⠀⠉⠉⢦⠀⢠⠋⠉⠁⠀⣉⣸⣗⣉⡈⠳⣄⠀⠀⠀⠀⠀⡇⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠘⣴⡀⠀⠀⢃⣠⠞⣿⡷⡿⠛⣿⣿⣿⢶⡄⠈⠳⠋⠀⠀⣰⢾⠛⢻⣿⣿⡿⣿⡈⡟⠂⠀⡇⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⣧⠀⠀⠈⠁⠀⠸⡇⢿⣽⣿⣿⣿⡇⠁⠀⠀⠀⠀⠀⠀⢿⡵⣿⣿⣯⡇⠏⡹⠁⠀⠀⢀⡇⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⡆⠀⠀⠀⠀⠀⠹⣌⠻⠿⠿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⠿⠿⠛⠀⣰⠃⠀⠀⠀⣠⠃⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⢆⢀⡀⠀⠀⠀⠈⠳⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⡃⠀⠀⢀⡜⠁⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠑⢆⡀⠀⠈⠻⡍⠀⠀⠀⠀⠀⠒⠒⠂⠀⠀⠀⠀⠀⣀⣤⣟⠁⣠⠔⠃⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠢⣄⣿⠛⣻⣶⣤⣤⣤⣀⣠⣤⢤⣤⣴⡶⠫⠿⣿⡚⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡴⢻⣶⡄⢰⢳⠃⢀⣷⣿⠦⢯⣿⡗⠀⢧⠹⡄⠀⣤⣽⢦⡀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣷⣶⣶⣿⣄⣾⠏⠀⠈⠑⢦⡀⣤⠞⠉⠀⠈⠱⣧⢠⣼⣿⣦⣽⣦⡀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⠔⣻⣿⣿⣿⡿⠟⢹⣿⡄⠀⠀⠀⣾⣿⣿⡀⠀⠀⠀⣸⣿⣿⢿⣿⣿⣿⣿⣿⢦⡀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⣰⣯⡟⠓⢍⠻⡿⠏⠁⠀⢸⢿⡟⠲⠶⠚⢱⠋⢲⠑⠒⠒⠊⣟⡩⢾⡇⠙⢿⣿⡿⢋⡼⡄⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⡼⠁⠀⠙⢤⡀⡻⠁⠀⠀⠀⡌⠶⣷⡶⠶⢦⠘⣗⠏⢀⠒⢒⣒⡻⠆⢸⡇⠀⠀⢻⡕⠉⠀⠀⠳⡀⠀⠀
⠀⠀⠀⠀⠀⠀⢰⡀⠀⠀⠀⣰⠋⠁⠀⠀⠀⠀⣧⠀⠀⠉⠉⠉⠀⢸⠀⠈⠉⠉⠀⠀⠀⣠⡇⠀⠀⠀⠀⠙⢦⣀⣀⡴⠃⠀
⠀⠀⠀⠀⠀⠀⠀⠑⠒⠉⠀⠀⠀⠀⠀⠀⠀⠀⡏⠳⣄⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⡠⠚⠁⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣇⡀⠈⠑⠢⣄⡀⠈⠁⠀⣀⠴⠋⠀⣀⣠⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣯⣽⠀⠀⠀⠀⠉⣷⠒⡋⠀⠀⠀⠀⢫⣵⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⢰⠤⡄⠀⠀⠀⡇⠀⣇⠀⠀⠀⡤⢦⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠧⠞⠀⠹⣄⠀⢸⠀⠀⢹⣀⣠⠞⠀⠘⠦⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⣀⣀⣉⡟⠀⠀⠀⡏⠀⠀⠀⣀⡀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠎⠉⠉⠉⠀⠈⡇⠀⠀⠀⡏⠉⠉⠉⠁⠉⢇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢨⡄⠀⠀⠀⣆⣠⠇⠀⠀⠀⣧⠀⣠⠀⠀⠀⢸⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠳⠤⠤⠶⠛⠁⠀⠀⠀⠀⠈⠻⠿⣦⣤⡤⠞⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀

*/