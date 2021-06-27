package teneocto.thiemjason.android_scorecounter.ui.gameplay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import teneocto.thiemjason.android_scorecounter.R;

public class GamePlayRowAdapter extends RecyclerView.Adapter<GamePlayRowAdapter.ViewHolder> {
    Context context;

    public GamePlayRowAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public GamePlayRowAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.game_play_row_cell, parent, false);
        return new GamePlayRowAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull GamePlayRowAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 12;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
        }
    }
}
