package com.cadastro_pc.view;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;

import javax.swing.text.MaskFormatter;

import com.cadastro_pc.controller.PessoaController;
import com.cadastro_pc.modal.entities.Pessoa;
import com.cadastro_pc.util.EnterToTab;
import com.cadastro_pc.util.Message;
import com.cadastro_pc.util.TransformFieldUppcase;
import com.cadastro_pc.util.ValidGmail;

public class UpdateView extends javax.swing.JDialog {
        private javax.swing.JButton jButt_Salvar;
        private javax.swing.JButton jButt_Sair;
        private javax.swing.JFormattedTextField jFormat_Telefone;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JTextField jTexF_Email;
        private javax.swing.JTextField jTexF_Nome;

        private final PessoaController pessoaController;
        private Pessoa user;

        public UpdateView(Pessoa userPessoa) {
                initComponents();
                setModal(true);
                this.pessoaController = new PessoaController();
                this.user = userPessoa;
                this.metodos();
                this.lodDados();
        }

        private void lodDados() {
                adicionarWindowListenerParaTelaLogin();
                jTexF_Nome.setText(user.getNome());
                jFormat_Telefone.setText(user.getTelefone());
                jTexF_Email.setText(user.getEmail());
        }

        private void metodos() {
                jTexF_Nome.setDocument(new TransformFieldUppcase(50));
                jTexF_Email.setDocument(new TransformFieldUppcase(50));
                EnterToTab.add(jTexF_Nome);
                EnterToTab.add(jTexF_Email);
                EnterToTab.add(jFormat_Telefone);
        }

        private void initComponents() {
                jPanel1 = new javax.swing.JPanel();
                jTexF_Nome = new javax.swing.JTextField();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                jTexF_Email = new javax.swing.JTextField();
                jLabel4 = new javax.swing.JLabel();
                jButt_Salvar = new javax.swing.JButton();
                jFormat_Telefone = new javax.swing.JFormattedTextField();
                jButt_Sair = new javax.swing.JButton();

                setTitle("Alterar");
                setBackground(new java.awt.Color(255, 255, 255));
                setMaximumSize(new java.awt.Dimension(846, 270));
                setMinimumSize(new java.awt.Dimension(846, 270));
                setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
                setResizable(false);
                setType(java.awt.Window.Type.UTILITY);
                // Torna a tela sempre visível
                setAlwaysOnTop(true);
                // Desabilita a opção de mover a tela
                setUndecorated(true);

                jPanel1.setBackground(new java.awt.Color(255, 255, 255));
                jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));

                jPanel1.setBackground(new java.awt.Color(255, 255, 255));
                jPanel1.setMaximumSize(new java.awt.Dimension(846, 270));
                jPanel1.setMinimumSize(new java.awt.Dimension(846, 270));

                jTexF_Nome.setFont(new java.awt.Font("Perpetua Titling MT", 0, 14)); // NOI18N

                jLabel2.setFont(new java.awt.Font("Perpetua Titling MT", 1, 12)); // NOI18N
                jLabel2.setText("Nome");
                jLabel3.setFont(new java.awt.Font("Perpetua Titling MT", 1, 12)); // NOI18N
                jLabel3.setText("Telefone");

                jTexF_Email.setFont(new java.awt.Font("Perpetua Titling MT", 0, 14)); // NOI18N

                jLabel4.setFont(new java.awt.Font("Perpetua Titling MT", 1, 12)); // NOI18N
                jLabel4.setText("Gmail / e-mail");

                jButt_Salvar.setText("Salvar");
                jButt_Salvar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButt_SalvarActionPerformed(evt);
                        }
                });

                try {
                        jFormat_Telefone = new javax.swing.JFormattedTextField(new MaskFormatter("(##) #####-####"));
                } catch (ParseException e) {
                        e.printStackTrace();
                }
                jFormat_Telefone.setFormatterFactory(
                                new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

                jButt_Sair.setText("Sair");
                jButt_Sair.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButt_SairActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(22, 22, 22)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabel4,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                230,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jTexF_Email,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                384,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addContainerGap(
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabel2,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                230,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jTexF_Nome,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                384,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                135,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                false)
                                                                                                                .addComponent(jLabel3,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(jFormat_Telefone,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                230,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGap(75, 75, 75))))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                                .createSequentialGroup()
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                jPanel1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(jButt_Sair,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                84,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGap(369, 369,
                                                                                                                                369))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                jPanel1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(jButt_Salvar,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                144,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGap(343, 343,
                                                                                                                                343)))));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(16, 16, 16)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel2,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                30,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addComponent(jTexF_Nome,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                36,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel3,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                30,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addComponent(jFormat_Telefone,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                36,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel4,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                30,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jTexF_Email,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                36,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                23,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(jButt_Salvar,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                34,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jButt_Sair)
                                                                .addContainerGap()));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                pack();
                setLocationRelativeTo(null);
        }

        private void jButt_SalvarActionPerformed(java.awt.event.ActionEvent evt) {

                String nome = jTexF_Nome.getText();
                String telefone = jFormat_Telefone.getText().replaceAll("[^0-9]", "");
                String email = jTexF_Email.getText();

                if (!nome.isEmpty() && !telefone.isEmpty() && !email.isEmpty()) {
                        if (ValidGmail.isValidEmail(email)) {
                                user.setNome(nome);
                                user.setTelefone(telefone);
                                user.setEmail(email);

                                boolean result = this.pessoaController.updateUser(user);
                                if (result) {
                                        dispose();
                                        Message.sucess(this, "Dados atualizados com sucesso!");
                                } else {
                                        dispose();
                                        Message.sqlErro(this, "Erro ao atualizar dados!");
                                }
                        } else {
                                Message.erroTrist(this, "E-mail / Gmail inválido!!!");
                        }
                } else {
                        Message.erroTrist(this, "Preencha todos os campos!!!");
                }
        }

        private void jButt_SairActionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
        }

        private void adicionarWindowListenerParaTelaLogin() {
                addWindowListener(new WindowListener() {
                        @Override
                        public void windowOpened(WindowEvent e) {
                                // Método não utilizado
                        }

                        @Override
                        public void windowClosing(WindowEvent e) {
                                // Método não utilizado
                        }

                        @Override
                        public void windowClosed(WindowEvent e) {
                                // Tela principal fechada, reabrir a tela de login
                                CadastroView telaLoginView = new CadastroView();
                                telaLoginView.setVisible(true);
                        }

                        @Override
                        public void windowIconified(WindowEvent e) {
                                // Método não utilizado
                        }

                        @Override
                        public void windowDeiconified(WindowEvent e) {
                                // Método não utilizado
                        }

                        @Override
                        public void windowActivated(WindowEvent e) {
                                // Método não utilizado
                        }

                        @Override
                        public void windowDeactivated(WindowEvent e) {
                                // Método não utilizado
                        }
                });
        }
}