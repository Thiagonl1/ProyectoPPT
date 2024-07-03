package thiago.ppt3v2.logica;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import thiago.ppt3v2.persistencia.ControladoraPersistencia;


@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUsuarioId", query = "SELECT u FROM Usuario u WHERE u.usuarioId = :usuarioId"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByEstrellas", query = "SELECT u FROM Usuario u WHERE u.estrellas = :estrellas")})
public class Usuario extends Thread implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "usuarioId")
    private Integer usuarioId;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "estrellas")
    private int estrellas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private Collection<CartaUsuario> cartaUsuarioCollection;

    public Usuario() {
    }

    
    public Usuario(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Usuario(Integer usuarioId, String nombre, int estrellas) {
        this.usuarioId = usuarioId;
        this.nombre = nombre;
        this.estrellas = estrellas;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public Collection<CartaUsuario> getCartaUsuarioCollection() {
        return cartaUsuarioCollection;
    }

    public void setCartaUsuarioCollection(Collection<CartaUsuario> cartaUsuarioCollection) {
        this.cartaUsuarioCollection = cartaUsuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioId != null ? usuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuarioId == null && other.usuarioId != null) || (this.usuarioId != null && !this.usuarioId.equals(other.usuarioId))) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public void run(){
        ControladoraPersistencia controlP = new ControladoraPersistencia();
        if(this.usuarioId == 1){
            // EXPORTAMOS EL DECK ACA
            List<CartaUsuario> mano = controlP.findByUsuarioId(this.usuarioId);
            while(!mano.isEmpty() && this.estrellas != 0){
                // MOSTRAR LAS IAS
                
                
                
            }
        }
    }
    
}
