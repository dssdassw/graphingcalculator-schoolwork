import java.applet.*;

@SuppressWarnings("serial")
public class GraphingCalc extends Applet {
	public static double getLinear(double m, double x, double b) {
		return (m*x+b); //resource leak?
	}
	public static double getQuadratic(double a, double b, double c, double x) {
		return (a*Math.pow(x, 2)+b*x+c);
	}
	public static double getCubic(double a, double b, double c, double d, double x) {
		return (a*Math.pow(x, 3)+b*Math.pow(x, 2)+c*x+d);
	}
}
