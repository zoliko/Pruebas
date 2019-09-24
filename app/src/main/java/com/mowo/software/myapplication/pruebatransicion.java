package com.mowo.software.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pruebatransicion extends AppCompatActivity {

    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pruebatransicion);

        b1 =  findViewById(R.id.button2);
    }

    public  void boton_cerrar(View w)
    {
        finish();
    }

}
