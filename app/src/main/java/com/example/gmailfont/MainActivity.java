package com.example.gmailfont;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private    ArrayList<Email> emaillist = new ArrayList<>();
    private    ListView lv;
    private    EmailAdapter emailAdapter;
    private    Context context;
    private    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        imageView = findViewById(R.id.imageView2);
        imageView.setImageResource(R.drawable.smol);
        lv = findViewById(R.id.lstv);
        connectAdapter();
    }

    private void connectAdapter() {
        emaillist = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            emaillist.add(new Email(R.drawable.star, "E", "MR.Banana", "Hello " + i, "12:12PM"));
            emailAdapter = new EmailAdapter(this, R.layout.list_item, emaillist);
            lv.setAdapter(emailAdapter);
        }
    }
}