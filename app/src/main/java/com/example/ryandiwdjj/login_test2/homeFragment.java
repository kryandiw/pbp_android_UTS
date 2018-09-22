package com.example.ryandiwdjj.login_test2;

import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;

public class homeFragment extends Fragment {
    View myView;
    private RecyclerView recyclerView;
    private RecycleAdapter adapter;
    private List<MatKulDAO> matkulList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("Testing", "enter homefragment");
        myView = inflater.inflate(R.layout.recycleradapter,container,false);
        ((MainActivity)getActivity()).setTitleCustom("Home");

        RecyclerView recyclerView=(RecyclerView) myView.findViewById(R.id.recycler_view);

        matkulList = new ArrayList<>();
        adapter = new RecycleAdapter(matkulList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        isiMatkul();

        return myView;
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    public void isiMatkul()
    {
        MatKulDAO matkul=new MatKulDAO("Pengembangan Berbasis Platform", "Pak Eric", "Lab. Perangkat Keras");
        matkulList.add(matkul);

        matkul=new MatKulDAO("Pengembangan Aplikasi Web", "Pak Sigit", "Ruang 3327");
        matkulList.add(matkul);

        matkul=new MatKulDAO("Manajemen Projek Perangkat Lunak", "Pak Andy", "Ruang 3318");

        adapter.notifyDataSetChanged();
    }
}
