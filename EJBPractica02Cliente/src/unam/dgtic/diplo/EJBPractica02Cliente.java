/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.dgtic.diplo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import unam.dgtic.diplo.interfaz.RegistraUsuarioRemote;
import unam.dgtic.diplo.modelo.Usuario;

/**
 *
 * @author omarmendozagonzalez
 */
public class EJBPractica02Cliente {
    
    BufferedReader br = null;
    {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EJBPractica02Cliente test = new EJBPractica02Cliente();
        test.testStateFullEjb();
    }
    
    private void showGUI(){
        System.out.println("************************");
        System.out.println("Registro de Usuario");
        System.out.println("************************");
        System.out.println("Opciones: \n1. Agregar \n2.Listar \n3. Salir\nIngresa tu opcion: ");
    }
    
    private void testStateFullEjb(){
        try {
            int op = 1;
            RegistraUsuarioRemote ru = (RegistraUsuarioRemote)
                    InitialContext.doLookup("java:global/EJBPractica02/RegistraUsuarioBean!unam.dgtic.diplo.interfaz.RegistraUsuarioRemote");
            while(op != 3){
                String nom, ap, email, pass;
                showGUI();
                op = Integer.parseInt(br.readLine());
                if(op == 1){
                    System.out.println("Ingresa el nombre: ");
                    nom = br.readLine();
                    System.out.println("Ingresa los apellidos; ");
                    ap = br.readLine();
                    System.out.println("Ingresa el email; ");
                    email = br.readLine();
                    System.out.println("Ingresa el pass: ");
                    pass = br.readLine();
                    
                    Usuario usuario = new Usuario(nom, ap, email, pass);
                    ru.addUsuario(usuario);
                }else if(op == 2){
                    ArrayList<Usuario> usuarios = ru.getUsuarios();
                    System.out.println("Usuario(s) registrado(s) " + usuarios.size());
                    for(Usuario u:usuarios){
                        System.out.println(u.toString() + "[" + u.getCorreo()+"]");
                        
                    }
                }else if(op == 3 ){
                    break;
                }
                
                
                RegistraUsuarioRemote ru1 = (RegistraUsuarioRemote)
                    InitialContext.doLookup("java:global/EJBPractica02/RegistraUsuarioBean!unam.dgtic.diplo.interfaz.RegistraUsuarioRemote");
                ArrayList<Usuario> usuarios = ru1.getUsuarios();
                    System.out.println("Usuario(s) registrado(s) " + usuarios.size());
                    for(Usuario u:usuarios){
                        System.out.println(u.toString() + "[" + u.getCorreo()+"]");
                        
                    }
                
            }
        } catch (Exception ex) {
            Logger.getLogger(EJBPractica02Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                if(br != null){
                    br.close();
                }
            }catch (IOException ex){
                System.out.println(ex.getMessage());
            }
        }
        
    }
}
