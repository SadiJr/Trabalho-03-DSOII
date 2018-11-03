package constru.app.listeners;

import android.view.View;

import org.json.JSONException;

interface MyViewHolder {
    void onClick(View v);

    void onClick(View view, int position) throws JSONException;
}
