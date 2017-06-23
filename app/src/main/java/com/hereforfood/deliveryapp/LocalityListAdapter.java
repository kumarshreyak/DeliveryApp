package com.hereforfood.deliveryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Shreyak Kumar on 22-06-2017.
 */

public class LocalityListAdapter extends BaseAdapter {

    Context context;
    List<Locality> localityList;
    private static LayoutInflater inflater = null;

    public LocalityListAdapter(Context context, List<Locality> localityList) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.localityList = localityList;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return localityList.size();
    }

    @Override
    public Object getItem(int position) {
        return localityList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null)
            view = inflater.inflate(R.layout.locality_list_item, null);
        TextView localityText = (TextView) view.findViewById(R.id.localityListItemText);
        TextView houseText = (TextView) view.findViewById(R.id.houseListItemText);
        localityText.setText("Locality " + localityList.get(position).getId());
        houseText.setText(localityList.get(position).getHousesLeft() + "/" + localityList.get(position).getLocalityHouses().size());
        return view;
    }

}
