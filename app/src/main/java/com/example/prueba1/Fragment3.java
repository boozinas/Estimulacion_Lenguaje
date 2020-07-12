package com.example.prueba1;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class Fragment3 extends Fragment {
    VideoView vvw;
    Uri uri;
    Uri[] uris;
    MediaController mcr;
    FloatingActionButton btHome;

    boolean respuestaTF;

    int indiceVideo;
    int puntaje;
    ImageView ivImage1;
    ImageView ivImage2;
    ImageView ivImage3;
    TextView tvCheck;

    Button btReproducir;

    int[][] listaImagenes;
    int[] listaImagenesLapiz = new int[]{R.drawable.lapiz, R.drawable.barniz, R.drawable.nariz};
    int[] listaImagenesMorado = new int[]{R.drawable.soldado, R.drawable.helado, R.drawable.morado};
    int[] listaImagenesFerrocarril = new int[]{R.drawable.albanil, R.drawable.ferrocarril, R.drawable.barril_1};

    int[] respuesta;
    int[][] listaRespuestas;

    int[] respuestaLapiz = new int[]{1, 0, 0};
    int[] respuestaMorado = new int[]{0, 0, 1};
    int[] respuestaFerrocarril = new int[]{0, 1, 0};

    MediaPlayer sound;

    public Fragment3() {
        // Required empty public constructor
        indiceVideo = 0;
        listaImagenes = new int[3][1];
        listaRespuestas = new int[3][1];
        listaImagenes[0] = listaImagenesLapiz;
        listaImagenes[1] = listaImagenesMorado;
        listaImagenes[2] = listaImagenesFerrocarril;

        listaRespuestas[0] = respuestaLapiz;
        listaRespuestas[1] = respuestaMorado;
        listaRespuestas[2] = respuestaFerrocarril;
        respuestaTF = false;

        uris = new Uri[3];
        uris[0] = Uri.parse("android.resource://com.example.prueba1/" + R.raw.lapiz_video);
        uris[1] = Uri.parse("android.resource://com.example.prueba1/" + R.raw.morado_video);
        uris[2] = Uri.parse("android.resource://com.example.prueba1/" + R.raw.ferrocarril_video);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sound = MediaPlayer.create(getContext(), R.raw.observa_el_movimiento_de_la_boca);
        sound.start();
        ivImage1 = (ImageView) view.findViewById(R.id.ivImagen1F3);
        ivImage2 = (ImageView) view.findViewById(R.id.ivImagen2F3);
        ivImage3 = (ImageView) view.findViewById(R.id.ivImagen3F3);

        tvCheck = (TextView) view.findViewById(R.id.tvCheckF3);
        btReproducir = (Button) view.findViewById(R.id.btnReproducirF3);
        btHome = (FloatingActionButton)view.findViewById(R.id.btHome);
        btHome.hide();

        ivImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                respuesta = new int[]{1, 0, 0};
                if (indiceVideo < listaRespuestas.length) {
                    respuestaTF = verificarRespuesta(respuesta, listaRespuestas[indiceVideo]);
                    System.out.println("El resultado es: " + respuestaTF);
                }
                if (puntaje >= listaRespuestas.length) {
                    tvCheck.setText("PERFECTO \n JUEGO TERMINADO");
                }
            }
        });

        ivImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                respuesta = new int[]{0, 1, 0};
                if (indiceVideo < listaRespuestas.length) {
                    respuestaTF = verificarRespuesta(respuesta, listaRespuestas[indiceVideo]);
                    System.out.println("El resultado es: " + respuestaTF);
                }
                if (puntaje >= listaRespuestas.length) {
                    tvCheck.setText("PERFECTO \n JUEGO TERMINADO");
                }
            }
        });

        ivImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                respuesta = new int[]{0, 0, 1};
                if (indiceVideo < listaRespuestas.length) {
                    respuestaTF = verificarRespuesta(respuesta, listaRespuestas[indiceVideo]);
                    System.out.println("El resultado es: " + respuestaTF);
                }
                if (puntaje >= listaRespuestas.length) {
                    tvCheck.setText("PERFECTO \n JUEGO TERMINADO");
                }
            }
        });

        btReproducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvCheck.setText("");
                vvw.setVideoURI(uri);
                vvw.start();
            }
        });

        vvw = (VideoView) view.findViewById(R.id.videoViewF3);
        uri = uris[0];
        vvw.setVideoURI(uri);
        vvw.start();

        final NavController navController = Navigation.findNavController(view);
        btHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.inicio);
            }
        });
    }




    public boolean verificarRespuesta(int[] respuesta, int[] respuestaObjetivo) {
        vvw.stopPlayback();
        if (Arrays.equals(respuesta, respuestaObjetivo)) {
            System.out.println("respuesta: " + respuesta.toString());
            System.out.println("respuesta Objetivo: " + respuestaObjetivo.toString());

            if (indiceVideo < listaRespuestas.length) {
                indiceVideo++;
            }

            tvCheck.setText("CORRECTO");
            puntaje = incrementarPuntaje(puntaje, listaRespuestas.length);
            tvCheck.setTextColor(Color.GREEN);
            System.out.println("El indice: " + indiceVideo);
            System.out.println("El puntaje: " + puntaje);
            if (puntaje >= listaRespuestas.length) {
                sound.stop();
                sound.release();
                sound = MediaPlayer.create(getContext(), R.raw.felicidades_has_termiando);
                sound.start();
                tvCheck.setText("PERFECTO \n JUEGO TERMINADO");
                //btNextLVL.show();
                btHome.show();
                vvw.stopPlayback();
            }
            //Colocación de todas las imagenes automáticamente
            if (indiceVideo < listaRespuestas.length) {
                btReproducir.setText("Reproducir video " + (indiceVideo + 1));
                cambiarVideo(indiceVideo);
                ivImage1.setImageResource(listaImagenes[indiceVideo][0]);
                ivImage2.setImageResource(listaImagenes[indiceVideo][1]);
                ivImage3.setImageResource(listaImagenes[indiceVideo][2]);
            }
            return true;
        } else {
            System.out.println("respuesta: " + respuesta.toString());
            System.out.println("respuesta Objetivo: " + respuestaObjetivo.toString());

            tvCheck.setText("INCORRECTO \n intentalo de nuevo");
            tvCheck.setTextColor(Color.RED);
            return false;
        }

    }

    public int incrementarPuntaje(int puntaje, int puntajeMaximo) {
        if (puntaje < puntajeMaximo) {
            puntaje++;
        }
        return puntaje;
    }

    public void cambiarVideo(int indice) {
        System.out.println("El indice es: " + indice);
        uri = uris[indice];
        vvw.setVideoURI(uri);
        vvw.start();
    }
}
