package com.homework1_3.androiddeynenko721;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    Uri uri = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText coordinates = findViewById(R.id.editGM);
        final String query = coordinates.getText().toString();

        Button btnSync = findViewById(R.id.button);
        btnSync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                if(Character.isLetter(query.charAt(0))){
                    uri = Uri.parse(getString(R.string.geoAddressGM,query));
                } else if((Character.isLetter(query.charAt(0))) && query.contains("\\D")) {

                } else {
                    uri = Uri.parse(getString(R.string.geoCoordinatesGM, query));
                    // intent.setData(uri);
                    //  startActivity(intent);
                }
                intent.setData(uri);
                startActivity(intent);
            }
        });
    }
}
