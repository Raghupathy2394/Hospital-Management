package com.example.repository;

import java.io.Serializable;
import java.util.List;

import org.aspectj.apache.bcel.util.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.google.common.base.Optional;

public interface ReadOnlyRepository<T, ID extends Serializable> extends Repository<T, ID> {
	
	  Optional<T> findById(ID id);
	    List<T> findAllById(Iterable<ID> ids);
	    List<T> findAll();
	    Page<T> findAll(Pageable pageable);
	    long count();
	}


