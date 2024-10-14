/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.managerProduct;

import java.io.Serializable;

/**
 *
 * @author acer
 */
public class CategoryDTO implements Serializable{
    private String type;

    public CategoryDTO() {
    }

    public CategoryDTO(String type) {
        this.type = type;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
    
}
