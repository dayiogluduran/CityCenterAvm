package com.avm.citycenter.adapter_classes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.avm.citycenter.CampaignDetailsActivity;
import com.avm.citycenter.GlobalVariables;
import com.avm.citycenter.R;
import com.avm.citycenter.pojo_classes.Campaign;

import java.util.ArrayList;

public class FavouritesRecyclerViewAdapter extends RecyclerView.Adapter<FavouritesRecyclerViewAdapter.FavouritesViewHolder> {
    private ArrayList<Campaign> favouritesList;
    private Context context;

    public FavouritesRecyclerViewAdapter(ArrayList<Campaign> favouritesList, Context context) {
        this.favouritesList = favouritesList;
        this.context = context;
    }

    @NonNull
    @Override
    public FavouritesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_campaign_activity, parent, false);
        return new FavouritesViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull FavouritesViewHolder holder, int position) {
        Campaign campaign = favouritesList.get(position);
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
        return favouritesList.size();
    }


    class FavouritesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView campaignTitle, campaignSlogan, campaignDate;
        private ImageView campaignImage, favourite;

        FavouritesViewHolder(@NonNull View itemView) {
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
                    Campaign favouriteCampaign = favouritesList.get(getAdapterPosition());
                    if (favouriteCampaign.isLiked()) {
                        if (favouriteCampaign.isCampaign()) {

                            //Get index of favourited campaign from GlobalVariables.campaignsList
                            int index = ((GlobalVariables) context.getApplicationContext()).getCampaignsList()
                                    .indexOf(favouritesList.get(getAdapterPosition()));

                            //Set unliked the like button of campaign of GlobalVariables.campaignsList
                            ((GlobalVariables) context.getApplicationContext()).getCampaignsList().get(index).setLiked(false);

                        } else {

                            //Get index of favourited activity from GlobalVariables.activitiesList
                            int index = ((GlobalVariables) context.getApplicationContext()).getActivitiesList()
                                    .indexOf(favouritesList.get(getAdapterPosition()));

                            //Set unliked the like button of activity of GlobalVariables.activitiesList
                            ((GlobalVariables) context.getApplicationContext()).getActivitiesList().get(index).setLiked(false);

                        }

                        //Remove from the GlobalVariables.favouriteCampaignsList
                        ((GlobalVariables) context.getApplicationContext()).getFavouriteCampaignsList().remove(favouriteCampaign);


                        notifyDataSetChanged();
                    }
                }
            });


        }

        @Override
        public void onClick(View v) {
            Campaign campaign = favouritesList.get(getAdapterPosition());
            Toast.makeText(context, campaign.getTitle() + " seçildi", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(context, CampaignDetailsActivity.class);
            intent.putExtra("campaign", campaign);
            context.startActivity(intent);
        }
    }
}
