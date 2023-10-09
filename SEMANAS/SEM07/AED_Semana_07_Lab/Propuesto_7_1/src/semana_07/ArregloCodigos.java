package semana_07;

public class ArregloCodigos {
	private int[] codigo;
	private int indice;

	public ArregloCodigos() {
		codigo = new int[10];
		indice = 0;
	}

	public int tamaño() {
		return indice;
	}

	public int obtener(int posicion) {
		if (posicion >= 0 && posicion < indice) {
			return codigo[posicion];
		} else {
			return -1;
		}
	}

	private void ampliarArreglo() {
		int[] nuevoCodigo = new int[codigo.length + 10];
		for (int i = 0; i < codigo.length; i++) {
			nuevoCodigo[i] = codigo[i];
		}
		codigo = nuevoCodigo;
	}

	public void adicionar(int nuevoCodigo) {
		if (indice == codigo.length) {
			ampliarArreglo();
		}
		codigo[indice] = nuevoCodigo;
		indice++;
	}

	public boolean intercambiarSegPen() {
		if (indice < 2) {
			return false;
		}
		int temp = codigo[1];
		codigo[1] = codigo[indice - 2];
		codigo[indice - 2] = temp;
		return true;
	}

	public boolean eliminarPrimero() {
		if (indice == 0) {
			return false;
		}
		for (int i = 0; i < indice - 1; i++) {
			codigo[i] = codigo[i + 1];
		}
		indice--;
		return true;
	}

	public int posCodigo() {
		for (int i = indice - 1; i >= 0; i--) {
			if (codigo[i] >= 1000 && codigo[i] <= 1111) {
				return i;
			}
		}
		return -1;
	}

	public boolean intercambiarCodigo() {
		int posUltimoCodigo = posCodigo();
		if (posUltimoCodigo == -1 || indice < 3) {
			return false;
		}
		int temp = codigo[posUltimoCodigo];
		codigo[posUltimoCodigo] = codigo[2];
		codigo[2] = temp;
		return true;
	}

	public boolean eliminarCodigo() {
		int posUltimoCodigo = posCodigo();
		if (posUltimoCodigo == -1) {
			return false;
		}
		for (int i = posUltimoCodigo; i < indice - 1; i++) {
			codigo[i] = codigo[i + 1];
		}
		indice--;
		return true;
	}
}
