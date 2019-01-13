package mgbeans;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.CD;
import model.Item;

/**
 *
 * @author metroeger
 */
@ManagedBean
@SessionScoped
public class ShoppingCart {

    private List<Item> shoppingList;
    private double totalPrice;

    public ShoppingCart() {
        shoppingList = new ArrayList<>();
        totalPrice = 0;
    }

    public void addItem(CD cd) {
        boolean isItem = false;
        Item item = null;
        
        for (Item i : shoppingList) {
            if (i.getProduct() == cd) {
                item = i;
                item.increaseQuantity();
                isItem = true;
            }
        }
        if (!isItem) {
            shoppingList.add(new Item(cd, 1));
        }else{
            item.increaseQuantity();
        }
    }

    public void removeItem(Item item) {
        shoppingList.remove(item);
    }
    
    public void incQuantity(Item i){
        i.increaseQuantity();
    }
    
     public void decQuantity(Item i){
        if (i.getQuantity()>1){
          i.decreaseQuantity();  
        }else{
            removeItem(i);
        }      
    }
     

    public double getTotalPrice() {
        totalPrice = 0;
        for (Item i : shoppingList) {
            totalPrice += i.getTotalPrice();
        }
        return totalPrice;
    }
    
    public String displayPrice(double price){
         DecimalFormat newFormat = new DecimalFormat("#.##");
            return newFormat.format(price) + "";
    }

    public List<Item> getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(List<Item> shoppingList) {
        this.shoppingList = shoppingList;
    }

}
