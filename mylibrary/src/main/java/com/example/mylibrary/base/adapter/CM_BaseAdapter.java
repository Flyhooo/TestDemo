package com.example.mylibrary.base.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Flyhooo on 2016/12/15 16:12
 */
public abstract class CM_BaseAdapter<T> extends RecyclerView.Adapter<CM_BaseViewHolder> {
    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;


    public CM_BaseAdapter(Context context, int layoutId, List<T> datas) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;
    }

    @Override
    public CM_BaseViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(mLayoutId, parent,
                false);
        final CM_BaseViewHolder viewHolder = new CM_BaseViewHolder(mContext, view, parent);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClickListener(viewHolder.getAdapterPosition(), view);
                }
            }
        });

        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (onItemLongClickListener != null) {
                    onItemLongClickListener.onItemLongClickListener(viewHolder.getAdapterPosition(), view);
                    return true;
                }
                return false;
            }
        });

        return viewHolder;
    }

    public interface OnItemClickListener {
        void onItemClickListener(int position, View view);
    }

    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface setOnItemLongClickListener {
        void onItemLongClickListener(int position, View view);
    }

    setOnItemLongClickListener onItemLongClickListener;

    public void setOnItemLongClickListener(setOnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    @Override
    public void onBindViewHolder(CM_BaseViewHolder holder, int position) {
        convert(holder, mDatas.get(position), position);
    }

    public abstract void convert(CM_BaseViewHolder holder, T t, int position);

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}