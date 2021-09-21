package com.example.bookstoreconsumer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Purchase {
    private String id;
    private Date purchaseDate;
    private Member member;
    private Double grandTotal;
    private List<PurchaseDetail> purchaseDetails = new ArrayList<>();

    public Purchase() {

    }

    public Purchase(String id, Date purchaseDate, Member member, Double grandTotal, List<PurchaseDetail> purchaseDetails) {
        this.id = id;
        this.purchaseDate = purchaseDate;
        this.member = member;
        this.grandTotal = grandTotal;
        this.purchaseDetails = purchaseDetails;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public List<PurchaseDetail> getPurchaseDetails() {
        return purchaseDetails;
    }

    public void setPurchaseDetails(List<PurchaseDetail> purchaseDetails) {
        this.purchaseDetails = purchaseDetails;
    }

    public String getPurchaseDetailsString() {
        StringBuilder res = new StringBuilder();
        for (PurchaseDetail detail: purchaseDetails) {
            res.append(detail.toString()).append("\n");
        }
        return res.toString();
    }
}
