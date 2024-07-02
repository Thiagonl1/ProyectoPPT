package thiago.ppt3v2.persistencia;

import java.util.logging.Level;
import java.util.logging.Logger;
import thiago.ppt3v2.logica.Cartas;
import thiago.ppt3v2.logica.Usuario;
import thiago.ppt3v2.persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();
    CartasJpaController cartaJpa = new CartasJpaController();

    
    // ------------------- USUARIO -----------------
    
    public void crearUsuario(Usuario usuario){
        usuarioJpa.create(usuario);
    }

    public void eliminarUsuario(int id) {
        try {
            usuarioJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarUsuario(Usuario usuario) {
        try {
            usuarioJpa.edit(usuario);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario traerUsuario(int id) {
       return usuarioJpa.findUsuario(id);
    }
    
    
    // --------------- CARTAS -----------------

    public void crearCartas(Cartas carta) {
        cartaJpa.create(carta);
    }

    public void eliminarCartas(int id) {
                try {
            cartaJpa.destroy(id);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarCarta(Cartas carta) {
                try {
            cartaJpa.edit(carta);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Cartas traerCarta(int id) {
        return cartaJpa.findCartas(id);
    }
        
    
    
}
