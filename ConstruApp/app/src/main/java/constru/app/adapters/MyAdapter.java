package constru.app.adapters;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import constru.app.R;
import constru.app.activities.EmpreendimentosActivity;
import constru.app.activities.MapsActivity;
import constru.app.listeners.ItemClickListener;

import static android.content.ClipData.*;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private JSONArray dataset;


    public MyAdapter(Context context, JSONArray dataset) {
        this.context = context;
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflate = LayoutInflater.from(context);
        View itemAdd = inflate.inflate(R.layout.activity_itens_empreendimentos, parent, false);
        MyViewHolder item = new MyViewHolder(itemAdd);
        return item;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        try {

            ((MyViewHolder) viewHolder).textView.setText(dataset.getJSONObject(i).getString("nome") );

                ((MyViewHolder) viewHolder).btMap.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent startIntent = new Intent(context, MapsActivity.class);
                        try {
                            startIntent.putExtra("latitude", Float.parseFloat(dataset.getJSONObject(i).get("latitude").toString()));
                            startIntent.putExtra("longitude", Float.parseFloat(dataset.getJSONObject(i).get("longitude").toString()));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        context.startActivity(startIntent);
                    }
                });

            ((MyViewHolder) viewHolder).setItemClickListener((view, position) -> {
                JSONObject obj = dataset.getJSONObject(position);
                new AlertDialog.Builder(context)
                        .setTitle("Sobre")
                        .setMessage("Nome: " + obj.getString("nome")
                                + "\n\nPaís: " + obj.getString("pais")
                                + "\n\nEstado: " + obj.getString("estado")
                                + "\n\nCidade: " + obj.getString("cidade")
                                + "\n\nBairro: " + obj.getString("bairro")
                                + "\n\nRua: " + obj.getString("rua")
                                + "\n\nÁrea total: " + obj.getString("area") + " metros quadrados"
                                + "\n\nNúmero de andares: " + obj.getInt("andares")
                                + "\n\nNúmero de quartos: " + obj.getString("quartos")
                                + "\n\nDisponível para aluguel: " + obj.getString("disponibilidadeAluguel")
                                + "\n\nData de Entrega: " + obj.getString("dataEntrega")
                                + "\n\nValor: R$ " + obj.getInt("preco")
                                + "\n\nLimite de Financiamento: " + obj.getString("prazoFinanciamento") + " meses")
                        .setPositiveButton("OK", null)
                        .create().show();
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView;
        Button btMap;
        Button btVideo;

        private ItemClickListener itemClickListener;

        public MyViewHolder(View itemView){
            super(itemView);
            textView = itemView.findViewById(R.id.item);
            btMap = itemView.findViewById(R.id.map);
            btVideo = itemView.findViewById(R.id.youtube);
            itemView.setOnClickListener(this);

        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            try {
                itemClickListener.onClick(v,getAdapterPosition());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
        public int getItemCount() {
            return dataset.length();
        }
    }
