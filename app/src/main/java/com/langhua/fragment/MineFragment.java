package com.langhua.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.langhua.activity.LoginActivity;
import com.langhua.activity.R;

public class MineFragment extends Fragment {

    private Fragment MineFragment, NoInformationFragment;
    private int mFragmentId = 0;

    // 标记两个Fragment
    public static final int FRAGMENT_NOINFORMATION = 0;
    public static final int FRAGMENT_MINE = 1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(savedInstanceState == null){

        }
        return inflater.inflate(R.layout.fragment_no_information, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button lg_bt = (Button) getActivity().findViewById(R.id.login);
        lg_bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}