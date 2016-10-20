package app.cn.com.fulicenter.activity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

import app.cn.com.fulicenter.R;
import app.cn.com.fulicenter.view.FlowIndicator;
import app.cn.com.fulicenter.view.SlideAutoLoopView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class BoutiqueChildActivity extends BaseActivity {

    @BindView(R.id.backClickArea)
    LinearLayout backClickArea;
    @BindView(R.id.tv_good_name_english)
    TextView tvGoodNameEnglish;
    @BindView(R.id.tv_good_name)
    TextView tvGoodName;
    @BindView(R.id.tv_good_price_shop)
    TextView tvGoodPriceShop;
    TextView tvGoodPriceCurrent;
    @BindView(R.id.salv)
    SlideAutoLoopView salv;
    @BindView(R.id.indicator)
    FlowIndicator indicator;
    @BindView(R.id.wv_good_brief)
    WebView wvGoodBrief;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_boutique_child);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {

    }

}
