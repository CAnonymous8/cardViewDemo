package com.neil.as.notificationmodeltext;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by As on 2017/5/20.
 */

public class TextViewActivity extends AppCompatActivity {

    String htmlString = "<html><body><h1>My First Head舒服舒服收费绝对是雷锋精神垃圾分类家里发动机辣椒粉案件的发生垃圾啊了解对方垃圾分类及拉丁服加链接发来撒大姐夫量减少了发动机是拉动房间爱上法律会计师的李开复拉萨附近速分散是个ing</h1><p><font size='73'>s计算机等法律就是浪费吉林省实际发电量就是电缆附件</font><font size='33'>s计算机等法律就是浪费吉林省实际发电量就是电缆附件</font>My first paragraph舒服舒服是的冯绍峰是的冯绍峰.</p></b";
    private TextView textView;
    private int lineCount;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_textviewactivity);
        textView = (TextView) findViewById(R.id.tv);
        textView.setText(Html.fromHtml(htmlString));

        textView.measure(0,0);
        final int height = textView.getMeasuredHeight();//获取高度

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (lineCount > 5){
                    textView.setLines(5);
                    Toast.makeText(getApplicationContext(),String.valueOf(height+"==="+ lineCount),Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setLines(lineCount);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        textView.post(new Runnable() {
            @Override
            public void run() {
                lineCount = textView.getLineCount();
                if (lineCount > 5){
                    textView.setLines(5);
                }
            }
        });
    }



}
