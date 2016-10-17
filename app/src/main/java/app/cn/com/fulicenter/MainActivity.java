package app.cn.com.fulicenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import app.cn.com.fulicenter.utils.L;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        L.i("MainActivity onCreate");
    }
}
