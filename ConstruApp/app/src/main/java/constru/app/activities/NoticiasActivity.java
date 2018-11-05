package constru.app.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;

import constru.app.R;
import constru.app.adapters.AdapterEmpreendimentos;
import constru.app.adapters.AdapterNoticias;

public class NoticiasActivity extends Activity {
    private JSONArray dataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);
        createDataset();

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.noticiasView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new AdapterNoticias(this, dataset));
    }

    private void createDataset() {
        String json;

        try {
            InputStream is = getAssets().open("Noticias.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
            dataset = new JSONArray(json);
        } catch (IOException e) {
            setContentView(R.layout.activity_error);
            e.printStackTrace();
        } catch (JSONException e) {
            setContentView(R.layout.activity_error);
            e.printStackTrace();
        }

        }
    }
