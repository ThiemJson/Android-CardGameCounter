package teneocto.thiemjason.android_scorecounter.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import teneocto.thiemjason.android_scorecounter.R;
import teneocto.thiemjason.android_scorecounter.ui.gamelist.GameList;
import teneocto.thiemjason.android_scorecounter.ui.players.PlayerAdapter;
import teneocto.thiemjason.android_scorecounter.ui.players.Players;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewInitial();

        Intent intent = new Intent(this, GameList.class);
        startActivity(intent);
    }

    /**
     * View Initial
     */
    private void viewInitial(){

    }
}