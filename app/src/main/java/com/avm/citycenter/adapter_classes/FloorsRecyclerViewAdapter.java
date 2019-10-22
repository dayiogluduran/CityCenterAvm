package com.avm.citycenter.adapter_classes;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.avm.citycenter.R;
import com.avm.citycenter.fragments_ui.stores.CategoryStoresFragment;
import com.avm.citycenter.fragments_ui.stores.FloorStoresFragment;
import com.avm.citycenter.pojo_classes.Floor;

import java.util.ArrayList;

public class FloorsRecyclerViewAdapter extends RecyclerView.Adapter<FloorsRecyclerViewAdapter.FloorsViewHolder> {
    private ArrayList<Floor> floorsList;
    private Context context;
    private FragmentManager childFragmentManager;


     /*
    Burada FloorsFragment'ten StoresParentFragment'in childFragmentManager'ini parametre olarak alıyor,
    böylece ChildStoresFragment MainActivity'nin host layoutunda değil StoresParentFragment'in host layoutunda gösteriliyor.
    ChildStoresFragment MainActivity'nin host layoutunda gösterildiği zaman geri butonu basıldığında aktif tüm
    fragmentler kapanıyor ve MainActivity'nin default fragmenti HomeParentFragment sayfasına dönüyor.
    Ancak burada yapıldığı gibi StoresParentFragment'in host layoutunda
    başlatırsak geri tuşuyla yalnızca o anda aktif olan ChildStoresFragment kapanıyor ve tekrar FloorsFragment sayfası görülüyor.
     */

    public FloorsRecyclerViewAdapter(ArrayList<Floor> floorsList, Context context, FragmentManager fragmentManager) {
        this.floorsList = floorsList;
        this.context = context;
        this.childFragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public FloorsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_stores_floors, parent, false);
        return new FloorsViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull FloorsViewHolder holder, int position) {
        if (floorsList.get(position) != null)
            holder.floorText.setText(floorsList.get(position).getFloor());
    }

    @Override
    public int getItemCount() {
        return floorsList.size();
    }

    class FloorsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView floorText;

        public FloorsViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            floorText = itemView.findViewById(R.id.item_store_floor_text);

        }

        @Override
        public void onClick(View v) {

            Floor floor = floorsList.get(getAdapterPosition());

            Bundle args = new Bundle();
            args.putParcelable(FloorStoresFragment.FLOOR_STORES_PARAM, floor);
            FloorStoresFragment floorStoresFragment = new FloorStoresFragment();
            floorStoresFragment.setArguments(args);

            childFragmentManager
                    .beginTransaction().add(R.id.child_stores_fragment_host, floorStoresFragment)
                    .addToBackStack(null)
                    .commit();

        }
    }
}
