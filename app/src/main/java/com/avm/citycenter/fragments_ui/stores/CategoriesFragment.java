package com.avm.citycenter.fragments_ui.stores;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.avm.citycenter.R;
import com.avm.citycenter.adapter_classes.CategoriesRecyclerViewAdapter;
import com.avm.citycenter.pojo_classes.Category;
import com.avm.citycenter.pojo_classes.Store;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriesFragment extends Fragment {

    public CategoriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_categories, container, false);

        RecyclerView categoriesRecyclerView = view.findViewById(R.id.stores_categories_recycler_view);
        CategoriesRecyclerViewAdapter adapter = null;
        if (getParentFragment() != null) {
            adapter = new CategoriesRecyclerViewAdapter(createSampleCategoriesList(), getContext(),getParentFragment().getChildFragmentManager());
        }
        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        categoriesRecyclerView.setLayoutManager(verticalLayoutManager);
        categoriesRecyclerView.addItemDecoration(new DividerItemDecoration(categoriesRecyclerView.getContext(), DividerItemDecoration.VERTICAL));

        categoriesRecyclerView.setAdapter(adapter);

        return view;
    }

    private ArrayList<Category> createSampleCategoriesList() {
        ArrayList<Category> categoriesList = new ArrayList<>();
        ArrayList<Store> storesList = new ArrayList<>();
        storesList.add(new Store("Mavi", "Kat 5", R.drawable.example_logo_mavi,
                "0 212 703 59 00", "info@mavi.com", "https://goo.gl/maps/F7KzteUq7qySW45c7",
                getString(R.string.detail_mavi)));
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

        categoriesList.add(new Category("Aksesuarlar", R.drawable.ic_aksesuarlar, storesList));
        categoriesList.add(new Category("Giyim", R.drawable.ic_giyim, storesList));
        categoriesList.add(new Category("Kozmetik", R.drawable.ic_kozmetik, storesList));
        categoriesList.add(new Category("Elektronik", R.drawable.ic_elektronik, storesList));
        categoriesList.add(new Category("Yiyecek ve İçecek", R.drawable.ic_yiyecek_icecek, storesList));
        categoriesList.add(new Category("Ev Dekorasyon", R.drawable.ic_ev_dekorasyon, storesList));
        categoriesList.add(new Category("Eğlence", R.drawable.ic_eglence, storesList));
        categoriesList.add(new Category("Çocuk", R.drawable.ic_cocuk_kategorisi, storesList));
        categoriesList.add(new Category("Aksesuarlar", R.drawable.ic_aksesuarlar, storesList));
        categoriesList.add(new Category("Giyim", R.drawable.ic_giyim, storesList));
        categoriesList.add(new Category("Kozmetik", R.drawable.ic_kozmetik, storesList));
        categoriesList.add(new Category("Elektronik", R.drawable.ic_elektronik, storesList));
        categoriesList.add(new Category("Yiyecek ve İçecek", R.drawable.ic_yiyecek_icecek, storesList));
        categoriesList.add(new Category("Ev Dekorasyon", R.drawable.ic_ev_dekorasyon, storesList));
        categoriesList.add(new Category("Eğlence", R.drawable.ic_eglence, storesList));
        categoriesList.add(new Category("Çocuk", R.drawable.ic_cocuk_kategorisi, storesList));
        categoriesList.add(new Category("Aksesuarlar", R.drawable.ic_aksesuarlar, storesList));
        categoriesList.add(new Category("Giyim", R.drawable.ic_giyim, storesList));
        categoriesList.add(new Category("Kozmetik", R.drawable.ic_kozmetik, storesList));

        return categoriesList;
    }


}
