package ar.unlam.git;

import java.util.Scanner;

public class SalaDeCine {

    final static Scanner scanner = new Scanner(System.in);
    static Cine cine;
    
	// PUNTO 2 "2. Consultar si la sala está vacía."
    private static void salaEstaVacia() {
    	cine.salaEstaVacia();
    }
    
	// PUNTO 3 "3. Consultar si una butaca está ocupada (referida por fila y asiento)"
    private static void verAsientoOcupado() {
    	boolean flag;
    	int verFila, verColumna;
    	do {
    		System.out.println("Ingrese numero de la fila");
    		verFila = scanner.nextInt();
    		System.out.println("Ingrese numero de la Columna");
    		verColumna = scanner.nextInt();
    		flag = cine.verAsientoOcupado(verFila, verColumna);
    	} while (!flag);
    	
    	//cine.verAsientoOcupado(verFila, verColumna);
    }
    
	// PUNTO 4 "4. Ocupar una butaca determinada, siempre que ésta no esté previamenteocupada."
    private static void comprarAsiento() {
        boolean flag;
        int comprarFila;
        int comprarColumna;
        do {
            System.out.println("Ingrese numero de filas");
            comprarFila = scanner.nextInt();
            System.out.println("Ingrese numero de Columnas");
            comprarColumna = scanner.nextInt();
            flag = cine.verificarAsiento(comprarFila, comprarColumna);
        } while (!flag);
        cine.comprarAsiento(comprarFila, comprarColumna);
        System.out.println("\nCompra realizada con exito");
    }
    
	// PUNTO 5 "5. Consultar la cantidad total de butacas ocupadas"
    private static void totalDeAsientosOcupados() {
    	cine.totalDeAsientosOcupados();
    }
    
	// PUNTO 6 "6. Consultar si es posible acomodar a un grupo de X personas, en forma contigua, en la misma fila:"
    private static void hayEspacioPara() {
    	int cantidadPersonas;
    	System.out.println("Ingrese cantidad de personas que desea acomodar");
    	cantidadPersonas = scanner.nextInt();
    	if (cantidadPersonas > 1) {
    	cine.hayEspacioPara(cantidadPersonas);}
    	else {
        	System.out.println("Ingrese una cantidad mayor a 1 persona");
    	}
    }

    public static void main(String[] args) {
    	// PUNTO 1 "1. Crearla con la cantidad de butacas totales y cantidad de filas"
        String menu = "\n1. Consultar si la sala esta vacia\n" +
                "2. Consultar si una butaca esta ocupada\n" +
                "3. Comprar butaca\n" +
                "4. Consultar la cantidad total de butacas ocupadas\n" +
                "5. Consultar si es posible acomodar a un grupo de X personas, en forma contigua, en la misma fila:\n"
                + "\n" +
                "6. Salir";

        System.out.println("\nSe creara una Sala de Cine\n");
        System.out.println("Ingrese filas");
        int filas = scanner.nextInt();
        System.out.println("Ingrese Columnas");
        int columnas = scanner.nextInt();

        cine = new Cine(filas, columnas);
        cine.llenarSalaDeAsientos();
        cine.ImprimirSala();

        int opcion;
        do {
            System.out.println(menu);
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                	salaEstaVacia();// llamada al metodo para verificar la sala
                    break;
                case 2:
                	verAsientoOcupado(); // llamada al metodo verificar un asiento
                    break;
                case 3:
                    comprarAsiento(); // llamada al metodo para comprar asiento
                    cine.ImprimirSala();
                    break;
                case 4:
                	totalDeAsientosOcupados(); // llamada al metodo para ver el total de asientos ocupados
                    break;
                case 5:
                	hayEspacioPara(); // llamada al metodo para ver si se puede acomodar un grupo de personas
                	break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (opcion != 6);
    }
}
