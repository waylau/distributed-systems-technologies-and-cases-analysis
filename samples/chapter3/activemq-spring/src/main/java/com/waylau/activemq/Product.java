/**
 * 
 */
package com.waylau.activemq;

import java.io.Serializable;

/**
 * 
 * @author <a href="http://waylau.com">Way Lau</a> 
 * @date 2016年8月7日
 */
public class Product implements Serializable {
	
	private String productId;
    
    private String name;
     
    private int quantity;
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getQuantity() {
        return quantity;
    }
 
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
 
    public String getProductId() {
        return productId;
    }
 
    public void setProductId(String productId) {
        this.productId = productId;
    }
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((productId == null) ? 0 : productId.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (productId == null) {
            if (other.productId != null)
                return false;
        } else if (!productId.equals(other.productId))
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "Product [productId=" + productId + ", name=" + name + ", quantity=" + quantity + "]";
    }
 
     
}