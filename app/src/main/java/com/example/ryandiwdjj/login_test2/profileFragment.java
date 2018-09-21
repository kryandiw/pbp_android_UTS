package com.example.ryandiwdjj.login_test2;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class profileFragment extends Fragment {
    View myView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("Testing", "enter profileFragment");
        myView = inflater.inflate(R.layout.layout_nav_profile,container,false);
        ((MainActivity)getActivity()).setTitleCustom("Profile");
        return myView;
    }
}
