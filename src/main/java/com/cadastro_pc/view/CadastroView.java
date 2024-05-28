package com.cadastro_pc.view;

import java.awt.Toolkit;
import java.text.ParseException;
import java.util.List;

import javax.swing.ListSelectionModel;
import javax.swing.text.MaskFormatter;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.cadastro_pc.controller.PessoaController;
import com.cadastro_pc.modal.entities.Pessoa;
import com.cadastro_pc.modal.table.PessoaTableModal;
import com.cadastro_pc.util.EnterToTab;
import com.cadastro_pc.util.Message;
import com.cadastro_pc.util.TableUtil;
import com.cadastro_pc.util.TransformFieldUppcase;
import com.cadastro_pc.util.ValidGmail;

public class CadastroView extends javax.swing.JFrame {
    private javax.swing.JButton jButt_Limpar;
    private javax.swing.JButton jButt_Puscar;
    private javax.swing.JButton jButt_Sair;
    private javax.swing.JButton jButt_Salvar;
    private javax.swing.JComboBox<String> jCBox_Puscar;
    private javax.swing.JFormattedTextField jFormat_Telefone;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTab_Informacoes;
    private javax.swing.JTextField jTexF_Email;
    private javax.swing.JTextField jTexF_Nome;

    private int lastSelectedRowIndex = -1;
    private final Pessoa entyPessoa;
    private List<Pessoa> listPessoas;
    private final PessoaController pessoaController;

    public CadastroView() {
        initComponents();
        this.entyPessoa = new Pessoa();
        this.pessoaController = new PessoaController();
        initMetods();
        metodos();
    }

    private void metodos() {
        jTexF_Nome.setDocument(new TransformFieldUppcase(50));
        jTexF_Email.setDocument(new TransformFieldUppcase(50));
        EnterToTab.add(jTexF_Nome);
        EnterToTab.add(jTexF_Email);
        EnterToTab.add(jFormat_Telefone);
        AutoCompleteDecorator.decorate(jCBox_Puscar);
        populCobobox();
        lodTable();
    }

    private void initMetods() {
        // Adicione um WindowListener para detectar o fechamento da tela principal
        setIconImage(Toolkit.getDefaultToolkit()
                .getImage(getClass().getResource("/com/cadastro_pc/resources/cadastro-64.png")));
    }

    private void add() {
        String nome = jTexF_Nome.getText();
        String telefone = jFormat_Telefone.getText().replaceAll("[^0-9]", "");
        String email = jTexF_Email.getText();

        if (!nome.isEmpty() && !telefone.isEmpty() && !email.isEmpty()) {
            if (ValidGmail.isValidEmail(email)) {
                entyPessoa.setNome(nome);
                entyPessoa.setTelefone(telefone);
                entyPessoa.setEmail(email);

                this.pessoaController.addPessoa(entyPessoa);
                populCobobox();
                lodTable();
            } else {
                Message.erroTrist(null, "E-mail / Gmail inválido!!!");
            }
        } else {
            Message.erroTrist(null, "Preencha todos os campos!!!");
        }
    }

    private void buscar() {
        if (jCBox_Puscar.getSelectedIndex() >= 0) {
            String nome = jCBox_Puscar.getSelectedItem().toString();
            lodTable();
            int rowCount = jTab_Informacoes.getRowCount();
            int startRow = lastSelectedRowIndex + 1;
            if (lastSelectedRowIndex < 0 || lastSelectedRowIndex >= rowCount) {
                startRow = 0;
            }
            boolean found = false;
            for (int row = startRow; row < rowCount; row++) {
                Object value = jTab_Informacoes.getValueAt(row, 1);
                if (value != null && value.toString().equals(nome)) {
                    jTab_Informacoes.setRowSelectionInterval(row, row);
                    lastSelectedRowIndex = row; // Atualiza o índice da última linha selecionada
                    found = true;
                    break;
                }
            }
            if (!found) {
                for (int row = 0; row < startRow; row++) {
                    Object value = jTab_Informacoes.getValueAt(row, 1);
                    if (value != null && value.toString().equals(nome)) {
                        jTab_Informacoes.setRowSelectionInterval(row, row);
                        lastSelectedRowIndex = row; // Atualiza o índice da última linha
                                                    // selecionada
                        break;
                    }
                }
            }
        }
    }

