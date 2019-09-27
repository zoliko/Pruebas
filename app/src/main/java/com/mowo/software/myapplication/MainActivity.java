package com.mowo.software.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    TextView etiqueta_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.txt_nip);
        etiqueta_menu = (TextView) findViewById(R.id.etiqueta_menu);
    }

    //Metodo de igreso via NIP
    public void NIP(View v)
    {
        String nip_String = et1.getText().toString();
        Toast.makeText(this, "Usted ah ingresado con el NIP " + nip_String, Toast.LENGTH_SHORT).show();
    }

    //Metodos via scrollView
    public void Seleccion(View view)
        {
            switch (view.getId())
                {
                    case R.id.codigoqr:
                        Toast.makeText(this, "Escanee el codigo QR", Toast.LENGTH_SHORT).show();
                        etiqueta_menu.setText("codigo QR");

                        Intent pantalla_menuPrincipal = new Intent(this,ventana_menuPrincipal.class);
                        startActivity(pantalla_menuPrincipal);
                        //finish();


                        break;
                    case R.id.buscar:
                        Toast.makeText(this, "FindYourself", Toast.LENGTH_SHORT).show();
                        etiqueta_menu.setText("Buscar");
                        break;
                    case R.id.ubicacion:
                        Toast.makeText(this, "Esta es su ubicacion actual", Toast.LENGTH_SHORT).show();
                        etiqueta_menu.setText("Mapa");
                        break;
                    case R.id.emergencia:
                        Toast.makeText(this, "Usted a solicitado una emergencia", Toast.LENGTH_SHORT).show();
                        etiqueta_menu.setText("emergencia");
                        break;
                    case R.id.about:
                        Toast.makeText(this, "Acerca de nosotros", Toast.LENGTH_SHORT).show();
                        etiqueta_menu.setText("Acerca de nosotros");
                        break;
                    case R.id.contacto:
                        Toast.makeText(this, "Contactanos!!!", Toast.LENGTH_SHORT).show();
                        etiqueta_menu.setText("Contactanos");
                        break;

                }
        }
}
