package teneocto.thiemjason.android_scorecounter.ui.home;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import teneocto.thiemjason.android_scorecounter.R;
import teneocto.thiemjason.android_scorecounter.utils.AppConst;

public class HomeAdapter extends BaseAdapter {
    Context context;
    private ArrayList<String> names;
    HomeAdapterDelegate delegate;

    // For debugs
    Boolean isClicked;

    public HomeAdapter(Context context, ArrayList<String> names) {
        this.names = names;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.names.size() + 1;
    }

    @Override
    public Object getItem(int position) {
        return this.names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (position == this.names.size()) {
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

        this.isClicked = false;
        TextView mPlayerName = convertView.findViewById(R.id.home_list_cell_name);
        View view = convertView.findViewById(R.id.home_list_cell_container);

        view.setOnClickListener(v -> {
            this.delegate.onItemLick(view, position);
            this.playersClicked(view, mPlayerName, isClicked);

            isClicked = !isClicked;
        });
        mPlayerName.setText(names.get(position));

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
//            view.setBackgroundResource(R.drawable.color_background_home_grid_item_default);
//            playerName.setTextColor(context.getResources().getColor(R.color.blue_primary, null));
        }
    }

    public interface HomeAdapterDelegate {
        void onItemLick(View view, int position);
    }
}
