package com.gmail.reebrando.myteam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyteamActivity extends AppCompatActivity {

    private TextView lblTitle;
    private ImageView imgTeam;
    private String myTeam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myteam);

        Bundle bundle = getIntent().getExtras();
        myTeam = bundle.getString("team");

        lblTitle = (TextView) findViewById(R.id.tvTitle);
        imgTeam = (ImageView) findViewById(R.id.imgTeam);

        lblTitle.setText(getString(R.string.hello, bundle.get("name")));
        switch(myTeam) {
            case "Cavaliers":
                imgTeam.setImageResource(R.drawable.cavaliers);
                break;
            case "Hawks":
                imgTeam.setImageResource(R.drawable.hawks);
                break;
            case "Lakers":
                imgTeam.setImageResource(R.drawable.lakers);
                break;
            case "Nuggets":
                imgTeam.setImageResource(R.drawable.nuggets);
                break;
            case "Suns":
                imgTeam.setImageResource(R.drawable.suns);
                break;
            case "Thunder":
                imgTeam.setImageResource(R.drawable.thunder);
                break;
            case "Wizards":
                imgTeam.setImageResource(R.drawable.wizards);
                break;
            default:
                imgTeam.setImageResource(R.drawable.wizards);
                Toast.makeText(MyteamActivity.this, R.string.error, Toast.LENGTH_SHORT).show();
        }

    }
}
