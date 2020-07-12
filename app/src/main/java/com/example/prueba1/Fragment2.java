package com.example.prueba1;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.StateListDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment2 extends Fragment {
    MediaPlayer sound;
    FloatingActionButton btNextLVL;

    int[][] listaImagenes;
    int[] listaImagenes1;
    int[] listaImagenes2;
    int[] listaImagenes3;


    int rutaSonido;
    int[][] listaSonidos;
    int[] rutasSonidos1;
    int[] rutasSonidos2;
    int[] rutasSonidos3;
    int indiceSonido;


    int[] respuesta;
    int[][] listaRespuestas;

    String[][] listaPalabras;
    String[] palabras1;
    String[] palabras2;
    String[] palabras3;



    public Fragment2() {
        // Required empty public constructor
        rutasSonidos1 = new int[]{R.raw.taza, R.raw.mochila, R.raw.calabaza, R.raw.brincar, R.raw.avion, R.raw.mostaza};
        palabras1 = new String[]{"Taza", "Mochila", "Calabaza", "Brincar", "Avión", "Mostaza"};
        listaImagenes = new int[3][1];
        listaSonidos = new int[3][1];
        listaPalabras = new String[3][1];
        listaRespuestas = new int[3][1];

        listaRespuestas[0]= new int[]{1,0,1,0,0,1};
        respuesta =         new int[]{0,0,0,0,0,0};
        //Asignación de las listas de sonidos
        listaSonidos[0] = rutasSonidos1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        indiceSonido = 0;
        sound = MediaPlayer.create(getContext(), R.raw.ahora_escucha_bien);
        sound.start();
        btNextLVL = (FloatingActionButton)view.findViewById(R.id.btLVL3);
        btNextLVL.hide();

        final ToggleButton btSonido1 = (ToggleButton) view.findViewById(R.id.btnSonido1);
        final ToggleButton btSonido2 = (ToggleButton)view.findViewById(R.id.btnSonido2);
        final ToggleButton btSonido3 = (ToggleButton)view.findViewById(R.id.btnSonido3);
        final ToggleButton btSonido4 = (ToggleButton)view.findViewById(R.id.btnSonido4);
        final ToggleButton btSonido5 = (ToggleButton)view.findViewById(R.id.btnSonido5);
        final ToggleButton btSonido6 = (ToggleButton)view.findViewById(R.id.btnSonido6);

        final TextView tvCheck = (TextView)view.findViewById(R.id.tvCheckF2);

        Button btVerificar = (Button)view.findViewById(R.id.btnVerificarF2);

        //rutaSonido = listaSonidos[0][1];
        //sound = MediaPlayer.create(getContext(), rutaSonido);
        btSonido1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound.stop();
                sound.release();
                //stopAndPlay(sound, listaSonidos[0][0], getContext());
                sound = MediaPlayer.create(getContext(), listaSonidos[0][0]);
                sound.start();
            }
        });


        btSonido2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound.stop();
                sound.release();
                sound = MediaPlayer.create(getContext(), listaSonidos[0][1]);
                sound.start();
                //stopAndPlay(sound, listaSonidos[0][1], getContext());
            }
        });

        btSonido3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound.stop();
                sound.release();
                sound = MediaPlayer.create(getContext(), listaSonidos[0][2]);
                sound.start();
                //stopAndPlay(sound, listaSonidos[0][2], getContext());
            }
        });

        btSonido4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound.stop();
                sound.release();
                sound = MediaPlayer.create(getContext(), listaSonidos[0][3]);
                sound.start();
                //stopAndPlay(sound, listaSonidos[0][3], getContext());
            }
        });

        btSonido5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound.stop();
                sound.release();
                sound = MediaPlayer.create(getContext(), listaSonidos[0][4]);
                sound.start();
                //stopAndPlay(sound, listaSonidos[0][4], getContext());
            }
        });

        btSonido6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound.stop();
                sound.release();
                sound = MediaPlayer.create(getContext(), listaSonidos[0][5]);
                sound.start();
                //stopAndPlay(sound, listaSonidos[0][5], getContext());
            }
        });


        btVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btSonido1.isChecked()){
                    respuesta[0] = 1;
                }else{
                    respuesta[0] = 0;
                }
                if(btSonido2.isChecked()){
                    respuesta[1] = 1;
                }else{
                    respuesta[1] = 0;
                }
                if(btSonido3.isChecked()){
                    respuesta[2] = 1;
                }else{
                    respuesta[2] = 0;
                }
                if(btSonido4.isChecked()){
                    respuesta[3] = 1;
                }else{
                    respuesta[3] = 0;
                }
                if(btSonido5.isChecked()){
                    respuesta[4] = 1;
                }else{
                    respuesta[4] = 0;
                }
                if(btSonido6.isChecked()){
                    respuesta[5] = 1;
                }else{
                    respuesta[5] = 0;
                }
                System.out.println("La respuesta es: " + respuesta[0] + respuesta[1] + respuesta[2] + respuesta[3] + respuesta[4] + respuesta[5]);
                if(Arrays.equals(respuesta, listaRespuestas[0])){
                    tvCheck.setTextColor(Color.GREEN);
                    tvCheck.setText("¡CORRECTO!");
                    sound = MediaPlayer.create(getContext(), R.raw.f_has_pasado_al_ultimo_nivel);
                    sound.start();
                    btNextLVL.show();
                }
                else{
                    tvCheck.setTextColor(Color.RED);
                    tvCheck.setText("Incorrecto, intentalo de nuevo");
                }

            }
        });

        final NavController navController = Navigation.findNavController(view);
        btNextLVL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.fragment3);
            }
        });

    }

    private void stopAndPlay (MediaPlayer sound, int direccion, Context ctx){
        if(sound!=null){

            if(sound.isPlaying()){

                sound.stop();
                sound.release();
            }
            else{
                sound.release();
            }

            sound = MediaPlayer.create(ctx, direccion);
            sound.start();
        }
        else{
            sound = MediaPlayer.create(ctx, direccion);
            sound.start();
        }
    }

}