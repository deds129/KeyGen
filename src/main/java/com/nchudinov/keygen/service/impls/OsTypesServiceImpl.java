package com.nchudinov.keygen.service.impls;

import com.nchudinov.keygen.model.OsType;
import com.nchudinov.keygen.repository.OsTypesRepository;
import com.nchudinov.keygen.service.OsTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OsTypesServiceImpl implements OsTypesService {
	
	@Autowired
	private OsTypesRepository osTypesRepository;
	
	@Override
	public List<OsType> getAllOsTypes() {
		return osTypesRepository.findAll();
	}

	@Override
	public void saveNewOsTypes(OsType osType) {
		osTypesRepository.save(osType);
	}

	@Override
	public OsType getOsTypeById(int id) {
		return osTypesRepository.getById(id);
	}

	@Override
	public void deleteOsTypeId(int id) {
		osTypesRepository.deleteById(id);
	}
}
