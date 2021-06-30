package teneocto.thiemjason.android_scorecounter.ui.gamelist;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.util.ArrayList;

import teneocto.thiemjason.android_scorecounter.R;

public class GameListAdapter extends RecyclerView.Adapter<GameListAdapter.ViewHolder> {
    Context context;
    GameListAdapterDelegate delegate;

    public GameListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.game_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull GameListAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mGameName;
        TextView mCreatedDate;
        ImageView mDeleteGame;
        ImageView mViewGame;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            mGameName = itemView.findViewById(R.id.game_list_name);
            mCreatedDate = itemView.findViewById(R.id.game_list_date);
            mDeleteGame = itemView.findViewById(R.id.game_list_delete);
            mViewGame = itemView.findViewById(R.id.game_list_view);

            mDeleteGame.setOnClickListener(v -> delegate.deleteGame(itemView, getAdapterPosition()));
            mViewGame.setOnClickListener(v -> delegate.viewGame(itemView, getAdapterPosition()));
        }
    }

    public interface GameListAdapterDelegate {
        void deleteGame(View view, int position);

        void viewGame(View view, int position);
    }
}
