/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Calendar;
/**
 *
 * @author Dimuthu
 */
public class DatabasePOS {
    Connection conn;
    public DatabasePOS(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos?zeroDateTimeBehavior=convertToNull","root","");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public ResultSet findAll(String table){
        ResultSet rs=null;
        try{
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from "+table);   
        }catch(Exception e){}
        return rs;
    }
    
    public ResultSet findSales(){
        ResultSet rs=null;
        try{
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT sales.bill_no, inventory.name, sales.amount, sales.bill_time, users.name FROM sales INNER JOIN inventory ON inventory.item_id=sales.item_id INNER JOIN users ON users.id = sales.user_id");   
        }catch(Exception e){}
        return rs;
    }
    
    public int getLastID(String table){
        ResultSet rs=null;
        int id=0;
        try{
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("select bill_no from "+table+" ORDER BY id DESC LIMIT 1");   
            if(rs.next()){
                id = rs.getInt(1);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return id;
    }
    
    public void saleDB(int bill_no, String item_id, int amount, int user_id, float buy_price, float sell_price){
        try{
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            // create a sql date object so we can use it in our INSERT statement
            String query = "insert into sales (bill_no, item_id, amount, bill_time, user_id, buy_price, sell_price) values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, bill_no);
            preparedStatement.setString(2, item_id);
            preparedStatement.setInt(3, amount);
            preparedStatement.setTimestamp(4, timestamp);
            preparedStatement.setInt(5, user_id);
            preparedStatement.setFloat(6, buy_price);
            preparedStatement.setFloat(7, sell_price);
            preparedStatement.executeUpdate(); 
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void stockDB(int bill_no, String item_id, int amount, int user_id, float buy_price, float sell_price){
        try{
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            // create a sql date object so we can use it in our INSERT statement
            String query = "insert into stock_add (bill_no, item_id, amount, bill_time, user_id, buy_price, sell_price) values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, bill_no);
            preparedStatement.setString(2, item_id);
            preparedStatement.setInt(3, amount);
            preparedStatement.setTimestamp(4, timestamp);
            preparedStatement.setInt(5, user_id);
            preparedStatement.setFloat(6, buy_price);
            preparedStatement.setFloat(7, sell_price);
            preparedStatement.executeUpdate(); 
            
            String query2 = "UPDATE inventory SET amount=amount+?, buy_price=?, sell_price=? WHERE item_id =?";
            PreparedStatement preparedStatement2 = conn.prepareStatement(query2);
            preparedStatement2.setInt(1, amount);
            preparedStatement2.setFloat(2, buy_price);
            preparedStatement2.setFloat(3, sell_price);
            preparedStatement2.setString(4, item_id);
            preparedStatement2.executeUpdate(); 
            
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void createUser(String name, String password){
        try{
            Statement stmt = conn.createStatement();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            // create a sql date object so we can use it in our INSERT statement
            String query = "insert into users (name, password, created_time) values (?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            preparedStatement.setTimestamp(3, timestamp);
            preparedStatement.executeUpdate(); 
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void createItem(String item_id, String name, float buy_price, float sell_price,int amount, int user_id){
        try{
            // create a sql date object so we can use it in our INSERT statement
            String query = "insert into inventory (name, amount, buy_price, sell_price, item_id, user_id) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, amount);
            preparedStatement.setFloat(3, buy_price);
            preparedStatement.setFloat(4, sell_price);
            preparedStatement.setString(5, item_id);
            preparedStatement.setInt(6, user_id);
            preparedStatement.executeUpdate(); 
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void loginDB(int id){
        try{
            Statement stmt = conn.createStatement();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            // create a sql date object so we can use it in our INSERT statement
            String query = "insert into login (user_id, login_time) values (?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setTimestamp(2, timestamp);
            preparedStatement.executeUpdate(); 
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void databaseClose() throws SQLException{
        conn.close();
    }
}
