//Recordemos que las reglas anteriores aún aplican: no puede desplazarse "hacia atrás".

public class Snake {
	
	// se considera un Snake que ocupa un solo casillero del mapa
	private int x, y;
	private boolean estaViva = true;
	private Mapa mapa;
	
	/**
	 * Recibe mapa y posición inicial. El mapa contiene posiciones
	 * previamente ocupadas
	 */
	public Snake(Mapa mapa, int x, int y) {
		this.mapa = mapa;
		this.x = x;
		this.y = y;
	}

	/**
	 * @pre  debe estar viva
	 * @post si el movimiento es posible, debe desplazarse
	 * @post debe morir si tal desplazamiento no es compatible
	 *       o si la posición está ocupada
	 * @post debe actualizar el mapa en todos los casos
	 * @param direccion, la dirección hacia la que debe moverse
	 */
	
	public void desplazarseHacia(Direccion direccion) {
		
		if (isViva()) {
			
			
			if (direccion == Direccion.ARRIBA) {
				if ((getY() == 0) || mapa.estaOcupado(getX(), getY() - 1) ) {
					estaViva = false;
				} else {
					mapa.desocupar(getX(), getY());
					y = y - 1;
					mapa.ocupar(getX(), getY());
				}
					
			}
			
			if (direccion == Direccion.ABAJO) {
				if ( mapa.estaOcupado(getX(), getY() + 1)) {
					estaViva = false;
				} else {
					mapa.desocupar(getX(), getY());
					y = y + 1;
					mapa.ocupar(getX(), getY());
				}
					
			}
			
			

			if (direccion == Direccion.DERECHA) {
				if (mapa.estaOcupado(getX() + 1, getY())) {
					estaViva = false;
				} else {
					mapa.desocupar(getX(), getY());
					y = y - 1;
					mapa.ocupar(getX(), getY());
				}
					
			}
		
		if (direccion == Direccion.IZQUIERDA) {
			if ((getX() == 0) || mapa.estaOcupado(getX() - 1, getY()) ) {
				estaViva = false;
			} else {
				mapa.desocupar(getX(), getY());
				x = x - 1;
				mapa.ocupar(getX(), getY());
			}
				
		}
		
		}
	
	}
		
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public boolean isViva() {
		return this.estaViva;
	}
}

enum Direccion {
	ARRIBA, ABAJO, IZQUIERDA, DERECHA
}

class Mapa {
	private boolean[][] ocupados;
	
	public Mapa(int ancho, int alto) {
		
		ocupados = new boolean[ancho + 1][alto + 1];
		for (int i = 0; i < ocupados.length; i++) {
			ocupar(i, ocupados[i].length - 1);
			
		}
		
		for (int i = 0; i < ocupados[0].length; i++) {
			ocupar(ocupados.length - 1, i);
			
		}

	
	
	}

	public boolean estaOcupado(int x, int y) {
		if (ocupados[x][y]) {
			return true;
		} else {
			return false;
		}
	}
	
	public void ocupar(int x, int y) {
		ocupados[x][y] = true;
	}
	
	public void desocupar(int x, int y) {
		ocupados[x][y] = false;
	}

}