package com.avm.citycenter.fragments_ui.favourites;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.avm.citycenter.GlobalVariables;
import com.avm.citycenter.R;
import com.avm.citycenter.adapter_classes.CampaignRecyclerViewAdapter;
import com.avm.citycenter.adapter_classes.FavouritesRecyclerViewAdapter;
import com.avm.citycenter.pojo_classes.Campaign;

import java.util.ArrayList;
import java.util.Objects;

public class FavouritesFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_favourites, container, false);

        RecyclerView favouriteCampaignsRecyclerView = root.findViewById(R.id.favourites_recycler_view);
        favouriteCampaignsRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        FavouritesRecyclerViewAdapter favouriteCampaignsAdapter = new FavouritesRecyclerViewAdapter(
                ((GlobalVariables) Objects.requireNonNull(getContext()).getApplicationContext()).getFavouriteCampaignsList(), getContext());

        favouriteCampaignsRecyclerView.setAdapter(favouriteCampaignsAdapter);

        return root;
    }
}
