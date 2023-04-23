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
import java.util.Random;

public class PanelPadre extends JPanel{

	private int i, casillas;
	private Random rand = new Random();
	int contadorDeFila = 1;
	int contadorDeColumna = 0;

	public PanelPadre(int numeroDeFilas, int numeroDeColumnas){
		super();

		//Le decimos al panel principal cuantos por cuantos paneles y el el margen entre los paneles
		setLayout(new GridLayout(numeroDeFilas, numeroDeColumnas, 3, 3));
		setPreferredSize(new Dimension(800, 800));

		casillas = numeroDeFilas*numeroDeColumnas;

		//este ciclo "dibuja" los paneles dentro del panel padre
		for(i=0; i<casillas; i++){

			//Este es un contador para que muestre la coordenada del panel al que se le dió click
			contadorDeColumna++;
			if(contadorDeColumna>numeroDeColumnas){
				contadorDeColumna = contadorDeColumna/numeroDeColumnas;
				contadorDeFila++;
			}

			//Esto es para hacer que el color de los paneles se aleatoreo, pero en tonos pasteles(por que se ve bonito xd)
			final float hue = rand.nextFloat();
			final float saturation = (rand.nextInt(2000) + 1000) / 10000f;
			final float luminance = 0.9f;

			final Color color = Color.getHSBColor(hue, saturation, luminance);

			add(new PanelClick(color, contadorDeFila, contadorDeColumna));

		}
	}

}

