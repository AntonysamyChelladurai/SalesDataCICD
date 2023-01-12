package com.jbeans.salesdata.entity;

import com.opencsv.bean.CsvBindByPosition;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "sales")
public class Salesrecord {
    @CsvBindByPosition(position = 0)
    @Id
    @Column(name = "OrderID")
    long orderID;
    @CsvBindByPosition(position =1)
    @Column(name = "ItemType")
    String itemType;
    @CsvBindByPosition(position = 2)
    @Column(name = "SalesChannel")
    String salesChannel;
    @CsvBindByPosition(position = 3)
    @Column(name = "OrderPriority")
    String orderPriority;
    @CsvBindByPosition(position = 4)
    @Column(name = "City")
    String city;
    @CsvBindByPosition(position = 5)
    @Column(name = "State")
    String state;
    @CsvBindByPosition(position = 6)
    @Column(name = "Type")
    String type;
    @CsvBindByPosition(position = 7)
    @Column(name = "UnitsSold")
    long unitsSold;
    @CsvBindByPosition(position = 8)
    @Column(name = "UnitCost")
    double unitCost;
    @CsvBindByPosition(position = 9)
    @Column(name = "UnitSellPrice")
    double unitSellPrice;
    @CsvBindByPosition(position = 10)
    @Column(name = "TotalRevenue")
    double totalRevenue;
    @CsvBindByPosition(position = 11)
    @Column(name = "TotalCost")
    double totalCost;
    @CsvBindByPosition(position = 12)
    @Column(name = "TotalProfit")
    double totalProfit;

    public Salesrecord(long orderID, String itemType, String salesChannel, String orderPriority, String city, String state, String type, long unitsSold, double unitCost, double unitSellPrice, double totalRevenue, double totalCost, double totalProfit) {
        this.orderID = orderID;
        this.itemType = itemType;
        this.salesChannel = salesChannel;
        this.orderPriority = orderPriority;
        this.city = city;
        this.state = state;
        this.type = type;
        this.unitsSold = unitsSold;
        this.unitCost = unitCost;
        this.unitSellPrice = unitSellPrice;
        this.totalRevenue = totalRevenue;
        this.totalCost = totalCost;
        this.totalProfit = totalProfit;
    }
}
