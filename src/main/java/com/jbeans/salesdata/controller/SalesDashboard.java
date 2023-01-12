package com.jbeans.salesdata.controller;

import com.jbeans.salesdata.entity.Salesrecord;
import com.jbeans.salesdata.services.SalesDetails;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.FileReader;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("api/sales")
public class SalesDashboard {
    @Autowired
    SalesDetails salesDetails;
    @Autowired
    ResourceLoader resourceLoader;
    @GetMapping("/load")
    public String loadSalesData() throws Exception {
        log.info("Controller SalesDashboard --> Load CSV File to Database ");
        Optional<Resource> resource = Optional.of(resourceLoader.getResource("classpath:MySQL_DB_Record_CSV.csv"));
        Resource value = resource.get();
        String fileName = value.getFile().getAbsolutePath();
        List<Salesrecord> salesrecordList = new CsvToBeanBuilder<Salesrecord>(new FileReader(fileName))
                .withType(Salesrecord.class)
                .withSkipLines(1)
                .build()
                .parse();
        return salesDetails.loadData(salesrecordList);
    }
    @PostMapping("/add")
    public ResponseEntity<Optional<Salesrecord>> insertData(@RequestBody Salesrecord rec) {
        log.info("Controller SalesDashboard --> InsertData Method");
        try {
            return ResponseEntity.ok(salesDetails.insertData(rec));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public String deleteData() {
        return null;
    }
    @GetMapping ("/getAll")
    public ResponseEntity<List<Salesrecord>> displayAllData() {
        return ResponseEntity.ok(salesDetails.getAllSalesRecords());
    }

    @GetMapping ("/get/{orderId}")
    public ResponseEntity<Salesrecord> fetchData(@PathVariable String orderId){
        Salesrecord resposeData=salesDetails.getById(orderId);
       return ResponseEntity.ok(resposeData);
    }
}
