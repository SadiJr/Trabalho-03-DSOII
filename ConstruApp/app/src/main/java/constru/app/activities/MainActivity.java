package constru.app.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import constru.app.R;

import static constru.app.R.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button noticias = findViewById(id.noticias);
        noticias.setOnClickListener( (v)-> {
            Intent intent = new Intent(getApplicationContext(), NoticiasActivity.class);
            startActivity(intent);
        });

        Button empreendimentos = findViewById(id.empreendimentos);
        empreendimentos.setOnClickListener((v) -> {
            Intent intent = new Intent(getApplicationContext(), EmpreendimentosActivity.class);
            startActivity(intent);
        });
    }
}
