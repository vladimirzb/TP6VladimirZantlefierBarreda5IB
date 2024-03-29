package com.example.tp6vladimirzantlefierbarreda5ib;

import android.util.Log;

import org.cocos2d.actions.interval.MoveTo;
import org.cocos2d.actions.interval.ScaleBy;
import org.cocos2d.layers.Layer;
import org.cocos2d.nodes.Director;
import org.cocos2d.nodes.Scene;
import org.cocos2d.nodes.Sprite;
import org.cocos2d.opengl.CCGLSurfaceView;
import org.cocos2d.types.CCSize;

import java.util.Random;

public class clsJuego {
    CCGLSurfaceView _VistaDelJuego;
    CCSize _Pantalla;
    Sprite _Jugador;

    public  clsJuego(CCGLSurfaceView VistaDelJuego)
    {
        Log.d("Constru", "Comienza el constructor de la clase");
        _VistaDelJuego=VistaDelJuego;
    }

    public void ComenzarJuego()
    {
        Log.d("Comenzar", "Comienza el juego");
        Director.sharedDirector().attachInView(_VistaDelJuego);

        _Pantalla= Director.sharedDirector().displaySize();
        Log.d("ComenzarJuego", "Pantalla - Ancho: " + _Pantalla.getWidth()+ "- Alto: " + _Pantalla.getHeight());

        Log.d("Comenzar", "Declaro e instancio la escena");
        Scene escenaAUsar;
        escenaAUsar = EscenaComienzo();

        Log.d("Comenzar", "Le digo al director de mi jueguito que inicie la escena");
        Director.sharedDirector().runWithScene(escenaAUsar);
    }

    private Scene EscenaComienzo()
    {
        Log.d("EscenaComienzo","comienza");
        Scene escenaADevovler;
        escenaADevovler=Scene.node();

        Log.d("EscenaComienzo","Agrego capa");
        capaJuego unaCapa;
        unaCapa = new capaJuego();
        escenaADevovler.addChild(unaCapa);

        Log.d("EscenaComienzo","Devuelvo la escena creada");
        return escenaADevovler;

    }

    class capaJuego extends Layer{

        public capaJuego()
        {
            Log.d("CapaJuego", "Bob nos construye la capita");

            Log.d("CapaJuego", "Voy a ubicar el jugador en su posicion inicial");
            super.schedule("ponerJugador",3.0f);

            Log.d("CapaJuego", "Ubico al shiba gordo de fondo");
            ponerImagenFondo();
        }

