package tiempos_ordenamientos;

import javax.swing.*;

public class MainOrdenamiento {

    private static int nRegistros;

    public static void main(String[] main) {

        boolean errorProceso = CantidadRegistros();
        if (!errorProceso) {
            MensajeDeOrdenamiento();
            Ordenamiento datosOrdenamiento = new Ordenamiento();
            int[] datosAleatorios = datosOrdenamiento.ArregloAleatorio(nRegistros, 1, 1000000);
            long ejecucionQuickSort = TiempoEjecucionQuickSort(datosAleatorios);
            long ejecucionBurbuja = TiempoEjecucionBurbuja(datosAleatorios);
            long ejecucionShell = TiempoEjecucionShell(datosAleatorios);
            long ejecucionInsercion = TiempoEjecucionInsercion(datosAleatorios);
            String resultado = "|\tMetodo\t|     Tiempo de Ordenamiento\t|\n";
            resultado += "---------------------------------------------------------------------------------\n";
            resultado += "|\tQuickSort\t|\t" + ejecucionQuickSort + " ms\t|\n";
            resultado += "|\tBurbuja\t|\t" + ejecucionBurbuja + " ms\t|\n";
            resultado += "|\tShell\t|\t" + ejecucionShell + " ms\t|\n";
            resultado += "|\tInsercion\t|\t" + ejecucionInsercion + " ms\t|\n";
            JOptionPane.showMessageDialog(null, new JTextArea(resultado), "Resultado", JOptionPane.PLAIN_MESSAGE, null);
        } else {
            MensajeCancelar();
        }
    }

    private static boolean CantidadRegistros() {
        boolean salir = false;
        boolean verificacion = false;
        do {
            String texto = "Cantidad de registros:\n1). 1000\n2). 25 000\n3). 50 000\n4). 100 000\n5). 250 000\n6). 500 000\n7). 750 000\n8). 1 000 000\nIngrese una opcion [1-8]:\n";
            String nCantidadRegistro = JOptionPane.showInputDialog(null, texto);
            if (nCantidadRegistro == null) {
                salir = true;
            } else if (nCantidadRegistro.equals("")) {
                JOptionPane.showMessageDialog(null, "Ingresa un opción");
            } else if (EsEntero(nCantidadRegistro)) {
                if (Integer.parseInt(nCantidadRegistro) > 0 && Integer.parseInt(nCantidadRegistro) < 9) {
                    OpcionRegistro(Integer.parseInt(nCantidadRegistro));
                    verificacion = true;
                } else {
                    MensajeRango();
                }
            } else {
                MensajeDatosEnteros();
            }
        } while (!verificacion && !salir);
        return salir;
    }

    private static void OpcionRegistro(int n) {
        switch (n) {
            case 1:
                nRegistros = 1000;
                break;
            case 2:
                nRegistros = 25000;
                break;
            case 3:
                nRegistros = 50000;
                break;
            case 4:
                nRegistros = 100000;
                break;
            case 5:
                nRegistros = 250000;
                break;
            case 6:
                nRegistros = 500000;
                break;
            case 7:
                nRegistros = 750000;
                break;
            case 8:
                nRegistros = 1000000;
                break;
        }
    }

    private static long TiempoEjecucionShell(int[] arreglo) {
        long inicioTiempo = System.currentTimeMillis();
        Ordenamiento.Shell(arreglo);
        return System.currentTimeMillis() - inicioTiempo;
    }

    private static long TiempoEjecucionInsercion(int[] arreglo) {
        long inicioTiempo = System.currentTimeMillis();
        Ordenamiento.Insercion(arreglo);
        return System.currentTimeMillis() - inicioTiempo;
    }

    private static long TiempoEjecucionBurbuja(int[] arreglo) {
        long inicioTiempo = System.currentTimeMillis();
        Ordenamiento.Burbuja(arreglo);
        return System.currentTimeMillis() - inicioTiempo;
    }

    private static long TiempoEjecucionQuickSort(int[] arreglo) {
        long inicioTiempo = System.currentTimeMillis();
        Ordenamiento.QuickSort(arreglo, 0, arreglo.length - 1);
        return System.currentTimeMillis() - inicioTiempo;
    }

    private static boolean EsEntero(String dato) {
        boolean verificacion = true;
        try {
            Integer.parseInt(dato);
        } catch (Exception e) {
            verificacion = false;
        }
        return verificacion;
    }

    private static void MensajeDeOrdenamiento() {
        JOptionPane.showMessageDialog(null, "Se comenzará a ordenar los registros.\nEsto puede demorar unos segundos");
    }

    private static void MensajeDatosEnteros() {
        JOptionPane.showMessageDialog(null, "Solo puede ingresar datos enteros!");
    }

    private static void MensajeRango() {
        JOptionPane.showMessageDialog(null, "Ingrese un numero entre [1-8]");
    }

    private static void MensajeCancelar() {
        JOptionPane.showMessageDialog(null, "Acabas de cancelar ...");
    }
}
