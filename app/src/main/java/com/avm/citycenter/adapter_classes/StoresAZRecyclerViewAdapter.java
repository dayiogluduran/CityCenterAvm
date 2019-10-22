package com.avm.citycenter.adapter_classes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.avm.citycenter.R;
import com.avm.citycenter.StoreDetailsActivity;
import com.avm.citycenter.pojo_classes.Store;

import java.util.ArrayList;

public class StoresAZRecyclerViewAdapter extends RecyclerView.Adapter<StoresAZRecyclerViewAdapter.StoreAZViewHolder> {
    private ArrayList<Store> storesList;
    private Context context;

    public StoresAZRecyclerViewAdapter(ArrayList<Store> storesList, Context context) {
        this.storesList = storesList;
        this.context = context;
    }

    @NonNull
    @Override
    public StoreAZViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_stores_a_to_z, parent, false);
        return new StoreAZViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreAZViewHolder holder, int position) {
        Store store = storesList.get(position);
        if (store.getStoreName() != null)
            holder.storeName.setText(store.getStoreName());
        if (store.getStoreFloor() != null)
            holder.storeFloor.setText(store.getStoreFloor());
        holder.storeLogo.setImageResource(store.getStoreLogo());
    }

    @Override
    public int getItemCount() {
        return storesList.size();
    }

    class StoreAZViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView storeLogo;
        private TextView storeName, storeFloor;
        private LinearLayout itemLayout;

        public StoreAZViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            storeFloor = itemView.findViewById(R.id.item_stores_az_floor);
            storeLogo = itemView.findViewById(R.id.item_stores_az_logo);
            storeName = itemView.findViewById(R.id.item_stores_az_title);

        }

        @Override
        public void onClick(View v) {
            Store storeAZ = storesList.get(getAdapterPosition());
            Toast.makeText(context, storeAZ.getStoreName() + " seçildi", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, StoreDetailsActivity.class);
            intent.putExtra("store", storeAZ);
            context.startActivity(intent);
        }
    }
}
