package thiago.ppt3v2.logica;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cartas")
@NamedQueries({
    @NamedQuery(name = "Cartas.findAll", query = "SELECT c FROM Cartas c"),
    @NamedQuery(name = "Cartas.findByCartaId", query = "SELECT c FROM Cartas c WHERE c.cartaId = :cartaId"),
    @NamedQuery(name = "Cartas.findByTipo", query = "SELECT c FROM Cartas c WHERE c.tipo = :tipo")})
public class Cartas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cartaId")
    private Integer cartaId;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cartaId")
    private Collection<CartaUsuario> cartaUsuarioCollection;

    public Cartas() {
    }

    public Cartas(Integer cartaId) {
        this.cartaId = cartaId;
    }

    public Cartas(Integer cartaId, String tipo) {
        this.cartaId = cartaId;
        this.tipo = tipo;
    }

    public Integer getCartaId() {
        return cartaId;
    }

    public void setCartaId(Integer cartaId) {
        this.cartaId = cartaId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        hash += (cartaId != null ? cartaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cartas)) {
            return false;
        }
        Cartas other = (Cartas) object;
        if ((this.cartaId == null && other.cartaId != null) || (this.cartaId != null && !this.cartaId.equals(other.cartaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "thiago.asdasda.Cartas[ cartaId=" + cartaId + " ]";
    }
    
}

