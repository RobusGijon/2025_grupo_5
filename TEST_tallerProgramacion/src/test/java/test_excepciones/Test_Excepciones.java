package test_excepciones;

import static org.junit.Assert.*;

import org.junit.Test;

import excepciones.ChoferNoDisponibleException;
import excepciones.ChoferRepetidoException;
import excepciones.ClienteConPedidoPendienteException;
import excepciones.ClienteConViajePendienteException;
import excepciones.ClienteNoExisteException;
import excepciones.ClienteSinViajePendienteException;
import excepciones.PasswordErroneaException;
import excepciones.PedidoInexistenteException;
import excepciones.SinVehiculoParaPedidoException;
import excepciones.SinViajesException;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioYaExisteException;
import excepciones.VehiculoNoDisponibleException;
import excepciones.VehiculoNoValidoException;
import excepciones.VehiculoRepetidoException;
import modeloDatos.Auto;
import modeloDatos.Chofer;
import modeloDatos.ChoferTemporario;
import modeloDatos.Cliente;
import modeloDatos.Combi;
import modeloDatos.Moto;
import modeloDatos.Pedido;
import util.Constantes;
import util.Mensajes;

public class Test_Excepciones {

	@Test
	public void test_choferNoDisponibleExcepcion() {
		/*
		 * 
		 * Prueba: ERROR
		 * 
		 * >> Esperado: El chofer no esta disponoble
		 * >> Resultado: El Pedido no figura en la lista
		 */

		ChoferTemporario chofer = new ChoferTemporario("11222333", "Juan Perez");

		try {
			throw new ChoferNoDisponibleException(chofer);
		} catch (ChoferNoDisponibleException e) {
			Chofer choferExcepcion = e.getChofer();

			Mensajes msj = Mensajes.CHOFER_NO_DISPONIBLE;

			assertEquals(choferExcepcion, chofer);
			assertEquals("El mensaje de la excepcion no es el correcto", msj.getValor(), e.getMessage());

		}
	}

	@Test
	public void test_choferRepetidoException() {

		String dniRepetido = "11222333";
		ChoferTemporario chofer = new ChoferTemporario(dniRepetido, "Juan Perez");

		try {
			throw new ChoferRepetidoException(dniRepetido, chofer);
		} catch (ChoferRepetidoException e) {

			assertEquals(dniRepetido, e.getDniPrentendido());
			assertEquals(chofer, e.getChoferExistente());
			Mensajes msj = Mensajes.CHOFER_YA_REGISTRADO;
			assertEquals("El mensaje de la excepcion no es el correcto", msj.getValor(), e.getMessage());
		}

	}

	@Test
	public void test_clienteConPedidoPendienteException() {
		/*
		 * Prueba: ERROR
		 * 
		 * >> Esperado: Cliente con pedido pendiente
		 * >> Resultado: Cliente con viaje pendiente
		 */
		try {
			throw new ClienteConPedidoPendienteException();
		} catch (ClienteConPedidoPendienteException e) {
			Mensajes msj = Mensajes.CLIENTE_CON_PEDIDO_PENDIENTE;
			assertEquals("El mensaje de la excepcion no es el correcto", msj.getValor(), e.getMessage());

		}

	}

	@Test
	public void test_clienteConViajePendienteException() {

		try {
			throw new ClienteConViajePendienteException();
		} catch (ClienteConViajePendienteException e) {

			Mensajes msj = Mensajes.CLIENTE_CON_VIAJE_PENDIENTE;
			assertEquals("El mensaje de la excepcion no es el correcto", msj.getValor(), e.getMessage());
		}

	}

	@Test
	public void test_clienteNoExisteException() {

		try {
			throw new ClienteNoExisteException();
		} catch (ClienteNoExisteException e) {

			Mensajes msj = Mensajes.CLIENTE_NO_EXISTE;
			assertEquals("El mensaje de la excepcion no es el correcto", msj.getValor(), e.getMessage());
		}

	}

	@Test
	public void test_clienteSinViajePendienteException() {
		try {
			throw new ClienteSinViajePendienteException();
		} catch (ClienteSinViajePendienteException e) {
			Mensajes msj = Mensajes.CLIENTE_SIN_VIAJE_PENDIENTE;
			assertEquals("El mensaje de la excepcion no es el correcto", msj.getValor(), e.getMessage());

		}
	}

	@Test
	public void test_passwordErroneaException() {

		String usuarioPretendido = "Juan Ramon";
		String passwordPretendida = "LAVECINDADEL8";

		try {
			throw new PasswordErroneaException(usuarioPretendido, passwordPretendida);
		} catch (PasswordErroneaException e) {

			String usuarioException = e.getUsuarioPretendido();
			String passException = e.getPasswordPretendida();

			assertEquals(usuarioPretendido, usuarioException);
			assertEquals(passwordPretendida, passException);

			Mensajes msj = Mensajes.PASS_ERRONEO;
			assertEquals("El mensaje de la excepcion no es el correcto", msj.getValor(), e.getMessage());

		}

	}

