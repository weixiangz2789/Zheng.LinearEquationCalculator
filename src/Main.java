import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome!");
        System.out.println("Enter coordinate 1: ");
        String coord1 = scan.nextLine();
        System.out.println("Enter coordinate 2: ");
        String coord2 = scan.nextLine();


        int index = coord1.indexOf(",");
        int index1 = coord1.indexOf(")");
        int index2 = coord2.indexOf(",");
        int index3 = coord2.indexOf(")");

        int x1 = Integer.parseInt(coord1.substring(1, index));
        int y1 = Integer.parseInt(coord1.substring(index + 2, index1));
        int x2 = Integer.parseInt(coord2.substring(1, index2));
        int y2 = Integer.parseInt(coord2.substring(index2 + 2, index3));

        if (x1 == x2) {
            System.out.println("These points on a vertical line: x = " + x1);
        } else {
            LinearEquation calc = new LinearEquation(x1, y1, x2, y2);
            System.out.println(calc.lineInfo());
            System.out.println("Enter a value for x:");
            double temp = scan.nextDouble();
            System.out.println();
            System.out.println("The point on the line is: " + calc.coordinateForX(temp));
        }
    }
}