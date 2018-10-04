package tiempos_ordenamientos;

public class Ordenamiento {

    int[] ArregloAleatorio(int tamaño, int min, int max) {
        int[] arreglo = new int[tamaño];
        for (int x = 0; x < tamaño; x++) {
            arreglo[x] = NumeroAleatorio(min, max);
        }
        return arreglo;
    }

    int NumeroAleatorio(int minimo, int maximo) {
        return (int) (Math.random() * (maximo - minimo));
    }

    static void QuickSort(int[] arreglo, int izquierda, int derecha) {
        int pivote, i, j, auxintercambio;
        pivote = arreglo[izquierda];
        i = izquierda;
        j = derecha;
        while (i < j) {
            while (arreglo[i] <= pivote && i < j) {
                i++;
            }
            while (arreglo[j] > pivote) {
                j--;
            }
            if (i < j) {
                auxintercambio = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = auxintercambio;
            }
        }
        arreglo[izquierda] = arreglo[j];
        arreglo[j] = pivote;
        if (izquierda < j - 1) {
            QuickSort(arreglo, izquierda, j - 1);
        }
        if (j + 1 < derecha) {
            QuickSort(arreglo, j + 1, derecha);
        }
    }

    static void Burbuja(int[] arreglo) {
        int i, j, aux;
        for (i = 0; i < arreglo.length - 1; i++) {
            for (j = 0; j < arreglo.length - i - 1; j++) {
                if (arreglo[j + 1] < arreglo[j]) {
                    aux = arreglo[j + 1];
                    arreglo[j + 1] = arreglo[j];
                    arreglo[j] = aux;
                }
            }
        }
    }

    static void Shell(int[] arreglo) {
        int n = arreglo.length;
        int i = n;
        do {
            i = i / 2;
            for (int x = 0; x < i; x++) {
                for (int y = i + x; y < n; y += i) {
                    int j = y;
                    while (j - i >= 0 && arreglo[j] < arreglo[j - i]) {
                        int tmp = arreglo[j];
                        arreglo[j] = arreglo[j - i];
                        arreglo[j - i] = tmp;
                        j -= i;
                    }
                }
            }
        } while (i > 1);
    }

    static void Insercion(int[] arreglo) {
        for (int x = 1; x < arreglo.length; x++) {
            int aux = arreglo[x];
            int y;
            for (y = x - 1; (y >= 0) && (arreglo[y] > aux); y--) {
                arreglo[y + 1] = arreglo[y];
            }
            arreglo[y + 1] = aux;
        }
    }
}
