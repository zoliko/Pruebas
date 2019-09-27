package com.mowo.software.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class pantalla_taxis extends AppCompatActivity {

    TextView tv1;
    ImageButton ib_rapido, ib_radio, ib_easy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_taxis);

        tv1 = (TextView)findViewById(R.id.txt_seleccion_taxis);
        ib_rapido = (ImageButton)findViewById(R.id.taxi_rapido);
        ib_radio = (ImageButton)findViewById(R.id.radio_taxi);
        ib_easy = (ImageButton)findViewById(R.id.easy_taxi);
    }

    //Metodo solicitar taxi
    public void SeleccionTaxi(View view){
        switch (view.getId())
        {
            case R.id.taxi_rapido:

                Toast.makeText(this,"",Toast.LENGTH_SHORT).show();
                tv1.setText("Taxi Rapido");
            case R.id.radio_taxi:

                Toast.makeText(this,"",Toast.LENGTH_SHORT).show();
                tv1.setText("Radio Taxi");
            case R.id.easy_taxi:

                Toast.makeText(this,"",Toast.LENGTH_SHORT).show();
                tv1.setText("Easy Taxi");
        }
    }
}
