package com.nchudinov.keygen.service.interfaces;

import com.nchudinov.keygen.model.OsType;

import java.util.List;

public interface OsTypesService {
	
	List<OsType> getAllOsTypes();

	public void saveNewOsTypes(OsType osType);

	OsType getOsTypeById(int id);

	void deleteOsTypeId(int id);
}
