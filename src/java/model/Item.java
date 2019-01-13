
package model;

/**
 *
 * @author metroeger
 */
public class Item {
    
    private CD product;
    private int quantity;
    
    public Item(){
        
    }
    
    public Item(CD product, int quantity){
        this.product=product;
        this.quantity=quantity;
    }
    
    public double getTotalPrice(){
        return quantity*product.getPrice();
    }
    
    
    public CD getProduct(){
        return product;
    }
    
    public void setProduct(CD product){
        this.product=product;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
}
