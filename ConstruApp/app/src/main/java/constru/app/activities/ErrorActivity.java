package constru.app.activities;

import android.app.Activity;
import android.os.Bundle;

import constru.app.R;

public class ErrorActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}
