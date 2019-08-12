package com.androidnetworking.assandroidnetworking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.androidnetworking.assandroidnetworking.adapter.ContentAdapter;
import com.androidnetworking.assandroidnetworking.adapter.OnClickListener;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetContentActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<String> linkList = new ArrayList<>();
    private ContentAdapter contentAdapter;
    private Intent intent;
    private String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_content);

        recyclerView = findViewById(R.id.rvPost);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        intent = getIntent();
        content = intent.getStringExtra("imageContent");

        getLink();

    }

    private void getLink() {
        Pattern pattern = Pattern.compile("/uploads(?<url>.*?)jpg.*?");
        Matcher matcher = pattern.matcher(content.trim());

        String s = "";

        while (matcher.find()) {
            int lengthm = matcher.group(1).length();
            int lengths = s.length();

            if(!matcher.group(1).substring(0, getLength(lengths, lengthm))
                    .equalsIgnoreCase(s.substring(0, getLength(lengths, lengthm)))
                    || s.length() == 0
            ){
                linkList.add("http://asian.dotplays.com/wp-content/uploads" + matcher.group(1) + "jpg");
                s = matcher.group(1);
            }else{
                s = matcher.group(1);
            }
        }

        contentAdapter = new ContentAdapter(this, linkList, new OnClickListener() {
            @Override
            public void onClickListener(int position) {
                Intent intent = new Intent(getApplicationContext(), ImageDetailActivity.class);
                intent.putExtra("imageContent", linkList.get(position));
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(contentAdapter);
    }

    int getLength(int i, int s){
        if (i > 10 && i < 14 && s > 10 && s < 14) return 9;
        else if (i < 37 && i >= 14 && s < 37 && s > 14) return 14;
        else if (i >= 37 && i < 42 && s >= 37 && s < 42)return 37;
        else if (i >= 42 && s >= 42) return 42;
        else return 0;
    }
}
