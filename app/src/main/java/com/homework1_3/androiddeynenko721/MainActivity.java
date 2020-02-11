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
    String query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText coordinates = findViewById(R.id.editGM);
        Button btnSync = findViewById(R.id.button);
        btnSync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                query = coordinates.getText().toString();

                String target;
                if(isLetter() || isDigit()){
                    target = getString(R.string.geoAddressGM,query);
                    uri = Uri.parse(target);
                } else if(isLetter()) {
                    target = getString(R.string.geoAddressGM,query);
                    uri = Uri.parse(target);
                } else {
                    target = target = getString(R.string.geoCoordinatesGM, query);
                    uri = Uri.parse(target);
                }
                intent.setData(uri);
                startActivity(intent);

            }
        });
    }

    private boolean isLetter(){
        for (int i = 0; i < query.length(); i += 1){
            if(Character.isLetter(query.charAt(i))){
                return true;
            }
        }
        return false;
    }

    private boolean isDigit(){
        for (int i = 0; i < query.length(); i += 1){
            if(Character.isDigit(query.charAt(i))){
                return true;
            }
        }
        return false;
    }
}
