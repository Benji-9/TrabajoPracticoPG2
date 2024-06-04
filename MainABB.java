package trabajoPractico;

import java.util.Scanner;

public class MainABB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ABB arbol = new ABB();
        arbol.InicializarArbol();

        // Ingreso de elementos al árbol
        System.out.println("Ingrese los elementos del arbol separados por espacios (ejemplo: 20 10 30 5 15 25 35):");
        String[] elementos = scanner.nextLine().split(" ");

        for (String elemento : elementos) {
            int valor = Integer.parseInt(elemento);
            arbol.AgregarElemento(valor);
        }

        // Ingreso del valor k
        System.out.println("Ingrese el valor de k:");
        int k = scanner.nextInt();

        ConjuntoTDA elementosMayores = arbol.ElementosMayoresQue(k);

        System.out.println("Elementos en el arbol mayores que " + k + ":");
        while (!elementosMayores.ConjuntoVacio()) {
            int x = elementosMayores.Elegir();
            System.out.println(x);
            elementosMayores.Sacar(x);
        }

        scanner.close();
    }
}
