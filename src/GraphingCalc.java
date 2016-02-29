import java.applet.*;
import java.awt.*;
import java.util.Scanner;
@SuppressWarnings({ "serial", "unused" })

public class GraphingCalc extends Applet {
	public static int choice = -1; //I cant think of any other way to do this without having "Element doesnt exist", u wanna tussle? Will fix if have time.
	double m, x, b, qa, qb, qc, qx, ca, cb, cc, cd, cx, endx;
	Scanner in = new Scanner(System.in); //Same applies here
	
	public static double getLinear(double m, double x, double b) {
		return (m*x+b); //forgot to remove the comment commenting on poor programming here, including another just to mock myself
	}
	
	public static double getQuadratic(double a, double b, double c, double x) {
		return ((a*Math.pow(x, 2))+(b*x)+(c));
	}
	
	public static double getCubic(double a, double b, double c, double d, double x) {
		return (a*Math.pow(x, 3)+b*Math.pow(x, 2)+c*x+d);
	}
	
	public static double[] getRange() { //just in case I want to use this
		return new double[]{0, 1};
	}
	
	public static void graphLin(Graphics2D g, double m, double x, double b, double endx, int w, int h) {
		g.setStroke(new BasicStroke(3));
		g.setColor(Color.red); //better dead than red? Maybe.
		g.rotate(180); //upside-down otherwise
		g.translate((int)Math.round(w/2), (int)Math.round(h/2)); //sets origin to the middle of the window
		g.drawLine((int)1, (int)Math.round(getLinear(m, 1, b)), (int)Math.round(endx), (int)Math.round(getLinear(m, endx, b)));
	}
	
	public static void graphQua(Graphics2D g, double a, double b, double c, double endx, int w, int h) {
		double x = 0;
		g.setStroke(new BasicStroke(3));
		g.setColor(Color.green);
		g.translate((int)Math.round(w/2), (int)Math.round(h/2));
		g.rotate(180);
		if(endx > 0d) { // - 
			while(x <= endx) {
				g.drawOval((int)Math.round(x), (int)Math.round(getQuadratic(a, b, c, x)), 1, 1);
				x += 0.01;			
			}
			x = 0; //x is not 0 at the end of the other loop
			while(x >= -endx) {
				g.drawOval((int)Math.round(x), (int)Math.round(getQuadratic(a, b, c, x)), 1, 1);
				x -= 0.01;
			}
		}
	}
	
	public static void graphCub(Graphics2D g, double a, double b, double c, double d, double endx, int w, int h) {
		double x = endx-(2*endx);
		g.setColor(Color.cyan); //System.out.println("y = " + );
		g.setStroke(new BasicStroke(1));
		g.translate((int)Math.round(w/2), (int)Math.round(h/2));
		g.scale(2, 2);
		g.rotate(-90); //unlike in the other two equations, the graph does not need to be fully turned around
		if(endx > 0d) { // - 
			while(x <= endx) {
				double ans = getCubic(a, b, c, d, x);
				System.out.println(x + " " + ans);
				g.drawOval((int)Math.round(x), (int)Math.round(ans), 1, 1);
				x += 0.01;
			}
		} else if(endx < 0d) { // +
			while(x >= endx) {
				g.drawOval((int)Math.round(x), (int)Math.round(getCubic(a, b, c, d, x)), 1, 1);
				x -= 0.01;
			}
		}
	}
	
	public void paint(Graphics g) { //twitchwatchespokemon random puu.sh fest!
		System.out.println("Painting..."); //http://puu.sh/noiVd/2a19c637cd.png http://puu.sh/noiVd/2a19c637cd.png
		Graphics2D g2 = (Graphics2D) g; //http://puu.sh/noiYa/480ab20aa4.png http://puu.sh/noiYs/d5f2b25e0b.png
		if(choice==-1) {
			System.out.println("Choose an equation type\n1. Linear\n2. Quadratic\n3. Cubic\n(Input the number)\n");
			choice = in.nextInt();
			switch(choice) {
				case 1:
					System.out.println("Linear\n---------------\n");
					System.out.println("Input m, then x, then b for y = mx+b\n");
					m = in.nextDouble();
					x = in.nextDouble();
					b = in.nextDouble();
					break;
				case 2:
					System.out.println("Quadratic\n---------------\n");
					System.out.println("Input a, b, then c for ax^2 + bx + c\n");
					qa = in.nextDouble();
					qb = in.nextDouble();
					qc = in.nextDouble();
					break;
				case 3:
					System.out.println("Cubic\n---------------");
					System.out.println("Input a, b, c, then d for ax^3 + bx^2 + cx + d");
					ca = in.nextDouble();
					cb = in.nextDouble();
					cc = in.nextDouble();
					cd = in.nextDouble();
					break;
			}
			System.out.println("Choose an end value for x\n");
			endx = in.nextDouble();
		}
		if(choice == 1) {
			System.out.println("x   y\n");
			for(int i = 0; i<=endx; i++) { //prints table of values
				System.out.println(i + " " + getLinear(m, (double)i, b));
			}
			graphLin(g2, m, x, b, endx, getWidth(), getHeight());
		} else if(choice == 2) {
			System.out.println("x   y\n");
			for(int i = 0; i<=endx; i++) { //prints table of values
				System.out.println(i + " " + getQuadratic(qa, qb, qc, (double)i));
			}
			graphQua(g2, qa, qb, qc, endx, getWidth(), getHeight());
		} else if(choice == 3) {
			System.out.println("x   y\n");
			for(int i = 0; i<=endx; i++) { //prints table of values
				System.out.println(i + " " + getCubic(ca, cb, cc, cd, (double)i));
			}
			graphCub(g2, ca, cb, cc, cd, endx, getWidth(), getHeight());
		} else {
			System.out.println("No input yet...");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("In main");
		GraphingCalc calc = new GraphingCalc();
		Graphics g = calc.getGraphics();
	}
}
