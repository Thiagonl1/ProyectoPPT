package thiago.ppt.logica;

import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Usuario extends Thread implements Juego, Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int usuarioId;
    
    private String apodo;
    private int estrellas;
    // private int eleccionJuego; // Se cambiara en lo que descubra como hacer que elijan de alguna manera por api
    private ArrayList<Carta> cartas;

    
    public Usuario(){}

   

    
    
    
    public Usuario(int estrellas, String apodo, ArrayList<Carta> cartas, int usuarioId) {
        this.estrellas = estrellas;
        this.apodo = apodo;
        this.cartas = cartas;
        this.usuarioId = usuarioId;
    }
    
 public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    public Usuario(int estrellas, int eleccionJuego, String apodo, Carta[] cartas) {
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    // verificar, verifica si se gana, empata o pierde el usuario y/o ia. modificando las estrellas correspondientes.

    public void verificar(Usuario ia, int desicionPlayer, int desicionIA){
        if(ia.cartas.get(desicionIA).getTipo().equals(this.cartas.get(desicionPlayer).getTipo())){
            System.out.println("Se empato");
        }else if(this.cartas.get(desicionPlayer).getTipo().equals("Piedra")){
            if(ia.cartas.get(desicionIA).getTipo().equals("Papel")){
                this.setEstrellas(this.getEstrellas()-1);
                ia.setEstrellas(ia.getEstrellas()+1);
                System.out.println("Perdiste");
            }else{
                System.out.println("Ganaste");
                this.setEstrellas(this.getEstrellas()+1);
                ia.setEstrellas(ia.getEstrellas()-1);
            }
        }else if(this.cartas.get(desicionPlayer).getTipo().equals("Papel")){
            if(ia.cartas.get(desicionIA).getTipo().equals("Tijera")){
                this.setEstrellas(this.getEstrellas()-1);
                ia.setEstrellas(ia.getEstrellas()+1);
                System.out.println("Perdiste");
            }else{
                System.out.println("Ganaste");
                this.setEstrellas(this.getEstrellas()+1);
                ia.setEstrellas(ia.getEstrellas()-1);
            }
        }else if(this.cartas.get(desicionPlayer).getTipo().equals("Tijera")){
            if(ia.cartas.get(desicionIA).getTipo().equals("Piedra")){
                this.setEstrellas(this.getEstrellas()-1);
                ia.setEstrellas(ia.getEstrellas()+1);
                System.out.println("Perdiste");
            }else{
                System.out.println("Ganaste");
                this.setEstrellas(this.getEstrellas()+1);
                ia.setEstrellas(ia.getEstrellas()-1);
            }
        }

    }


    public void juegoPreliminar(Usuario ia){
        Scanner scan = new Scanner(System.in);
        // Muestro las cartas primero
        for(int i = 0 ; i < this.cartas.size() ; i++){
            System.out.println(i+")"+this.cartas.get(i).getTipo());
        }
        // agrego desicion
        int desicion = scan.nextInt();
        //Implementar interfaz visual y no consola
        while(desicion > this.cartas.size() || desicion < 0){
            if(desicion > this.cartas.size() || desicion < 0){
                System.out.println("Elija una carta valida");
                for(int i = 0 ; i < this.cartas.size() ; i++){
                    System.out.println(i+")"+this.cartas.get(i).getTipo());
                }
            }
            System.out.println("Que carta vas a utilizar");
            desicion = scan.nextInt();
        }
        juego(desicion, ia);
    }

    public void juego(int desicion, Usuario ia){
        Random random = new Random();
        int eleccionIA = random.nextInt(ia.cartas.size());
        // implementar win/loose
        System.out.println("El jugador ("+this.apodo+") eligio "+this.cartas.get(desicion).getTipo()+"\nLa ia eligio "+ ia.cartas.get(eleccionIA).getTipo());
        verificar(ia, desicion, eleccionIA);
        //
        this.cartas.remove(desicion);

        ia.cartas.remove(eleccionIA);

    }

    public ArrayList<Carta> inicializarCartas(){
        if(this.cartas == null) {
            this.cartas = new ArrayList<>();
            this.cartas.add(new Carta("Piedra"));
            this.cartas.add(new Carta("Papel"));
            this.cartas.add(new Carta("Tijera"));
        }
        return this.cartas;
    }


    // multithreating, para las ia's

    public void run(int desicion, Usuario ia){
        juego(desicion, ia);
    }
}
