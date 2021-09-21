package com.example.bookstoreconsumer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PurchaseDetail {
    private Purchase purchase;
    private Book book;
    private Double priceSell;
    private Integer quantity;

    public PurchaseDetail() {

    }

    public PurchaseDetail(Purchase purchase, Book book, Double priceSell, Integer quantity) {
        this.purchase = purchase;
        this.book = book;
        this.priceSell = priceSell;
        this.quantity = quantity;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Double getPriceSell() {
        return priceSell;
    }

    public void setPriceSell(Double priceSell) {
        this.priceSell = priceSell;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return book.toString() + "" +
                "Quantity : " + quantity + "\n" +
                "Subtotal : " + priceSell + "\n";
    }
}
