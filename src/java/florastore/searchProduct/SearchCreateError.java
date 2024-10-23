/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.searchProduct;

public class SearchCreateError {
    private String priceRangeError;
    private String priceEmpty;
    private String priceInvalid;
    private String priceNegative;

    public String getPriceNegative() {
        return priceNegative;
    }

    public void setPriceNegative(String priceNegative) {
        this.priceNegative = priceNegative;
    }
    
    public String getPriceInvalid() {
        return priceInvalid;
    }

    public void setPriceInvalid(String priceInvalid) {
        this.priceInvalid = priceInvalid;
    }
    
    public String getPriceEmpty() {
        return priceEmpty;
    }

    public void setPriceEmpty(String priceEmpty) {
        this.priceEmpty = priceEmpty;
    }
    
    public void setPriceRangeError(String priceRangeError) {
        this.priceRangeError = priceRangeError;
    }
    
    public String getPriceRangeError() {
        return priceRangeError;
    }
    
}
