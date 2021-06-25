package teneocto.thiemjason.android_scorecounter.ui.players;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import teneocto.thiemjason.android_scorecounter.R;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {
    Context context;
    PlayerAdapterDelegate delegate;

    public PlayerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public PlayerAdapter.ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.player_list_item, parent, false);
        return new PlayerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull PlayerAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mDelete;

        TextView mPlayerName;

        public ViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);

            mDelete = itemView.findViewById(R.id.player_list_delete);
            mPlayerName = itemView.findViewById(R.id.player_list_name);

            mDelete.setOnClickListener(v -> delegate.onDeletePlayer(itemView, getAdapterPosition()));
        }
    }

    public interface PlayerAdapterDelegate {
        void onDeletePlayer(View view, int position);
    }
}
