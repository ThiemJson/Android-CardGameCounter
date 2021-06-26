package teneocto.thiemjason.android_scorecounter.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

import teneocto.thiemjason.android_scorecounter.R;
import teneocto.thiemjason.android_scorecounter.ui.gamelist.GameList;
import teneocto.thiemjason.android_scorecounter.utils.AppConst;

public class Home extends AppCompatActivity implements HomeAdapter.HomeAdapterDelegate {
    /**
     * Components
     */
    EditText mEdtGameName;
    EditText mMaxScore;
    EditText mMaxPlayer;
    TextView mPlayerCount;

    Button mGameList;
    Button mGameSetting;
    Button mGameStart;

    GridView mGridView;
    View mEmpty;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewInitial();
        gridViewInitial();
    }

    /**
     * View Initial
     */
    private void viewInitial() {
        this.mEdtGameName = findViewById(R.id.home_game_name);
        this.mMaxScore = findViewById(R.id.home_game_max_score);
        this.mMaxPlayer = findViewById(R.id.home_game_max_players);
        this.mPlayerCount = findViewById(R.id.home_game_players_count);

        this.mGameList = findViewById(R.id.home_game_list);
        this.mGameSetting = findViewById(R.id.home_game_setting);
        this.mGameStart = findViewById(R.id.home_game_start);

        this.mGridView = findViewById(R.id.home_game_players_grid_view);
        this.mEmpty = findViewById(R.id.home_players_empty_layout);
    }

    /**
     * GridView initial
     */
    private void gridViewInitial() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("eqw ");
        names.add("eqw ");
        names.add("eqw ");
        names.add("eqw ");
        names.add("eqw ");
        names.add("eqw ");
        names.add("eqw ");

        HomeAdapter adapter = new HomeAdapter(this, names);
        adapter.delegate = this;
        this.mGridView.setAdapter(adapter);
        this.hideShowEmpty();
    }

    /**
     * Hide / Show empty image
     */
    private void hideShowEmpty() {
        this.mEmpty.setVisibility(View.GONE);
    }

    @Override
    public void onItemLick(View view, int position) {
        Log.i(AppConst.TAG_Home, " Clicked");
    }
}