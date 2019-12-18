/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore_client.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import lk.ijse.dinemore_client.connector.ProxyHandler;
import lk.ijse.dinemore_client.controller.CheffController;
import lk.ijse.dinmore_common.dto.CheffDTO;
import lk.ijse.dinmore_common.dto.TelOperatorDTO;
import lk.ijse.dinmore_common.observer.Observer;
import lk.ijse.dinmore_common.service.custom.LogInService;

/**
 *
 * @author Dell
 */
public class CheffPopup extends javax.swing.JFrame implements Observer{
   
    private String startTime = "";
    private String endTime = "";
    private CheffController controller = new CheffController();
    
    /**
     * Creates new form Popup
     */
    public CheffPopup() {
        try {
            initComponents();
            showTime();
            UnicastRemoteObject.exportObject(this, 0);
            LogInService loginService = ProxyHandler.getInstance().getLogInService();
            loginService.register(this);
        } catch (RemoteException ex) {
            Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public CheffPopup(TelOperatorDTO operatorDTO){
         initComponents();
        txtOrderId.setText(Integer.toString(operatorDTO.getOid()));
        txtCheffId.setText(operatorDTO.getE_id()+"");
        txtCustomerName.setText(operatorDTO.getCustomer_name());
        txtContact.setText(operatorDTO.getCustomer_contact()+"");
        txtFood.setText(operatorDTO.getFood()); 
        txtQuantity.setText(operatorDTO.getQty()+"");
        txtStartTime.setText(operatorDTO.getTime());
     }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtOrderId = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtFood = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtContact = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtStartTime = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnFinshOrder = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        lblFinishTime = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtCheffId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setBackground(new java.awt.Color(69, 50, 69));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Take Order");
        jLabel2.setOpaque(true);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Order Id");

        txtOrderId.setEditable(false);
        txtOrderId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtOrderId.setToolTipText("");
        txtOrderId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrderIdActionPerformed(evt);
            }
        });

        txtQuantity.setEditable(false);
        txtQuantity.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtQuantity.setToolTipText("");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Quantity");

        txtFood.setEditable(false);
        txtFood.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtFood.setToolTipText("");
        txtFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFoodActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Food");

        txtContact.setEditable(false);
        txtContact.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtContact.setToolTipText("");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Customer Contact");

        txtCustomerName.setEditable(false);
        txtCustomerName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCustomerName.setToolTipText("");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Customer Name");

        txtStartTime.setEditable(false);
        txtStartTime.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtStartTime.setToolTipText("");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Start Time");

        btnFinshOrder.setBackground(new java.awt.Color(0, 102, 51));
        btnFinshOrder.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnFinshOrder.setText("Finish Order");
        btnFinshOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinshOrderActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Finish Time");

        lblFinishTime.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Cheff Id");

        txtCheffId.setEditable(false);
        txtCheffId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCheffId.setToolTipText("");
        txtCheffId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCheffIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtQuantity)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFood, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCustomerName)
                                    .addComponent(txtContact, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE))
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtStartTime)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtOrderId, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCheffId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(btnFinshOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblFinishTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOrderId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCheffId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel10)
                .addGap(7, 7, 7)
                .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel11)
                .addGap(7, 7, 7)
                .addComponent(txtStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFinishTime, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFinshOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtOrderIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrderIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrderIdActionPerformed

    private void btnFinshOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinshOrderActionPerformed
        try {
            int oid = Integer.parseInt(txtOrderId.getText());
            int e_id = Integer.parseInt(txtCheffId.getText());
            String name = txtCustomerName.getText();
            int contact = Integer.parseInt(txtContact.getText());
            String food = txtFood.getText();
            int qty = Integer.parseInt(txtQuantity.getText());
            
            startTime = controller.getStartTime(oid);
            endTime = LocalTime.now().toString();
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            Date start = format.parse(startTime);
            Date end = format.parse(endTime);
            long time = end.getTime() - start.getTime();
            long timess = time / 1000 % 60;
            long timemm = time / (60 * 1000) & 60;
            long timehh = time / (60 * 60 * 1000) % 24;

            String duration = timehh + " : " + timemm + " : " + timess;
            
            boolean finishOrder = controller.finishOrder(new CheffDTO(oid, e_id, name, contact,food, qty, duration));
            System.out.println("finishOrder :"+finishOrder);
            if (finishOrder) {
                JOptionPane.showMessageDialog(this, "Order completed...");
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Order not completed...");
            }
        } catch (Exception ex) {
            Logger.getLogger(CheffPopup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFinshOrderActionPerformed

    private void txtFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFoodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFoodActionPerformed

    private void txtCheffIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCheffIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCheffIdActionPerformed

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
            java.util.logging.Logger.getLogger(CheffPopup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheffPopup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheffPopup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheffPopup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheffPopup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinshOrder;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFinishTime;
    private javax.swing.JTextField txtCheffId;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtFood;
    private javax.swing.JTextField txtOrderId;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtStartTime;
    // End of variables declaration//GEN-END:variables
private void showTime() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss a");
                lblFinishTime.setText(simpleDateFormat.format(date));
            }
        }).start();
    }

    @Override
    public void update(String message) throws Exception {
       JOptionPane.showMessageDialog(this, message);
    }
}
