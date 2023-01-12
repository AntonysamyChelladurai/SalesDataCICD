package com.jbeans.salesdata.repository;

import com.jbeans.salesdata.entity.Salesrecord;
import org.springframework.data.repository.CrudRepository;

public interface SalesRepo extends CrudRepository<Salesrecord, Long> {
}