/*
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⢦⣤⣤⣤⣄⣤⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣽⣿⢨⡿⠟⠛⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢲⣤⣤⣀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣉⠻⣿⣿⣿⣿⣿⡏⠉⠉⠉⠉⢩⣿
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢈⣩⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⡭⢝⣻⣿⣿⣿⣷⣿⣿⣿⣿
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⢤⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⣭⡿⠛⣻⣿⣿⣿⣿
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣿⣻⣿⣿⣿⣿
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣶⣥⣬⣭⣿
⠀⠀⠀⠀⠀⠀⠀⠀⠰⠚⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⡍⠹⠿
⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⣴⣶⣶⣾
⠀⠀⠀⡄⠀⠀⣠⢟⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿⣿⣿⣿⠋⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⢛⡛⣹⣿
⠀⠀⠀⣷⡀⠀⢱⠟⢻⣿⣿⣿⣿⣿⣿⣿⡿⢫⣽⣿⣿⣿⣿⣿⣿⣿⣏⢹⠏⣼⣿⣟⣛⣙⡒⣾⣿⣀⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⢛⣣⣿⣿
⡄⠀⢀⣿⣇⣤⣾⢾⣿⣿⣿⣿⣿⣿⣿⣿⡇⣾⢿⣿⣿⣿⣿⣿⣿⣿⢿⣇⠀⠙⠿⠿⣿⡏⠛⢿⡮⠙⢻⡿⢡⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣭⢶⣿⡿⣿⣿⣿
⣇⠀⢸⣿⡏⠁⠀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣧⢧⡸⡿⠟⣿⣿⣿⣿⣿⠈⣿⠀⠀⠀⠀⠀⠀⠀⠬⡷⠖⠋⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠋⠁⠀⠙⠻⢶⣍⡛
⡿⢿⡇⢹⡿⢦⡀⠙⠛⢿⣿⣿⣿⣿⣿⣿⣿⣎⢻⡛⠂⣿⣿⡿⠙⠃⠈⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠁⠀⣿⡟⢛⣦⣹⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⠾⠀⠀⠀⠀⠀⠀⠉⠻
⣦⣿⡉⠻⣿⣯⠹⠀⣐⢦⣿⣿⣿⣿⣿⣿⣿⣿⣷⣄⣠⠘⢿⣷⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⢿⠟⢠⣿⣿⣿⣿⣿⣿⢿⡛⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⢻⠙⢿⣦⡈⠛⣄⡀⠈⠀⠉⠛⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⢸⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⠄⠀⣾⣿⣿⣿⣿⣿⠛⠛⠛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠘⠀⠀⠙⢻⣶⣄⠙⢦⡀⠀⠀⠈⠹⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⢀⡆⣼⣿⣿⣿⢻⡍⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠈⠻⢷⣄⠈⠦⡀⣀⣴⢶⣿⣟⠛⠫⠍⠉⠉⠉⠙⠛⠛⠛⠛⠛⠛⠛⠛⢻⣿⣟⡽⠶⠚⢿⣷⡾⠋⡰⠋⢹⣟⠙⢷⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⢀⣀⣀⠻⢿⡟⠉⠻⠶⠧⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣶⠿⢯⡥⣤⠤⣤⣀⣻⢅⡴⠃⠀⢸⠛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⣀⠀⢰⣿⡿⠿⢧⣤⣾⡿⠛⠻⢿⡛⠲⢤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⢾⡿⠋⠀⠠⣄⣈⢛⣄⡹⣧⡞⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠈⠁⢺⣿⡇⣠⣶⣿⣿⣿⣿⣿⣿⣿⣷⣶⣭⡳⢤⡀⠀⠀⠐⢤⣠⢞⣵⠋⠀⠀⠀⠀⠈⠛⠿⠋⣹⣾⡛⠶⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⣸⣿⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⢿⣷⣶⣶⣿⣵⣿⣿⣷⣄⠀⠀⠀⠀⠀⠀⣼⠃⠀⠙⠲⡌⠳⣄⠀⠀⠀⠀⣀⡤⠶⠶⠦⣤⣀⠀⢀⣀⡀⠀⠀⠀⠀⠀
⠀⣠⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣝⣿⣧⣝⣻⡿⣿⣿⣿⣷⣦⣄⣀⣀⣼⣿⡷⣄⠀⠀⠙⢦⣸⣧⠔⣛⣿⠷⠋⠙⠲⠶⣄⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀
⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣝⢿⣄⣉⣷⢬⣿⣿⣿⣿⣿⣿⣿⣿⠿⠿⣷⣄⠀⠀⠛⠛⠛⠉⠀⠀⠀⠀⠀⠀⠈⢷⡄⠀⠀⠀⠀⠀⠀⠀⠀
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣆⠹⣿⣷⣿⣿⣿⣿⣿⡿⠛⠉⠀⠀⠀⠈⠛⢷⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣄⢀⠀⠀⠀⠀⠀⠀
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣆⠈⠻⣿⣿⣿⣿⣮⡳⣄⠀⠀⠀⠀⠀⠀⠀⠈⠛⠛⠲⢤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⣶⡄⠀⠀⠀⠀
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣄⠘⣿⣿⣏⠉⠻⣽⣧⣤⣴⣖⣲⠶⠬⠽⠿⠶⠖⠷⣬⡉⠉⠂⠀⠀⠀⠀⠀⠀⠀⠀⠉⠓⠶⠶⡂
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡃⠈⢻⣿⢧⢀⣠⣙⣻⣿⣿⣿⣷⣄⠀⠀⠀⠀⡀⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⣿⣿⣤⠟⢿⣿⣿⣿⣿⣿⣿⣿⣷⣄⠀⢰⡷⣿⣇⣀⣀⣀⣴⣶⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠇⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⡗⢒⣋⣉⣉⣭⣏⠻⣶⡖⢽⣏⠳⣤⡀⠀⠀⠀⠀⠀
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄⠀⠈⣿⡿⣿⣿⣿⣿⣿⣿⣷⣾⣿⣿⣿⡏⠉⠳⢤⡉⢺⣿⡆⠀⠉⠂⠀⠀⠀⠀
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⣹⣿⣶⣝⠿⣿⣿⣿⢿⣿⣿⣿⣿⡇⠀⠀⠀⠙⣾⣿⢻⡄⠀⠀⠀⠀⠀⠀
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠙⣿⣿⣷⣌⠛⢿⣌⢻⣿⣿⣿⣿⣷⣴⡤⠀⣿⣿⢰⣿⠀⠀⠀⠀⠀⠀
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⡘⢿⣿⣿⣿⣦⡙⠿⣿⣿⣿⣿⣿⣿⠀⠀⣿⣿⣾⣿⣷⠀⠀⠀⠀⠀
*/
