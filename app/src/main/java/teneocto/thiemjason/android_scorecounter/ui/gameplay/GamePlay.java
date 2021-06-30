package teneocto.thiemjason.android_scorecounter.ui.gameplay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.widget.PopupMenu;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import me.rishabhkhanna.recyclerswipedrag.OnDragListener;
import me.rishabhkhanna.recyclerswipedrag.OnSwipeListener;
import me.rishabhkhanna.recyclerswipedrag.RecyclerHelper;
import teneocto.thiemjason.android_scorecounter.R;
import teneocto.thiemjason.android_scorecounter.ui.gamelist.GameList;
import teneocto.thiemjason.android_scorecounter.ui.players.Players;
import teneocto.thiemjason.android_scorecounter.utils.AppConst;
import teneocto.thiemjason.android_scorecounter.utils.Utils;

public class GamePlay extends AppCompatActivity {
    ImageView mAddRound;
    Button mGameList;
    Button mGameSetting;
    Button mGameStatistic;
    TextView mGameName;
    TextView mGamePlayersCount;

    TableLayout mHeaderTableLayout;
    TableLayout mBodyTableLayout;

    Dialog mNewRoundDialog;
    Dialog mStatisticDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_game_play);
        this.viewInitial();
        this.initHeaderTableLayout();
        this.initBodyTableLayout();
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
        this.mHeaderTableLayout = findViewById(R.id.game_play_header_table_layout);
        this.mBodyTableLayout = findViewById(R.id.game_play_body_table_layout);

        this.mGameList.setOnClickListener(v -> {
            Intent intent = new Intent(this, GameList.class);
            startActivity(intent);
        });

        this.mGameSetting.setOnClickListener(v -> onGamePlaySettingClick());
        this.mAddRound.setOnClickListener(v -> onAddRoundBtnClick());
        this.mGameStatistic.setOnClickListener(v -> onStatisticBtnClick());
        HorizontalScrollView ho = findViewById(R.id.game_play_horizontal_scroll_view);
        ho.setOnClickListener(v -> Utils.hideKeyboard(this));
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
                    this.mBodyTableLayout.removeViewAt(this.mBodyTableLayout.getChildCount() - 1);
                    break;
            }

            return true;
        });

        MenuPopupHelper menuHelper = new MenuPopupHelper(this, (MenuBuilder) popup.getMenu(), this.mGameSetting);
        menuHelper.setForceShowIcon(true);
        menuHelper.show();
    }

    /**
     * Initial Header table layout
     */
    private void initHeaderTableLayout() {
        TableRow tableRow = new TableRow(getApplicationContext());
        for (int i = 0; i < 12; i++) {
            if (i == 0) {
                LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
                View view = inflater.inflate(R.layout.game_play_start_header_cell, tableRow, false);
                tableRow.addView(view);
                i++;
                continue;
            }

            LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
            View view = inflater.inflate(R.layout.game_play_header_cell, tableRow, false);
            tableRow.addView(view);
        }
        this.mHeaderTableLayout.addView(tableRow);
    }

    /**
     * Initial Body table layout
     */
    private void initBodyTableLayout() {
        for (int i = 0; i < 15; i++) {
            TableRow tableRow = new TableRow(getApplicationContext());
            for (int k = 0; k < 12; k++) {
                if (k == 0) {
                    LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
                    View view = inflater.inflate(R.layout.game_play_start_row_cell, tableRow, false);
                    tableRow.addView(view);
                    k++;
                    continue;
                }

                LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
                View view = inflater.inflate(R.layout.game_play_row_cell, tableRow, false);
                tableRow.addView(view);
            }
            this.mBodyTableLayout.addView(tableRow);
        }
    }

    /**
     * Add round
     */
    private void onAddRoundBtnClick() {
        if (this.mNewRoundDialog != null) {
            this.mNewRoundDialog.dismiss();
        }

        this.mNewRoundDialog = new Dialog(this);
        this.mNewRoundDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.mNewRoundDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        this.mNewRoundDialog.setContentView(R.layout.game_play_add_round_dialog);
        this.mNewRoundDialog.setCancelable(true);

        this.mNewRoundDialog.show();
    }

    /**
     * On statistic button click
     */
    private void onStatisticBtnClick() {
        if (this.mStatisticDialog != null) {
            this.mStatisticDialog.dismiss();
        }

        this.mStatisticDialog = new Dialog(this);
        this.mStatisticDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.mStatisticDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        this.mStatisticDialog.setContentView(R.layout.game_play_statistic_dialog);
        this.mStatisticDialog.setCancelable(true);


        this.mStatisticDialog.show();

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(12);
        numbers.add(12);
        numbers.add(12);
        numbers.add(12);
        numbers.add(12);
        numbers.add(12);
        numbers.add(12);
        numbers.add(12);
        numbers.add(12);
        numbers.add(12);
        numbers.add(12);
        numbers.add(12);
        numbers.add(12);
        numbers.add(12);
        numbers.add(12);

        RecyclerView mStatisticRe = this.mStatisticDialog.findViewById(R.id.game_play_statistic_dialog_recycler);
        StatisticAdapter mAdapter = new StatisticAdapter(this, numbers);
        mStatisticRe.setLayoutManager(new LinearLayoutManager(this));
        mStatisticRe.setAdapter(mAdapter);


        RecyclerHelper touchHelper = new RecyclerHelper<Integer>(numbers, (RecyclerView.Adapter) mAdapter);
        touchHelper.setRecyclerItemDragEnabled(true);
        touchHelper.setRecyclerItemSwipeEnabled(true);
        touchHelper
                .setOnDragItemListener((fromPosition, toPosition) -> Log.d(AppConst.TAG_GamePlay, "onDragItemListener: callback after dragging recycler view item"))
                .setOnSwipeItemListener(() -> Log.d(AppConst.TAG_GamePlay, "onSwipeItemListener: callback after swiping recycler view item"));
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(touchHelper);
        itemTouchHelper.attachToRecyclerView(mStatisticRe);
    }
}