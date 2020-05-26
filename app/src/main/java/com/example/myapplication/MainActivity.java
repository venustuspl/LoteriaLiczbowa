package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button przycisk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        przycisk = findViewById(R.id.button);
    }

    public void onClick(View view) {
        List<Integer> lista = new ArrayList<>();
        Random r = new Random();
        while (lista.size() < 6){
            Integer nowe = 1 + r.nextInt(49);
            boolean czyjest = false;
            for (int i:lista)
            {
                if (i==nowe){
                    czyjest = true;
                }
            }
            if (czyjest == false) lista.add(nowe);
        }
        String napis = "Wylosowano 6 liczb: ";
        for (int i:lista) napis += i + " ";
        przycisk.setText(napis);
    }
}
