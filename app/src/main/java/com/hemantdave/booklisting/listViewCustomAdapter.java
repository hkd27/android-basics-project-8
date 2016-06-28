package com.hemantdave.booklisting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class listViewCustomAdapter extends BaseAdapter {
    private static final String TAG_TITLE = "title";
    private static final String VOLUME_INFO = "volumeInfo";
    private static final String ITEMS_OBJ = "items";
    private static final String ITEMS_AUTHORS = "authors";
    String title;
    JSONArray details = null;
    ArrayList<DetailsPOJO> detailedData = new ArrayList<>();
    String result;
    Context context;

    public listViewCustomAdapter(String result, Context context) {
        this.result = result;
        this.context = context;
        if (result != null) {
            try {
                JSONObject jsonObj = new JSONObject(result);
                details = jsonObj.getJSONArray(ITEMS_OBJ);
                for (int i = 0; i < details.length(); i++) {
                    JSONObject c = details.getJSONObject(i);
                    JSONObject deta = c.getJSONObject(VOLUME_INFO);


                    JSONArray Authors = deta.getJSONArray(ITEMS_AUTHORS);
                    title = deta.getString(TAG_TITLE);
                    detailedData.add(new DetailsPOJO(Authors.toString(), title));
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public int getCount() {
        return detailedData.size()-1;
    }

    @Override
    public Object getItem(int position) {
        return detailedData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_row, parent, false);
        }

        TextView title = (TextView) row.findViewById(R.id.TitleTV);
        TextView Authors = (TextView) row.findViewById(R.id.authorTV);

        DetailsPOJO temp = detailedData.get(position);

        title.setText("Title: " + temp.Title);
        Authors.setText("Authors: " + temp.getAuthors());


        return row;
    }
}
