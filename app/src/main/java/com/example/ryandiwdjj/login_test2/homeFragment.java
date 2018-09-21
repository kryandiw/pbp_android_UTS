package com.example.ryandiwdjj.login_test2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class homeFragment extends Fragment {
    View myView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("Testing", "enter homefragment");
        myView = inflater.inflate(R.layout.layout_nav_home,container,false);
        ((MainActivity)getActivity()).setTitleCustom("Home");
        return myView;
    }
}
