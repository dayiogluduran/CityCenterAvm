package com.avm.citycenter.fragments_ui.stores;

import android.os.Bundle;

import androidx.annotation.Nullable;
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
import com.avm.citycenter.pojo_classes.Floor;
import com.avm.citycenter.pojo_classes.Store;
import com.avm.citycenter.pojo_classes.Category;

import java.util.ArrayList;


public class FloorStoresFragment extends Fragment {
    private ArrayList<Store> storesInFloor;
    public static final String FLOOR_STORES_PARAM = "floorStores";
    private Floor floor;

    public FloorStoresFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            floor = getArguments().getParcelable(FLOOR_STORES_PARAM);
        }
        if (floor != null && floor.getStoresInFloor() != null) {
            storesInFloor = floor.getStoresInFloor();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_floor_stores, container, false);

        TextView toolbarTitle = view.findViewById(R.id.floor_stores_toolbar_title);
        toolbarTitle.setText(floor.getFloor());

        RecyclerView storesRecyclerView = view.findViewById(R.id.floor_stores_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        storesRecyclerView.setLayoutManager(layoutManager);
        storesRecyclerView.addItemDecoration(new DividerItemDecoration(storesRecyclerView.getContext(), DividerItemDecoration.VERTICAL));

        StoresAZRecyclerViewAdapter storesAdapter = new StoresAZRecyclerViewAdapter(storesInFloor, getContext());
        storesAdapter.notifyDataSetChanged();
        storesRecyclerView.setAdapter(storesAdapter);

        return view;
    }
}
