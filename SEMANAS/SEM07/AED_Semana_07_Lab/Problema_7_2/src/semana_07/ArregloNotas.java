// En la clase ArregloNotas, agrega los métodos solicitados:

package semana_07;

public class ArregloNotas {

	// Atributos privados
	private int[] nota;
	private int indice;

	// Constructor
	public ArregloNotas() {
		nota = new int[10];
		indice = 0;
	}

	// Operaciones públicas básicas
	public int tamanio() {
		return indice;
	}

	public int obtener(int i) {
		return nota[i];
	}

	public void adicionar(int numero) {
		if (indice == nota.length)
			ampliarArreglo();
		nota[indice] = numero;
		indice++;
	}

	// Operaciones públicas complementarias
	public void eliminarAlFinal() {
		indice--;
	}

	public void eliminarTodo() {
		indice = 0;
	}

	// Operaciones privadas
	private void ampliarArreglo() {
		int[] aux = nota;
		nota = new int[indice + 10];
		for (int i = 0; i < indice; i++)
			nota[i] = aux[i];
	}

	public int notaMenor() {
		if (indice == 0) {
			return -1; // Si el arreglo está vacío, retorna -1
		}
		int menor = nota[0];
		for (int i = 1; i < indice; i++) {
			if (nota[i] < menor) {
				menor = nota[i];
			}
		}
		return menor;
	}

	public int posPrimeraNotaAprobatoria() {
		for (int i = 0; i < indice; i++) {
			if (nota[i] >= 13 && nota[i] <= 20) {
				return i;
			}
		}
		return -1;
	}

	public int posUltimaNotaAprobatoria() {
		for (int i = indice - 1; i >= 0; i--) {
			if (nota[i] >= 13 && nota[i] <= 20) {
				return i;
			}
		}
		return -1;
	}

	public void remplazarUltimaNotaAprobatoria() {
		int posUltimaAprobatoria = posUltimaNotaAprobatoria();
		if (posUltimaAprobatoria != -1) {
			int notaMenor = notaMenor();
			nota[posUltimaAprobatoria] = notaMenor;
		}
	}

	public void eliminarPrimeraNotaAprobatoria() {
		int posPrimeraAprobatoria = posPrimeraNotaAprobatoria();
		if (posPrimeraAprobatoria != -1) {
			eliminar(posPrimeraAprobatoria);
		}
	}

	private void eliminar(int pos) {
		for (int i = pos; i < indice - 1; i++) {
			nota[i] = nota[i + 1];
		}
		indice--;
	}
}
