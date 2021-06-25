package teneocto.thiemjason.android_scorecounter.ui.players;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import teneocto.thiemjason.android_scorecounter.R;
import teneocto.thiemjason.android_scorecounter.utils.AppConst;

public class Players extends AppCompatActivity implements PlayerAdapter.PlayerAdapterDelegate {
    /**
     * Components
     */
    RecyclerView mRecycleView;
    PlayerAdapter mAdapter;
    View mEmpty;
    Button mBackBtn;
    FloatingActionButton mAddBtn;
    Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        viewInitial();
        recycleViewInitial();
    }

    /**
     * RecycleView Initial
     */
    private void recycleViewInitial() {
        this.mAdapter = new PlayerAdapter(this);
        this.mRecycleView.setAdapter(this.mAdapter);
        this.mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        this.mAdapter.delegate = this;

        this.syncEmptyImage();
    }

    /**
     * View Initial
     */
    private void viewInitial() {
        this.mBackBtn = findViewById(R.id.player_list_back_icon);
        this.mEmpty = findViewById(R.id.player_list_empty);
        this.mRecycleView = findViewById(R.id.player_list_recycle_view);
        this.mAddBtn = findViewById(R.id.player_list_add);

        this.mAddBtn.setOnClickListener(v -> addPlayer());
    }

    private void syncEmptyImage() {
        this.mEmpty.setVisibility(View.GONE);
    }

    /**
     * Add players
     */
    private void addPlayer() {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }

        this.mDialog = new Dialog(this);
        this.mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.mDialog.setContentView(R.layout.player_list_add_dialog);

        EditText mPlayerName = this.mDialog.findViewById(R.id.player_list_add_dialog_player_name);
        Button mAddBtn = this.mDialog.findViewById(R.id.player_list_add_dialog_add);
        Button mCancel = this.mDialog.findViewById(R.id.player_list_add_dialog_cancel);

        mCancel.setOnClickListener(v -> mDialog.dismiss());

        mAddBtn.setOnClickListener(v -> {
            if (mPlayerName.getText().toString().trim().equals("") || mPlayerName.getText() == null) {
                Toast.makeText(this, "Please input valid player name", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "Successfully !", Toast.LENGTH_SHORT).show();
            mDialog.dismiss();
        });

        this.mDialog.show();
    }

    /**
     * Delete players
     */
    private void deletePlayer(View view, int position) {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }

        this.mDialog = new Dialog(this);
        this.mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.mDialog.setContentView(R.layout.player_list_delete_dialog);

        Button mDelete = this.mDialog.findViewById(R.id.player_list_delete_dialog_delete);
        Button mCancel = this.mDialog.findViewById(R.id.player_list_delete_dialog_cancel);

        mCancel.setOnClickListener(v -> this.mDialog.dismiss());
        mDelete.setOnClickListener(v -> {
            // Todo
            this.mDialog.dismiss();
        });

        this.mDialog.show();
    }

    /**
     * PlayerAdapter Delegate
     * @param view View
     * @param position int
     */
    @Override
    public void onDeletePlayer(View view, int position) {
        Log.i(AppConst.TAG_Players," ==> click");
        this.deletePlayer(view, position);
    }
}