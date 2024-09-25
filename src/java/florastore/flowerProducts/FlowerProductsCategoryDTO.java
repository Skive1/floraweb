/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.flowerProducts;

/**
 *
 * @author ADMIN
 */
public class FlowerProductsCategoryDTO {
    private String productType;
    private int productTypeQuantity;

    public FlowerProductsCategoryDTO() {
    }

    public FlowerProductsCategoryDTO(String productType, int productTypeQuantity) {
        this.productType = productType;
        this.productTypeQuantity = productTypeQuantity;
    }

    /**
     * @return the productType
     */
    public String getProductType() {
        return productType;
    }

    /**
     * @param productType the productType to set
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * @return the productTypeQuantity
     */
    public int getProductTypeQuantity() {
        return productTypeQuantity;
    }

    /**
     * @param productTypeQuantity the productTypeQuantity to set
     */
    public void setProductTypeQuantity(int productTypeQuantity) {
        this.productTypeQuantity = productTypeQuantity;
    }
    
    
}
