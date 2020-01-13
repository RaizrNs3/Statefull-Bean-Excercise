/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.dgtic.diplo.interfaz;

import java.util.ArrayList;
import javax.ejb.Remote;
import unam.dgtic.diplo.modelo.Usuario;

/**
 *
 * @author omarmendozagonzalez
 */
@Remote
public interface RegistraUsuarioRemote {
    void addUsuario(Usuario usuario);
    ArrayList<Usuario> getUsuarios();
}
