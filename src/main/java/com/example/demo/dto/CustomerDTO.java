package com.example.demo.dto;

import jakarta.persistence.Column;

public class CustomerDTO {
    private int CustomerID;
    private String customerName;
    private String customerAddress;
    private double customerSalary;
    private String nic;
    private boolean activeState;

    public CustomerDTO() {
    }

    public CustomerDTO(int customerID, String customerName, String customerAddress, double customerSalary, String nic, boolean activeState) {
        CustomerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
        this.nic = nic;
        this.activeState = activeState;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public double getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(double customerSalary) {
        this.customerSalary = customerSalary;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public boolean isActiveState() {
        return activeState;
    }

    public void setActiveState(boolean activeState) {
        this.activeState = activeState;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "CustomerID=" + CustomerID +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerSalary=" + customerSalary +
                ", nic='" + nic + '\'' +
                ", activeState=" + activeState +
                '}';
    }
}
