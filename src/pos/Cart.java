/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

/**
 *
 * @author Dimuthu
 */
public class Cart {
    
    public String name;
    public String ID;
    public int amount;
    public float buy_price;
    public float sell_price;
    
    public Cart(){
        
    }
    
    public Cart(String ID, String name, int amount, float buy_price, float sell_price){
        this.ID = ID;
        this.name = name;
        this.amount = amount;
        this.buy_price = buy_price;
        this.sell_price = sell_price;
    }
    
}
