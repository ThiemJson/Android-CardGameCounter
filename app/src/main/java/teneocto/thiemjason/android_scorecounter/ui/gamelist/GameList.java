package teneocto.thiemjason.android_scorecounter.ui.gamelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import teneocto.thiemjason.android_scorecounter.R;

public class GameList extends AppCompatActivity implements GameListAdapter.GameListAdapterDelegate {
    /**
     * Components
     */
    Button mBackBtn;
    RecyclerView mRecycle;
    View mEmpty;
    Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);

        viewInitial();
        recycleViewInitial();
    }

    /**
     * View initial
     */
    private void viewInitial() {
        this.mBackBtn = findViewById(R.id.game_list_back_icon);
        this.mRecycle = findViewById(R.id.game_list_recycle_view);
        this.mEmpty = findViewById(R.id.game_list_empty);

        this.mBackBtn.setOnClickListener(v -> finish());
    }

    /**
     * RecycleView Initial
     */
    private void recycleViewInitial() {
        GameListAdapter mAdapter = new GameListAdapter(this);
        this.mRecycle.setAdapter(mAdapter);
        this.mRecycle.setLayoutManager(new LinearLayoutManager(this));
        mAdapter.delegate = this;
        this.syncEmptyImage();
    }

    private void syncEmptyImage() {
        this.mEmpty.setVisibility(View.GONE);
    }

    private void delete(View view, int position) {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }

        this.mDialog = new Dialog(this);
        this.mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.mDialog.setContentView(R.layout.game_list_delete_dialog);

        Button mDelete = this.mDialog.findViewById(R.id.game_list_delete_dialog_delete);
        Button mCancel = this.mDialog.findViewById(R.id.game_list_delete_dialog_cancel);

        mCancel.setOnClickListener(v -> this.mDialog.dismiss());
        mDelete.setOnClickListener(v -> {
            // TODO
            this.mDialog.dismiss();
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
        });

        this.mDialog.show();
    }

    /**
     * Delegate
     *
     * @param view     View
     * @param position Position
     */
    @Override
    public void deleteGame(View view, int position) {
        this.delete(view, position);
    }

    @Override
    public void viewGame(View view, int position) {
        Toast.makeText(this, "Successfully ", Toast.LENGTH_SHORT).show();
    }
}