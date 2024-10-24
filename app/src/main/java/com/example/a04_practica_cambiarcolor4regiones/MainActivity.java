package com.example.a04_practica_cambiarcolor4regiones;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        View rect1 = findViewById(R.id.rect1);
        View rect2 = findViewById(R.id.rect2);
        View rect3 = findViewById(R.id.rect3);
        View rect4 = findViewById(R.id.rect4);


        int originalColor = Color.parseColor("#8a0000");
        int blackColor = ContextCompat.getColor(rect1.getContext(), android.R.color.black);             // Color negro


        rect1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((ColorDrawable) v.getBackground()).getColor() == blackColor) {
                    v.setBackgroundColor(originalColor); // Cambia de negro a color original
                    // v.setNextFocusRightId (android.R.color.white);
                } else {
                    v.setBackgroundColor(blackColor); // Cambia de color original a negro
                }
            }
        });

        rect2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (((ColorDrawable) v.getBackground()).getColor() == blackColor) {
                    v.setBackgroundColor(originalColor); // Cambia de nuevo color a original
                } else {
                    v.setBackgroundColor(blackColor); // Cambia a nuevo color
                }
                return true; // Indica que el evento ha sido manejado


            }
        });

        rect3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {

                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        v.setBackgroundColor(blackColor);  // Cambia a negro al tocar
                        return true;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        v.setBackgroundColor(originalColor);  // Vuelve al color original al soltar o cancelar
                        return true;
                }
                return false;
            }
        });

        rect4.setOnTouchListener(new View.OnTouchListener() {
            private boolean isTouching = false; // Variable para verificar si está tocando
            private boolean isInRect4 = false;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int x = (int) event.getRawX();
                int y = (int) event.getRawY();

                int[] location = new int[2];
                rect4.getLocationOnScreen(location); // Asegurar donde pulsamos
                int left = location[0];
                int top = location[1];
                int right = left + rect4.getWidth();
                int bottom = top + rect4.getHeight();

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        isTouching = true; // Comenzamos a tocar
                        // Cambia a negro si el toque está dentro de rect4
                        if (x >= left && x <= right && y >= top && y <= bottom) {
                            v.setBackgroundColor(blackColor); // Cambia a negro
                            isInRect4 = true; // Marcamos que estamos dentro
                        } else {
                            v.setBackgroundColor(originalColor); //  Rojo si está fuera
                            isInRect4 = false; // Marcamos que estamos fuera
                        }
                        return true; // Indica que el evento fue manejado

                    case MotionEvent.ACTION_MOVE:
                        if (isTouching) {
                            // Verifica si el toque está dentro de rect4
                            if ((x >= left && x <= right && y >= top && y <= bottom)) {
                                if (!isInRect4) { // Si antes no estaba dentro, cambiamos a negro
                                    v.setBackgroundColor(blackColor); // Cambia a negro
                                    isInRect4 = true; // Actualiza el estado
                                }
                            } else {
                                if (isInRect4) { // Si antes estaba dentro y ahora está fuera
                                    v.setBackgroundColor(originalColor); // Vuelve a rojo
                                    isInRect4 = false; // Actualiza el estado
                                }
                            }

                        }
                        return true; // Indica que el evento fue manejado

                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        isTouching = false; // Restablece el estado
                        isInRect4 = false; // Restablece el estado
                        v.setBackgroundColor(originalColor); // Vuelve al color original
                        return true; // Indica que el evento fue manejado

                    default:
                        return false; // Para otros eventos, no hacer nada
                }
            }
        });
    }
}