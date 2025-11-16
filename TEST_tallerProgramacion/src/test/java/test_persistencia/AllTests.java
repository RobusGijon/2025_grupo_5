package test_persistencia;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Test_EmpresaDTO.class, Test_PersistenciaBIN.class, Test_UtilPersistencia.class })
public class AllTests {

}
