import java.util.Arrays;
import java.util.Scanner;

public class Challenge2 {
    
    /**
     * Calculates the maximum amount of money that the thief can steal without setting off the alarms, 
     * i.e. in non-adjacent items
     * @param nums An array of of numbers representing the money of each house
     * @return the maximum amount of money stolen
     */
    public static int findMaxSum(int[] nums) {
        int inclusive = 0;
        int exclusive = 0;

        for (int num : nums) {
            int temp = inclusive;
            inclusive = Math.max(inclusive, exclusive + num);
            exclusive = temp;
        }

        return Math.max(inclusive, exclusive);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input arreglo: ");
        String input = scanner.nextLine();

        // Eliminar los corchetes y espacios en blanco
        input = input.replaceAll("\\[|\\]|\\s", "");

        // Dividir la cadena en elementos separados por coma
        String[] elementos = input.split(",");

        // Convertir los elementos de cadena a enteros
        int[] arreglo = Arrays.stream(elementos)
                             .mapToInt(Integer::parseInt)
                             .toArray();



        scanner.close();

        System.out.println("Output: "+findMaxSum(arreglo));


        /* int[] arr1 = {1, 2, 3, 1};
        System.out.println("El resultado para [1, 2, 3, 1] es: " + findMaxSum(arr1));

        int[] arr2 = {2, 7, 9, 3, 1};
        System.out.println("El resultado para [2, 7, 9, 3, 1] es: " + findMaxSum(arr2));

        int[] arr3 = {10, 1, 1, 10};
        System.out.println("El resultado para [10, 1, 1, 10] es: " + findMaxSum(arr3)); */
    }
}
