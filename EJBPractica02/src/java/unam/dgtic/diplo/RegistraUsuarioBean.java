/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.dgtic.diplo;

import java.util.ArrayList;
import javax.ejb.Stateful;
import unam.dgtic.diplo.interfaz.RegistraUsuarioRemote;
import unam.dgtic.diplo.modelo.Usuario;

/**
 *
 * @author omarmendozagonzalez
 */
@Stateful
public class RegistraUsuarioBean implements RegistraUsuarioRemote{

    ArrayList<Usuario> usuarios;

    public RegistraUsuarioBean() {
        this.usuarios = new ArrayList<>();
    }
    
    
    @Override
    public void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    
}
