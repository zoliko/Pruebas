package com.mowo.software.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

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
                        /*
                        Toast.makeText(this, "Escanee el codigo QR", Toast.LENGTH_SHORT).show();
                        etiqueta_menu.setText("codigo QR");

                        Intent pantalla_menuPrincipal = new Intent(this,ventana_menuPrincipal.class);
                        startActivity(pantalla_menuPrincipal); */
                        //finish();
                        new IntentIntegrator(MainActivity.this).initiateScan();

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if(result != null)
            if (result.getContents() != null)
            {

                if("1".equals(result.getContents()))
                    {

                        etiqueta_menu.setText("codigo QR");
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
}
