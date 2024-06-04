package trabajoPractico;

public class Conjunto implements ConjuntoTDA {
    private int[] elementos;
    private int cantidad;

    public void InicializarConjunto() {
        elementos = new int[100]; // Tamaño máximo del conjunto
        cantidad = 0;
    }

    public void Agregar(int x) {
        if (!Pertenece(x)) {
            elementos[cantidad] = x;
            cantidad++;
        }
    }

    public int Elegir() {
        if (cantidad > 0) {
            return elementos[cantidad - 1]; // Devuelve el último elemento agregado
        }
        return 0;
    }

    public boolean ConjuntoVacio() {
        return cantidad == 0;
    }

    public void Sacar(int x) {
        for (int i = 0; i < cantidad; i++) {
            if (elementos[i] == x) {
                elementos[i] = elementos[cantidad - 1];
                cantidad--;
                return;
            }
        }
    }

    public boolean Pertenece(int x) {
        for (int i = 0; i < cantidad; i++) {
            if (elementos[i] == x) {
                return true;
            }
        }
        return false;
    }

    public int[] ObtenerElementos() {
        int[] resultado = new int[cantidad];
        System.arraycopy(elementos, 0, resultado, 0, cantidad);
        return resultado;
    }
}
