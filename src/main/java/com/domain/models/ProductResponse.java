package com.domain.models;

public class ProductResponse {
    private String productName;
    public String productLine;
    public String productIssueDate;
    public String clientName;
    public int yearsOfIssue;
    public int monthsOfIssue;
    public int daysOfIssue;

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


    public void setYearsOfIssue(int yearsOfIssue) {
        this.yearsOfIssue = yearsOfIssue;
    }
    public void setMonthsOfIssue(int monthsOfIssue) {
        this.monthsOfIssue = monthsOfIssue;
    }
    public void setDaysOfIssue(int daysOfIssue) {
        this.daysOfIssue = daysOfIssue;
    }

}