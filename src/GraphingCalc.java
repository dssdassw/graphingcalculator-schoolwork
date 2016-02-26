import java.applet.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;


@SuppressWarnings("serial")

public class GraphingCalc extends Applet {
	public static int choice = -1; //I cant think of any other way to do this without having "Element doesnt exist", u wanna tussle? Will fix if have time.
	public static double getLinear(double m, double x, double b) {
		return (m*x+b); //forgot to remove the comment commenting on poor programming here, including another just to mock myself
	}
	public static double getQuadratic(double a, double b, double c, double x) {
		return (a*Math.pow(x, 2)+b*x+c);
	}
	public static double getCubic(double a, double b, double c, double d, double x) {
		return (a*Math.pow(x, 3)+b*Math.pow(x, 2)+c*x+d);
	}
	public static double[] getRange() { //just in case I want to use this
		return new double[]{0, 1};
	}
	public static void graphLin(Graphics g, double m, double x, double b) {
		System.out.println("Linear\n---------------\n");
		System.out.print("Enter m, then x, then b for y = mx+b\n");
		System.out.println("y = " + getLinear(m, x, b));
		g.setColor(Color.red); //better dead than red? Maybe.
		double todo=getLinear(m, x, b);
		todo = getLinear(m, x+100, b);
		System.out.println(todo);
		g.translate((int)x, (int)getLinear(m, x, b));
		g.drawLine((int) (x), (int)getLinear(m, (x), b), (int)x+100, (int)getLinear(m, x+100, b)); //a little convoluted but fuck it
	}
	public static void graphQua(Graphics g) {
		Scanner in = new Scanner(System.in);
		System.out.println("Quadratic\n---------------\n");
		System.out.print("For ax^2+bx+c, enter a, b, c, then x\n");
		double qa = 1d; qa = in.nextDouble();
		double qb = 2d; qb = in.nextDouble();
		double qc = 3d; qc = in.nextDouble();
		double qx = 4d; qx = in.nextDouble();
		in.close();
		System.out.println("y = " + getQuadratic(qa, qb, qc, qx));
		g.setColor(Color.green);
	}
	public static void graphCub(Graphics g) {
		
	}
	public void paint(Graphics g) {
		System.out.println("Painting");
		Scanner in = new Scanner(System.in);
		double m = 2d; double x = 1d; double b = 3d; double ca = 1d; double cb = 2d; double cc = 3d; double cd = 4d; double cx = 5d;
		if(choice==-1) { //"init" and also SHITTY FORM
			System.out.println("Choose an equation type\n1. Linear\n2. Quadratic\n3. Cubic\n(Input the number)\n");
			choice = in.nextInt();
			System.out.println(choice);
			switch(choice) {
				case 1:
					System.out.println("Input m, then x, then b for y = mx+b");
					m = in.nextDouble();
					x = in.nextDouble();
					b = in.nextDouble();
					break;
				case 2:
					break;
				case 3:
					break;
			}
			System.out.println(choice);
		}
		System.out.println(choice);
		switch(choice) {
			case 1:
				graphLin(g, m, x, b);
				break;
			case 2:
				break;
			case 3:
				System.out.println("Cubic\n---------------\n");
				System.out.print("For ax^3+bx*2+cx+d, enter a, b, c, d, then x\n");
				ca = in.nextDouble();
				cb = in.nextDouble();
				cc = in.nextDouble();
				cd = in.nextDouble();
				cx = in.nextDouble();
				System.out.println("y = " + getCubic(ca, cb, cc, cd, cx));
				break;
			default: //in case the user is a cheeky bastard
				System.out.println("Moronic\n---------------\nyou");
				break;
		}
	}
	public static void main(String[] args) {
		GraphingCalc calc = new GraphingCalc();
		Graphics g = calc.getGraphics();
	}
}
