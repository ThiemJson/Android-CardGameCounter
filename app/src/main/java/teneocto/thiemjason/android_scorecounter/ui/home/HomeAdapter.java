package teneocto.thiemjason.android_scorecounter.ui.home;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;

import teneocto.thiemjason.android_scorecounter.R;
import teneocto.thiemjason.android_scorecounter.models.Player;
import teneocto.thiemjason.android_scorecounter.utils.AppConst;

public class HomeAdapter extends BaseAdapter {
    Context context;
    private ArrayList<Player> players;
    HomeAdapterDelegate delegate;


    public HomeAdapter(Context context, ArrayList<Player> players) {
        this.players = players;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.players.size() + 1;
    }

    @Override
    public Object getItem(int position) {
        return this.players.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (position == this.players.size()) {
            if (convertView == null) {
                final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
                convertView = layoutInflater.inflate(R.layout.home_grid_item_add_player, null);
                return convertView;
            }
            return convertView;
        }


        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.home_grid_item, null);
        }

        TextView mPlayerName = convertView.findViewById(R.id.home_list_cell_name);
        View view = convertView.findViewById(R.id.home_list_cell_container);

        view.setOnClickListener(v -> {
            this.delegate.onItemLick(view, position);
            this.playersClicked(view, mPlayerName, this.players.get(position).getClicked());

            Boolean isClicked = this.players.get(position).getClicked();

            this.playersClicked(view, mPlayerName, !isClicked);
            this.players.get(position).setClicked(!isClicked);
        });
        mPlayerName.setText(players.get(position).getName());

        return convertView;
    }

    /**
     * Players
     */
    private void playersClicked(View view, TextView playerName, Boolean isChoose) {
        if (isChoose) {
            view.setBackgroundResource(R.drawable.color_background_home_grid_item_choose);
            playerName.setTextColor(Color.WHITE);
        } else {
            view.setBackgroundResource(R.drawable.color_background_home_grid_item_default);
            playerName.setTextColor(ContextCompat.getColor(context, R.color.white));
        }
    }

    public interface HomeAdapterDelegate {
        void onItemLick(View view, int position);
    }
}
