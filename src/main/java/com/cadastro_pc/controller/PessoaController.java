package com.cadastro_pc.controller;

import java.util.ArrayList;
import java.util.List;

import com.cadastro_pc.modal.dao.PessoaDao;
import com.cadastro_pc.modal.entities.Pessoa;
import com.cadastro_pc.util.Message;

public class PessoaController {
    private final PessoaDao dao;

    public PessoaController() {
        this.dao = new PessoaDao();
    }

    public void addPessoa(Pessoa enty) {
        try {
            dao.add(enty);
            Message.sucess(null, "Salvo com sucesso!");
        } catch (Exception e) {
            Message.errorX(null, "Erro 'addPessoa' " + e.getMessage());
        }
    }

    public List<Pessoa> listAll() {
        try {
            return dao.findAll();
        } catch (Exception e) {
            Message.errorX(null, "Erro 'listAll' " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public Pessoa findById(int idPessoa) {
        try {
            return dao.findById(idPessoa);
        } catch (Exception e) {
            Message.errorX(null, "Erro ao obter Usuário!!! 'findById' " + e.getMessage());
            return null;
        }
    }

    public boolean updateUser(Pessoa user) {
        try {
            dao.update(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(int enty) {
        try {
            dao.delete(enty);
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }
}
