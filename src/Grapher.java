import java.applet.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Grapher extends GraphingCalc {
	public static double[] getRange() { //just in case I want to use this
		return new double[]{0, 1};
	}
	public static void graphLin(Graphics g, double m, double x, double b) {
		g.setColor(Color.red); //better dead than red? Maybe.
		for(int i = 0; i<100; i++) {
			x = x++;
			g.drawLine((int) ((int)x-1d), (int)getLinear(m, (x-1d), b), (int)x, (int)getLinear(m, x, b)); //a little convoluted but fuck it
		}
	}
	public static void graphQua(Graphics g) {
		
	}
	public static void graphCub(Graphics g) {
		
	}
}
