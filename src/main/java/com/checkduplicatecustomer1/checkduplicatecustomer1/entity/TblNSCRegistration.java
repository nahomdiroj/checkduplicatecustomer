package com.checkduplicatecustomer1.checkduplicatecustomer1.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TblNSCRegistration {
    @Id
    private long id;
    private String customerFullName;
    private String CustomerID;
    private int IsDeliquent;
    private int Freq;
    private int ISReinstated;
    private String FLetter;
    private Date FDate;
    private String FPenality;
    private String SLetter;
    private Date SDate;
    private String SPenality;
    private String TLetter;
    private Date TDate;
    private String TPenality;
    private String BRegion;
    private String BTownSubCity;
    private String BKebele;
    private String BHouseNo;
    private String BPOBox;
    private String BTelNo;
    private String PRegion;
    private String PTownSubCity;
    private String PKebele;
    private String PHouseNo;
    private String PPOBox;
    private String PTelNo;
    private String CrtBy;
    private String CrtDt;
    private String CrtWs;
    private String CrtIP;
    private String ACustomerFullName;
    private String TIN;
    private String IsCleared;
}
