package es.altia.beca.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import es.altia.beca.entity.Marca;

public interface MarcaMapper {

	@Select("select * from marca")
	List<Marca> getAll();

	@Select("SELECT * FROM marca where marca.id = #{marcaId}")
	Marca getMarca(int marcaId);

	@Insert("INSERT into marca(nombre) VALUES(#{nombre})")
	void insertMarca(Marca marca);
	
	@Insert("INSERT into marca(id, nombre) VALUES(#{id}, #{nombre})")
	void insertMarcaWithId(Marca marca);
	
	@Insert("DELETE from marca WHERE marca.id = #{marcaId}")
	void deleteMarca(int marcaId);
}
