/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dto;

/**
 *
 * @author apprentice
 */
public class ProductsFlooring {
    
private int prodId;
private String ProductType;
private double CostPerSquareFoot;
private double LaborCostPerSquareFoot;

    /**
     * @return the prodId
     */
    public int getProdId() {
        return prodId;
    }

    /**
     * @param prodId the prodId to set
     */
    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    /**
     * @return the ProductType
     */
    public String getProductType() {
        return ProductType;
    }

    /**
     * @param ProductType the ProductType to set
     */
    public void setProductType(String ProductType) {
        this.ProductType = ProductType;
    }

    /**
     * @return the CostPerSquareFoot
     */
    public double getCostPerSquareFoot() {
        return CostPerSquareFoot;
    }

    /**
     * @param CostPerSquareFoot the CostPerSquareFoot to set
     */
    public void setCostPerSquareFoot(double CostPerSquareFoot) {
        this.CostPerSquareFoot = CostPerSquareFoot;
    }

    /**
     * @return  LaborCostPerSquareFoot
     */
    public double getLaborCostPerSquareFoot() {
        return LaborCostPerSquareFoot;
    }

    /**
     * @param LaborCostPerSquareFoot the LaborCostPerSquareFoot to set
     */
    public void setLaborCostPerSquareFoot(double LaborCostPerSquareFoot) {
        this.LaborCostPerSquareFoot = LaborCostPerSquareFoot;
    }
    
}