    private void populCobobox() {
        this.listPessoas = this.pessoaController.listAll();
        jCBox_Puscar.removeAllItems();
        for (Pessoa listPessoas : listPessoas) {
            jCBox_Puscar.addItem(listPessoas.getNome());
        }
    }

    private void limpar() {
        jTexF_Nome.setText("");
        jTexF_Email.setText("");
        jFormat_Telefone.setText("");
    }

    private void lodTable() {
        PessoaTableModal modal = new PessoaTableModal(this.pessoaController.listAll());
        configTable(modal);
    }

    private void configTable(PessoaTableModal model) {
        jTab_Informacoes.setModel(model);
        jTab_Informacoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTab_Informacoes.getTableHeader().setReorderingAllowed(false);
        TableUtil.hide(jTab_Informacoes, 0);
        TableUtil.showToltip(jTab_Informacoes, 1);
        TableUtil.showToltip(jTab_Informacoes, 2);
        TableUtil.showToltip(jTab_Informacoes, 3);

        jTab_Informacoes.getColumnModel().getColumn(1).setResizable(false);
        jTab_Informacoes.getColumnModel().getColumn(2).setResizable(false);
        jTab_Informacoes.getColumnModel().getColumn(3).setResizable(false);

        jTab_Informacoes.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTab_Informacoes.getColumnModel().getColumn(2).setPreferredWidth(140);
        jTab_Informacoes.getColumnModel().getColumn(3).setPreferredWidth(140);
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTexF_Nome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTab_Informacoes = new javax.swing.JTable();
        jCBox_Puscar = new javax.swing.JComboBox<>();
        jButt_Puscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTexF_Email = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButt_Salvar = new javax.swing.JButton();
        jButt_Limpar = new javax.swing.JButton();
        jButt_Sair = new javax.swing.JButton();
        jFormat_Telefone = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro");
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(846, 597));
        setMinimumSize(new java.awt.Dimension(846, 597));
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setResizable(false);
        setType(java.awt.Window.Type.NORMAL);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Baskerville Old Face", 1, 26)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Cadastro");

        jTexF_Nome.setFont(new java.awt.Font("Perpetua Titling MT", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Perpetua Titling MT", 1, 12)); // NOI18N
        jLabel2.setText("Nome");

        jTab_Informacoes.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        {},
                        {},
                        {},
                        {}
                },
                new String[] {

                }));
        jScrollPane1.setViewportView(jTab_Informacoes);

        jButt_Puscar
                .setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cadastro_pc/resources/pesquisar.png"))); // NOI18N
        jButt_Puscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButt_Puscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButt_PuscarActionPerformed(evt);
            }
        });

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

        jButt_Limpar.setText("Limpar");
        jButt_Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButt_LimparActionPerformed(evt);
            }
        });

        jButt_Sair.setText("Sair");
        jButt_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButt_SairActionPerformed(evt);
            }
        });

        try {
            jFormat_Telefone = new javax.swing.JFormattedTextField(new MaskFormatter("(##) #####-####"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        jFormat_Telefone.setFont(new java.awt.Font("Arial", 0, 12));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTexF_Email,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 384,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTexF_Nome,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 384,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jFormat_Telefone,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 230,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(75, 75, 75))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(49, 49, 49)
                                                                .addComponent(jCBox_Puscar,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 634,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(26, 26, 26)
                                                                .addComponent(jButt_Puscar))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(234, 234, 234)
                                                                .addComponent(jButt_Limpar,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(180, 180, 180)
                                                                .addComponent(jButt_Sair,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 95, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1)))
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButt_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 144,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(380, 380, 380)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTexF_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jFormat_Telefone,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTexF_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39,
                                        Short.MAX_VALUE)
                                .addComponent(jButt_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButt_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButt_Limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jCBox_Puscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButt_Puscar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 6, Short.MAX_VALUE)));

        pack();
        setLocationRelativeTo(null);
    }

    private void jButt_PuscarActionPerformed(java.awt.event.ActionEvent evt) {
        this.buscar();
    }

    private void jButt_SalvarActionPerformed(java.awt.event.ActionEvent evt) {
        this.add();
    }

    private void jButt_LimparActionPerformed(java.awt.event.ActionEvent evt) {
        this.limpar();
    }

    private void jButt_SairActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }
}