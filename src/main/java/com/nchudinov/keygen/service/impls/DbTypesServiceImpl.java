package com.nchudinov.keygen.service.impls;

import com.nchudinov.keygen.model.DbType;
import com.nchudinov.keygen.repository.DbTypesRepository;
import com.nchudinov.keygen.service.DbTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbTypesServiceImpl implements DbTypesService {
	
	@Autowired
	private DbTypesRepository dbTypesRepository;
	
	@Override
	public List<DbType> getAllDbTypes() {
		return dbTypesRepository.findAll();
	}
	
	@Override
	public void saveNewDbType(DbType dbType) {
		dbTypesRepository.save(dbType);
	}

	@Override
	public DbType getDbTypeById(int id) {
		return dbTypesRepository.getById(id);
	}

	@Override
	public void deleteDbTypeId(int id) {
		dbTypesRepository.deleteById(id);
	}
}
