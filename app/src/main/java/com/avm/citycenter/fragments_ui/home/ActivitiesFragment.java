package com.avm.citycenter.fragments_ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.avm.citycenter.GlobalVariables;
import com.avm.citycenter.R;
import com.avm.citycenter.adapter_classes.CampaignRecyclerViewAdapter;
import com.avm.citycenter.pojo_classes.Campaign;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class ActivitiesFragment extends Fragment {

    public ActivitiesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_activities, container, false);

        RecyclerView activitiesRecyclerView = view.findViewById(R.id.activities_recycler_view);
        activitiesRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        CampaignRecyclerViewAdapter activitiesAdapter = new CampaignRecyclerViewAdapter((
                        (GlobalVariables) Objects.requireNonNull(getContext()).getApplicationContext()).getCampaignsList(), getContext());
        activitiesRecyclerView.setAdapter(activitiesAdapter);

        return view;
    }
}
