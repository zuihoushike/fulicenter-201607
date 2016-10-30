package app.cn.com.fulicenter.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import app.cn.com.fulicenter.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 最后时刻 on 2016/10/19.
 */
public class FooterViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tvFooter)
    public
    TextView mTvFooter;

    public FooterViewHolder(View view) {
        super(view);
        ButterKnife.bind(this,view);
    }
}
