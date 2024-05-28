package com.cadastro_pc.modal.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.cadastro_pc.modal.entities.Pessoa;

public class PessoaTableModal extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    private final List<Pessoa> rows;
    private final String[] columns;

    public PessoaTableModal(List<Pessoa> calledTIs) {
        this.rows = calledTIs;
        this.columns = new String[] { "ID", "NOME", "TELEFONE", "E-MAIL-GMAIL" };
    }

    // Retorna a quantidade de linhas
    @Override
    public int getRowCount() {
        return this.rows.size();
    }

    // Retorna a quantidade de colunas
    @Override
    public int getColumnCount() {
        return this.columns.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return this.columns[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            default:
                return String.class;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pessoa obj = rows.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return obj.getId();
            case 1:
                return obj.getNome();
            case 2:
                return obj.getTelefone();
            case 3:
                return obj.getEmail();
            default:
                throw new IndexOutOfBoundsException("Coluna inexistente");
        }
    }
}
