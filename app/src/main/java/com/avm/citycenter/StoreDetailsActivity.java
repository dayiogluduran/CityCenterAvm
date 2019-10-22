package com.avm.citycenter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.avm.citycenter.pojo_classes.Store;

import java.util.Objects;

public class StoreDetailsActivity extends AppCompatActivity implements View.OnClickListener {
    private Store mStore;
    private TextView storeDetails, storeFloor, storeTitle;
    private ImageView storeLogo;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_details);
        toolbar = findViewById(R.id.store_details_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.navigate_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mStore = Objects.requireNonNull(getIntent().getExtras()).getParcelable("store");

        if (mStore != null) {
            bindAndFillViews(mStore);
        }
        findViewById(R.id.store_details_call_layout).setOnClickListener(this);
        findViewById(R.id.store_details_mail_layout).setOnClickListener(this);
        findViewById(R.id.store_details_map_layout).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.store_details_call_layout:
                if (mStore.getStorePhoneNumber() != null) {
                    String phoneUri = "tel:" + mStore.getStorePhoneNumber();
                    Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse(phoneUri));
                    startActivity(callIntent);
                }
                break;
            case R.id.store_details_mail_layout:
                if (mStore.getStoreMailAddress() != null) {
                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                    emailIntent.setData(Uri.parse("mailto:"));
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{mStore.getStoreMailAddress()});
                    startActivity(emailIntent);
                }
                break;
            case R.id.store_details_map_layout:
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse(mStore.getGoogleMapsUrl()));
                startActivity(intent);
                break;
        }
    }

    private void bindAndFillViews(Store store) {
        storeTitle = findViewById(R.id.store_details_toolbar_title);
        storeDetails = findViewById(R.id.store_details_text);
        storeLogo = findViewById(R.id.store_details_logo);
        storeFloor = findViewById(R.id.store_details_floor);

        if (store.getStoreName() != null)
            storeTitle.setText(store.getStoreName());

        if (store.getStoreFloor() != null)
            storeFloor.setText(store.getStoreFloor());

        if (store.getStoreDetails() != null)
            storeDetails.setText(store.getStoreDetails());

        storeLogo.setImageResource(store.getStoreLogo());


    }
}