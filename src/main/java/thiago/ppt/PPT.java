package thiago.ppt;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import thiago.ppt.logica.Usuario;
import thiago.ppt.persistencia.ControladoraPersistencia;




public class PPT {
    public static void main(String[] args) {
        
        
        /*  Scanner scan = new Scanner(System.in);

        // INICIO AL USUARIO
        Usuario player = new Usuario();
        player.setCartas(player.inicializarCartas());
        player.setEstrellas(3);
        System.out.println("Nombre del Jugador");
        player.setApodo(scan.nextLine());

        // INICIO LAS IAS
        ArrayList<Usuario> ias = new ArrayList<>();

        Usuario ia1 = new Usuario();
        ia1.setCartas(ia1.inicializarCartas());
        ia1.setEstrellas(3);
        ia1.setApodo("sucucho");

        Usuario ia2 = new Usuario();
        ia2.setCartas(ia2.inicializarCartas());
        ia2.setEstrellas(3);
        ia2.setApodo("cerrucho");

        Usuario ia3 = new Usuario();
        ia3.setCartas(ia3.inicializarCartas());
        ia3.setEstrellas(3);
        ia3.setApodo("papucho");

        Usuario ia4 = new Usuario();
        ia4.setCartas(ia4.inicializarCartas());
        ia4.setEstrellas(3);
        ia4.setApodo("pucho");

        Usuario ia5 = new Usuario();
        ia5.setCartas(ia5.inicializarCartas());
        ia5.setEstrellas(3);
        ia5.setApodo("carlos");

        ias.add(ia1);
        ias.add(ia2);
        ias.add(ia3);
        ias.add(ia4);
        ias.add(ia5);

        do {
            // Tratar de implementar algo mas visual que una consola
            // Tratar de hacer que pase el tiempo y las IA's interaccionen entre si
            System.out.println("Elige un oponente \n1)"+ia1.getApodo());
            System.out.println("\n2)"+ia2.getApodo());
            System.out.println("\n3)"+ia3.getApodo());
            System.out.println("\n4)"+ia4.getApodo());
            System.out.println("\n5)"+ia5.getApodo());
            //eleccion de oponente
            int opcion =(scan.nextInt());
            switch (opcion){
                case 1:{
                    Random random = new Random();
                    int eleccionIA = random.nextInt(ia1.getEstrellas()*10);
                    if(eleccionIA >=10 && ia1.getCartas().size() >= 1){
                        System.out.println(ia1.getApodo()+ " Acepto tu desafio.");
                        System.out.println(" ---Cartas disponibles actualmente ---");
                        System.out.println("--------------------------------------");

                        player.juegoPreliminar(ia1);
                    }else{
                        System.out.println("Rechazo tu desafio");
                    }
                    break;
                } case 2:{
                    Random random = new Random();
                    int eleccionIA = random.nextInt(ia2.getEstrellas()*10);
                    if(eleccionIA >=10){
                        System.out.println(ia2.getApodo()+ " Acepto tu desafio.");
                        System.out.println(" ---Cartas disponibles actualmente ---");
                        System.out.println("--------------------------------------");

                        player.juegoPreliminar(ia2);
                    }else{
                        System.out.println("Rechazo tu desafio");
                    }
                    break;
                } case 3:{
                    Random random = new Random();
                    int eleccionIA = random.nextInt(ia3.getEstrellas()*10);
                    if(eleccionIA >=10){
                        System.out.println(ia3.getApodo()+ " Acepto tu desafio.");
                        System.out.println(" ---Cartas disponibles actualmente ---");
                        System.out.println("--------------------------------------");
                        player.juegoPreliminar(ia3);
                    }else{
                        System.out.println("Rechazo tu desafio");
                    }
                    break;
                } case 4:{
                    Random random = new Random();
                    int eleccionIA = random.nextInt(ia4.getEstrellas()*10);
                    if(eleccionIA >=10){
                        System.out.println(ia4.getApodo()+ " Acepto tu desafio.");
                        System.out.println(" ---Cartas disponibles actualmente ---");
                        System.out.println("--------------------------------------");

                        player.juegoPreliminar(ia4);
                    }else{
                        System.out.println("Rechazo tu desafio");
                    }
                    break;
                } case 5:{
                    Random random = new Random();
                    int eleccionIA = random.nextInt(ia5.getEstrellas()*10);
                    if(eleccionIA >=10){
                        System.out.println(ia5.getApodo()+ " Acepto tu desafio.");
                        System.out.println(" ---Cartas disponibles actualmente ---");
                        System.out.println("--------------------------------------");

                        player.juegoPreliminar(ia5);
                    }else{
                        System.out.println("Rechazo tu desafio");
                    }
                    break;
                }
            }
            System.out.println("-------------Interaccion entre las Ia's----------------");

            try{
                if (ia1.getEstrellas() >= 1 && !ia1.getCartas().isEmpty()) {
                    Random random2 = new Random();
                    Random random3 = new Random();
                    int eleccionIACarta = random3.nextInt(ia1.getCartas().size());
                    int eleccionOponenteIaint;
                    do {
                        eleccionOponenteIaint = random2.nextInt(ias.size());
                    } while (ias.get(eleccionOponenteIaint).getEstrellas() == 0);

                    Random random = new Random();
                    int eleccionIA = random.nextInt(ias.get(eleccionOponenteIaint).getEstrellas() * 10 + 1);
                    if (eleccionIA >= 10) {
                        System.out.println(ias.get(eleccionOponenteIaint).getApodo() + " acepto el desafio de " + ia1.getApodo());

                        ia1.run(eleccionIACarta, ias.get(eleccionOponenteIaint));

                        System.out.println("Se jugo");
                    } else {
                        System.out.println(ias.get(eleccionOponenteIaint).getApodo() + " rechazo el desafio de " + ia2.getApodo());
                    }
                }
                System.out.println("------------------------------------------------------");

                if (ia2.getEstrellas() >= 1 && !ia2.getCartas().isEmpty()) {
                    Random random2 = new Random();
                    Random random3 = new Random();
                    int eleccionIACarta = random3.nextInt(ia2.getCartas().size());
                    int eleccionOponenteIaint;
                    do {
                        eleccionOponenteIaint = random2.nextInt(ias.size());
                    } while (ias.get(eleccionOponenteIaint).getEstrellas() == 0);
                    Random random = new Random();
                    int eleccionIA = random.nextInt(ias.get(eleccionOponenteIaint).getEstrellas() * 10 + 1);
                    if (eleccionIA >= 10) {
                        System.out.println(ias.get(eleccionOponenteIaint).getApodo() + " acepto el desafio de " + ia2.getApodo());
                        ia2.run(eleccionIACarta, ias.get(eleccionOponenteIaint));
                        System.out.println("Se jugo");
                    } else {
                        System.out.println(ias.get(eleccionOponenteIaint).getApodo() + " rechazo el desafio de " + ia2.getApodo());
                    }
                }
                System.out.println("------------------------------------------------------");

                if (ia3.getEstrellas() >= 1 && !ia3.getCartas().isEmpty()) {
                    Random random2 = new Random();
                    Random random3 = new Random();
                    int eleccionIACarta = random3.nextInt(ia3.getCartas().size());
                    int eleccionOponenteIaint;
                    do {
                        eleccionOponenteIaint = random2.nextInt(ias.size());
                    } while (ias.get(eleccionOponenteIaint).getEstrellas() == 0);
                    Random random = new Random();
                    int eleccionIA = random.nextInt(ias.get(eleccionOponenteIaint).getEstrellas() * 10 + 1);
                    if (eleccionIA >= 10) {
                        System.out.println(ias.get(eleccionOponenteIaint).getApodo() + " acepto el desafio de " + ia3.getApodo());
                        ia3.run(eleccionIACarta, ias.get(eleccionOponenteIaint));
                        System.out.println("Se jugo");
                    } else {
                        System.out.println(ias.get(eleccionOponenteIaint).getApodo() + " rechazo el desafio de " + ia3.getApodo());
                    }
                }

                System.out.println("------------------------------------------------------");

                if (ia4.getEstrellas() >= 1 && !ia4.getCartas().isEmpty()) {
                    Random random2 = new Random();
                    Random random3 = new Random();
                    int eleccionIACarta = random3.nextInt(ia4.getCartas().size());
                    int eleccionOponenteIaint;
                    do {
                        eleccionOponenteIaint = random2.nextInt(ias.size());
                    } while (ias.get(eleccionOponenteIaint).getEstrellas() == 0);
                    Random random = new Random();
                    int eleccionIA = random.nextInt(ias.get(eleccionOponenteIaint).getEstrellas() * 10 + 1);

                    if (eleccionIA >= 10) {
                        System.out.println(ias.get(eleccionOponenteIaint).getApodo() + " acepto el desafio de " + ia4.getApodo());
                        ia4.run(eleccionIACarta, ias.get(eleccionOponenteIaint));
                        System.out.println("Se jugo");
                    } else {
                        System.out.println(ias.get(eleccionOponenteIaint).getApodo() + " rechazo el desafio de " + ia4.getApodo());
                    }
                }

                System.out.println("------------------------------------------------------");


                if (ia5.getEstrellas() >= 1 && !ia5.getCartas().isEmpty()) {
                    Random random2 = new Random();
                    Random random3 = new Random();
                    int eleccionIACarta = random3.nextInt(ia5.getCartas().size());
                    int eleccionOponenteIaint;
                    do {
                        eleccionOponenteIaint = random2.nextInt(ias.size());
                    } while (ias.get(eleccionOponenteIaint).getEstrellas() == 0);
                    Random random = new Random();
                    int eleccionIA = random.nextInt(ias.get(eleccionOponenteIaint).getEstrellas() * 10 + 1);
                    if (eleccionIA >= 10) {
                        System.out.println(ias.get(eleccionOponenteIaint).getApodo() + " acepto el desafio de " + ia5.getApodo());
                        ia5.run(eleccionIACarta, ias.get(eleccionOponenteIaint));
                        System.out.println("Se jugo");
                    } else {
                        System.out.println(ias.get(eleccionOponenteIaint).getApodo() + " rechazo el desafio de " + ia5.getApodo());
                    }
                }

                System.out.println("------------------------------------------------------");
            }
            catch(Exception e){
                    System.out.println("Murio");
                    // AGREGA UN EXTEND
                }


            // Hacer que las ia's que no elegiste para jugar interactuen entre si
            // Tienen que tener una chance X de no interactuar por alguna razón
            // Tiene que actualizarse cada vez que jugas
        }while(!player.getCartas().isEmpty());
 */ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    }
    
        
}