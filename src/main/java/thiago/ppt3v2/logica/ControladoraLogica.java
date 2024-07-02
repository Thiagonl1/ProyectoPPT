
package thiago.ppt3v2.logica;
import thiago.ppt3v2.persistencia.ControladoraPersistencia;


public class ControladoraLogica {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    
    //--------------------------- USUARIO --------------------
    
    public void crearUsuario(Usuario usuario){
        controlPersis.crearUsuario(usuario);
    }
    
    public void eliminarUsuario(int id){
        controlPersis.eliminarUsuario(id);
    }
    
    public void editarUsuario(Usuario usuario){
        controlPersis.editarUsuario(usuario);
    }
    
        public Usuario traerUsuario(int id){
        return controlPersis.traerUsuario(id);
    }
        
   //----------------------------- CARTAS --------------------
        
    public void crearCartas(Cartas carta){
        controlPersis.crearCartas(carta);
    }
    
    public void eliminarCartas(int id){
        controlPersis.eliminarCartas(id);
    }
    
    public void editarCartas(Cartas carta){
        controlPersis.editarCarta(carta);
    }
    
    public Cartas traerCartas(int id){
        return controlPersis.traerCarta(id);
    }
    
}
