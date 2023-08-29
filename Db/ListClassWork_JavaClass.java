package com.example.database_work2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class role_adapter extends BaseAdapter {
    Context applicationContext;
    ArrayList<role_gs> arr;
    LayoutInflater l;
    public role_adapter(Context applicationContext, ArrayList<role_gs> arr) {
        this.applicationContext=applicationContext;
        this.arr=arr;
        l= LayoutInflater.from(applicationContext);
    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = l.inflate(R.layout.res_layout,null);
        TextView t = view.findViewById(R.id.textView2);
        role_gs st = arr.get(i);
        t.setText(st.getName());
        return view;
    }
}
