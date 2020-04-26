package cn.edu.sdwu.android02.home.sn170507180215.myapplication7;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MusicActivity extends AppCompatActivity {
    private ServiceConnection serviceConnection;
    private boolean bound;
    private MediaService mediaService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_music);
        bound=false;
        serviceConnection=new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                bound=true;
                MediaService.MyBinder myBinder=(MediaService.MyBinder)iBinder;
                mediaService=myBinder.getMediaService();
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                bound=false;
            }
        };
    }
    public void music_start(View view){
        startServiceClick(view);
    }
    public void music_pause(View view){
        startServiceClick(view);
    }
    public void music_stop(View view){
        startServiceClick(view);
    }
    public void music_stopservice(View view){
        startServiceClick(view);
    }
    public void startServiceClick(View view){
        //使用本方法 统一处理用户的点击 (启动方式的按键)
        int id=view.getId();
        Intent intent=new Intent(this,MediaService.class);
        switch (id){
            case R.id.music_start:
                intent.putExtra("PlayerState","START");
                break;
            case R.id.music_pause:
                intent.putExtra("PlayerState","PAUSE");
                break;
            case R.id.music_stop:
                intent.putExtra("PlayerState","STOP");
                break;
            case R.id.music_stopservice:
                intent.putExtra("PlayerState","STOPSERVICE");
                break;
        }
        startService(intent);
    }

    public void bindClick(View view){
        int id=view.getId();
        switch (id){
            case R.id.music_bind:
                Intent intent=new Intent(this,MediaService.class);
                bindService(intent,serviceConnection,BIND_AUTO_CREATE);
                break;
            case R.id.music_unbind:
                unbindService(serviceConnection);
                bound=false;
                break;
            case R.id.music_bindstart:
                if(bound){
                    mediaService.start();
                }
                break;
            case R.id.music_bindpause:
                if(bound){
                    mediaService.pause();
                }
                break;
            case R.id.music_bindstop:
                if(bound){
                    mediaService.stop();
                }
                break;
        }
    }

}
