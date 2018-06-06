package es.altia.beca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.altia.beca.dao.MarcaMapper;
import es.altia.beca.entity.Marca;

@Service
public class MarcaService {

	@Autowired
	private MarcaMapper marcaMapper;

	public List<Marca> getAll() {
		return marcaMapper.getAll();
	}

	public void insertMarca(Marca marca) {
		marcaMapper.insertMarca(marca);
	}
	
	public void insertMarcaWithId(Marca marca) {
		marcaMapper.insertMarcaWithId(marca);
	}

	public Marca getMarca(int marcaId) {
		return marcaMapper.getMarca(marcaId);
	}
	
	public void deleteMarca(int marcaId) {
		marcaMapper.deleteMarca(marcaId);
	}
}
