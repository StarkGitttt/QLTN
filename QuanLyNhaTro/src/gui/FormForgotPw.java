/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

/**
 *
 * @author DELL
 */
public class FormForgotPw extends javax.swing.JDialog {
    String placeHolder = " Your Code";
    int random = 0;
    boolean confirmSendMail = false;
    /**
     * Creates new form FormForgotPw
     */
    public FormForgotPw(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Forgot Password Form");
        setLocationRelativeTo(null);
        initError();
        setPlaceholder();
        txtUser.requestFocus();
    }
    public void setPlaceholder() {
        LineBorder lineBorder =new LineBorder(Color.white, 15, true);
        txtCode.setBorder(lineBorder);
        // Set Place Holder
        txtCode.setText(placeHolder);
        txtCode.setForeground(new java.awt.Color(170, 170, 170));
    }
    public void initError() {
        lblErrPw.setText("");
        lblErrUser.setText("");
        lblErrConfirmPw.setText("");
    }
    public void resetError() {
        initError();
        txtUser.setBackground(Color.white);
        txtPw.setBackground(Color.white);
        txtConfirmPw.setBackground(Color.white);
    }
    public void resetForm() {
        resetError();
        txtUser.setText("");
        txtPw.setText("");
        txtConfirmPw.setText("");
        txtCode.setText(placeHolder);
        txtCode.setForeground(new java.awt.Color(170, 170, 170));
    }
    public void randomCode() {
        random = (int) Math.round((Math.random() * 100000) + 100000);
    }
 
