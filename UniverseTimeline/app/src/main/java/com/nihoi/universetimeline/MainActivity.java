package com.nihoi.universetimeline;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView miTextViewT=findViewById(R.id.textViewTierra);
        TextView miTextViewB = findViewById(R.id.textViewBigBang);
        TextView miTextViewS =findViewById(R.id.textViewMateria);
        TextView miTextViewA = findViewById(R.id.textViewAtomos);
        TextView miTextViewN =findViewById(R.id.textViewNeuro);
        TextView miTextViewEs = findViewById(R.id.textViewEstrellas);
        TextView miTextViewG =findViewById(R.id.textViewGalaxias);
        TextView miTextViewSS =findViewById(R.id.textViewSS);


        miTextViewB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un diálogo emergente personalizado
                Dialog popupDialog = new Dialog(MainActivity.this); // "context" es el contexto de la actividad o fragmento

                // Establecer el diseño personalizado del diálogo
                popupDialog.setContentView(R.layout.popup_layout);

                // Enlazar vistas del diseño del diálogo
                TextView textViewPopupContent1 = popupDialog.findViewById(R.id.textViewPopupContent1);
                TextView textViewPopupContent2 = popupDialog.findViewById(R.id.textViewPopupContent2);
                Button buttonClose = popupDialog.findViewById(R.id.buttonClose);

                // Configurar el contenido del TextView en el diálogo según tus necesidades
                textViewPopupContent1.setText("BIG BANG");
                textViewPopupContent2.setText(getString(R.string.bigbangtext));

                // Configurar el botón "X" para cerrar el diálogo
                buttonClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Cerrar el diálogo emergente
                        popupDialog.dismiss();
                    }
                });

                // Mostrar el diálogo emergente
                popupDialog.show();
            }
        });
        miTextViewS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un diálogo emergente personalizado
                Dialog popupDialog = new Dialog(MainActivity.this); // "context" es el contexto de la actividad o fragmento

                // Establecer el diseño personalizado del diálogo
                popupDialog.setContentView(R.layout.popup_layout);

                // Enlazar vistas del diseño del diálogo
                TextView textViewPopupContent1 = popupDialog.findViewById(R.id.textViewPopupContent1);
                TextView textViewPopupContent2 = popupDialog.findViewById(R.id.textViewPopupContent2);
                Button buttonClose = popupDialog.findViewById(R.id.buttonClose);

                // Configurar el contenido del TextView en el diálogo según tus necesidades
                textViewPopupContent1.setText("PROTONES Y NEUTRONES");
                textViewPopupContent2.setText(getString(R.string.materiatext));

                // Configurar el botón "X" para cerrar el diálogo
                buttonClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Cerrar el diálogo emergente
                        popupDialog.dismiss();
                    }
                });

                // Mostrar el diálogo emergente
                popupDialog.show();
            }
        });

        miTextViewA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un diálogo emergente personalizado
                Dialog popupDialog = new Dialog(MainActivity.this); // "context" es el contexto de la actividad o fragmento

                // Establecer el diseño personalizado del diálogo
                popupDialog.setContentView(R.layout.popup_layout);

                // Enlazar vistas del diseño del diálogo
                TextView textViewPopupContent1 = popupDialog.findViewById(R.id.textViewPopupContent1);
                TextView textViewPopupContent2 = popupDialog.findViewById(R.id.textViewPopupContent2);
                Button buttonClose = popupDialog.findViewById(R.id.buttonClose);

                // Configurar el contenido del TextView en el diálogo según tus necesidades
                textViewPopupContent1.setText("PRIMEROS ÁTOMOS");
                textViewPopupContent2.setText(getString(R.string.atomstext));

                // Configurar el botón "X" para cerrar el diálogo
                buttonClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Cerrar el diálogo emergente
                        popupDialog.dismiss();
                    }
                });

                // Mostrar el diálogo emergente
                popupDialog.show();
            }
        });
        miTextViewEs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un diálogo emergente personalizado
                Dialog popupDialog = new Dialog(MainActivity.this); // "context" es el contexto de la actividad o fragmento

                // Establecer el diseño personalizado del diálogo
                popupDialog.setContentView(R.layout.popup_layout);

                // Enlazar vistas del diseño del diálogo
                TextView textViewPopupContent1 = popupDialog.findViewById(R.id.textViewPopupContent1);
                TextView textViewPopupContent2 = popupDialog.findViewById(R.id.textViewPopupContent2);
                Button buttonClose = popupDialog.findViewById(R.id.buttonClose);

                // Configurar el contenido del TextView en el diálogo según tus necesidades
                textViewPopupContent1.setText("FORMACIÓN DE ESTRELLAS");
                textViewPopupContent2.setText(getString(R.string.estrellestext));

                // Configurar el botón "X" para cerrar el diálogo
                buttonClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Cerrar el diálogo emergente
                        popupDialog.dismiss();
                    }
                });

                // Mostrar el diálogo emergente
                popupDialog.show();
            }
        });
        miTextViewN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un diálogo emergente personalizado
                Dialog popupDialog = new Dialog(MainActivity.this); // "context" es el contexto de la actividad o fragmento

                // Establecer el diseño personalizado del diálogo
                popupDialog.setContentView(R.layout.popup_layout);

                // Enlazar vistas del diseño del diálogo
                TextView textViewPopupContent1 = popupDialog.findViewById(R.id.textViewPopupContent1);
                TextView textViewPopupContent2 = popupDialog.findViewById(R.id.textViewPopupContent2);
                Button buttonClose = popupDialog.findViewById(R.id.buttonClose);

                // Configurar el contenido del TextView en el diálogo según tus necesidades
                textViewPopupContent1.setText("NEUROSÍNTESIS ESTELAR");
                textViewPopupContent2.setText(getString(R.string.neurosintesistext));

                // Configurar el botón "X" para cerrar el diálogo
                buttonClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Cerrar el diálogo emergente
                        popupDialog.dismiss();
                    }
                });

                // Mostrar el diálogo emergente
                popupDialog.show();
            }
        });
        miTextViewG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un diálogo emergente personalizado
                Dialog popupDialog = new Dialog(MainActivity.this); // "context" es el contexto de la actividad o fragmento

                // Establecer el diseño personalizado del diálogo
                popupDialog.setContentView(R.layout.popup_layout);

                // Enlazar vistas del diseño del diálogo
                TextView textViewPopupContent1 = popupDialog.findViewById(R.id.textViewPopupContent1);
                TextView textViewPopupContent2 = popupDialog.findViewById(R.id.textViewPopupContent2);
                Button buttonClose = popupDialog.findViewById(R.id.buttonClose);

                // Configurar el contenido del TextView en el diálogo según tus necesidades
                textViewPopupContent1.setText("PRIMERAS GALAXIAS");
                textViewPopupContent2.setText(getString(R.string.galaxiestext));

                // Configurar el botón "X" para cerrar el diálogo
                buttonClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Cerrar el diálogo emergente
                        popupDialog.dismiss();
                    }
                });

                // Mostrar el diálogo emergente
                popupDialog.show();
            }
        });
        miTextViewSS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un diálogo emergente personalizado
                Dialog popupDialog = new Dialog(MainActivity.this); // "context" es el contexto de la actividad o fragmento

                // Establecer el diseño personalizado del diálogo
                popupDialog.setContentView(R.layout.popup_layout);

                // Enlazar vistas del diseño del diálogo
                TextView textViewPopupContent1 = popupDialog.findViewById(R.id.textViewPopupContent1);
                TextView textViewPopupContent2 = popupDialog.findViewById(R.id.textViewPopupContent2);
                Button buttonClose = popupDialog.findViewById(R.id.buttonClose);

                // Configurar el contenido del TextView en el diálogo según tus necesidades
                textViewPopupContent1.setText("EL SISTEMA SOLAR");
                textViewPopupContent2.setText(getString(R.string.galaxiestext));

                // Configurar el botón "X" para cerrar el diálogo
                buttonClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Cerrar el diálogo emergente
                        popupDialog.dismiss();
                    }
                });

                // Mostrar el diálogo emergente
                popupDialog.show();
            }
        });
        miTextViewT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un diálogo emergente personalizado
                Dialog popupDialog = new Dialog(MainActivity.this); // "context" es el contexto de la actividad o fragmento

                // Establecer el diseño personalizado del diálogo
                popupDialog.setContentView(R.layout.popup_layout);

                // Enlazar vistas del diseño del diálogo
                TextView textViewPopupContent1 = popupDialog.findViewById(R.id.textViewPopupContent1);
                TextView textViewPopupContent2 = popupDialog.findViewById(R.id.textViewPopupContent2);
                Button buttonClose = popupDialog.findViewById(R.id.buttonClose);

                // Configurar el contenido del TextView en el diálogo según tus necesidades
                textViewPopupContent1.setText("LA TIERRA");
                textViewPopupContent2.setText(getString(R.string.terratext));

                // Configurar el botón "X" para cerrar el diálogo
                buttonClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Cerrar el diálogo emergente
                        popupDialog.dismiss();
                    }
                });

                // Mostrar el diálogo emergente
                popupDialog.show();
            }
        });


    }
}