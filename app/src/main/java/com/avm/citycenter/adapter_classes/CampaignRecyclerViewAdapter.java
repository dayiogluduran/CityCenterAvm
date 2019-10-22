package com.avm.citycenter.adapter_classes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.avm.citycenter.CampaignDetailsActivity;
import com.avm.citycenter.GlobalVariables;
import com.avm.citycenter.R;
import com.avm.citycenter.pojo_classes.Campaign;

import java.util.ArrayList;

public class CampaignRecyclerViewAdapter extends RecyclerView.Adapter<CampaignRecyclerViewAdapter.CampaignViewHolder> {
    private ArrayList<Campaign> campaignsList;
    private Context context;

    public CampaignRecyclerViewAdapter(ArrayList<Campaign> campaignsList, Context context) {
        this.campaignsList = campaignsList;
        this.context = context;
    }

    @NonNull
    @Override
    public CampaignViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_campaign_activity, parent, false);
        return new CampaignViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull CampaignViewHolder holder, int position) {
        Campaign campaign = campaignsList.get(position);
        if (campaign.getTitle() != null)
            holder.campaignTitle.setText(campaign.getTitle());
        if (campaign.getSlogan() != null)
            holder.campaignSlogan.setText(campaign.getSlogan());
        if (campaign.getDateRange() != null)
            holder.campaignDate.setText(campaign.getDateRange());
        if (campaign.isLiked())
            holder.favourite.setImageResource(R.drawable.ic_favourite_selected);
        else
            holder.favourite.setImageResource(R.drawable.ic_favourite_unselected);
        holder.campaignImage.setImageResource(campaign.getImage());

    }

    @Override
    public int getItemCount() {
        return campaignsList.size();
    }


    class CampaignViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView campaignTitle, campaignSlogan, campaignDate;
        private ImageView campaignImage, favourite;

        CampaignViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            campaignTitle = itemView.findViewById(R.id.item_campaign_title);
            campaignSlogan = itemView.findViewById(R.id.item_campaign_slogan);
            campaignDate = itemView.findViewById(R.id.item_campaign_date);
            campaignImage = itemView.findViewById(R.id.item_campaign_image);
            favourite = itemView.findViewById(R.id.item_campaign_favourite_icon);

            favourite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Campaign campaign = campaignsList.get(getAdapterPosition());
                    if (campaign.isLiked()) {
                        campaignsList.get(getAdapterPosition()).setLiked(false);
                        ((GlobalVariables) context.getApplicationContext()).getFavouriteCampaignsList().remove(campaign);
                        notifyItemChanged(getAdapterPosition());

                    } else {
                        campaignsList.get(getAdapterPosition()).setLiked(true);
                        ((GlobalVariables) context.getApplicationContext()).getFavouriteCampaignsList().add(campaign);
                        notifyItemChanged(getAdapterPosition());
                    }

                }
            });

        }

        @Override
        public void onClick(View v) {
            Campaign campaign = campaignsList.get(getAdapterPosition());
            Toast.makeText(context, campaign.getTitle() + " seçildi", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(context, CampaignDetailsActivity.class);
            intent.putExtra("campaign", campaign);
            context.startActivity(intent);
        }
    }
}
