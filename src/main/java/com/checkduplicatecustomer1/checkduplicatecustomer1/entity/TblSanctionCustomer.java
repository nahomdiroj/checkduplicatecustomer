package com.checkduplicatecustomer1.checkduplicatecustomer1.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="tblSanctionCustomer")
public class TblSanctionCustomer {

    @Id
    private long id;

    @Column(name = "CustomerID")
    private String CustomerID;

    @Column(name = "customerFullName")
    private String customerFullName;

    @Column(name = "motherName")
    private String motherName;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "BankID")
    private int BankID;

    @Column(name = "BranchID")
    private int BranchID;

    @Column(name = "sanctioned_by")
    private String sanctioned_by;

    @Column(name = "RefNumber")
    private String RefNumber;

    @Column(name = "RefDate")
    private Date RefDate;

    @Column(name = "ReinRemarks")
    private String ReinRemarks;

    @Column(name = "RRefNO")
    private String RRefNO;

    @Column(name = "RRefDate")
    private String RRefDate;

    @Column(name = "photo_id")
    private String photo_id;

    @Column(name = "passport_id")
    private String passport_id;

    @Column(name = "other_doc_id")
    private String other_doc_id;

    @Column(name = "DateReinstated")
    private String DateReinstated;

    @Column(name = "ACStatus")
    private String ACStatus;

    @Column(name = "registration_date")
    private Date registration_date;

    @Column(name = "lifting_date")
    private Date lifting_date;

    @Column(name = "status")
    private int status;

    @Column(name = "CrtBy")
    private String CrtBy;

    @Column(name = "CrtDt")
    private String CrtDt;

    @Column(name = "CrtWs")
    private String CrtWs;

    @Column(name = "CrtIp")
    private String CrtIp;

    @Column(name = "reference_letter_id")
    private String reference_letter_id;

    @Column(name = "Remark")
    private String Remark;
}
