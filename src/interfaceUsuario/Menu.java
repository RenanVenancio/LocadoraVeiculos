/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceUsuario;

import locadoraveiculos.Cliente;
import locadoraveiculos.LocadoraDados;
import locadoraveiculos.Veiculo;

/**
 *
 * @author renan
 */
public class Menu extends javax.swing.JFrame {
    
    
    Clientes telaClientes;  // Instancia da tela de clientes
    Veiculos telaVeiculos;  // Instancia da tela de veiculos
    Locar telaLocar;        // Instancia da tela de locacao
    ListarLocacoes listaLocacoes;
    ListarClientes listaClientes;
    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        telaClientes = new Clientes();  telaClientes.setVisible(false);
        telaVeiculos = new Veiculos(-1);  telaVeiculos.setVisible(false);
        telaLocar = new Locar();    telaLocar.setVisible(false);
        listaLocacoes = new ListarLocacoes(); listaLocacoes.setVisible(false);
        listaClientes = new ListarClientes(); listaClientes.setVisible(false);
        
        painelDesktop.add(telaClientes); //adicionando aos componentes
        painelDesktop.add(telaVeiculos); //adicionando aos componentes
        painelDesktop.add(telaLocar); //adicionando aos componentes
        painelDesktop.add(listaLocacoes);
        painelDesktop.add(listaClientes);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelCentral = new javax.swing.JPanel();
        painelDesktop = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        btClientes = new javax.swing.JButton();
        btVeiculos = new javax.swing.JButton();
        btLocar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setResizable(false);
        getContentPane().setLayout(null);

        painelCentral.setLayout(null);

        painelDesktop.setBackground(new java.awt.Color(240, 240, 240));
        painelDesktop.setToolTipText("");

        jPanel1.setLayout(null);

        btClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uiLocadora/img/cliente50x50.png"))); // NOI18N
        btClientes.setText("Clientes");
        btClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClientesActionPerformed(evt);
            }
        });
        jPanel1.add(btClientes);
        btClientes.setBounds(10, 10, 140, 59);

        btVeiculos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uiLocadora/img/veiculos50x50.png"))); // NOI18N
        btVeiculos.setText("Veiculos");
        btVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVeiculosActionPerformed(evt);
            }
        });
        jPanel1.add(btVeiculos);
        btVeiculos.setBounds(160, 10, 140, 59);

        btLocar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uiLocadora/img/locar50x50.png"))); // NOI18N
        btLocar.setText("Locar");
        btLocar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLocarActionPerformed(evt);
            }
        });
        jPanel1.add(btLocar);
        btLocar.setBounds(310, 10, 150, 59);

        painelDesktop.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout painelDesktopLayout = new javax.swing.GroupLayout(painelDesktop);
        painelDesktop.setLayout(painelDesktopLayout);
        painelDesktopLayout.setHorizontalGroup(
            painelDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDesktopLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        painelDesktopLayout.setVerticalGroup(
            painelDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDesktopLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 473, Short.MAX_VALUE))
        );

        painelCentral.add(painelDesktop);
        painelDesktop.setBounds(0, 0, 940, 550);

        getContentPane().add(painelCentral);
        painelCentral.setBounds(-1, -3, 950, 550);

        setBounds(0, 0, 933, 573);
    }// </editor-fold>//GEN-END:initComponents

    private void btClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClientesActionPerformed
        telaClientes.setVisible(true);
    }//GEN-LAST:event_btClientesActionPerformed

    private void btVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVeiculosActionPerformed
        telaVeiculos.setVisible(true);
    }//GEN-LAST:event_btVeiculosActionPerformed

    private void btLocarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLocarActionPerformed
        telaLocar.setVisible(true);
    }//GEN-LAST:event_btLocarActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
        
        
        
        
        Veiculo veiculo = new Veiculo("0", "CARRO", "50.00", "FOX 2016 4P FLEX PRETO", "MOS3422", "4", "SIM", "WOLKSWAGEN", true);
        LocadoraDados.cadastraVeiculo(veiculo);
        
        veiculo = new Veiculo("0", "CARRO", "30.00", "UNO 2P BRANCO 2009", "RES0021", "4", "SIM", "FIAT", true);
        LocadoraDados.cadastraVeiculo(veiculo);
        
        veiculo = new Veiculo("0", "MOTO", "34.00", "CG TITTAN 160 2016 PRETA", "UNH8906", "2", "NÃO", "HONDA", true);
        LocadoraDados.cadastraVeiculo(veiculo);
        
        veiculo = new Veiculo("0", "CARRO", "120.00", "DOBLO PRATA 2017", "KDK8675", "8", "SIM", "FIAT", true);
        LocadoraDados.cadastraVeiculo(veiculo);
        
        veiculo = new Veiculo("0", "MOTO", "18.00", "POP 100 LARANJA 2012", "UNH86000", "2", "NÃO", "HONDA", true);
        LocadoraDados.cadastraVeiculo(veiculo);
        
        veiculo = new Veiculo("0", "CARRO", "110.00", "SPIN BRANCA 2015 CB AUTOMATICO", "RVE3712", "7", "SIM", "CHEVROLET", true);
        LocadoraDados.cadastraVeiculo(veiculo);
         
        Cliente cliente = new Cliente("ANA PAULA RODRIGUES", "1", "RUA JOÃO MARIA DE ARAUJO - CENTRO - JOÃO PESSOA - PB", "9932-3344");
        LocadoraDados.cadastraCliente(cliente);  
        
        cliente = new Cliente("JEFFERSON ANDRÉ DA SILVA", "2", "RUA IEDA RODRIGUES DA ROCHA - CENTRO - MOSSORÓ - RN", "9000-0000");
        LocadoraDados.cadastraCliente(cliente);
        
        cliente = new Cliente("UNIPE - CENTRO UNIVERSITÁRIO DE JOÃO PESSOA", "3", "BR 230 - JOÃO PESSOA - PB", "9000-0000");
        LocadoraDados.cadastraCliente(cliente);
    
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClientes;
    private javax.swing.JButton btLocar;
    private javax.swing.JButton btVeiculos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel painelCentral;
    private javax.swing.JDesktopPane painelDesktop;
    // End of variables declaration//GEN-END:variables
}
