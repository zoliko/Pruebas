package com.mowo.software.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ventana_emergencias extends AppCompatActivity {

    TextView tv1;
    ImageButton ib_policia, ib_ambulancia, ib_bomberos, ib_grua;
    Button btn_policia, btn_ambulancia, btn_bomberos, btn_grua;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_emergencias);

        tv1 = (TextView)findViewById(R.id.txt_menuEmergencias);
        //imageButtons
        ib_policia = (ImageButton) findViewById(R.id.ib_policia);
        ib_ambulancia = (ImageButton) findViewById(R.id.ib_ambulancia);
        ib_bomberos = (ImageButton) findViewById(R.id.ib_bomberos);
        ib_grua = (ImageButton) findViewById(R.id.ib_grua);
        //normalButtons
        btn_policia = (Button) findViewById(R.id.btn_policia);
        btn_ambulancia = (Button) findViewById(R.id.btn_ambulancia);
        btn_bomberos = (Button) findViewById(R.id.btn_bomberos);
        btn_grua = (Button) findViewById(R.id.btn_grua);
    }

    //Metodo botones de policia
    public void BtnsPolicia(View view){

        Toast.makeText(this,"Policia en camino.",Toast.LENGTH_SHORT).show();
        tv1.setText("Policia");
    }

    //Metodod botones ambulancia
    public void BtnsAmbulancia(View view){

        Toast.makeText(this,"Servicio medico en camino.",Toast.LENGTH_SHORT).show();
        tv1.setText("Ambulancia");
    }

    //Metodo botones bomberos
    public void BtnsBomberos(View view){

        Toast.makeText(this,"Bomberos en camino.",Toast.LENGTH_SHORT).show();
        tv1.setText("Bomberos");
    }

    //Metodo botones grua
    public void BtnsGrua(View view){

        Toast.makeText(this,"¡Atencion! Este servicio tiene un coste extra.",Toast.LENGTH_SHORT).show();
        tv1.setText("Servicio de Grua");
    }
}
