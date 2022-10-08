import org.junit.Test;
import org.junit.Assert;
public class Pruebas {
	
	@Test
	public void MuertePorBordeArribaEn8x8() {
		Mapa mapa = new Mapa(8,8);
		Snake snake = new Snake(mapa, 2, 3);
		snake.desplazarseHacia(Direccion.ARRIBA);
		snake.desplazarseHacia(Direccion.ARRIBA);
		snake.desplazarseHacia(Direccion.ARRIBA);
		snake.desplazarseHacia(Direccion.ARRIBA);
		snake.desplazarseHacia(Direccion.ARRIBA);
		
		Assert.assertEquals(false, snake.isViva());
		
		
		
	}
	
	@Test
	public void MuertePorBordeAbajoEn5x5() {
		Mapa mapa = new Mapa(5,5);
		Snake snake = new Snake(mapa, 2, 3);
		snake.desplazarseHacia(Direccion.ABAJO);
		snake.desplazarseHacia(Direccion.ABAJO);
		snake.desplazarseHacia(Direccion.ABAJO);
		
		Assert.assertEquals(false, snake.isViva());
		
		
	}
	
	@Test
	public void MuertePorBordeIzquierdoEn5x3() {
		Mapa mapa = new Mapa(5,3);
		Snake snake = new Snake(mapa, 2, 3);
		snake.desplazarseHacia(Direccion.IZQUIERDA);
		snake.desplazarseHacia(Direccion.IZQUIERDA);
		snake.desplazarseHacia(Direccion.IZQUIERDA);
		Assert.assertEquals(false, snake.isViva());
		
		
	}
	@Test
	public void MuertePorBordeDerechoEn5x3() {
		Mapa mapa = new Mapa(5,3);
		Snake snake = new Snake(mapa, 2, 3);
		snake.desplazarseHacia(Direccion.DERECHA);
		snake.desplazarseHacia(Direccion.DERECHA);
		snake.desplazarseHacia(Direccion.DERECHA);
		snake.desplazarseHacia(Direccion.DERECHA);
		
		Assert.assertEquals(false, snake.isViva());
		
		
	}
	
	@Test
	public void MuertePorObstaculoArribaEn8x8() {
		Mapa mapa = new Mapa(8,8);
		
		mapa.ocupar(2, 2);
		Snake snake = new Snake(mapa, 2, 3);
		snake.desplazarseHacia(Direccion.ARRIBA);
		snake.desplazarseHacia(Direccion.ARRIBA);

		
		Assert.assertEquals(false, snake.isViva());
		
		
		
	}
	
	@Test
	public void MuertePorObstaculoAbajoEn8x8() {
		Mapa mapa = new Mapa(8,8);
		
		Snake snake = new Snake(mapa, 2, 3);
		mapa.ocupar(2, 6);
		
		snake.desplazarseHacia(Direccion.ABAJO);
		snake.desplazarseHacia(Direccion.ABAJO);
		snake.desplazarseHacia(Direccion.ABAJO);
		snake.desplazarseHacia(Direccion.ABAJO);

		
		Assert.assertEquals(false, snake.isViva());
		
		
		
	}
	
	@Test
	public void MuertePorObstaculoIzquierdaEn8x8() {
		Mapa mapa = new Mapa(8,8);
		
		Snake snake = new Snake(mapa, 2, 3);
		mapa.ocupar(1, 3);
		snake.desplazarseHacia(Direccion.IZQUIERDA);
	
		Assert.assertEquals(false, snake.isViva());
		
		
		
	}
	
	@Test
	public void MuertePorObstaculoDerechaEn8x8() {
		Mapa mapa = new Mapa(8,8);
		
		Snake snake = new Snake(mapa, 2, 3);
		mapa.ocupar(3, 3);
		snake.desplazarseHacia(Direccion.DERECHA);
	
		Assert.assertEquals(false, snake.isViva());
		
		
		
	}
}
