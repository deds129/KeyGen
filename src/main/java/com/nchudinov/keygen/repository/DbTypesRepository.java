package com.nchudinov.keygen.repository;

import com.nchudinov.keygen.model.DbType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DbTypesRepository extends JpaRepository<Integer, DbType> {
}
