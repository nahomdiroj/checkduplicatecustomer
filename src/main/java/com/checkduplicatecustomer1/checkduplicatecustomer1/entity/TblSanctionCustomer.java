package com.checkduplicatecustomer1.checkduplicatecustomer1.entity;

import java.util.Date;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TblSanctionCustomer {

    @Id
    private long id;

    private String CustomerID;
    private String customerFullName;
    private String motherName;
    private String telephone;
    private int BankID;
    private int BranchID;
    private String sanctioned_by;
    private String RefNumber;
    private Date RefDate;
    private String ReinRemarks;
    private String RRefNO;
    private String RRefDate;
    private String photo_id;
    private String passport_id;
    private String other_doc_id;
    private String DateReinstated;
    private String ACStatus;
    private Date registration_date;
    private Date lifting_date;
    private int status;
    private String CrtBy;
    private String CrtDt;
    private String CrtWs;
    private String CrtIp;
    private String reference_letter_id;
    private String Remark;
}
