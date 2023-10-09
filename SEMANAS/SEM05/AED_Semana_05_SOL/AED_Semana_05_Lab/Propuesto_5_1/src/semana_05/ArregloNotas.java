package semana_05;

public class ArregloNotas {
	private int[] nota = { 11, 10, 16, 18, 15, 13, 20, 12, 19, 17 };

	public ArregloNotas() {
	}

	public int tamanio() {
		return nota.length;
	}

	public int obtener(int posicion) {
		return nota[posicion];
	}

	public double notaPromedio() {
		int suma = 0;
		for (int i = 0; i < tamanio(); i++) {
			suma += nota[i];
		}
		return (double) suma / tamanio();
	}

	public int notaMayor() {
		int mayor = nota[0];
		for (int i = 1; i < tamanio(); i++) {
			if (nota[i] > mayor) {
				mayor = nota[i];
			}
		}
		return mayor;
	}

	public int notaMenor() {
		int menor = nota[0];
		for (int i = 1; i < tamanio(); i++) {
			if (nota[i] < menor) {
				menor = nota[i];
			}
		}
		return menor;
	}

	public int cantNotasAprobatorias() {
		int contador = 0;
		for (int i = 0; i < tamanio(); i++) {
			if (nota[i] >= 13) {
				contador++;
			}
		}
		return contador;
	}

	public int cantNotasDesaprobatorias() {
		int contador = 0;
		for (int i = 0; i < tamanio(); i++) {
			if (nota[i] < 13) {
				contador++;
			}
		}
		return contador;
	}

	public int cantNotasMayoresA15() {
		int contador = 0;
		for (int i = 0; i < tamanio(); i++) {
			if (nota[i] > 15) {
				contador++;
			}
		}
		return contador;
	}

	public int posPrimeraNotaAprobatoria() {
		for (int i = 0; i < tamanio(); i++) {
			if (nota[i] >= 13) {
				return i;
			}
		}
		return -1;
	}

	public int posPenultimaNotaDesaprobatoria() {
		int ultimaPosicion = -1;
		for (int i = 0; i < tamanio(); i++) {
			if (nota[i] < 13) {
				ultimaPosicion = i;
			}
		}
		return ultimaPosicion;
	}

	public void generarNotas() {
		for (int i = 0; i < tamanio(); i++) {
			nota[i] = aleatorio(0, 20);
		}
	}

	private int aleatorio(int min, int max) {
		return (int) ((max - min + 1) * Math.random()) + min;
	}
}
