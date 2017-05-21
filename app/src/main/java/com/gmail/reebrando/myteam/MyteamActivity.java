package com.gmail.reebrando.myteam;

import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MyteamActivity extends AppCompatActivity {

    private TextView lblTitle;
    private ImageView imgTeam;
    private TextToSpeech textToSpeech;
    private String myTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myteam);

        final Bundle bundle = getIntent().getExtras();
        myTeam = bundle.getString("team");

        lblTitle = (TextView) findViewById(R.id.tvTitle);
        imgTeam = (ImageView) findViewById(R.id.imgTeam);

        lblTitle.setText(getString(R.string.hello, bundle.get("name")));
        switch (myTeam) {
            case "76ers":
                imgTeam.setImageResource(R.drawable.sixers);
                break;
            case "Blazers":
                imgTeam.setImageResource(R.drawable.blazers);
                break;
            case "Bobcats":
                imgTeam.setImageResource(R.drawable.bobcats);
                break;
            case "Bulls":
                imgTeam.setImageResource(R.drawable.bulls);
                break;
            case "Cavaliers":
                imgTeam.setImageResource(R.drawable.cavaliers);
                break;
            case "Celtics":
                imgTeam.setImageResource(R.drawable.celtics);
                break;
            case "Clippers":
                imgTeam.setImageResource(R.drawable.clippers);
                break;
            case "Grizzlies":
                imgTeam.setImageResource(R.drawable.grizzlies);
                break;
            case "Hawks":
                imgTeam.setImageResource(R.drawable.hawks);
                break;
            case "Heat":
                imgTeam.setImageResource(R.drawable.heat);
                break;
            case "Hornets":
                imgTeam.setImageResource(R.drawable.hornets);
                break;
            case "Jazz":
                imgTeam.setImageResource(R.drawable.jazz);
                break;
            case "Kings":
                imgTeam.setImageResource(R.drawable.kings);
                break;
            case "Lakers":
                imgTeam.setImageResource(R.drawable.lakers);
                break;
            case "Magic":
                imgTeam.setImageResource(R.drawable.magic);
                break;
            case "Marvericks":
                imgTeam.setImageResource(R.drawable.mavericks);
                break;
            case "Nets":
                imgTeam.setImageResource(R.drawable.nets);
                break;
            case "Nuggets":
                imgTeam.setImageResource(R.drawable.nuggets);
                break;
            case "Pistons":
                imgTeam.setImageResource(R.drawable.pistons);
                break;
            case "Rockets":
                imgTeam.setImageResource(R.drawable.rockets);
                break;
            case "Suns":
                imgTeam.setImageResource(R.drawable.suns);
                break;
            case "Thunder":
                imgTeam.setImageResource(R.drawable.thunder);
                break;
            case "Timberwolves":
                imgTeam.setImageResource(R.drawable.timberwolves);
                break;
            case "Warriors":
                imgTeam.setImageResource(R.drawable.nets);
                break;
            case "Wizards":
                imgTeam.setImageResource(R.drawable.wizards);
                break;
            default:
                imgTeam.setImageResource(R.drawable.wizards);
                Toast.makeText(MyteamActivity.this, R.string.error, Toast.LENGTH_SHORT).show();
        }

        textToSpeech = new TextToSpeech( MyteamActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.getDefault());
                }
            }
        });

        imgTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    textToSpeech.speak(getString(R.string.hello, bundle.get("name")) + myTeam, TextToSpeech.QUEUE_FLUSH, null, null);
                }
                else {
                    textToSpeech.speak(getString(R.string.hello, bundle.get("name")) + myTeam, TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });
    }



    public void onPause(){
        if(textToSpeech != null){
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onPause();
    }

}



