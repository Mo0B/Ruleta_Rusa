package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int _op = 0, _seguir = 0, _opAceptar = 0;
        int _bala = 6, _tamaño = 6, _posicionActual = 0;
        List<Integer> jugadores = new ArrayList<>();
        Ruleta_Rusa ruleru = new Ruleta_Rusa(_tamaño,_bala,_posicionActual);
        Scanner _teclado = new Scanner(System.in);

        while (_op != 5 ){
            System.out.println(" ############# Ruleta Rusa ############# \n" +
                    "1. Jugar\n"+
                    "2. Tamaño de Tambor\n" +

                    "5. Salir");
            _op = _teclado.nextInt();
            switch (_op){
                case 1 ->{
                    ruleru = new Ruleta_Rusa(_tamaño,_bala,_posicionActual);
                    do{
                        System.out.println("Cantidad de jugadores ");
                        _opAceptar = _teclado.nextInt();
                        jugadores.clear();
                        for (int i = 0; i<_opAceptar; i++){
                            jugadores.add(i);
                        }
                        for (int j = 0; j<jugadores.size(); j++){
                            System.out.println("Turno de Jugador: "+(j+1));
                            System.out.println("1. Disparar\n" +
                                    "2. Reiniciar Juego\n" +
                                    "0. Salir");
                            _seguir = _teclado.nextInt();
                            switch (_seguir){
                                case 1 -> {


                                    System.out.println("posiciones del tambor: ");
                                    for (int i = 0; i < ruleru.get_tambor().size(); i++){
                                        System.out.println(ruleru.get_tambor().get(i));
                                    }


                                    System.out.println("posiciones de la bala: ");
                                    System.out.println(ruleru.get_bala());
                                    System.out.println("posiciones actual: ");
                                    System.out.println(ruleru.get_posicionActual());
                                    System.out.println("Jugador esta en posicion: ");
                                    if (ruleru.Disparar()){
                                        System.out.println("##############   Perdiste, Haz Muerto Jugador: " + (j+1) +
                                                "\n digite cualquier numero para Salir");
                                        _seguir = 0;
                                        _opAceptar = _teclado.nextInt();
                                        j=jugadores.size() + 1 ;

                                    }else {
                                        System.out.println("##############   Haz sobrevivido Jugador: "+ (j+1));
                                        int o = jugadores.size() - 1;

                                        if (o == j){
                                            j = -1;
                                        }
                                    }
                                }
                                case 2 -> {
                                    ruleru.ReiniciarJuego(_bala);
                                }
                                default -> {
                                    System.out.println("Saliendo ...");
                                    j=jugadores.size() + 1 ;
                                }
                            }
                        }

                    }while (_seguir != 0);
                }
                case 2 -> {
                    System.out.println("asignar tamaño de tambor: ");
                    _opAceptar = _teclado.nextInt();
                    ruleru.get_tambor().clear();
                    for (int i = 0; i<_opAceptar; i++){
                        ruleru.get_tambor().add(i);
                    }
                }

                default -> System.out.println("Saliendo ...");
            }
        }
    }
}