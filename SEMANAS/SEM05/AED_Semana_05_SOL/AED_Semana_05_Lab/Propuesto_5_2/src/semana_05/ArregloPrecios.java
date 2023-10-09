package semana_05;

public class ArregloPrecios {
	private double[] precio = { 240.5, 350.2, 80.4, 100.3, 470.1, 60.0, 330.8, 260.6, 510.9, 200.7 };

	public ArregloPrecios() {
	}

	public int tamanio() {
		return precio.length;
	}

	public double obtener(int posicion) {
		return precio[posicion];
	}

	public double precioPromedio() {
		double suma = 0;
		for (int i = 0; i < tamanio(); i++) {
			suma += precio[i];
		}
		return suma / tamanio();
	}

	public double precioMayor() {
		double mayor = precio[0];
		for (int i = 1; i < tamanio(); i++) {
			if (precio[i] > mayor) {
				mayor = precio[i];
			}
		}
		return mayor;
	}

	public double precioMenor() {
		double menor = precio[0];
		for (int i = 1; i < tamanio(); i++) {
			if (precio[i] < menor) {
				menor = precio[i];
			}
		}
		return menor;
	}

	public int cantMayoresPrecioPromedio() {
		double promedio = precioPromedio();
		int contador = 0;
		for (int i = 0; i < tamanio(); i++) {
			if (precio[i] >= promedio) {
				contador++;
			}
		}
		return contador;
	}

	public int cantMenoresPrecioPromedio() {
		double promedio = precioPromedio();
		int contador = 0;
		for (int i = 0; i < tamanio(); i++) {
			if (precio[i] < promedio) {
				contador++;
			}
		}
		return contador;
	}

	public int posPrimerPrecioMayorAlSegundo(double primerPrecio, double segundoPrecio) {
		for (int i = 0; i < tamanio(); i++) {
			if (precio[i] > primerPrecio && precio[i] > segundoPrecio) {
				return i;
			}
		}
		return -1;
	}

	public int posUltimoPrecioMenorAlPenultimo() {
		double penultimo = precio[tamanio() - 2];
		for (int i = tamanio() - 1; i >= 0; i--) {
			if (precio[i] < penultimo) {
				return i;
			}
		}
		return -1;
	}

	public void generarPrecios() {
		for (int i = 0; i < tamanio(); i++) {
			precio[i] = aleatorio(99.9, 999.9);
		}
	}

	private double aleatorio(double min, double max) {
		return (Math.random() * (max - min + 1)) + min;
	}
}
