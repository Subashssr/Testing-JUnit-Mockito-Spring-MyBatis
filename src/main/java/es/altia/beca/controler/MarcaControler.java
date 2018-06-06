package es.altia.beca.controler;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.altia.beca.entity.Marca;
import es.altia.beca.service.MarcaService;

@RestController
public class MarcaControler {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private MarcaService marcaService;

	@RequestMapping(method = RequestMethod.GET, value = "/marcas")
	public List<Marca> marcas() {
		logger.info("Estoy aprendiendo ");
		return marcaService.getAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/marca/{marcaId}")
	public Marca equipo(@PathVariable("marcaId") int marcaId) {
		return marcaService.getMarca(marcaId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/insertMarca/{nombre}")
	public void insertMarca(@PathVariable("nombre") String nombre) {
		Marca marca = new Marca();
		marca.setNombre(nombre);
		marcaService.insertMarca(marca);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/insertMarcaWithId/{id}-{nombre}")
	public void insertMarcaWithId(@PathVariable("id") int marcaId, @PathVariable("nombre") String nombre) {
		Marca marca = new Marca();
		marca.setNombre(nombre);
		marca.setId(marcaId);
		marcaService.insertMarcaWithId(marca);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/deleteMarca/{marcaId}")
	public void deleteMarca(@PathVariable("marcaId") int marcaId) {
		marcaService.deleteMarca(marcaId);
	}

}
