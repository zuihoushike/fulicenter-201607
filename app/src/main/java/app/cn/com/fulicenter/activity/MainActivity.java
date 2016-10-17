package app.cn.com.fulicenter.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import app.cn.com.fulicenter.R;
import butterknife.ButterKnife;


public class MainActivity extends Activity {
    RadioButton mLayoutNewGood;
    RadioButton mLayoutBoutique;
    RadioButton mLayoutCategory;
    RadioButton mLayoutCart;
    TextView mtvCartHint;
    RadioButton mLayoutPersonalCenter;

    int index;
    RadioButton [] rbs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        rbs = new RadioButton[5];
        rbs[0]=mLayoutNewGood;
        rbs[1]=mLayoutBoutique;
        rbs[2]=mLayoutCategory;
        rbs[3]=mLayoutCart;
        rbs[4]=mLayoutPersonalCenter;
    }

    public void onCheckedChang(View v){
        switch (v.getId()){
            case R.id.new_good:
                index = 0;
                break;
            case R.id.boutique:
                index = 1;
                break;
            case R.id.conversation:
                index = 2;
                break;
            case R.id.cart:
                index = 3;
                break;
            case R.id.personal_center:
                index = 4;
                break;
        }
        setRadioButtonStatus();
    }

    private void setRadioButtonStatus() {
        for (int i=0;i<rbs.length;i++){
            if (i==index){
                rbs[i].setChecked(true);
            }else {
                rbs[i].setChecked(false);
            }
        }
    }
}
