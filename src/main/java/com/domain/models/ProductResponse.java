package com.domain.models;

public class ProductResponse {
    public String productName;
    public Long productId;
    public String productLine;
    public String productIssueDate;
    public String clientName;
    public int yearsOfIssue;
    public int monthsOfIssue;
    public int daysOfIssue;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId){
        this.productId=productId;
    }
    
    public String getProductName() {
        return productName;
    }
    
     public String getProductLine() {
        return productLine;
    }

    public String getProductIssueDate() {
        return productIssueDate;
    }

    public int getYearsOfIssue() {
        return yearsOfIssue;
    }

    public int getMonthsOfIssue() {
        return monthsOfIssue;
    }

    public int getDaysOfIssue() {
        return daysOfIssue;
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


    public void setYearsOfIssue(int yearsOfIssue) {
        this.yearsOfIssue = yearsOfIssue;
    }
    public void setMonthsOfIssue(int monthsOfIssue) {
        this.monthsOfIssue = monthsOfIssue;
    }
    public void setDaysOfIssue(int daysOfIssue) {
        this.daysOfIssue = daysOfIssue;
    }

    public Object getClientName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getClientName'");
    }

}