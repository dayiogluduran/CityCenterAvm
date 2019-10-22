package com.avm.citycenter.adapter_classes;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.avm.citycenter.R;
import com.avm.citycenter.fragments_ui.stores.CategoryStoresFragment;
import com.avm.citycenter.pojo_classes.Category;

import java.util.ArrayList;

public class CategoriesRecyclerViewAdapter extends RecyclerView.Adapter<CategoriesRecyclerViewAdapter.CategoryViewHolder> {
    private ArrayList<Category> categoriesList;
    private Context context;
    private FragmentManager childFragmentManager;

    /*
    Burada CategoriesFragment'ten StoresParentFragment'in childFragmentManager'ini parametre olarak alıyor,
    böylece CategoryStoresFragment MainActivity'nin host layoutunda değil StoresParentFragment'in host layoutunda gösteriliyor.
    CategoryStoresFragment MainActivity'nin host layoutunda gösterildiği zaman geri butonu basıldığında aktif tüm
    fragmentler kapanıyor ve MainActivity'nin default fragmenti HomeParentFragment sayfasına dönüyor.
    Ancak burada yapıldığı gibi StoresParentFragment'in host layoutunda
    başlatırsak geri tuşuyla yalnızca o anda aktif olan CategoryStoresFragment kapanıyor ve tekrar CategoriesFragment sayfası görülüyor.
     */

    public CategoriesRecyclerViewAdapter(ArrayList<Category> categoriesList, Context context, FragmentManager fragmentManager) {
        this.categoriesList = categoriesList;
        this.context = context;
        this.childFragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_stores_categories, parent, false);
        return new CategoryViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = categoriesList.get(position);
        if (category.getTitle() != null)
            holder.categoryTitle.setText(category.getTitle());
        holder.categoryIcon.setImageResource(category.getIcon());
    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView categoryIcon;
        private TextView categoryTitle;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            categoryIcon = itemView.findViewById(R.id.item_stores_category_icon);
            categoryTitle = itemView.findViewById(R.id.item_stores_category_title);
        }

        @Override
        public void onClick(View v) {
            Category category = categoriesList.get(getAdapterPosition());

            Bundle args = new Bundle();
            args.putParcelable(CategoryStoresFragment.CHILD_STORES_PARAM, category);
            CategoryStoresFragment categoryStoresFragment = new CategoryStoresFragment();
            categoryStoresFragment.setArguments(args);

            childFragmentManager
                    .beginTransaction().add(R.id.child_stores_fragment_host, categoryStoresFragment)
                    .addToBackStack(null)
                    .commit();

        }
    }
}
