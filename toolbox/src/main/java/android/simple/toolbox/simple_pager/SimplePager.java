package android.simple.toolbox.simple_pager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Sikang on 2017/12/6.
 */

public abstract class SimplePager {
    protected View rootView;
    protected Context context;
    protected RecyclePagerAdapter.OnItemClickListener mOnItemClickListener;
    public int sign;
    public int position;
    public boolean isVisible = false;
    public int id;

    public void setOnItemClickListener(RecyclePagerAdapter.OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public SimplePager(Context context, int layout) {
        if (context == null)
            throw new RuntimeException("the param \"context\" can not be null!");
        this.context = context;
        this.id = layout;
        rootView = LayoutInflater.from(context).inflate(layout, null);
    }

    protected View findViewById(int id) {
        return rootView.findViewById(id);
    }

    public View view() {
        return rootView;
    }

    public void initSign(int sign) {
        this.sign = sign;
    }


    public void onRefresh() {
    }

    /**
     * 当Pager被SimplePagerAdapter创建时，会调用该方法
     */
    public abstract void onCreate(View view);

    /**
     * 当Pager被RecyclePagerAdapter创建时，会调用该方法
     */
    public abstract void onCreate(View view, Object obj);

    /**
     * 当Pager被加载时，会调用该方法
     */
    public abstract void onAttach();

    /**
     * 当Pager被remove时(即将销毁)，会调用该方法
     */
    public abstract void onDetached();

    /**
     * 当Pager可见时，会调用该方法
     */
    public abstract void onVisible();

    /**
     * 当Pager不可见时，会调用该方法
     */
    public abstract void onInvisible();

    /**
     * 用来和Activity onStart() 同步
     */
    public void onStart() {
    }

    /**
     * 用来和Activity onPause() 同步
     */
    public void onPause() {
    }

    /**
     * 用来和Activity onStop() 同步
     */
    public void onStop() {
    }


}
