package cn.edu.sdwu.android02.home.sn170507180215.myapplication7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_homework);
    }
    public void homeworkOne(View view){
        //界面跳转
        Intent intent=new Intent(this,MusicActivity.class);
        startActivity(intent);
    }
}
