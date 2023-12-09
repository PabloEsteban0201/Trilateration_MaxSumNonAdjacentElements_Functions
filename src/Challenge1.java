import java.util.Locale;
import java.util.Scanner;

public class Challenge1 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.println("Ingresa las posiciones de los satelites: ");

        double distance1 = scanner.nextDouble();
        double distance2 = scanner.nextDouble();
        double distance3 = scanner.nextDouble();

        scanner.close();

        double[] distances = {distance1,distance2,distance3};

        getLocation(distances);
    }

    /**
     * Calculates the location of the vehicle by solving the system of equations
     * @param distances An array of the distances captured by the satellites
     * @return The position of the vehicle in form of an array [x,y]
     * @return Null if the position could not be found
     */
    public static double[] getLocation(double distances[]) {

        // Coordenadas de los satélites
        double x1 = -500;
        double y1 = -200;
        double x2 = 100;
        double y2 = -100;
        double x3 = 500;
        double y3 = 100;

        //Para probar con un punto exacto
        /* double x1 = 0;
        double y1 = 0;
        double x2 = 100;
        double y2 = 100;
        double x3 = 100;
        double y3 = -100; */

        // Distancias desde los satélites al transporte
        double d1 = distances[0];
        double d2 = distances[1];
        double d3 = distances[2];

        // Resolver el sistema de ecuaciones
        double x, y;

        double A = 2 * (x2 - x1);
        double B = 2 * (y2 - y1);
        double C = 2 * (x3 - x1);
        double D = 2 * (y3 - y1);

        double E = d1 * d1 - d2 * d2 - x1 * x1 + x2 * x2 - y1 * y1 + y2 * y2;
        double F = d1 * d1 - d3 * d3 - x1 * x1 + x3 * x3 - y1 * y1 + y3 * y3;

        // Calcular las coordenadas del transporte
        x = (E - F * D / B) / (A - C * D / B);
        y = (E - A * x) / B;

        //Comprobación
        boolean eq1= Math.pow((x-x1), 2) +Math.pow((y-y1), 2) == Math.pow(d1, 2);
        boolean eq2= Math.pow((x-x2), 2) +Math.pow((y-y2), 2) == Math.pow(d2, 2);
        boolean eq3= Math.pow((x-x3), 2) +Math.pow((y-y3), 2) == Math.pow(d3, 2);

        double[] position = new double[2];

        if(eq1==false || eq2==false || eq3==false ){
            System.out.println("No es posible encontrar la ubicación");
            return null;
        }else{
    // Imprimir las coordenadas del transporte
            System.out.println("Output: ");
            System.out.println(x);
            System.out.println(y);

            position[0]=x;
            position[1]=y;
        }

        

        return position;
    }

}
