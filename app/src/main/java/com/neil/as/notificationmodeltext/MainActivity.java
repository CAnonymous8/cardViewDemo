package com.neil.as.notificationmodeltext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,RecyclerViewItemClickListener{

    private ImageView ivOne;
    private ImageView ivTwo;
    private ImageView ivThree;

    ImageView[] imageViewsArray = new ImageView[2]; //0 : 放大 1 ：缩小
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivOne = (ImageView) findViewById(R.id.ivOne);
        ivTwo = (ImageView) findViewById(R.id.ivTwo);
        ivThree = (ImageView) findViewById(R.id.ivThree);
        recyclerView = (RecyclerView) findViewById(R.id.rv);

        ivOne.setOnClickListener(this);
        ivTwo.setOnClickListener(this);
        ivThree.setOnClickListener(this);

        imageViewsArray[0] = ivTwo;
        ivTwo.setScaleX(1.6f);
        ivTwo.setScaleY(1.6f);

        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            strings.add(i * i + "");
        }

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(getApplicationContext(),strings);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(recyclerAdapter);

        recyclerAdapter.setOnRecyclerViewItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ivOne :
                imageViewsArray[1] = imageViewsArray[0];
                imageViewsArray[0] = ivOne;
                break;
            case R.id.ivTwo :
                imageViewsArray[1] = imageViewsArray[0];
                imageViewsArray[0] = ivTwo;
                break;
            case R.id.ivThree:
                imageViewsArray[1] = imageViewsArray[0];
                imageViewsArray[0] = ivThree;
                break;
        }
        if (imageViewsArray[0] != imageViewsArray[1])
        NotificationAnimatorUtils.startAnimator(imageViewsArray[0],imageViewsArray[1]);
    }

    @Override
    public void itemClick(int position) {
//        Toast.makeText(getApplicationContext(),position+"",Toast.LENGTH_SHORT).show();

        startActivity(new Intent(getApplicationContext(),TextViewActivity.class));
    }
}
