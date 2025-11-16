package test_gui_panelCliente;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Test_Gui_PanelCliente.class, Test_Gui_PanelCliente_ClienteConPedidoPendiente.class,
		Test_Gui_PanelCliente_ClienteSinPedido.class, Test_Gui_PanelCliente_ClineteConViajeIniciado.class })
public class AllTests {

}
