package com.example.prueba1;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {
    //MediaPlayer reproductor;
    Button btPlay;
    ImageView ivImage1, ivImage2, ivImage3;
    TextView tvCheck;
    boolean respuestaTF;
    int[] rutasSonidos;
    int rutaSonido;
    int indiceListasImagenes;
    int indicePalabras;
    int puntaje;
    int[] respuesta;
    int[][] listaRespuestas;

    int[] respuestaViento = new int[]{1,0,0};
    int[] respuestaLluvia = new int[]{0,0,1};
    int[] respuestaSarten = new int[]{1,0,0};
    int[] respuestaCaballo = new int[]{1,0,0};
    int[] respuestaDelfin = new int[]{0,1,0};
    int[] respuestaVaca = new int[]{0,0,1};
    int[] respuestaLicuadora = new int[]{0,0,1};


    int[][] listaImagenes;
    int[] listaImagenesViento = new int[]{R.drawable.viento, R.drawable.lluvia, R.drawable.sol};
    int[] listaImagenesLluvia = new int[]{R.drawable.sol, R.drawable.viento, R.drawable.lluvia};
    int[] listaImagenesSarten = new int[]{R.drawable.sarten, R.drawable.fuego, R.drawable.cascada};
    int[] listaImagenesCaballo = new int[]{R.drawable.caballo, R.drawable.vaca, R.drawable.perro};
    int[] listaImagenesDelfin = new int[]{R.drawable.vaca, R.drawable.delfin,  R.drawable.perro};
    int[] listaImagenesVaca = new int[]{R.drawable.perro, R.drawable.caballo, R.drawable.vaca};
    int[] listaImagenesLicuadora = new int[]{R.drawable.aspiradora, R.drawable.lavadora, R.drawable.licuadora};


    MediaPlayer sound;
    public Fragment1() {
        rutasSonidos = new int[]{R.raw.viento_r, R.raw.lluvia_r, R.raw.sarten_r, R.raw.caballo_r, R.raw.delfin_r, R.raw.vaca_r, R.raw.licuadora_r};
        indiceListasImagenes = 0;
        indicePalabras = 0;
        puntaje = 0;
        respuestaTF = false;
        //Asignacion de las listas de imagenes
        listaImagenes = new int[7][1];
        listaRespuestas = new int[7][1];

        listaImagenes[0] = listaImagenesViento;
        listaImagenes[1] = listaImagenesLluvia;
        listaImagenes[2] = listaImagenesSarten;
        listaImagenes[3] = listaImagenesCaballo;
        listaImagenes[4] = listaImagenesDelfin;
        listaImagenes[5] = listaImagenesVaca;
        listaImagenes[6] = listaImagenesLicuadora;

        listaRespuestas[0] = respuestaViento;
        listaRespuestas[1] = respuestaLluvia;
        listaRespuestas[2] = respuestaSarten;
        listaRespuestas[3] = respuestaCaballo;
        listaRespuestas[4] = respuestaDelfin;
        listaRespuestas[5] = respuestaVaca;
        listaRespuestas[6] = respuestaLicuadora;

        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sound = MediaPlayer.create(getContext(), R.raw.aprieta_play);
        sound.start();

        respuesta = new int[]{0,0,0};
        btPlay = (Button)view.findViewById(R.id.btnReproducirF1);
        //etEntrada = (EditText)view.findViewById(R.id.etEntradaF1);
        tvCheck = (TextView)view.findViewById(R.id.textViewCheckF1);
        //ImageView de las imagenes
        ivImage1 = (ImageView)view.findViewById(R.id.ivImagen1F1);
        ivImage2 = (ImageView)view.findViewById(R.id.ivImagen2F1);
        ivImage3 = (ImageView)view.findViewById(R.id.ivImagen3F1);

        ivImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                respuesta = new int[]{1,0,0};
                if(indicePalabras < listaRespuestas.length) {
                    respuestaTF = verificarRespuesta(respuesta, listaRespuestas[indicePalabras]);
                    System.out.println("El resultado es: " + respuestaTF);
                }
                if(puntaje >= listaRespuestas.length){
                    tvCheck.setText("PERFECTO \n JUEGO TERMINADO");
                }
            }
        });
        ivImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                respuesta = new int[]{0,1,0};
                if(indicePalabras < listaRespuestas.length) {
                    respuestaTF = verificarRespuesta(respuesta, listaRespuestas[indicePalabras]);
                    System.out.println("El resultado es: " + respuestaTF);
                }
                if(puntaje >= listaRespuestas.length){
                    tvCheck.setText("PERFECTO \n JUEGO TERMINADO");
                }
            }
        });
        ivImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                respuesta = new int[]{0,0,1};
                if(indicePalabras < listaRespuestas.length) {
                    respuestaTF = verificarRespuesta(respuesta, listaRespuestas[indicePalabras]);
                    System.out.println("El resultado es: " + respuestaTF);
                }
                if(puntaje >= listaRespuestas.length){
                    tvCheck.setText("PERFECTO \n JUEGO TERMINADO");
                }
            }
        });

        rutaSonido = rutasSonidos[indicePalabras];
        sound = MediaPlayer.create(getContext(), rutaSonido);
        btPlay.setText("Reproducir sonido 1");
        //Botón de play
        btPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound = MediaPlayer.create(getContext(), rutaSonido);
                sound.start();
                tvCheck.setText("");
            }
        });
    }

    public boolean verificarRespuesta(int[] respuesta, int[] respuestaObjetivo){
        sound.stop();
        if(Arrays.equals(respuesta, respuestaObjetivo)){
            System.out.println("respuesta: " + respuesta.toString());
            System.out.println("respuesta Objetivo: " + respuestaObjetivo.toString());

            if(indicePalabras < listaRespuestas.length) {
                indicePalabras++;
            }




            tvCheck.setText("CORRECTO");
            puntaje = incrementarPuntaje(puntaje,listaRespuestas.length);
            tvCheck.setTextColor(Color.GREEN);
            System.out.println("El indice: "+ indicePalabras);
            System.out.println("El puntaje: "+ puntaje);
            if(puntaje >= listaRespuestas.length){
                tvCheck.setText("PERFECTO \n JUEGO TERMINADO");
                sound = MediaPlayer.create(getContext(), R.raw.felicidades_has_termiando);
                sound.start();
            }
            //Colocación de todas las imagenes automáticamente
            if(indicePalabras < listaRespuestas.length) {
                btPlay.setText("Reproducir sonido " + (indicePalabras+1));
                cambiarSonido(indicePalabras);
                ivImage1.setImageResource(listaImagenes[indicePalabras][0]);
                ivImage2.setImageResource(listaImagenes[indicePalabras][1]);
                ivImage3.setImageResource(listaImagenes[indicePalabras][2]);
            }
            return true;
        }
        else{
            System.out.println("respuesta: " + respuesta.toString());
            System.out.println("respuesta Objetivo: " + respuestaObjetivo.toString());

            tvCheck.setText("INCORRECTO \n intentalo de nuevo");
            tvCheck.setTextColor(Color.RED);
            return false;
        }

    }


    public void cambiarSonido(int indice){
        System.out.println("El indice es: " + indice);
        rutaSonido = rutasSonidos[indice];
    }

    public int incrementarPuntaje(int puntaje, int puntajeMaximo){
        if(puntaje < puntajeMaximo){
            puntaje++;
        }
        return puntaje;
    }
}