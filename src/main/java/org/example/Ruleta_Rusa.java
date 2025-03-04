package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ruleta_Rusa {
    private List<Integer> _tambor = new ArrayList<>(); // las posiciones donde se ubica la bala o balas 0 a 5 defecto
    private int _bala, _posicionActual;
    private Random random = new Random();

    public Ruleta_Rusa(int _tamaño, int _bala, int _posicionActual){
       for (int i = 0; i<_tamaño; i++){
           this._tambor.add(i);
       }
       this._bala = random.nextInt(_bala);
       this._posicionActual = _posicionActual;
    }

    public List<Integer> get_tambor() {
        return _tambor;
    }

    public int get_bala() {
        return _bala;
    }

    public int get_posicionActual() {
        return _posicionActual;
    }

    public Random getRandom() {
        return random;
    }

    public void set_tambor(List<Integer> _tambor) {
        this._tambor = _tambor;
    }

    public void set_bala(int _bala) {
        this._bala = _bala;
    }

    public void set_posicionActual(int _posicionActual) {
        this._posicionActual = _posicionActual;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
    public Boolean Disparar(){
        if (this._posicionActual == this._bala){
            return true;
        }else {
            this._posicionActual++;
            return false;
        }
    }
    public void ReiniciarJuego(int _bala){
        //algoritmo para reiniciar todas las posiciones y se genero una nueva posicion aleatoria
        this._posicionActual = 0;
        this._bala = this.random.nextInt(_bala);
    }
    public String ToString(){
        return "tambor lista";
    }

}
