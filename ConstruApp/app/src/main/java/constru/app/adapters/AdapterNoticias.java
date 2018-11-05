package constru.app.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import constru.app.R;
import constru.app.listeners.ItemClickListener;

public class AdapterNoticias extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private JSONArray dataset;

    public AdapterNoticias(Context context, JSONArray dataset) {
        this.context = context;
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflate = LayoutInflater.from(context);
        View itemAdd = inflate.inflate(R.layout.activity_lista_noticias, parent, false);
        MyViewHolder item = new MyViewHolder(itemAdd);
        return item;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        try {
            ((MyViewHolder) viewHolder).textView.setText(dataset.getJSONObject(i).getString("noticia") );
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        EditText textView;

        public MyViewHolder(View itemView){
            super(itemView);
            textView = itemView.findViewById(R.id.editText2);

        }

        @Override
        public void onClick(View v) {

        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return dataset.length();
    }
}
