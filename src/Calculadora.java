
/**
 * Clase Calculadora
 * -----------------
 * Esta clase proporciona varios métodos para realizar operaciones matemáticas básicas,
 * como suma, resta, multiplicación, división, potencia y raíz cuadrada.
 * 
 * Permite trabajar con números de tipo double y maneja casos especiales,
 * como división entre cero o el intento de calcular la raíz cuadrada de un número negativo,
 * lanzando excepciones adecuadas en esos casos.
 * 
 * También incluye un método main() con ejemplos de uso para probar su funcionamiento.
 * @author Adrian Herrera
 * @version 1.0
 */
public class Calculadora {

    /**
     * Método para sumar dos números.
     * @param a primer número
     * @param b segundo número
     * @return la suma de a y b
     */
    public double sumar(double a, double b) {
        return a + b;
    }

    /**
     * Método para restar dos números.
     * @param a primer número
     * @param b segundo número
     * @return la resta de a menos b
     */
    public double restar(double a, double b) {
        return a - b;
    }

    /**
     * Método para multiplicar dos números.
     * @param a primer número
     * @param b segundo número
     * @return el producto de a y b
     */
    public double multiplicar(double a, double b) {
        return a * b;
    }

    /**
     * Método para dividir dos números.
     * @param a numerador
     * @param b denominador
     * @return el cociente de a entre b
     * @throws ArithmeticException si b es igual a 0
     */
    public double dividir(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Error: no se puede dividir entre cero.");
        }
        return a / b;
    }

    /**
     * Método para calcular la potencia de un número.
     * @param base número base
     * @param exponente exponente al que se eleva la base
     * @return base elevada a la potencia exponente
     */
    public double potencia(double base, double exponente) {
        return Math.pow(base, exponente);
    }

    /**
     * Método para calcular la raíz cuadrada de un número.
     * @param numero número al cual se le calculará la raíz cuadrada
     * @return la raíz cuadrada del número
     * @throws IllegalArgumentException si el número es negativo
     */
    public double raizCuadrada(double numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("Error: no se puede calcular la raíz cuadrada de un número negativo.");
        }
        return Math.sqrt(numero);
    }

    // Método principal para probar la clase
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        System.out.println("Suma: " + calc.sumar(5, 3));
        System.out.println("Resta: " + calc.restar(5, 3));
        System.out.println("Multiplicación: " + calc.multiplicar(5, 3));
        System.out.println("División: " + calc.dividir(5, 3));
        System.out.println("Potencia: " + calc.potencia(2, 3));
        System.out.println("Raíz cuadrada: " + calc.raizCuadrada(16));
    }
}