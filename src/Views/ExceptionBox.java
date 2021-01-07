/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

/**
 *
 * @author Dimuthu
 */
public class ExceptionBox extends javax.swing.JFrame {

    /**
     * Creates new form ExceptionBox
     */
    Exception e;
    String message;
    public ExceptionBox() {
        initComponents();
    }
    
    public ExceptionBox(Exception e) {
        this.e = e;
        initComponents();
        display.setText(e.toString());
    }
    
    public ExceptionBox(String message) {
        this.message = message;
        initComponents();
        System.out.println("fff");
        display.setText(message);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        display = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        display.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        display.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                displayKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(display, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(display, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void displayKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_displayKeyPressed
        // TODO add your handling code here:
        int a = evt.getKeyCode();
        if(a==10){
            this.dispose();
        }
    }//GEN-LAST:event_displayKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel display;
    // End of variables declaration//GEN-END:variables
}