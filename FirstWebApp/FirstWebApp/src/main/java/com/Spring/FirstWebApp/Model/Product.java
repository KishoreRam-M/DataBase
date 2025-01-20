package com.Spring.FirstWebApp.Model;

import org.springframework.stereotype.Component;

@Component
public class Product {
    private  String prodname;
    private  int prodid;

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", prodname='" + prodname + '\'' +
                ", prodid=" + prodid +
                '}';
    }

    private  int price;

    public  Product ()
    {

    }

    public Product(String p, int n , int pr) {
        this.price=pr;
        this.prodid=n;
        this.prodname=p;
    }
    public String getProdname() {
        return prodname;
    }

    public void setProdname(String prodname) {
        this.prodname = prodname;
    }

    public int getProdid() {
        return prodid;
    }

    public void setProdid(int prodid) {
        this.prodid = prodid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



}
