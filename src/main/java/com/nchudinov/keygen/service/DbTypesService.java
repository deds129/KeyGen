package com.nchudinov.keygen.service;

import com.nchudinov.keygen.model.DbType;

import java.util.List;

public interface DbTypesService {
	List<DbType> getAllDbTypes();

	public void saveNewDbType(DbType dbType);

	DbType getDbTypeById(int id);

	void deleteDbTypeId(int id);
}
