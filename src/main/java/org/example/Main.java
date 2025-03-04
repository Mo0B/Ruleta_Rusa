// ACHICANOY VELASQUEZ BRAYAN SEBASTIAN v1.0
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
        String _opS;
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
                    do {
                        System.out.println("Cantidad de jugadores (maximo 10)");

                        _opAceptar = _teclado.nextInt();
                        if (_opAceptar <= 10) {


                        jugadores.clear();
                        for (int i = 0; i < _opAceptar; i++) {
                            jugadores.add(i);
                        }
                        for (int j = 0; j < jugadores.size(); j++) {
                            System.out.println("___________________________________________________________" +
                                    "\nTurno de Jugador: " + (j + 1));
                            System.out.println("1. Disparar\n" +
                                    "2. Reiniciar Juego\n" +
                                    "0. Salir");
                            _seguir = _teclado.nextInt();
                            switch (_seguir) {
                                case 1 -> {


                                    System.out.println("Tamaño del Tambor");
                                    for (int i = 0; i < ruleru.get_tambor().size(); i++) {
                                        System.out.println(ruleru.get_tambor().get(i));
                                    }


                                    System.out.println(">>>>>> BALA POSICION");
                                    System.out.println(ruleru.get_bala());
                                    System.out.println(">>>>>> JUGADOR POSICION");
                                    System.out.println(ruleru.get_posicionActual());
                                    if (ruleru.Disparar()) {
                                        System.out.println("""
                                                    ▒▒▒░░░░░░░░░░▄▐░░░░
                                                    ▒░░░░░░▄▄▄░░▄██▄░░░
                                                    ░░░░░░▐▀█▀▌░░░░▀█▄░
                                                    ░░░░░░▐█▄█▌░░░░░░▀█▄
                                                    ░░░░░░░▀▄▀░░░▄▄▄▄▄▀▀
                                                    ░░░░░▄▄▄██▀▀▀▀░░░░░
                                                    ░░░░█▀▄▄▄█░▀▀░░░░░░
                                                    ░░░░▌░▄▄▄▐▌▀▀▀░░░░░
                                                    ░▄░▐░░░▄▄░█░▀▀░░░░░
                                                    ░▀█▌░░░▄░▀█▀░▀░░░░░
                                                    ░░░░░░░░▄▄▐▌▄▄░░░░░
                                                    ░░░░░░░░▀███▀█░▄░░░
                                                    ░░░░░░░▐▌▀▄▀▄▀▐▄░░░
                                                    ░░░░░░░▐▀░░░░░░▐▌░░
                                                    ░░░░░░░█░░░░░░░░█░░
                                                    ░░░░░░▐▌░░░░░░░░░█░
                                                """);
                                        System.out.println(" F en el Chat, PERDIO JUGADOR: " + (j + 1) );
                                        System.out.println("\n digite cualquier numero para Salir");
                                        if (ruleru.get_bala() == 0){
                                            System.out.println(" ----------------------");
                                            System.out.println("""
                                                       ∧,,,∧
                                                     (̳• · •̳)
                                                     /     づ♡ EN LA PRIMERA RONDA
                                                    """);
                                        }
                                        _seguir = 0;
                                        _opAceptar = _teclado.nextInt();
                                        j = jugadores.size() + 1;

                                    } else {
                                        System.out.println("""
                                                ──────▄▀▄─────▄▀▄
                                                ─────▄█░░▀▀▀▀▀░░█▄
                                                ─▄▄──█░░░░░░░░░░░█──▄▄
                                                █▄▄█─█░░▀░░┬░░▀░░█─█▄▄█
                                                """);
                                        System.out.println(" SOBREVIVIO JUGADOR: " + (j + 1));
                                        int o = jugadores.size() - 1;

                                        if (o == j) {
                                            j = -1;
                                        }
                                    }
                                }
                                case 2 -> {
                                    ruleru.ReiniciarJuego(_bala);
                                }
                                default -> {
                                    System.out.println("Saliendo ...");
                                    j = jugadores.size() + 1;
                                }
                            }
                        }
                    }
                        else {
                            System.out.println("Has excedido el numero maximo de jugadores (10)" +
                                    "\n Digite cualquier tecla para continuar");
                            _opAceptar = _teclado.nextInt();
                        }
                    }while (_seguir != 0);
                }
                case 2 -> {
                    System.out.println("asignar tamaño de tambor (maximo 10)");
                    _opAceptar = _teclado.nextInt();

                    if (_opAceptar <= 10){
                        ruleru.get_tambor().clear();
                        _tamaño = _opAceptar;
                    }else {
                        System.out.println("Ha sobrepasado el numero maximo (10)" +
                                "\n digite cualquier numero para continuar");
                        _opAceptar = _teclado.nextInt();
                    }

                }

                default -> System.out.println("Saliendo ...");
            }
        }
    }
}