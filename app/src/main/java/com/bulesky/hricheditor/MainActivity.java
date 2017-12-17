package com.bulesky.hricheditor;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private HRichEditor mEditor;
    private TextView mPreview;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


    }

    private void init() {
        mEditor = findViewById(R.id.editor);
        mEditor.setEditorHeight(200);
        mEditor.setEditorFontSize(22);
        mEditor.setEditorFontColor(Color.RED);
        mEditor.setPadding(10, 10, 10, 10);
        mEditor.setBackground("https://raw.githubusercontent.com/wasabeef/art/master/chip.jpg");
        mEditor.setPlaceholder("Insert text here...");
        //mEditor.setInputEnabled(false);
        mPreview = findViewById(R.id.preview);
        mPreview = findViewById(R.id.preview);
        mEditor.setOnTextChangeListener(new HRichEditor.OnTextChangeListener() {
            @Override
            public void onTextChange(String text) {
                mPreview.setText(text);
            }
        });
        findViewById(R.id.btnInsertImg).setOnClickListener(this);
        findViewById(R.id.btnInsertAudio).setOnClickListener(this);
        findViewById(R.id.btnInsertVideo).setOnClickListener(this);
        url = "img/0.jpg";
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnInsertImg:
                mEditor.insertImage(url,"图片");
                break;
            case R.id.btnInsertAudio:
                url = "audio/find.mp3";
                mEditor.insertAudio(url);
                break;
            case R.id.btnInsertVideo:
                url = "video/beautiful.mp4";
                mEditor.insertVideo(url);
                break;
            default:
                break;
        }

    }
}
