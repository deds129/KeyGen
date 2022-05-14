package com.nchudinov.keygen.service.interfaces;

import com.nchudinov.keygen.model.DbType;

import java.util.List;

public interface DbTypesService {
	List<DbType> getAllDbTypes();

	void saveNewDbType(DbType dbType);

	DbType getDbTypeById(int id);

	void deleteDbTypeId(int id);
}
