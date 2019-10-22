package com.avm.citycenter.fragments_ui.stores;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.avm.citycenter.R;
import com.avm.citycenter.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class StoresParentFragment extends Fragment {

    private ViewPagerAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private TextView toolbarTitle;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_stores, container, false);

        toolbar = (androidx.appcompat.widget.Toolbar) root.findViewById(R.id.shops_fragment_toolbar);
        toolbar.inflateMenu(R.menu.stores_fragment_toolbar_menu);

        //To set searchview as match parent when expanded.
        // Before this part of code when searchview expanded there was an empty field at the left of the toolbar
        Menu menu = toolbar.getMenu();


        viewPager = (ViewPager) root.findViewById(R.id.shops_fragment_view_pager);
        tabLayout = (TabLayout) root.findViewById(R.id.shop_fragment_tab_layout);
        toolbarTitle = (TextView) root.findViewById(R.id.shop_fragment_sub_category_title);

        adapter = new ViewPagerAdapter(getChildFragmentManager());
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        toolbarTitle.setText(getContext().getString(R.string.stores_frag_tab_stores));
                        break;
                    case 1:
                        toolbarTitle.setText(getContext().getString(R.string.stores_frag_tab_categories));
                        break;
                    case 2:
                        toolbarTitle.setText(getContext().getString(R.string.stores_frag_tab_floor));
                        break;
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        // setTabItemDivider(tabLayout); To set divider between tabLayout tabs
        return root;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new StoresAZFragment(), Objects.requireNonNull(getContext()).getString(R.string.stores_frag_tab_a_to_z));
        adapter.addFragment(new CategoriesFragment(), getContext().getString(R.string.stores_frag_tab_categories));
        adapter.addFragment(new FloorsFragment(), getContext().getString(R.string.stores_frag_tab_floor));
        viewPager.setAdapter(adapter);
    }

    private void setTabItemDivider(TabLayout tabLay) {
        LinearLayout linearLayout = (LinearLayout) tabLay.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(Color.GRAY);
        drawable.setSize(1, 1);
        linearLayout.setDividerPadding(20);
        linearLayout.setDividerDrawable(drawable);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.stores_fragment_toolbar_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.stores_fragment_menu_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }
}
