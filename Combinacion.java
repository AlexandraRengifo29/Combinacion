import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Combinacion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cadenaAlfabetica = "";
        String cadenaNumerica = "";

        while (cadenaAlfabetica.isEmpty()) {
            System.out.print("Ingrese la cadena alfabética: ");
            cadenaAlfabetica = scanner.nextLine();
            if (!esCadenaAlfabeticaValida(cadenaAlfabetica)) {
                System.out.println("Por favor, ingrese una cadena alfabética válida.");
                cadenaAlfabetica = "";
            }
        }

        while (cadenaNumerica.isEmpty() || cadenaNumerica.length() < 2) {
            System.out.print("Ingrese la cadena numérica (de al menos 2 caracteres): ");
            cadenaNumerica = scanner.nextLine();
            if (!esCadenaNumericaValida(cadenaNumerica)) {
                System.out.println("Por favor, ingrese una cadena numérica válida.");
                cadenaNumerica = "";
            }
        }

        List<String> combinaciones = generarCombinaciones(cadenaAlfabetica, cadenaNumerica);
        for (String combinacion : combinaciones) {
            System.out.println(combinacion);
        }
    }

    public static boolean esCadenaAlfabeticaValida(String cadena) {
        return cadena.matches("^[a-zA-Z]+$");
    }

    public static boolean esCadenaNumericaValida(String cadena) {
        return cadena.matches("^[0-9]+$");
    }

    public static List<String> generarCombinaciones(String cadenaAlfabetica, String cadenaNumerica) {
        List<String> combinaciones = new ArrayList<>();
        List<String> permutacionesNumerica = generarPermutaciones(cadenaNumerica);
        for (String permutacionNumerica : permutacionesNumerica) {
            for (String permutacionAlfabetica : generarPermutaciones(cadenaAlfabetica)) {
                combinaciones.add(permutacionAlfabetica + permutacionNumerica);
            }
        }
        return combinaciones;
    }

    public static List<String> generarPermutaciones(String s) {
        List<String> result = new ArrayList<>();
        permutar("", s, result);
        return result;
    }

    private static void permutar(String prefix, String s, List<String> result) {
        int n = s.length();
        if (n == 0) {
            result.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutar(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, n), result);
            }
        }
    }
}
