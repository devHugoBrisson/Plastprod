package com.hugobrisson.plastprod;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hugo on 21/05/2015.
 */
public class CommandAdapter extends BaseAdapter {

    private List<String> listCommand;
    private LayoutInflater layoutInflater;

    public CommandAdapter(List<String> commands, LayoutInflater inflater) {
        listCommand = commands;
        layoutInflater = inflater;

    }

    @Override
    public int getCount() {
        return listCommand.size();
    }

    @Override
    public Object getItem(int position) {
        return listCommand.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.list_item_command, null);
        TextView clientName = (TextView) convertView.findViewById(R.id.client_name);
        clientName.setText(listCommand.get(position));

        return convertView;
    }
}
