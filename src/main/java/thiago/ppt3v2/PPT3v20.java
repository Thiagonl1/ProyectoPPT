
package thiago.ppt3v2;

import java.util.ArrayList;
import thiago.ppt3v2.logica.Cartas;
import thiago.ppt3v2.logica.ControladoraLogica;
import thiago.ppt3v2.logica.Usuario;
import thiago.ppt3v2.persistencia.CartasJpaController;
import thiago.ppt3v2.persistencia.ControladoraPersistencia;
import thiago.ppt3v2.persistencia.UsuarioJpaController;


/**
 *
 * @author Thiago Luque
 */

public class PPT3v20 {

    public static void main(String[] args) {
        // TENGO QUE INICIAR LA PERSISTENCIA ANTES QUE NADA
        ControladoraLogica control = new ControladoraLogica();

        
        // PARA CREAR UN USUARIO NECESITO: ID, NOMBRE, ESTRELLAS, CARTAS      
        //NO PUEDO CREAR UN USUARIO SI NO TENGO CARTAS ANTES, entonces hago un placeholder
        ArrayList<Cartas> cartasUsuario = new ArrayList<>();
        //CREO LAS CARTAS

        //CREO EL USUARIO
        Usuario player = new Usuario(1, "Thiago", 3, cartasUsuario);
        control.crearUsuario(player);
        //EL PROBLEMA ESTA EN ALGO DE LAS CARTAS, TANTO EL INICIALIZAR COMO ALGO DE AHI, FIJATE!!!
        
        
        for(int i=0 ; i < player.getCartas().size() ; i++){
            control.crearCartas(player.getCartas().get(i));
        }
        //control.eliminarUsuario(3);
        //usuario.setEstrellas(999);
        //control.editarUsuario(usuario);
    }
}
