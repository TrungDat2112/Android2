package com.example.gmailfont;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class EmailAdapter extends ArrayAdapter<Email> {

    ArrayList<Email> emailArrayList;
    Activity activityContext;
    int IDlayout;
    public EmailAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Email> objects) {
        super(context, resource, objects);
        this.activityContext = (Activity) context;
        this.IDlayout = resource;
        this.emailArrayList = objects;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = activityContext.getLayoutInflater();
            convertView = layoutInflater.inflate(IDlayout, parent, false);
            convertView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }

        Email email = emailArrayList.get(position);

        ImageView imageView = convertView.findViewById(R.id.imageView6);
        TextView tvsender = convertView.findViewById(R.id.senderName);
        TextView tvmessage = convertView.findViewById(R.id.messageSnippet);
        TextView tvtime = convertView.findViewById(R.id.textView3);
        TextView tvicon = convertView.findViewById(R.id.icon);

        imageView.setImageResource(email.getImage());
        tvsender.setText(email.getSendername());
        tvicon.setText(email.getIcon());
        tvmessage.setText(email.getMessage());
        tvtime.setText(email.getTime());

        return convertView;
    }

}
