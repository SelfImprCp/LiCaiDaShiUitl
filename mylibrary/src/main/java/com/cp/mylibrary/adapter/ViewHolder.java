package com.cp.mylibrary.adapter;

import android.content.Context;
import android.graphics.Bitmap;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cp.mylibrary.utils.LogCp;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by Jerry on 2016/6/17.
 * <p>
 * ViewHolder 的封装,
 */
public class ViewHolder extends RecyclerView.ViewHolder {


    private final SparseArray<View> mViews;
    private int mPosition;
    private View mConvertView;
    private Context mContext;


    public ViewHolder(Context context, View itemView, ViewGroup parent, int position) {
        super(itemView);
        mContext = context;
        mConvertView = itemView;
        mPosition = position;
        mViews = new SparseArray<View>();
        mConvertView.setTag(this);

    }

    //    private ViewHolder(Context context, ViewGroup parent, int layoutId,
//                       int position)
//    {
//        this.mPosition = position;
//        this.mViews = new SparseArray<View>();
//        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent,
//                false);
//        // setTag
//        mConvertView.setTag(this);
//    }
    public void updatePosition(int position) {
        mPosition = position;
    }

    /**
     * 拿到一个ViewHolder对象
     *
     * @param context
     * @param convertView
     * @param parent
     * @param layoutId
     * @param position
     * @return
     */
    public static ViewHolder get(Context context, View convertView,
                                 ViewGroup parent, int layoutId, int position) {
        if (convertView == null || convertView.getTag() == null) {
            convertView = LayoutInflater.from(context).inflate(layoutId, parent,
                    false);
            ViewHolder holder = new ViewHolder(context, convertView, parent, position);
            convertView.setTag(holder);
            return holder;
        } else {
            ViewHolder holder = (ViewHolder) convertView.getTag();


            holder.mPosition = position;
            return holder;
        }
    }

    public View getConvertView() {
        return mConvertView;
    }

    /**
     * 通过控件的Id获取对于的控件，如果没有则加入views
     *
     * @param viewId
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * 为TextView设置字符串
     *
     * @param viewId
     * @param text
     * @return
     */
    public ViewHolder setText(int viewId, String text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }


    /**
     * 为TextView设置字符串
     *
     * @param viewId
     * @param text
     * @return
     */
    public ViewHolder setHint(int viewId, String text) {
        TextView view = getView(viewId);
        view.setHint(text);
        return this;
    }


    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @param drawableId
     * @return
     */
    public ViewHolder setImageResource(int viewId, int drawableId) {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);

        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @param
     * @return
     */
    public ViewHolder setImageBitmap(int viewId, Bitmap bm) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @param
     * @return
     */
    public ViewHolder setImageByUrl(int viewId, String url) {


        ImageLoader.getInstance().displayImage(url,
                (ImageView) getView(viewId));
        //   ImageLoader.getInstance().loadImage(url,(ImageView) getView(viewId));
        return this;
    }


    /**
     *
     *
     * @param viewId
     * @param
     * @return
     */
    public ViewHolder setVisible(int viewId ) {
        View view = getView(viewId);
        view.setVisibility(View.VISIBLE);
     return this;
    }


    /**
     *
     *
     * @param viewId
     * @param
     * @return
     */
    public ViewHolder setGone(int viewId ) {

        View view = getView(viewId);
        view.setVisibility(View.GONE);
      return this;
    }




}