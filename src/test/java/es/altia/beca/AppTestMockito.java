package es.altia.beca;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import es.altia.beca.dao.MarcaMapper;
import es.altia.beca.entity.Marca;
import es.altia.beca.service.MarcaService;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;;

/**
 * Test unitario con Mockito
 * 
 * @author pablo.esteve
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AppTestMockito {

	private static Log log = LogFactory.getLog(AppTest.class);

	@Mock
	private MarcaMapper marcaMapper;

	@InjectMocks
	private MarcaService service;

	@Test
	public void testSelectAllMarcas() {
		log.info("testing selectAllMarcas()...");
		List<Marca> lista = new ArrayList<Marca>();
		Marca a = mock(Marca.class);
		Marca b = mock(Marca.class);
		when(a.getNombre()).thenReturn("algo");
		when(b.getNombre()).thenReturn("algo numero 2");
		lista.add(a);
		lista.add(b);
		when(marcaMapper.getAll()).thenReturn(lista);
		List<Marca> marcas = service.getAll();
		assertNotNull("Error en testSelectAllMarcas - marcas es null", marcas);
		assertTrue("Error, tamaños distintos!", marcas.size() == lista.size());

		for (int i = 0; i < marcas.size(); i++) {
			assertTrue("Not equal name in position: " + i, marcas.get(i).getNombre().equals(lista.get(i).getNombre()));
		}

		log.info(marcas);
	}

	@Test
	public void testSelectMarca() {
		log.info("testing selectMarca()...");

		String marcaName = "adidas";
		Marca a = mock(Marca.class);

		when(a.getNombre()).thenReturn(marcaName);
		when(marcaMapper.getMarca(any(Integer.class))).thenReturn(a);

		Marca marca = service.getMarca(0);

		assertNotNull("Error en testSelectMarca - marca es null", marca);
		assertTrue("Error en testSelectMarca - nombre incorrecto en marca", marca.getNombre().equals(marcaName));
	}

	@Test
	public void testInsertMarca() {
		log.info("testing insertMarca()...");

		Marca a = mock(Marca.class);
		doNothing().when(marcaMapper).insertMarcaWithId(isA(Marca.class));
		service.insertMarcaWithId(a);
		verify(marcaMapper, times(1)).insertMarcaWithId(a);
	}

	@Test
	public void testDeleteMarca() {
		log.info("testing deleteMarca()...");

		doNothing().when(marcaMapper).deleteMarca(isA(Integer.class));
		service.deleteMarca(any(Integer.class));
		verify(marcaMapper, times(1)).deleteMarca(any(Integer.class));
	}
}
