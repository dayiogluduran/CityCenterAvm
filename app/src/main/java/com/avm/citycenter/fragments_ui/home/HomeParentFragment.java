package com.avm.citycenter.fragments_ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.avm.citycenter.R;
import com.avm.citycenter.ViewPagerAdapter;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;

public class HomeParentFragment extends Fragment {

    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ViewPagerAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageView iconSettings;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        ViewCompat.setTransitionName(root.findViewById(R.id.app_bar_layout), "Transition");
        collapsingToolbarLayout = (CollapsingToolbarLayout) root.findViewById(R.id.collapsing_toolbar);
        // collapsingToolbarLayout.setTitle("");
        collapsingToolbarLayout.setContentScrimColor(getResources().getColor(R.color.colorPrimary));
        collapsingToolbarLayout.setStatusBarScrimColor(getResources().getColor(R.color.colorPrimaryDark));
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        iconSettings = root.findViewById(R.id.fragment_home_toolbar_settings);
        iconSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingsFragment settingsFragment = new SettingsFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, settingsFragment, "setFrag")
                        .addToBackStack(null)
                        .commit();
            }
        });

        viewPager = (ViewPager) root.findViewById(R.id.main_menu_view_pager);
        tabLayout = (TabLayout) root.findViewById(R.id.main_menu_tab_layout);
        adapter = new ViewPagerAdapter(getChildFragmentManager());
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        return root;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());

        adapter.addFragment(new CampaignsFragment(), "Kampanyalar");
        adapter.addFragment(new ActivitiesFragment(), "Etkinlikler");

        viewPager.setAdapter(adapter);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

    }
}
