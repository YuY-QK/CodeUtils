package com.yu.codelib;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;


/**
 * Created by yu on 2020/08/12.
 *
 * 筛选按钮
 */

public class FilterCheckBox extends LinearLayout {

    private Context mContext;
    private CheckBox mCheckBox;
    private LinearLayout ll_filter_root;
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener;

    public FilterCheckBox(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public FilterCheckBox(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.content_filter_check_box, this);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.FilterCheckBox);
        String text = ta.getString(R.styleable.FilterCheckBox_text);
        final int textSelectColor = ta.getColor(R.styleable.FilterCheckBox_textSelectedColor,
                ContextCompat.getColor(context, R.color.login_blue));
        final int textUnselectColor = ta.getColor(R.styleable.FilterCheckBox_textUnSelectColor,
                ContextCompat.getColor(context, R.color.black));
        mCheckBox = findViewById(R.id.checkbox);
        mCheckBox.setText(text);
        mCheckBox.setTextColor(textUnselectColor);
        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mCheckBox.setTextColor(b ? textSelectColor : textUnselectColor);
                if (mOnCheckedChangeListener != null) {
                    mOnCheckedChangeListener.onCheckedChanged(compoundButton, b);
                }
            }
        });
        ll_filter_root = findViewById(R.id.ll_filter_root);
        ll_filter_root.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mCheckBox.setChecked(!mCheckBox.isChecked());
            }
        });
    }

    public void setText(String text) {
        if (mCheckBox != null) {
            mCheckBox.setText(text);
        }
    }

    public void setTextColor(int color) {
        if (mCheckBox != null) {
            mCheckBox.setTextColor(color);
        }
    }

    public void setChecked(boolean check) {
        if (mCheckBox != null && !(check & mCheckBox.isChecked())) {
            mCheckBox.setChecked(check);
        }
    }

    public String getText() {
        String text = "";
        if (mCheckBox != null) {
            text = mCheckBox.getText().toString();
        }
        return text;
    }

    public boolean isChecked() {
        if (mCheckBox != null) {
            return mCheckBox.isChecked();
        }
        return false;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        mOnCheckedChangeListener = onCheckedChangeListener;
    }
}
