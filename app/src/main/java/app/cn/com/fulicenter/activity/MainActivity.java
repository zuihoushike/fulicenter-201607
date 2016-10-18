package app.cn.com.fulicenter.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import app.cn.com.fulicenter.R;
import app.cn.com.fulicenter.fragment.NewGoodsFragment;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {
    RadioButton mLayoutNewGood;
    RadioButton mLayoutBoutique;
    RadioButton mLayoutCategory;
    RadioButton mLayoutCart;
    TextView mtvCartHint;
    RadioButton mLayoutPersonalCenter;

    int index;
    RadioButton [] rbs;
    Fragment[] mFragment;
    NewGoodsFragment mNewGoodsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initFragment() ;
    }

    private void initFragment() {
        mFragment=new Fragment[5];
        mNewGoodsFragment=new NewGoodsFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container,mNewGoodsFragment)
                .show(mNewGoodsFragment)
                .commit();
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
            case R.id.layout_new_good:
                index = 0;
                break;
            case R.id.layout_boutique:
                index = 1;
                break;
            case R.id.layout_category:
                index = 2;
                break;
            case R.id.layout_cart:
                index = 3;
                break;
            case R.id.layout_personal_center:
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
