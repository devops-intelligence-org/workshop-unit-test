package com.domain.models;

public class ProductResponse {
    private String productName;
    public String productLine;
    public String productIssueDate;
    public String clientName;

    public String getProductName() {
        return productName;
    }

     public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }
    public void setIssueDate(String productIssueDate) {
        this.productIssueDate = productIssueDate;
    }
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

}