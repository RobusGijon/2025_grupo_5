package test_modeloDatos;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Test_Chofer_Permanente.class, Test_Chofer_Temporario.class, Test_Pedido.class,
		Test_Usuario_Administrador.class, Test_Usuario_Cliente.class, Test_Vehiculo_Auto.class,
		Test_Vehiculo_Combi.class, Test_Vehiculo_Moto.class, Test_Viaje.class })
public class AllTests {

}
