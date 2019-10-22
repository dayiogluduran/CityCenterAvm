package com.avm.citycenter.fragments_ui.stores;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.avm.citycenter.R;
import com.avm.citycenter.adapter_classes.StoresAZRecyclerViewAdapter;
import com.avm.citycenter.pojo_classes.Store;
import com.avm.citycenter.pojo_classes.Category;

import java.util.ArrayList;

public class CategoryStoresFragment extends Fragment {
    private ArrayList<Store> storesInCategory;
    public static final String CHILD_STORES_PARAM = "category";
    private Category category;

    public CategoryStoresFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            category = getArguments().getParcelable(CHILD_STORES_PARAM);
        }
        if (category != null && category.getStoresInCategory() != null) {
            storesInCategory = category.getStoresInCategory();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category_stores, container, false);

        TextView toolbarTitle = view.findViewById(R.id.category_stores_toolbar_title);
        toolbarTitle.setText(category.getTitle());
        toolbarTitle.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(category.getIcon())
                ,null,null,null);

        RecyclerView storesRecyclerView = view.findViewById(R.id.category_stores_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        storesRecyclerView.setLayoutManager(layoutManager);
        storesRecyclerView.addItemDecoration(new DividerItemDecoration(storesRecyclerView.getContext(), DividerItemDecoration.VERTICAL));

        StoresAZRecyclerViewAdapter storesAdapter = new StoresAZRecyclerViewAdapter(storesInCategory, getContext());
        storesAdapter.notifyDataSetChanged();
        storesRecyclerView.setAdapter(storesAdapter);
        return view;
    }



}
