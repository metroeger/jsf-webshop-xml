package mgbeans;

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
        Item item;

        for (Item i : shoppingList) {
            if (i.getProduct() == cd) {
                i.setQuantity(i.getQuantity() + 1);
            } else {
                shoppingList.add(new Item(cd, 1));
            }
        }
    }

    public void removeItem(CD cd) {
        for (Item i : shoppingList) {
            if (i.getProduct() == cd && i.getQuantity()>1) {
                i.setQuantity(i.getQuantity()-1);
            } else if (i.getProduct()==cd && i.getQuantity()==1) {
                shoppingList.remove(cd);
            }
        }
    }

    public double getTotalPrice() {
        for (Item i : shoppingList) {
            totalPrice += i.getTotalPrice();
        }
        return totalPrice;
    }

    public List<Item> getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(List<Item> shoppingList) {
        this.shoppingList = shoppingList;
    }

}
