package teneocto.thiemjason.android_scorecounter.ui.gameplay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.widget.PopupMenu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.widget.PopupMenu;

import teneocto.thiemjason.android_scorecounter.R;
import teneocto.thiemjason.android_scorecounter.ui.gamelist.GameList;
import teneocto.thiemjason.android_scorecounter.ui.players.Players;

public class GamePlay extends AppCompatActivity {
    ImageView mAddRound;
    Button mGameList;
    Button mGameSetting;
    Button mGameStatistic;
    TextView mGameName;
    TextView mGamePlayersCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_game_play);

        this.viewInitial();
    }

    /**
     * View initial
     */
    void viewInitial() {
        this.mAddRound = findViewById(R.id.game_play_add);
        this.mGameSetting = findViewById(R.id.game_play_round_setting);
        this.mGameList = findViewById(R.id.game_play_game_list);
        this.mGameStatistic = findViewById(R.id.game_play_round_chart);
        this.mGameName = findViewById(R.id.game_play_game_name);
        this.mGamePlayersCount = findViewById(R.id.game_play_players_count);

        this.mGameList.setOnClickListener(v -> {
            Intent intent = new Intent(this, GameList.class);
            startActivity(intent);
        });

        this.mGameSetting.setOnClickListener(v -> onGamePlaySettingClick());
    }

    /**
     * On Game Setting click
     */
    @SuppressLint("RestrictedApi")
    private void onGamePlaySettingClick() {
        PopupMenu popup = new PopupMenu(this, this.mGameSetting);
        popup.getMenuInflater().inflate(R.menu.round_setting_menu, popup.getMenu());

        popup.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.game_play_refresh_round:
                    Toast.makeText(this, "Game refresh successfully ", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.game_play_add_player:
                    Intent intent = new Intent(this, Players.class);
                    startActivity(intent);
                    break;
                case R.id.game_play_delete_round:
                    Toast.makeText(this, "Delete round successfully ! ", Toast.LENGTH_SHORT).show();
                    break;
            }

            return true;
        });

        MenuPopupHelper menuHelper = new MenuPopupHelper(this, (MenuBuilder) popup.getMenu(), this.mGameSetting);
        menuHelper.setForceShowIcon(true);
        menuHelper.show();
    }
}