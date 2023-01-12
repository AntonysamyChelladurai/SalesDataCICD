package com.jbeans.salesdata;

import com.jbeans.salesdata.entity.Salesrecord;
import com.jbeans.salesdata.repository.SalesRepo;
import com.jbeans.salesdata.services.SalesDetails;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

@Slf4j
@SpringBootTest
class SalesDataApplicationTests {

	@Autowired
	SalesDetails sales;
	@MockBean
	SalesRepo salesRepo;

	Salesrecord salesrecord1=new Salesrecord(72689720,"Meats","Onlines","Hs","Ranchis","Jharkhands","Urban Agglomerations",81890,3640.69,4210.89,34548570.21,29864460.41,4684100.8);

	Salesrecord salesrecord2= new Salesrecord(72689721,"Meates","Onlinees","Hes","Ranchies","Jharkhandes","Urban Agglomerationes",81891,3641.69,4211.89,34548571.21,29864461.41,4684101.8);

	List<Salesrecord> recordList =Arrays.asList(salesrecord1,salesrecord2);
	List<Salesrecord> fetchRecordList =Arrays.asList(salesrecord1,salesrecord2);

	@Test
	void getAllSalesRecords() {
		/*when(salesRepo.findAll()).thenReturn(Stream.of(new Salesrecord(72689720,"Meats","Onlines","Hs","Ranchis","Jharkhands","Urban Agglomerations",81890,3640.69,4210.89,34548570.21,29864460.41,4684100.8),new Salesrecord(72689721,"Meates","Onlinees","Hes","Ranchies","Jharkhandes","Urban Agglomerationes",81891,3641.69,4211.89,34548571.21,29864461.41,4684101.8)).collect(Collectors.toList()));*/
		log.info("Test Case Running SalesDashboard getAllSalesRecords ..");
		when(salesRepo.findAll()).thenReturn(recordList.stream().toList());
		assertEquals(2,sales.getAllSalesRecords().size());
	}

	@Test
	void fetchData(){
		log.info("Test Case Running SalesDashboard fetchData .. ");
		when(salesRepo.findById(72689720L)).thenReturn(Optional.ofNullable(salesrecord1));
		//assertSame(salesrecord1,);
		assertEquals(salesrecord1,sales.getById("72689720"));
	}

}
