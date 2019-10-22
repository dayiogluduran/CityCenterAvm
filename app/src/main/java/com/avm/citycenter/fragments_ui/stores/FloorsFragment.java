package com.avm.citycenter.fragments_ui.stores;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.avm.citycenter.R;
import com.avm.citycenter.adapter_classes.FloorsRecyclerViewAdapter;
import com.avm.citycenter.pojo_classes.Floor;
import com.avm.citycenter.pojo_classes.Store;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FloorsFragment extends Fragment {

    public FloorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_floors, container, false);

        RecyclerView floorsRecyclerView = view.findViewById(R.id.stores_floors_recycler_view);
        FloorsRecyclerViewAdapter adapter = null;
        if (getParentFragment() != null) {
            adapter = new FloorsRecyclerViewAdapter(createSampleFloorList(), getContext(), getParentFragment().getChildFragmentManager());
        }
        floorsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        floorsRecyclerView.addItemDecoration(new DividerItemDecoration(floorsRecyclerView.getContext(), DividerItemDecoration.VERTICAL));
        floorsRecyclerView.setAdapter(adapter);
        return view;
    }

    private ArrayList<Floor> createSampleFloorList() {
        ArrayList<Floor> floorsList = new ArrayList<>();
        ArrayList<Store> storesList = new ArrayList<>();
        storesList.add(new Store("Burger King", "Kat 7", R.drawable.example_logo_burger,
                "02126204646", "info@burgerking.com", "https://goo.gl/maps/F7KzteUq7qySW45c7",
                getString(R.string.detail_burger_king)));
        storesList.add(new Store("Alaçatı", "Kat 1", R.drawable.example_logo_alacati,
                "0 212 620 55 55", "info@alacati.com", "https://goo.gl/maps/F7KzteUq7qySW45c7",
                getString(R.string.detail_alacati_muhallebicisi)));
        storesList.add(new Store("Flo", "Kat 5", R.drawable.example_logo_flo,
                "0 212 620 47 20", "info@flo.com", "https://goo.gl/maps/F7KzteUq7qySW45c7",
                getString(R.string.detail_flo)));
        storesList.add(new Store("Koton", "Kat 6", R.drawable.example_logo_koton,
                "0 212 620 82 50", "info@koton.com", "https://goo.gl/maps/F7KzteUq7qySW45c7",
                getString(R.string.detail_koton)));
        storesList.add(new Store("Mavi", "Kat 5", R.drawable.example_logo_mavi,
                "0 212 703 59 00", "info@mavi.com", "https://goo.gl/maps/F7KzteUq7qySW45c7",
                getString(R.string.detail_mavi)));
        storesList.add(new Store("Penti", "Kat 5", R.drawable.example_logo_penti,
                "0 212 620 95 03", "info@penti.com", "https://goo.gl/maps/F7KzteUq7qySW45c7",
                getString(R.string.detail_penti)));
        floorsList.add(new Floor("Kat 1 - Cadde Dükkan", storesList));

        floorsList.add(new Floor("Kat 1 - Cadde Dükkan", storesList));
        floorsList.add(new Floor("Kat 2 - Stantlar", storesList));
        floorsList.add(new Floor("Kat 3 - P1 Otopark Katı", storesList));
        floorsList.add(new Floor("Kat 4 - 2. Çarşı", storesList));
        floorsList.add(new Floor("Kat 5 - 1. Çarşı", storesList));
        floorsList.add(new Floor("Kat 6 - Zemin Çarşı", storesList));
        floorsList.add(new Floor("Kat 7 - Yemek Katı", storesList));
        floorsList.add(new Floor("Kat 1 - Cadde Dükkan", storesList));
        floorsList.add(new Floor("Kat 2 - Stantlar", storesList));
        floorsList.add(new Floor("Kat 3 - P1 Otopark Katı", storesList));
        floorsList.add(new Floor("Kat 4 - 2. Çarşı", storesList));
        floorsList.add(new Floor("Kat 5 - 1. Çarşı", storesList));
        floorsList.add(new Floor("Kat 6 - Zemin Çarşı", storesList));
        floorsList.add(new Floor("Kat 7 - Yemek Katı", storesList));
        floorsList.add(new Floor("Kat 1 - Cadde Dükkan", storesList));
        floorsList.add(new Floor("Kat 2 - Stantlar", storesList));
        floorsList.add(new Floor("Kat 3 - P1 Otopark Katı", storesList));
        floorsList.add(new Floor("Kat 4 - 2. Çarşı", storesList));

        return floorsList;
    }
}
