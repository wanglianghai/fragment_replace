package com.bignerdranch.android.fragmenttext;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Administrator on 2017/5/12/012.
 */

public class FragmentTop extends Fragment {
    private Button mButtonOne;
    private Button mButtonTow;
    private Button mButtonThree;
    private CallBacks mBacks;

    public interface CallBacks{
        void upDateFragment(Fragment fragment);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mBacks = (CallBacks) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top, container, false);
        mButtonOne = (Button) view.findViewById(R.id.fragment_button_one);
        mButtonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBacks.upDateFragment(new FragmentOne());
            }
        });
        mButtonTow = (Button) view.findViewById(R.id.fragment_button_tow);
        mButtonTow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBacks.upDateFragment(new FragmentTow());
            }
        });
        mButtonThree = (Button) view.findViewById(R.id.fragment_button_three);
        mButtonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBacks.upDateFragment(new FragmentThree());
            }
        });
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mBacks = null;
    }
}
