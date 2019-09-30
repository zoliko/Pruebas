package com.mowo.software.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ventana_menuPrincipal extends AppCompatActivity {

    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_ventana_menu_principal);

            tv1 = (TextView)findViewById(R.id.txt_Tax_Sos);
        }

    //Metodo seleccion Servicios de emergencia

    public void Servicios_de_emergencia(View view)
        {
            tv1.setText("Servicios de emergencias");

            Intent pantalla_emergencias = new Intent(this, ventana_emergencias.class);
            startActivity(pantalla_emergencias);
            finish();
        }

    //Metodo Solicitar un taxi
    public void solicitar_taxi (View view)
        {
            Mensaje_CuadroDialogo("Exito","Un taxi sera enviado a su ubicacion actual230893","ok");


        }

    public void Mensaje_CuadroDialogo(String Titulo,String mensaje,String TextoBoton)
    {
        AlertDialog.Builder Ventanita = new AlertDialog.Builder(this);
        Ventanita.setCancelable(false);
        Ventanita.setTitle(Titulo);
        Ventanita.setMessage(mensaje);
        Ventanita.setPositiveButton(TextoBoton, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {

            }
        });
        Ventanita.create().show();

    }
}
