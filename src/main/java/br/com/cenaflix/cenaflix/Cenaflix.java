package br.com.cenaflix.cenaflix;

import br.com.cenaflix.gui.TelaLogin;
import javax.swing.JOptionPane;

/**
 *
 * @author glaub
 */
public class Cenaflix {

    public static void main(String[] args) {
        
        JOptionPane.showMessageDialog(null,"Para validar usuarios\nLogin:user1 Senha:123\nLogin:user2 Senha:123\nLogin:user3 Senha:123 ","Atenção",0);
        
        TelaLogin telaLogin = new TelaLogin();
        telaLogin.setVisible(true);
    }
}
