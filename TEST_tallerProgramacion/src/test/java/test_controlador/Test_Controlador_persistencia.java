package test_controlador;

import static org.junit.Assert.*;

import java.awt.Component;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

import javax.swing.JTextField;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controlador.Controlador;
import modeloNegocio.Empresa;
import persistencia.EmpresaDTO;
import util.AuxiliarPersistenciaTesting;
import util.FalsoOptionPanel;
import util.Mensajes;
import vista.Ventana;

public class Test_Controlador_persistencia {
	
	private Controlador controlador;
	private String archivoTestName = "empresaTest.bin";
	FalsoOptionPanel miOptionPanel;
	Ventana ventana;

	@Before
	public void setUp() throws Exception {
		File archivoEmpresa = new File(archivoTestName);
		if(archivoEmpresa.exists()) {
			archivoEmpresa.delete();
		}
		controlador = new Controlador();
		ventana = (Ventana) controlador.getVista();
		miOptionPanel = new FalsoOptionPanel();
		ventana.setOptionPane(miOptionPanel);
	}
	
	@After
	public void tearDown() throws Exception {
		File archivoEmpresa = new File(archivoTestName);
		if(archivoEmpresa.exists()) {
			archivoEmpresa.delete();
		}

		if (ventana != null) {
			ventana.dispose();
		}
	}

	@Test
	public void test_getterSetter_fileName() {
		controlador.setFileName(archivoTestName);
		assertEquals(archivoTestName, controlador.getFileName());
	}

	// @Test
	// public void test_persistencia_lecturaArchivoInexistente() {

	// 	controlador.setFileName(archivoTestName);
	// 	miOptionPanel.setMensaje(null);

	// 	controlador.leer();
		
	// 	String mensajeEsperado = "";
	// 	try {
	// 		Path archivoPath = Path.of(archivoTestName);
	// 		AuxiliarPersistenciaTesting.cargar(archivoPath);
	// 	} catch (Exception e) {
	// 		System.out.println("entro aca");
	// 		mensajeEsperado = e.getMessage();
	// 	}

	// 	assertEquals(miOptionPanel.getMensaje(), mensajeEsperado);
	// }	

	@Test
	public void test_persistencia_lecturaArchivoExistente() {
		controlador.setFileName(archivoTestName);
		EmpresaDTO empresaDTO = AuxiliarPersistenciaTesting.crearEmpresaDTOGenerico();
		Path archivoPath = Path.of(archivoTestName);	
		try {
			AuxiliarPersistenciaTesting.guardar(empresaDTO, archivoPath);
		} catch (Exception e) {
			fail("Fallo la creacion del archivo de persistencia");
		}

		miOptionPanel.setMensaje(null);
		controlador.leer();
		
		assertNull(miOptionPanel.getMensaje());
		EmpresaDTO empresaDTOLeida = AuxiliarPersistenciaTesting.empresaToEmpresaDTO();

		assertTrue(AuxiliarPersistenciaTesting.sonIguales(empresaDTO, empresaDTOLeida));
	}

	@Test
	public void test_persistencia_escritura() {
		controlador.setFileName(archivoTestName);
		
		EmpresaDTO empresaDTO = AuxiliarPersistenciaTesting.crearEmpresaDTOGenerico();
		AuxiliarPersistenciaTesting.cargarDTOaLaEmpresa(empresaDTO);

		controlador.escribir();

		Path archivoPath = Path.of(archivoTestName);
		EmpresaDTO empresaDTOLeido = null;
		try {
			empresaDTOLeido = (EmpresaDTO) AuxiliarPersistenciaTesting.cargar(archivoPath);
		} catch (ClassNotFoundException | IOException e) {
			fail("Fallo la lectura del archivo de persistencia");
		}

		assertTrue(AuxiliarPersistenciaTesting.sonIguales(empresaDTO, empresaDTOLeido));

		
	}

	
}