        public void ponerJugador(float diferenciaTiempo)
        {

            Log.d("PonerJugador", "Le asigno la imagen grafica al Sprite del jugador");
            _Jugador= Sprite.sprite("jugador.jpg");
            int alturaJugadorArreglador1= Math.round(_Jugador.getHeight()/2);
            int anchoJugadorArreglador1= Math.round(_Jugador.getWidth()/2);

            Log.d("PonerJugador", "Le pongo su posicion inicial");

            Random r = new Random();
            int low = 1;
            int high = 5;
            int cuadrante = r.nextInt(high-low) + low;

            //Numeros de cuadrantes
            //3 4 //
            //1 2 //
            switch(cuadrante) {
                case 1:
                    int lowX1 = 0 + anchoJugadorArreglador1;
                    int highX1 = Math.round(_Pantalla.getWidth()/2)-anchoJugadorArreglador1;
                    int posicionX1 = r.nextInt(highX1-lowX1) + lowX1;

                    int lowY1 = 0+alturaJugadorArreglador1;
                    int highY1 = Math.round(_Pantalla.getHeight()/2)-alturaJugadorArreglador1;
                    int posicionY1 = r.nextInt(highY1-lowY1) + lowY1;


                    Log.d("PosicionAperecida", "x:" + posicionX1 + "   y:" + posicionY1);

                    _Jugador.setPosition(posicionX1,posicionY1);

                    //Ahora lo movemos al punto mas lejano de este cuadrante, el 4
                    float verticeX1=_Pantalla.getWidth()-anchoJugadorArreglador1;
                    float verticeY1= _Pantalla.getHeight()-alturaJugadorArreglador1;
                    _Jugador.runAction(MoveTo.action(3,verticeX1,verticeY1));


                    break;
                case 2:
                    int lowX2 = Math.round(_Pantalla.getWidth()/2) + anchoJugadorArreglador1;
                    int highX2 = Math.round(_Pantalla.getWidth())-anchoJugadorArreglador1;
                    int posicionX2 = r.nextInt(highX2-lowX2) + lowX2;

                    int lowY2 = 0+alturaJugadorArreglador1;
                    int highY2 = Math.round(_Pantalla.getHeight()/2)-alturaJugadorArreglador1;
                    int posicionY2 = r.nextInt(highY2-lowY2) + lowY2;


                    Log.d("PosicionAperecida", "x:" + posicionX2 + "   y:" + posicionY2);

                    _Jugador.setPosition(posicionX2,posicionY2);

                    //Ahora lo movemos al punto mas lejano de este cuadrante, el 3
                    float verticeX2=0+ anchoJugadorArreglador1;
                    float verticeY2= _Pantalla.getHeight()-alturaJugadorArreglador1;
                    _Jugador.runAction(MoveTo.action(3,verticeX2,verticeY2));
                    break;
                case 3:
                    int lowX3 =  0 + anchoJugadorArreglador1;
                    int highX3 =  Math.round(_Pantalla.getWidth()/2)-anchoJugadorArreglador1;
                    int posicionX3 = r.nextInt(highX3-lowX3) + lowX3;

                    int lowY3 =  Math.round(_Pantalla.getHeight()/2)+alturaJugadorArreglador1;
                    int highY3 = Math.round(_Pantalla.getHeight())-alturaJugadorArreglador1;
                    int posicionY3 = r.nextInt(highY3-lowY3) + lowY3;


                    Log.d("PosicionAperecida", "x:" + posicionX3 + "   y:" + posicionY3);

                    _Jugador.setPosition(posicionX3,posicionY3);

                    //Ahora lo movemos al punto mas lejano de este cuadrante, el 2
                    float verticeX3=_Pantalla.getWidth() - anchoJugadorArreglador1;
                    float verticeY3= 0+alturaJugadorArreglador1;
                    _Jugador.runAction(MoveTo.action(3,verticeX3,verticeY3));
                    break;
                case 4:
                    int lowX4 = Math.round(_Pantalla.getWidth()/2) + anchoJugadorArreglador1;
                    int highX4 = Math.round(_Pantalla.getWidth())-anchoJugadorArreglador1;
                    int posicionX4 = r.nextInt(highX4-lowX4) + lowX4;

                    int lowY4 =  Math.round(_Pantalla.getHeight()/2)+alturaJugadorArreglador1;
                    int highY4 = Math.round(_Pantalla.getHeight())-alturaJugadorArreglador1;
                    int posicionY4 = r.nextInt(highY4-lowY4) + lowY4;


                    Log.d("PosicionAperecida", "x:" + posicionX4 + "   y:" + posicionY4);

                    _Jugador.setPosition(posicionX4,posicionY4);

                    //Ahora lo movemos al punto mas lejano de este cuadrante, el 1
                    float verticeX4=0 + anchoJugadorArreglador1;
                    float verticeY4= 0+alturaJugadorArreglador1;
                    _Jugador.runAction(MoveTo.action(3,verticeX4,verticeY4));
                    break;
            }

            Log.d("PonerJugador", "Lo agrego a la capa");
            super.addChild(_Jugador,10);
        }

        void ponerImagenFondo(){
            Sprite imagenFondo;
            Log.d("PonerFondo","Asigno el fondo del shiba gordito al sprite");
            imagenFondo= Sprite.sprite("shibagorditoFondo.jpg");

            Log.d("PonerFondo","Lo ubico");
            imagenFondo.setPosition(_Pantalla.getWidth()/2, _Pantalla.getHeight()/2);

            Log.d("PonerFondo","Escalo al perro de fondo");
            float factorAncho, factorAlto;
            factorAncho= _Pantalla.getWidth()/imagenFondo.getWidth();
            factorAlto=  _Pantalla.getHeight()/imagenFondo.getHeight();
            Log.d("PonerFondo", "Lo escalo para que ocupe toda la pantalla");
            imagenFondo.runAction(ScaleBy.action(0.01f,factorAncho,factorAlto));


            super.addChild(imagenFondo,-10);
        }
    }
}
