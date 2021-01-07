/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Dimuthu
 */
public class NewItem extends javax.swing.JFrame {

    /**
     * Creates new form NewItem
     */
    private int user_id;
    private JTextArea transDialog;
    private JTextField txt;
    private List<Cart> transactionItem = new ArrayList<>(); //this list will store all items to be used in this sale
    private String  name, id;
    private int amount_item;
    private float buy_price, sell_price;
    
    public NewItem() {
        initComponents();
    }
    
    public NewItem(int user_id, JTextArea transDialog, JTextField txt, List<Cart> transactionItem) {
        this.transactionItem = transactionItem;
        this.transDialog = transDialog;
        this.txt = txt;
        this.user_id = user_id;
        initComponents();
    }
    
    private void updateTextArea()
    {
	transDialog.setText(null);
        txt.setText(null);
        float total = 0;
        for (Cart temp: transactionItem)
        {
            String itemString = temp.name+"\t"+temp.amount+"\t"+String.format("%.2f", temp.amount*temp.sell_price)+"\n";
            transDialog.append(itemString);
            total = total+temp.amount*temp.sell_price;
        }
        txt.setText(null);
    }
    
    public void addItem(){
        this.setVisible(false);
        amount_item = Integer.valueOf(amount_text.getText());
        id = item_text.getText();
        name = name_text.getText();
        buy_price = Float.valueOf(buy_price_text.getText());
        sell_price = Float.valueOf(sell_price_text.getText());
        Cart cart_item = new Cart(id, name, amount_item, buy_price, sell_price);
        transactionItem.add(cart_item);
        DatabasePOS db = new DatabasePOS();
        db.createItem(id, name, buy_price, sell_price, amount_item, user_id);
        updateTextArea();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        item_text = new javax.swing.JTextField();
        amount_text = new javax.swing.JTextField();
        buy_price_text = new javax.swing.JTextField();
        sell_price_text = new javax.swing.JTextField();
        jlabeltext = new javax.swing.JLabel();
        name_text = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Item Code");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Amount");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Buying Price");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Selling Price");

        item_text.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        item_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                item_textKeyPressed(evt);
            }
        });

        amount_text.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        amount_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                amount_textKeyPressed(evt);
            }
        });

        buy_price_text.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        buy_price_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buy_price_textKeyPressed(evt);
            }
        });

        sell_price_text.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        sell_price_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sell_price_textKeyPressed(evt);
            }
        });

        jlabeltext.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jlabeltext.setText("Name");

        name_text.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        name_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                name_textKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabeltext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(item_text)
                    .addComponent(amount_text)
                    .addComponent(buy_price_text)
                    .addComponent(sell_price_text)
                    .addComponent(name_text, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(item_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabeltext)
                    .addComponent(name_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(amount_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(buy_price_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(sell_price_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void item_textKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_item_textKeyPressed
        // TODO add your handling code here:
        int a = evt.getKeyCode();
        if(a==10){
            name_text.requestFocus();
        }
    }//GEN-LAST:event_item_textKeyPressed

    private void amount_textKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amount_textKeyPressed
        // TODO add your handling code here:
        int a = evt.getKeyCode();
        if(a==10){
            buy_price_text.requestFocus();
        }
    }//GEN-LAST:event_amount_textKeyPressed

    private void buy_price_textKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buy_price_textKeyPressed
        // TODO add your handling code here:
        int a = evt.getKeyCode();
        if (a==10){
            sell_price_text.requestFocus();
        }
    }//GEN-LAST:event_buy_price_textKeyPressed

    private void sell_price_textKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sell_price_textKeyPressed
        // TODO add your handling code here:
        int a = evt.getKeyCode();
        if(a==10){
            this.dispose();
            addItem();
        }
    }//GEN-LAST:event_sell_price_textKeyPressed

    private void name_textKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_name_textKeyPressed
        // TODO add your handling code here:
        int a = evt.getKeyCode();
        if (a==10){
            amount_text.requestFocus();
        }
    }//GEN-LAST:event_name_textKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewItem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amount_text;
    private javax.swing.JTextField buy_price_text;
    private javax.swing.JTextField item_text;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jlabeltext;
    private javax.swing.JTextField name_text;
    private javax.swing.JTextField sell_price_text;
    // End of variables declaration//GEN-END:variables
}