     public boolean validatePw() {
         boolean isValid = false;
         String getPw = new String(txtPw.getPassword());
         if(getPw.equals("")) {
            lblErrPw.setText("Vui lòng nhập trường này");
            lblErrPw.setForeground(new java.awt.Color(255, 51, 51));
            txtPw.setBackground(new java.awt.Color(255, 237, 94));
            isValid = true;
            return isValid;
         }
         if(getPw.length() < 6) {
            lblErrPw.setText("Vui lòng nhập tối thiểu 6 kí tự");
            lblErrPw.setForeground(new java.awt.Color(255, 51, 51));
            txtPw.setBackground(new java.awt.Color(255, 237, 94));
            isValid = true;
         }
         return isValid;
     }
     public boolean validateConfirmPw() {
         boolean isValid = false;
         String getPw = new String(txtPw.getPassword());
         String getPwConfirm = new String(txtConfirmPw.getPassword());
         if(getPwConfirm.equals("")) {
            lblErrConfirmPw.setText("Vui lòng nhập trường này");
            lblErrConfirmPw.setForeground(new java.awt.Color(255, 51, 51));
            txtConfirmPw.setBackground(new java.awt.Color(255, 237, 94));
            isValid = true;
            return isValid;
         }
         if(!getPwConfirm.equals(getPw)) {
            lblErrConfirmPw.setText("Vui lòng nhập mật khẩu chính xác");
            lblErrConfirmPw.setForeground(new java.awt.Color(255, 51, 51));
            txtConfirmPw.setBackground(new java.awt.Color(255, 237, 94));
            isValid = true;
         }
         return isValid;
     }
    public boolean validateUser() {
        boolean isValid = false;
        if(txtUser.getText().equals("")) {
            lblErrUser.setText("Mời nhập tên tài khoản");
            lblErrUser.setForeground(new java.awt.Color(255, 51, 51));
            txtUser.setBackground(new java.awt.Color(255, 237, 94));
            isValid = true;
            return isValid;
        }
        return isValid;
    }
    public void validateAll() {
        boolean isFormValid = true;
        if(validateUser()) {
            isFormValid = false;
        }
        if(isFormValid) {
//            sendMail();
            confirmSendMail = true;
        }
    }
    public void changePw() {
          if(confirmSendMail) {
            boolean existData = true;
            String getCode = txtCode.getText();
            if(!getCode.equals(random + "")) {
                existData = false;
                JOptionPane.showMessageDialog(this, "Mã không hợp lệ vui lòng kiểm tra lại");
                return;
            }
            if(validatePw()) {
                existData = false;
            }
            if(validateConfirmPw()) {
                existData = false;
            }
            if(existData) {
                String getUserName = txtUser.getText();
                String getPw = new String(txtPw.getPassword());
                boolean changePwSuccess = true;
//                RoleDAO roleDAO = new RoleDAO();
//                changePwSuccess = roleDAO.getPassword(getUserName, getPw);
//                if(changePwSuccess) {              
//                    JOptionPane.showMessageDialog(this, "User: " + getUserName + " đã được cập nhập mật khẩu thành công");
//                    resetForm();
//                    confirmSendMail = false;
//                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng nhận mã qua Email trước khi đổi mật khẩu");
            
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        btnGetCode = new javax.swing.JButton();
        lblPw = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblErrUser = new javax.swing.JLabel();
        lblErrPw = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        lblErrConfirmPw = new javax.swing.JLabel();
        txtConfirmPw = new javax.swing.JPasswordField();
        lblConfirmPw = new javax.swing.JLabel();
        txtPw = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        btnChangePw = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitle.setText("LẤY LẠI MẬT KHẨU");

        lblUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblUser.setText("Tên tài khoản");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 51, 0));
        jLabel2.setText("*");

        txtUser.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserFocusLost(evt);
            }
        });
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserKeyPressed(evt);
            }
        });

        btnGetCode.setBackground(new java.awt.Color(1, 157, 176));
        btnGetCode.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGetCode.setForeground(new java.awt.Color(255, 255, 255));
        btnGetCode.setText("NHẬN MÃ");
        btnGetCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetCodeActionPerformed(evt);
            }
        });

        lblPw.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPw.setText("Mật khẩu mới");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 51, 0));
        jLabel4.setText("*");

        lblErrUser.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblErrUser.setText("Error Message");

        lblErrPw.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblErrPw.setText("Error Message");

        txtCode.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodeKeyTyped(evt);
            }
        });

        lblErrConfirmPw.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblErrConfirmPw.setText("Error Message");

        txtConfirmPw.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtConfirmPw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtConfirmPwKeyPressed(evt);
            }
        });

        lblConfirmPw.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblConfirmPw.setText("Nhập lại mật khẩu");

        txtPw.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtPw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPwKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 51, 0));
        jLabel1.setText("*");

        btnChangePw.setBackground(new java.awt.Color(1, 157, 176));
        btnChangePw.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnChangePw.setForeground(new java.awt.Color(255, 255, 255));
        btnChangePw.setText("ĐỔI MẬT KHẨU");
        btnChangePw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePwActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPw)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblConfirmPw)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtUser)
                    .addComponent(txtPw)
                    .addComponent(txtConfirmPw)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnGetCode, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(btnChangePw))
                    .addComponent(lblErrUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblErrPw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblErrConfirmPw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(130, 130, 130))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPw)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPw, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrPw)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConfirmPw)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConfirmPw, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrConfirmPw)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChangePw, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGetCode, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGetCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetCodeActionPerformed
        validateAll();
    }//GEN-LAST:event_btnGetCodeActionPerformed

    private void txtUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserFocusLost
        validateUser();
    }//GEN-LAST:event_txtUserFocusLost

    private void txtUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyPressed
        lblErrUser.setText("");
        txtUser.setBackground(Color.white);
    }//GEN-LAST:event_txtUserKeyPressed

    private void txtCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodeKeyTyped
        if(txtCode.getText().equalsIgnoreCase(placeHolder)) {
            txtCode.setText("");
            txtCode.setForeground(Color.black);
        } else if(txtCode.getText().equalsIgnoreCase("")) {
            txtCode.setText(placeHolder);
            txtCode.setForeground(new java.awt.Color(170, 170, 170));
        }
    }//GEN-LAST:event_txtCodeKeyTyped

    private void btnChangePwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePwActionPerformed
                changePw();       
    }//GEN-LAST:event_btnChangePwActionPerformed

    private void txtPwKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPwKeyPressed
        lblErrPw.setText(null);
        txtPw.setBackground(Color.white);
    }//GEN-LAST:event_txtPwKeyPressed

    private void txtConfirmPwKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConfirmPwKeyPressed
        lblErrConfirmPw.setText(null);
        txtConfirmPw.setBackground(Color.white);
    }//GEN-LAST:event_txtConfirmPwKeyPressed

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

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
            java.util.logging.Logger.getLogger(FormForgotPw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormForgotPw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormForgotPw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormForgotPw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormForgotPw dialog = new FormForgotPw(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangePw;
    private javax.swing.JButton btnGetCode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblConfirmPw;
    private javax.swing.JLabel lblErrConfirmPw;
    private javax.swing.JLabel lblErrPw;
    private javax.swing.JLabel lblErrUser;
    private javax.swing.JLabel lblPw;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTextField txtCode;
    private javax.swing.JPasswordField txtConfirmPw;
    private javax.swing.JPasswordField txtPw;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
