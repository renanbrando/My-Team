package com.gmail.reebrando.myteam;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnConfirm;
    private TextInputLayout txtName;
    private TextInputLayout txtAge;
    private Spinner  cmbTeams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConfirm = (Button) findViewById(R.id.btnConfirm);
        txtName = (TextInputLayout) findViewById(R.id.edName);
        txtAge = (TextInputLayout) findViewById(R.id.edAge);
        cmbTeams = (Spinner) findViewById(R.id.spnMyTeam);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txtName.getEditText().getText().toString().equals("") && !txtAge.getEditText().getText().toString().equals("")){
                    Intent intent = new Intent(MainActivity.this, MyteamActivity.class);
                    intent.putExtra("name", txtName.getEditText().getText().toString());
                    intent.putExtra("age", txtAge.getEditText().getText().toString());
                    intent.putExtra("team", cmbTeams.getSelectedItem().toString());
                    startActivity(intent);
                } else {
                    // Shows a toast saying that the user did not made an input
                    Toast.makeText(getApplicationContext(), R.string.help, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
