package com.example.sqlite_database_connection;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DBO object = new DBO(this, "StudentDB", null, 1);

    EditText name;
    EditText age;
    EditText deleteID;
    Button add;
    Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.nameET);
        age = findViewById(R.id.ageET);
        deleteID = findViewById(R.id.deletET);
        add = findViewById(R.id.addBTN);
        delete = findViewById(R.id.deleteBTN);

//        //Add button click listener
//        add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String enterdName = name.getText().toString();
//                Integer enterdAge = Integer.parseInt(age.getText().toString());
//                object.addData(enterdName,enterdAge);
//Toast.makeText(this,"record inserted successfully",Toast.LENGTH_SHORT);
//                name.setText("");
//                age.setText("");
//            }
//        });

//        //delete button click listener
//        add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Integer enterdID = Integer.parseInt(deleteID.getText().toString());
//                object.delete_record(enterdID);
//        Toast.makeText(this,"record deleted successfully",Toast.LENGTH_SHORT);
//            }
//        });

        StringBuilder sb = new StringBuilder();
        Cursor result;
        result = object.getData();

        while (result.moveToNext()) {
            sb.append(result.getColumnIndex("stud_name"));
        }
//        Toast.makeText(this, result.getColumnIndex("stud_name"), Toast.LENGTH_SHORT);
    }
}