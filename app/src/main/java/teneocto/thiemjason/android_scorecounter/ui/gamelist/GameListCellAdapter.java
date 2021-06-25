package teneocto.thiemjason.android_scorecounter.ui.gamelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import teneocto.thiemjason.android_scorecounter.R;

public class GameListCellAdapter extends BaseAdapter {
    private ArrayList<String> names = new ArrayList<>();

    public GameListCellAdapter(ArrayList<String> names) {
        this.names = names;
    }

    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int position) {
        return names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.game_list_grid_cell, null);
        }

        TextView mPlayerName = convertView.findViewById(R.id.game_list_cell_name);
        mPlayerName.setText(names.get(position));

        return convertView;
    }
}
