package com.example.a04_practica_cambiarcolor4regiones;


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

        int originalColor = ContextCompat.getColor(rect1.getContext(), android.R.color.holo_red_light); // Color original
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
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        isTouching = true; // Indica que se está tocando
                        v.setBackgroundColor(blackColor); // Cambia a negro al tocar
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        // Verifica si el toque está fuera del rectángulo
                        if (!isTouching) {
                            v.setBackgroundColor(originalColor); // Vuelve al color original si sale
                        }
                        return false; //he cambiado a false (original true)
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        isTouching = false; // Restablece el estado
                        v.setBackgroundColor(originalColor); // Vuelve al color original al soltar
                        return true;
                    case MotionEvent.ACTION_OUTSIDE:
                        if (isTouching) {
                            // Permanece negro si todavía se está tocando
                            v.setBackgroundColor(blackColor);
                        }
                        return true;
                }
                return false;
            }
        });


    }

}