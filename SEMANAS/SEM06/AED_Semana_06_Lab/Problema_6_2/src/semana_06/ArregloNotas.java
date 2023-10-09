package semana_06;

public class ArregloNotas {
	private int[] nota;
	private int indice;

	public ArregloNotas() {
		nota = new int[10];
		indice = 0;
	}

	public int tamanio() {
		return indice;
	}

	public int obtener(int posicion) {
		if (posicion >= 0 && posicion < indice) {
			return nota[posicion];
		} else {
			throw new IllegalArgumentException("Posición fuera de rango");
		}
	}

	private void ampliarArreglo() {
		int[] nuevoArreglo = new int[nota.length + 10];
		System.arraycopy(nota, 0, nuevoArreglo, 0, nota.length);
		nota = nuevoArreglo;
	}

	public void adicionar(int nuevaNota) {
		if (indice == nota.length) {
			ampliarArreglo();
		}
		nota[indice] = nuevaNota;
		indice++;
	}

	public void eliminarAlFinal() {
		if (indice > 0) {
			indice--;
		} else {
			throw new IllegalStateException("El arreglo está vacío");
		}
	}

	public void eliminarTodo() {
		indice = 0;
	}

	public int posUltimaNotaDesaprobatoria() {
		for (int i = indice - 1; i >= 0; i--) {
			if (nota[i] < 13) {
				return i;
			}
		}
		return -1;
	}

	public void decrementarUltimaNotaDesaprobatoria() {
		int posUltimaDesaprobatoria = posUltimaNotaDesaprobatoria();
		if (posUltimaDesaprobatoria != -1) {
			nota[posUltimaDesaprobatoria] -= 2;
			if (nota[posUltimaDesaprobatoria] < 0) {
				nota[posUltimaDesaprobatoria] = 0;
			}
		} else {
			throw new IllegalStateException("No hay notas desaprobatorias para decrementar");
		}
	}

	public void remplazarUltimaNotaDesaprobatoria() {
		int posUltimaDesaprobatoria = posUltimaNotaDesaprobatoria();
		if (posUltimaDesaprobatoria != -1) {
			nota[posUltimaDesaprobatoria] = nota[indice - 1];
		} else {
			throw new IllegalStateException("No hay notas desaprobatorias para reemplazar");
		}
	}
}
