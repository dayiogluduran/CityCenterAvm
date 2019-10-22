package com.avm.citycenter;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.avm.citycenter.pojo_classes.Campaign;

public class CampaignDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campaign_detail);

        Toolbar toolbar = findViewById(R.id.campaign_details_toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.navigate_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Campaign mCampaign = getIntent().getParcelableExtra("campaign");
        findAndBindViews(mCampaign);

        findViewById(R.id.campaign_details_share_button).setOnClickListener(this);
    }

    private void findAndBindViews(Campaign campaign) {
        TextView campaignTitle = findViewById(R.id.campaign_title_text);
        TextView campaignDetail = findViewById(R.id.campaign_details_text);
        TextView campaignToolbarTitle = findViewById(R.id.campaign_details_toolbar_title);
        TextView campaignDateRange = findViewById(R.id.campaign_date_range_text);
        ImageView campaignImage = findViewById(R.id.campaign_details_image);

        if (campaign.getTitle() != null)
            campaignTitle.setText(campaign.getTitle());
        if (campaign.getDateRange() != null)
            campaignDateRange.setText(campaign.getDateRange());

        campaignImage.setImageResource(campaign.getImage());

        if (campaign.getTitle() != null)
            campaignToolbarTitle.setText(campaign.getTitle());
        if (campaign.getDetails() != null)
            campaignDetail.setText(campaign.getDetails());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.campaign_details_share_button:
                Toast.makeText(getApplicationContext(), "Paylaşıldı", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