	@Test
	public void test_pedidoInexistenteexception() {

		Cliente cliente = new Cliente("nombreUsuario", "pass", "nombreReal");

		Pedido pedido = new Pedido(cliente, 5, true, false, 10, Constantes.ZONA_SIN_ASFALTAR);

		try {
			throw new PedidoInexistenteException(pedido);
		} catch (PedidoInexistenteException e) {
			Pedido pedidoException = e.getPedido();
			assertEquals(pedido, pedidoException);

			Mensajes msj = Mensajes.PEDIDO_INEXISTENTE;
			assertEquals("El mensaje de la excepcion no es el correcto", msj.getValor(), e.getMessage());

		}

	}

	@Test
	public void test_sinVehiculoParaPedidoException() {

		Cliente cliente = new Cliente("nombreUsuario", "pass", "nombreReal");

		Pedido pedido = new Pedido(cliente, 5, true, false, 10, Constantes.ZONA_SIN_ASFALTAR);

		try {
			throw new SinVehiculoParaPedidoException(pedido);
		} catch (SinVehiculoParaPedidoException e) {
			Pedido pedidoException = e.getPedido();
			assertEquals(pedido, pedidoException);

			Mensajes msj = Mensajes.SIN_VEHICULO_PARA_PEDIDO;
			assertEquals("El mensaje de la excepcion no es el correcto", msj.getValor(), e.getMessage());

		}

	}

	@Test
	public void test_sinViajesException() {

		try {
			throw new SinViajesException();
		} catch (SinViajesException e) {
			Mensajes msj = Mensajes.CHOFER_SIN_VIAJES;
			assertEquals("El mensaje de la excepcion no es el correcto", msj.getValor(), e.getMessage());

		}
	}

	@Test
	public void test_usuarioNoExisteException() {

		String usuarioPretendido = "nombreUsuario";

		try {
			throw new UsuarioNoExisteException(usuarioPretendido);
		} catch (UsuarioNoExisteException e) {

			assertEquals(usuarioPretendido, e.getUsuarioPretendido());

			Mensajes msj = Mensajes.USUARIO_DESCONOCIDO;
			assertEquals("El mensaje de la excepcion no es el correcto", msj.getValor(), e.getMessage());
		}

	}

	@Test
	public void test_usuarioYaExisteException() {

		String usuarioPretendido = "nombreUsuario";

		try {
			throw new UsuarioYaExisteException(usuarioPretendido);
		} catch (UsuarioYaExisteException e) {

			assertEquals(usuarioPretendido, e.getUsuarioPretendido());

			Mensajes msj = Mensajes.USUARIO_REPETIDO;
			assertEquals("El mensaje de la excepcion no es el correcto", msj.getValor(), e.getMessage());
		}

	}

	@Test
	public void test_vehiculoNoDisponibleException() {

		Moto moto = new Moto("MM123MM");

		try {
			throw new VehiculoNoDisponibleException(moto);
		} catch (VehiculoNoDisponibleException e) {
			assertEquals(moto, e.getVehiculo());
			Mensajes msj = Mensajes.VEHICULO_NO_DISPONIBLE;
			assertEquals("El mensaje de la excepcion no es el correcto", msj.getValor(), e.getMessage());
		}

	}

	@Test
	public void test_vehiculoNoValidoException() {

		Auto auto = new Auto("AA123AA", 3, false);
		Cliente cliente = new Cliente("nombreUsuario", "pass", "nombreReal");
		Pedido pedido = new Pedido(cliente, 8, true, true, 10, Constantes.ZONA_PELIGROSA);

		try {
			throw new VehiculoNoValidoException(auto, pedido);
		} catch (VehiculoNoValidoException e) {
			assertEquals(pedido, e.getPedido());
			assertEquals(auto, e.getVehiculo());
			Mensajes msj = Mensajes.VEHICULO_NO_VALIDO;
			assertEquals("El mensaje de la excepcion no es el correcto", msj.getValor(), e.getMessage());
		}

	}

	@Test
	public void test_vehiculoRepetidoException() {

		String patenteRepetida = "CC123CC";
		Combi combi = new Combi(patenteRepetida, 9, true);

		try {
			throw new VehiculoRepetidoException(patenteRepetida, combi);
		} catch (VehiculoRepetidoException e) {
			assertEquals(patenteRepetida, e.getPatentePrentendida());
			assertEquals(combi, e.getVehiculoExistente());
			Mensajes msj = Mensajes.VEHICULO_YA_REGISTRADO;
			assertEquals("El mensaje de la excepcion no es el correcto", msj.getValor(), e.getMessage());

		}

	}

}




















