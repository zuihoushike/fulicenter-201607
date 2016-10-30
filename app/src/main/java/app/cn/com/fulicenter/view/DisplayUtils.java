package app.cn.com.fulicenter.view;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import app.cn.com.fulicenter.R;
import app.cn.com.fulicenter.activity.CollectsActivity;
import app.cn.com.fulicenter.utils.MFGT;

/**
 * Created by 最后时刻 on 2016/10/23.
 */

public class DisplayUtils {
    public static void initBack(final Activity activity){
        activity.findViewById(R.id.backClickArea).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                activity.finish();
                MFGT.finish(activity);
            }
        });
    }

    public static void initBackWiththTiltle(final Activity activity ,final String title){
        initBack(activity);
        ((TextView)activity.findViewById(R.id.tv_common_title)).setText(title);
    }

    public static void initBackWithTitle(CollectsAdapter mContext, String string) {

    }
}
