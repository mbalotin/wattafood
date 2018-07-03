/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guipkg;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author mateus
 */
public class CadastroRefeicaoPanel extends javax.swing.JFrame {

    /**
     * Creates new form CadastroRefeicao
     */
    public CadastroRefeicaoPanel(Sessao _sessao) {
        initComponents();
        sessao = _sessao;
        refeicoes_feitas_map = new HashMap<String, Integer>();
    }

    private Sessao sessao;
    HashMap<String, Integer> refeicoes_feitas_map;
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Refeições feitas");

        jComboBox5.setEditable(true);
        jComboBox5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setText("Alimentos da refeição");

        jComboBox6.setEditable(true);
        jComboBox6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6ActionPerformed(evt);
            }
        });

        jButton16.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton16.setText("Add");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton17.setText("Fechar");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton16)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jComboBox6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12)
                                .addComponent(jButton3)
                                .addComponent(jComboBox5, 0, 330, Short.MAX_VALUE)
                                .addComponent(jLabel7))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jButton17)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(47, 47, 47)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jButton17)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed

        // atualizar combobox com alimentos da refeicao
        // quando esta combobox mudar de selecao
        if (evt.getActionCommand() != "comboBoxChanged"){
            return;
        }

        if (jComboBox5.getSelectedItem() == null){
            return;
        }

        String ref_label = jComboBox5.getSelectedItem().toString();
        if (!refeicoes_feitas_map.containsKey(ref_label)){
            return;
        }

        ArrayList<String> alims = new ArrayList<String>();
        alims = sessao.dbintf.readRegistroRefeicao(refeicoes_feitas_map.get(ref_label));

        jComboBox6.removeAllItems();
        for (String s: alims){
            jComboBox6.addItem(s);
        }
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (jComboBox5.getSelectedItem() == null){
            return;
        }
        String ref_label = jComboBox5.getSelectedItem().toString();
        if (refeicoes_feitas_map.containsKey(ref_label)){
            return; // ja tem este label
        }
        ArrayList<String> alim_dummy = new ArrayList<String>();
        int pk = sessao.dbintf.registrarRefeicao(alim_dummy);
        if (pk == -1){
            return;
        }
        refeicoes_feitas_map.put(ref_label, pk);
        jComboBox5.addItem(ref_label);
        jComboBox6.removeAllItems();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox6ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed

        // alim
        if (jComboBox6.getSelectedItem() == null){
            return;
        }
        String novo_alim_ref = jComboBox6.getSelectedItem().toString();

        // reg. ref
        if (jComboBox5.getSelectedItem() == null){
            return;
        }
        String ref_label = jComboBox5.getSelectedItem().toString();
        if (!refeicoes_feitas_map.containsKey(ref_label)){
            return;
        }

        ArrayList<String> nar_a = new ArrayList<String>();
        nar_a.add(novo_alim_ref);
        sessao.dbintf.insertEmRegistroRefeicao(refeicoes_feitas_map.get(ref_label), nar_a);

        jComboBox6.addItem(novo_alim_ref);

    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton17ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}