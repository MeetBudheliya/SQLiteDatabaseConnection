package com.example.sqlite_database_connection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    DBO object = new DBO(this, "StudentDB", null, 1);

    EditText name;
    EditText age;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.nameET);
        age = findViewById(R.id.ageET);
        add = findViewById(R.id.addBTN);

        object.delete_record(2);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enterdName = name.getText().toString();
                Integer enterdAge = Integer.parseInt(age.getText().toString());
                object.addData(enterdName,enterdAge);

                name.setText("");
                age.setText("");
                name.beginBatchEdit();
            }
        });

    }
}