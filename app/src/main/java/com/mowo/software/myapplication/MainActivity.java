package com.mowo.software.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    TextView etiqueta_menu;

    //*********

    String NIP = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.txt_nip);

    }

    //Metodo de igreso via NIP
    public void NIP(View v)
    {
        /*String nip_String = et1.getText().toString();
        Toast.makeText(this, "Usted ah ingresado con el NIP " + nip_String, Toast.LENGTH_SHORT).show();//*/

        NIP = et1.getText().toString().trim();

        if("230893".equals(NIP) && NIP.equals("") != true)
            {


                Intent pantalla_menuPrincipal = new Intent(this,ventana_menuPrincipal.class);
                /*pantalla_menuPrincipal.putExtra("Codigo de cliente",NIP);
                pantalla_menuPrincipal.putExtra("Correo","Arnaiz@gmail.com");
                pantalla_menuPrincipal.putExtra("Nombre","Instituto Arnaiz");//*/
                startActivity(pantalla_menuPrincipal);
            }
        else
            {
                Mensaje_CuadroDialogo("Error","Usuario no registrado, Verifique sus datos","ok");
            }
    }

    //Metodos via scrollView
    public void Seleccion(View view)
        {

            //***********

            AlertDialog.Builder Ventada_info;
            View vista_alerta;
            final AlertDialog vista_Viaje;


            //**********
            switch (view.getId())
                {
                    case R.id.codigoqr:
                        /*
                        Toast.makeText(this, "Escanee el codigo QR", Toast.LENGTH_SHORT).show();
                        etiqueta_menu.setText("codigo QR");

                        Intent pantalla_menuPrincipal = new Intent(this,ventana_menuPrincipal.class);
                        startActivity(pantalla_menuPrincipal); */
                        //finish();
                        new IntentIntegrator(MainActivity.this).initiateScan();

                        break;
                    case R.id.buscar:
                        //Toast.makeText(this, "FindYourself", Toast.LENGTH_SHORT).show();

                                     Ventada_info = new AlertDialog.Builder(MainActivity.this);
                                     vista_alerta = getLayoutInflater().inflate(R.layout.cuadro_dialogo_buscarte,null);

                                    EditText correo =  (EditText) vista_alerta.findViewById(R.id.editText_correo);
                                    EditText Numero =  (EditText) vista_alerta.findViewById(R.id.editText_numero);

                                    Button Buscarte_Cancelar =  (Button) vista_alerta.findViewById(R.id.Buscarte_Cancelar);
                                    Button Buscarte_Buscar =  (Button) vista_alerta.findViewById(R.id.Buscarte_Buscar);


                                    Ventada_info.setView(vista_alerta);
                                     vista_Viaje = Ventada_info.create();

                                    Buscarte_Cancelar.setOnClickListener(new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view)
                                        {

                                            vista_Viaje.cancel();
                                        }
                                    });
                                    Buscarte_Buscar.setOnClickListener(new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view)
                                        {




                                        }
                                    });
                                    vista_Viaje.show();

                        break;
                    case R.id.ubicacion:
                        Toast.makeText(this, "Esta es su ubicacion actual", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.emergencia:

                                Ventada_info = new AlertDialog.Builder(MainActivity.this);
                                 vista_alerta = getLayoutInflater().inflate(R.layout.cuadro_dialogo_emergencia,null);

                                Button Viajes_No_Encontrados_Aviso_Boton_Si =  (Button) vista_alerta.findViewById(R.id.Buscarte_Cancelar);
                                Button Viajes_No_Encontrados_Aviso_Boton_No =  (Button) vista_alerta.findViewById(R.id.Buscarte_Buscar);


                                Ventada_info.setView(vista_alerta);
                                vista_Viaje = Ventada_info.create();

                                Viajes_No_Encontrados_Aviso_Boton_Si.setOnClickListener(new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view)
                                            {


                                            }
                                    });
                                Viajes_No_Encontrados_Aviso_Boton_No.setOnClickListener(new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view)
                                            {

                                                vista_Viaje.cancel();


                                            }
                                    });
                                vista_Viaje.show();
                        //Toast.makeText(this, "Usted a solicitado una emergencia", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.about:
                        Toast.makeText(this, "Acerca de nosotros", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.contacto:
                        Toast.makeText(this, "Contactanos!!!", Toast.LENGTH_SHORT).show();

                        break;

                }
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if(result != null)
            if (result.getContents() != null)
            {

                if("230893".equals(result.getContents()))
                    {


                        Intent pantalla_menuPrincipal = new Intent(this,ventana_menuPrincipal.class);
                        pantalla_menuPrincipal.putExtra("Codigo de cliente",result.getContents());
                        startActivity(pantalla_menuPrincipal);
                    }
                else
                    {
                        Toast.makeText(this, "Usuario no registrado", Toast.LENGTH_SHORT).show();
                    }


            }

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
