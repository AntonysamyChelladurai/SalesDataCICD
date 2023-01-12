package com.jbeans.salesdata.services;

import com.jbeans.salesdata.entity.Salesrecord;
import com.jbeans.salesdata.repository.SalesRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SalesDetails {
    @Autowired
    SalesRepo salesRepo;
    public Optional<Salesrecord> insertData(Salesrecord rec) throws Exception{
            log.info("Insert the Sales Data :: ");
        return Optional.of(salesRepo.save(rec) );
    }
    public String loadData(List<Salesrecord> salesrecordList) {
        log.info("Load the Sales Records :: ");
        salesRepo.saveAll(salesrecordList);
        return "All Data Loaded in to Database.";
    }
    public List<Salesrecord> getAllSalesRecords(){
        return (List<Salesrecord>) salesRepo.findAll();
    }
    public Salesrecord getById(String orderId) {
        Optional<Salesrecord> record = salesRepo.findById(Long.valueOf(orderId));
        Salesrecord sales = null;
        if(record.isPresent()) {
            sales=record.get();
        }
        return sales;
    }
}
