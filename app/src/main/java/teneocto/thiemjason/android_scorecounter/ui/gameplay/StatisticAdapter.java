package teneocto.thiemjason.android_scorecounter.ui.gameplay;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import teneocto.thiemjason.android_scorecounter.R;

public class StatisticAdapter extends RecyclerView.Adapter<StatisticAdapter.ViewHolder> {
    Context context;
    ArrayList<Integer> numbers = new ArrayList<>();

    public StatisticAdapter(Context context, ArrayList<Integer> numbers) {
        this.context = context;
        this.numbers = numbers;

    }

    @NonNull
    @NotNull
    @Override
    public StatisticAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.game_play_statistic_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull StatisticAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return this.numbers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
        }
    }
}
