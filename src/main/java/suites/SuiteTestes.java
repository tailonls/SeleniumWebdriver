package suites;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import core.DriverFactory;
import test.TesteAlerts;
import test.TesteCadastro;
import test.TesteCampoTreinamento;

@RunWith(Suite.class)
@SuiteClasses({ TesteCadastro.class, TesteCampoTreinamento.class, TesteAlerts.class

})
public class SuiteTestes {

	@AfterClass
	public static void finalizaTudo() {
		DriverFactory.killDriver();

	}
}
