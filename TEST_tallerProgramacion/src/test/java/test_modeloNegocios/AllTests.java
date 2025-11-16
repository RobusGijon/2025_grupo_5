package test_modeloNegocios;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Test_Empresa_Excepciones_agregarChofer.class, Test_Empresa_Excepciones_agregarCliente.class,
		Test_Empresa_Excepciones_agregarPedido.class, Test_Empresa_Excepciones_agregarVehiculo.class,
		Test_Empresa_Excepciones_agregarViaje.class, Test_Empresa_Excepciones_calificacionChofer.class,
		Test_Empresa_Excepciones_login.class, Test_Empresa_Excepciones_pagarYFinalizarViaje.class,
		Test_Empresa_gettersSetters_Iterators.class, Test_Empresa_Otros.class })
public class AllTests {

}
