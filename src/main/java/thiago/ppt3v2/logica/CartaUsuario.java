package thiago.ppt3v2.logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "carta_usuario")
@NamedQueries({
    @NamedQuery(name = "CartaUsuario.findAll", query = "SELECT c FROM CartaUsuario c"),
    @NamedQuery(name = "CartaUsuario.findByCartaUsuarioId", query = "SELECT c FROM CartaUsuario c WHERE c.cartaUsuarioId = :cartaUsuarioId")})
public class CartaUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "carta_usuario_id")
    private Integer cartaUsuarioId;
    @JoinColumn(name = "cartaId", referencedColumnName = "cartaId")
    @ManyToOne(optional = false)
    private Cartas cartaId;
    @JoinColumn(name = "usuarioId", referencedColumnName = "usuarioId")
    @ManyToOne(optional = false)
    private Usuario usuarioId;

    public CartaUsuario() {
    }

    
    public CartaUsuario(Integer cartaUsuarioId) {
        this.cartaUsuarioId = cartaUsuarioId;
    }

    public Integer getCartaUsuarioId() {
        return cartaUsuarioId;
    }

    public void setCartaUsuarioId(Integer cartaUsuarioId) {
        this.cartaUsuarioId = cartaUsuarioId;
    }

    public Cartas getCartaId() {
        return cartaId;
    }

    public void setCartaId(Cartas cartaId) {
        this.cartaId = cartaId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cartaUsuarioId != null ? cartaUsuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CartaUsuario)) {
            return false;
        }
        CartaUsuario other = (CartaUsuario) object;
        if ((this.cartaUsuarioId == null && other.cartaUsuarioId != null) || (this.cartaUsuarioId != null && !this.cartaUsuarioId.equals(other.cartaUsuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "thiago.asdasda.CartaUsuario[ cartaUsuarioId=" + cartaUsuarioId + " ]";
    }
    
}