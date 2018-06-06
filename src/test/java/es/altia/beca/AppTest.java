package es.altia.beca;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.altia.beca.entity.Marca;
import es.altia.beca.service.MarcaService;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;;

/**
 * Test de integración
 * 
 * @author pablo.esteve
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring/spring-context.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppTest {

	private int marcaId = 123;

	private static Log log = LogFactory.getLog(AppTest.class);

	@Autowired
	private MarcaService service;

	@Test
	public void test10SelectAllMarcas() {
		log.info("testing selectAllMarcas()...");
		System.out.println("entro");
		List<Marca> marcas = service.getAll();
		assertNotNull("Error en testSelectAllMarcas - marcas es null", marcas);
		assertTrue("Error - esperaba 2 marcas", marcas.size() == 2);
		assertTrue("Error - nombre incorrecto", marcas.get(0).getNombre().equals("nike"));
		assertTrue("Error - nombre incorrecto", marcas.get(1).getNombre().equals("adidas"));

		log.info(marcas);
	}

	@Test
	public void test20SelectMarca() {
		log.info("testing selectMarca()...");
		int marcaId = 2;
		String marcaName = "adidas";
		Marca marca = service.getMarca(marcaId);

		assertNotNull("Error en testSelectMarca - marca es null", marca);
		assertTrue("Error en testSelectMarca - nombre incorrecto en marca", marca.getNombre().equals(marcaName));
	}

	@Test
	public void test30InsertMarca() {

		log.info("testing insertMarca()...");

		String marcaName = "Tommy Hilfiger";

		Marca marca = new Marca();
		marca.setNombre(marcaName);
		marca.setId(marcaId);
		service.insertMarcaWithId(marca);

		marca = service.getMarca(marcaId);

		assertNotNull("Error en testInsertMarca - marca es null", marca);
		assertTrue("Error en testInsertMarca - nombre incorrecto en marca", marca.getNombre().equals(marcaName));

	}

	@Test
	public void test40DeleteMarca() {
		log.info("testing deleteMarca()...");

		service.deleteMarca(marcaId);

		assertTrue("Error", service.getMarca(marcaId) == null);
	}
}
