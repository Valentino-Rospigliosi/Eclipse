package semana_07;

public class ArregloTemperaturas {

	private double[] temperatura;
	private int indice;

	public ArregloTemperaturas() {
		temperatura = new double[10];
		indice = 0;
	}

	public int tamanio() {
		return indice;
	}

	public double obtener(int i) {
		return temperatura[i];
	}

	public void adicionar(double numero) {
		if (indice == temperatura.length)
			ampliarArreglo();
		temperatura[indice] = numero;
		indice++;
	}

	public void eliminarAlFinal() {
		indice--;
	}

	public void eliminarTodo() {
		indice = 0;
	}

	public void eliminar(int posicion) {
		if (posicion >= 0 && posicion < indice) {
			for (int i = posicion; i < indice - 1; i++) {
				temperatura[i] = temperatura[i + 1];
			}
			indice--;
		}
	}

	public void remplazar(int posicion, double nuevoValor) {
		if (posicion >= 0 && posicion < indice) {
			temperatura[posicion] = nuevoValor;
		}
	}

	private void ampliarArreglo() {
		double[] aux = temperatura;
		temperatura = new double[indice + 10];
		for (int i = 0; i < indice; i++) {
			temperatura[i] = aux[i];
		}
	}

	public int posPrimeraTemperaturaFebril() {
		for (int i = 0; i < indice; i++) {
			if (temperatura[i] > 37.2) {
				return i;
			}
		}
		return -1;
	}

	public int buscarUltimaTemperaturaFebril() {
		for (int i = indice - 1; i >= 0; i--) {
			if (temperatura[i] > 37.2) {
				return i;
			}
		}
		return -1;
	}

	public double temperaturaPromedio() {
		double suma = 0;
		for (int i = 0; i < indice; i++) {
			suma += temperatura[i];
		}
		if (indice > 0) {
			return suma / indice;
		} else {
			return 0;
		}
	}
}
