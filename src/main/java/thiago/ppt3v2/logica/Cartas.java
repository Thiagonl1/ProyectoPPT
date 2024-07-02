
package thiago.ppt3v2.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Cartas implements Serializable{
    
   
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int usuarioID;
   
    private String tipo;

    
    // ASOCIO LA CARDINALIDAD
    @ManyToOne
    private Usuario user;

    public Cartas() {
    }

    public Cartas(String tipo) {
        this.tipo = tipo;
    }
    
    public Cartas(int usuarioID, String tipo) {
        this.usuarioID = usuarioID;
        this.tipo = tipo;
    }

    public int getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    void setUsuarioId(int usuarioId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
