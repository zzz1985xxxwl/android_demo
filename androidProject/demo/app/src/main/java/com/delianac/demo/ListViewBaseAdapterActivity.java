package com.delianac.demo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListViewBaseAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_base_adapter);
        ListView listView = (ListView) findViewById(R.id.listView);
        List<MyItem> myItems = new ArrayList();
        for (int i = 0; i < 50; i++) {
            myItems.add(i, new MyItem("test" + i));
        }
        MyBaseAdapter myBaseAdapter = new MyBaseAdapter(this, myItems);
        listView.setAdapter(myBaseAdapter);
    }

    class MyItem {
        public MyItem(String name) {
            Name = name;
        }

        public String Name;
    }

    class MyBaseAdapter extends BaseAdapter {
        private LayoutInflater layoutInflater;
        private List<MyItem> myItemList;

        public MyBaseAdapter(Context context, List<MyItem> list) {
            layoutInflater = LayoutInflater.from(context);
            myItemList = list;
        }

        @Override
        public int getCount() {
            return myItemList.size();
        }

        @Override
        public Object getItem(int position) {
            return myItemList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            MyItem item = myItemList.get(position);
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.item_base_adapter, null);
                holder = new ViewHolder();
                holder.nameTextView = (TextView) convertView.findViewById(R.id.txtName);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.nameTextView.setText(item.Name);
            return convertView;
        }

        class ViewHolder {
            public TextView nameTextView;
        }
    }
}
