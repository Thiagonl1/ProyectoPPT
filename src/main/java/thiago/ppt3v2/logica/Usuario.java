package thiago.ppt3v2.logica;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int usuarioId;
    private String nombre;
    private int estrellas;
    
    @OneToMany (mappedBy= "user")
    private ArrayList<Cartas> cartas;

    public Usuario(int usuarioId, String nombre, int estrellas, ArrayList<Cartas> cartas) {
        this.usuarioId = usuarioId;
        this.nombre = nombre;
        this.estrellas = estrellas;
        this.cartas = cartas;
    }

    public Usuario(){
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
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

    public ArrayList<Cartas> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Cartas> cartas) {
        this.cartas = cartas;
    }
    
    public ArrayList<Cartas> inicializarCartas(ArrayList<Cartas> cartas){
        // SI LA LISTA DE CARTAS ESTA VACIA (cosa que tendria que pasar siempre)
        if(this.cartas == null) {
            // le agrego las cartas que tengo predefinidas en una lista al usuario en cuestion
            // EL PROBLEMA QUE VEO ACA
            // no tengo o veo manera de agregar el ID del usuario en cuestion, entonces le mando null como parametro
            
            for(int i = 0 ; i < cartas.size() ; i++){
                this.cartas.add(cartas.get(i));
                this.cartas.get(i).setUsuarioId(this.usuarioId);
             }
        }
        return this.cartas;
    }
    
    
    
    
}
