package semana_06;

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

	public void adicionar(double temp) {
		if (indice == temperatura.length) {
			ampliarArreglo();
		}
		temperatura[indice] = temp;
		indice++;
	}

	public void eliminarAlFinal() {
		if (indice > 0) {
			indice--;
		}
	}

	public void eliminarTodo() {
		indice = 0;
	}

	public double temperaturaMenor() {
		if (indice == 0) {
			throw new IllegalStateException("El arreglo está vacío.");
		}
		double menor = temperatura[0];
		for (int i = 1; i < indice; i++) {
			if (temperatura[i] < menor) {
				menor = temperatura[i];
			}
		}
		return menor;
	}

	public int posPrimeraTemperaturaNormal() {
		for (int i = 0; i < indice; i++) {
			if (temperatura[i] >= 36.1 && temperatura[i] <= 37.2) {
				return i;
			}
		}
		return -1;
	}

	public void remplazarPrimeraTemperaturaNormal() {
		int pos = posPrimeraTemperaturaNormal();
		if (pos != -1) {
			double menorTemp = temperaturaMenor();
			temperatura[pos] = menorTemp;
		}
	}

	public void incrementarTemperaturas() {
		for (int i = 0; i < indice; i++) {
			temperatura[i] += 0.2;
		}
	}

	private void ampliarArreglo() {
		double[] aux = temperatura;
		temperatura = new double[indice + 10];
		System.arraycopy(aux, 0, temperatura, 0, indice);
	}
}
