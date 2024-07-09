package com.checkduplicatecustomer1.checkduplicatecustomer1.customer;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "mnemonic")
    private String mnemonic;
    @Column(name = "name1")
    private String name1;
    @Column(name = "name2")
    private String name2;
    @Column(name = "short_name")
    private String shortName;
    @Column(name = "sms1telephone")
    private String sms1Telephone;
    @Column(name = "customer_id")
    private String customerId;
    @Column(name = "mother_name")
    private String motherName;
    public Customer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getSms1Telephone() {
        return sms1Telephone;
    }

    public void setSms1Telephone(String sms1Telephone) {
        this.sms1Telephone = sms1Telephone;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", mnemonic='" + mnemonic + '\'' +
                ", name1='" + name1 + '\'' +
                ", name2='" + name2 + '\'' +
                ", shortName='" + shortName + '\'' +
                ", sms1Telephone='" + sms1Telephone + '\'' +
                ", customerId=" + customerId +
                ", motherName=" + motherName +
                '}';
    }
}

