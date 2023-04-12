package ar.unlam.git;


public class Cine {
	private final int columna;
	private final int fila;
	private String[][] sala;

	public Cine (int fila, int columna) {
		this.fila = fila;
		this.columna = columna;
		this.sala = new String [fila + 1 ] [columna + 1];
	}
	
	public void llenarSalaDeAsientos() {
		for (int i = 0; i < sala.length; i++) {
			for (int j = 0; j < sala[0].length; j ++) {
				if (i == 0 && j == 0) sala[i][j] = " ";
				else if (i == 0) sala[i][j] = String.valueOf(j);
				else if (j == 0) sala[i][j] = String.valueOf(i);
				else sala[i][j] = "A";
			}
		}
	}
	
	public int getFila() {
		return fila;
	}
	
	public int getColumna() {
		return columna;
	}
	
	// PUNTO 1 "1. Crearla con la cantidad de butacas totales y cantidad de filas"
	public void ImprimirSala() { 
		System.out.println ("\nSala de cine: \n");
		for (String[] asientos : sala) {
			for (int j = 0; j < sala[0].length; j++) {
				System.out.print(asientos[j] + " ");
			}
			System.out.print("\n\n");
		}
	}

	// PUNTO 2 "2. Consultar si la sala está vacía."
	public boolean salaEstaVacia() { 
	    for (int i = 0; i < sala.length; i++) {
	        for (int j = 0; j < sala[0].length; j ++) {
	            if (sala[i][j].equals("O")) {
	                System.out.println("\nLa sala no esta vacia\n");
	                return false; // hay al menos un asiento ocupado
	            }
	        }
	    }
	    System.out.println("\nLa sala esta completamente vacia\n");
	    return true; // no hay ningún asiento ocupado
	}
	
	// PUNTO 3 "3. Consultar si una butaca está ocupada (referida por fila y asiento)"
	public boolean verAsientoOcupado(int verFila, int verColumna) { 
		if (verFila <= 0 || verFila > fila || verColumna <= 0 || verColumna > columna) {
			System.out.println("\nVerifique su entrada\n");
			return false;
		} else if (sala[verFila][verColumna].equals("O")) {
			System.out.println("\nEse asiento ya fue ocupado\n");
		} else {
			System.out.println("\nEse asiento esta libre\n");
		}
		return true;
	}

	// PUNTO 4 "4. Ocupar una butaca determinada, siempre que ésta no esté previamenteocupada."
	public void comprarAsiento(int comprarFila, int comprarColumna){
		sala[comprarFila][comprarColumna] = "O";
	}
	
	public boolean verificarAsiento(int comprarFila, int comprarColumna){
		boolean verificar = comprarFila > fila ||
							comprarColumna > columna ||
							comprarFila == 0 ||
							comprarColumna == 0;
		if (verificar) {
			System.out.println("\nVerifique la sala, numero de fila y de columnas incorrectos\n");
			return false;
		} else if (sala[comprarFila][comprarColumna].equals("O")) {
			System.out.println("\nEste asiento esta ocupado\n");
			return false;
		}
		return true;
	}
	
	// PUNTO 5 "5. Consultar la cantidad total de butacas ocupadas"
	public int totalDeAsientosOcupados() {
	    int ocupados = 0;
	    for (int i = 0; i < sala.length; i++) {
	        for (int j = 0; j < sala[0].length; j ++) {
	            if (sala[i][j].equals("O")) {
	                ocupados++;
	            }
	        }
	    }
	    if (ocupados == 0) {
	        System.out.println("\nLa sala esta completamente vacia\n");
	    } else {
	        System.out.println("\nLa sala tiene " + ocupados + " asientos ocupados\n");
	    }
	    return ocupados;
	}

	// PUNTO 6 "6. Consultar si es posible acomodar a un grupo de X personas, en forma contigua, en la misma fila:"
	public void hayEspacioPara(int cantidadPersonas) {
	    boolean encontrado = false;
	    for (int i = 1; i < sala.length; i++) {
	        int asientosOcupados = 0;
	        int primerAsientoLibre = -1;
	        for (int j = 1; j < sala[0].length; j++) {
	            if (!sala[i][j].equals("O")) {
	                asientosOcupados = 0;
	                primerAsientoLibre = -1;
	            } else {
	                if (primerAsientoLibre == -1) {
	                    primerAsientoLibre = j;
	                }
	                asientosOcupados++;
	                if (asientosOcupados == cantidadPersonas) {
	                    encontrado = true;
	                    int ultimoAsientoLibre = j;
	                    System.out.println("Se puede acomodar a " + cantidadPersonas + " personas en la fila " + i + " desde el asiento " + primerAsientoLibre + " hasta el asiento " + ultimoAsientoLibre);
	                    break;
	                }
	            }
	        }
	        if (encontrado) {
	            break;
	        }
	    }
	    if (!encontrado) {
	        System.out.println("No es posible acomodar a ninguna personas en forma contigua en la misma fila");
	    }
	}


}

