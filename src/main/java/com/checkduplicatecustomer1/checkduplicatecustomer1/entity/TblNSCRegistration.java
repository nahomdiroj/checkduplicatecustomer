package com.checkduplicatecustomer1.checkduplicatecustomer1.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tblNSCRegistration")
public class TblNSCRegistration {
    @Id
    private long id;
    
    @Column(name = "customerFullName")
    private String customerFullName;

    @Column(name = "CustomerID")
    private String CustomerID;

    @Column(name = "IsDeliquent")
    private int IsDeliquent;

    @Column(name = "Freq")
    private int Freq;

    @Column(name = "ISReinstated")
    private int ISReinstated;

    @Column(name = "FLetter")
    private String FLetter;

    @Column(name = "FDate")
    private Date FDate;

    @Column(name = "FPenality")
    private String FPenality;

    @Column(name = "SLetter")
    private String SLetter;

    @Column(name = "SDate")
    private Date SDate;

    @Column(name = "SPenality")
    private String SPenality;

    @Column(name = "TLetter")
    private String TLetter;

    @Column(name = "TDate")
    private Date TDate;

    @Column(name = "TPenality")
    private String TPenality;

    @Column(name = "BRegion")
    private String BRegion;

    @Column(name = "BTownSubCity")
    private String BTownSubCity;

    @Column(name = "BKebele")
    private String BKebele;

    @Column(name = "BHouseNo")
    private String BHouseNo;

    @Column(name = "BPOBox")
    private String BPOBox;

    @Column(name = "BTelNo")
    private String BTelNo;

    @Column(name = "PRegion")
    private String PRegion;

    @Column(name = "PTownSubCity")
    private String PTownSubCity;

    @Column(name = "PKebele")
    private String PKebele;

    @Column(name = "PHouseNo")
    private String PHouseNo;

    @Column(name = "PPOBox")
    private String PPOBox;

    @Column(name = "PTelNo")
    private String PTelNo;

    @Column(name = "CrtBy")
    private String CrtBy;

    @Column(name = "CrtDt")
    private String CrtDt;

    @Column(name = "CrtWs")
    private String CrtWs;

    @Column(name = "CrtIP")
    private String CrtIP;

    @Column(name = "ACustomerFullName")
    private String ACustomerFullName;

    @Column(name = "TIN")
    private String TIN;

    @Column(name = "IsCleared")
    private String IsCleared;

}
