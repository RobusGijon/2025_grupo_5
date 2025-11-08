package test_modeloDatos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import junit.framework.Assert;
import modeloDatos.Cliente;

public class Test_Usuario_Cliente {

	
	String nombreUsuario;
	String pass;
	String nombreReal;
	Cliente cliente;
	
	@Before
	public void setUp() throws Exception {
		nombreUsuario = "juanzerPerez";
		pass = "123456789";
		nombreReal = "Juan Perez";
		cliente = new Cliente(nombreUsuario, pass, nombreReal);
	}

	@Test
	public void test_getNombreReal() {
		Assert.assertEquals(cliente.getNombreReal(), nombreReal);
	}
	
	@Test
	public void test_getPass() {
		Assert.assertEquals(cliente.getPass(), pass);
	}
	

}
