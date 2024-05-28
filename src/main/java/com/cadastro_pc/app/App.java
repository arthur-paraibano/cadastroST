package com.cadastro_pc.app;

import com.cadastro_pc.util.Theme;
import com.cadastro_pc.util.base.BaseDados;
import com.cadastro_pc.view.CadastroView;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Theme.setTheme(Theme.WINDOWS);
        BaseDados.testConnection();
        CadastroView tela = new CadastroView();
        tela.setVisible(true);
    }
}
