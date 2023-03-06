package com.alpha.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {
    private Button submit;
    private ImageView img1;
    private ImageView img3;
    EditText kolom;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kolom = findViewById(R.id.kolom);
        submit = findViewById(R.id.submit);
        img1 = findViewById(R.id.img1);
        ImageView img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);

        sharedPreferences = getSharedPreferences("Komen", Context.MODE_PRIVATE);

        String defaultValue = "";
        String savedValue = sharedPreferences.getString("Komen", defaultValue);
        kolom.setText(savedValue);

        submit.setOnClickListener(v-> {
            Toast.makeText(getApplicationContext(), "Komen Tersubmit", Toast.LENGTH_SHORT).show();
        });
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Masuk ke Wa", Toast.LENGTH_SHORT).show();
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Masuk ke Instagram", Toast.LENGTH_SHORT).show();
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Masuk ke Twitter", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),"Siklus OnStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),"Siklus OnStop", Toast.LENGTH_SHORT).show();
    }

    /**
     * {@inheritDoc}
     * <p>
     * Dispatch onPause() to fragments.
     */
    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        String inputValue = kolom.getText().toString();

        editor.putString("Komen", inputValue);
        editor.apply();

        Toast.makeText(getApplicationContext(),"Siklus OnPause", Toast.LENGTH_SHORT).show();
    }

    /**
     * {@inheritDoc}
     * <p>
     * Dispatch onResume() to fragments.  Note that for better inter-operation
     * with older versions of the platform, at the point of this call the
     * fragments attached to the activity are <em>not</em> resumed.
     */
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"Siklus OnResume", Toast.LENGTH_SHORT).show();
    }


}