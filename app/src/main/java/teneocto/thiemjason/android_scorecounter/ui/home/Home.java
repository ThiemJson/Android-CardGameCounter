package teneocto.thiemjason.android_scorecounter.ui.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.widget.PopupMenu;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import teneocto.thiemjason.android_scorecounter.R;
import teneocto.thiemjason.android_scorecounter.models.Player;
import teneocto.thiemjason.android_scorecounter.ui.gamelist.GameList;
import teneocto.thiemjason.android_scorecounter.ui.gameplay.GamePlay;
import teneocto.thiemjason.android_scorecounter.ui.players.Players;
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

    HomeViewModel mViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.mViewModel = new HomeViewModel();
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

        this.mGameSetting.setOnClickListener(v -> this.onGameSettingClicked());
        this.mGameStart.setOnClickListener(v -> {
            Intent intent = new Intent(this, GamePlay.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });

        this.mGameList.setOnClickListener(v -> {
            Intent intent = new Intent(this, GameList.class);
            startActivity(intent);
        });
    }

    /**
     * GridView initial
     */
    private void gridViewInitial() {
        HomeAdapter adapter = new HomeAdapter(this, this.mViewModel.players.getValue());
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

    /**
     * On Game Setting button click
     */
    @SuppressLint("RestrictedApi")
    private void onGameSettingClicked() {
        PopupMenu popup = new PopupMenu(this, this.mGameSetting);
        popup.getMenuInflater().inflate(R.menu.game_setting_menu, popup.getMenu());

        popup.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()){
                case R.id.game_setting_sync:
                    Toast.makeText(this, "Game sync successfully ", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.game_setting_add_players:
                    Intent intent = new Intent(this, Players.class);
                    startActivity(intent);
                    break;
                case R.id.game_signIn:
                    Toast.makeText(this, "Sign in successfully ! ", Toast.LENGTH_SHORT).show();
                    break;
            }

            return true;
        });

        MenuPopupHelper menuHelper = new MenuPopupHelper(this, (MenuBuilder) popup.getMenu(), this.mGameSetting);
        menuHelper.setForceShowIcon(true);
        menuHelper.show();
    }

//    /**
//     * View model live data listener
//     */
//    private void viewModelLiveDataListener(){
//        this.mViewModel.players.observe( , new Observer<ArrayList<Player>>() {
//            @Override
//            public void onChanged(ArrayList<Player> players) {
//
//            }
//        });
//    }
}