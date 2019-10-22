package com.avm.citycenter.fragments_ui.contact;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.avm.citycenter.R;

public class ContactUsFragment extends Fragment implements View.OnClickListener {
    ConstraintLayout websiteLayout, mailLayout, phoneCallLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_contact_us, container, false);
        websiteLayout = root.findViewById(R.id.contact_us_website_layout);
        mailLayout = root.findViewById(R.id.contact_us_mail_layout);
        phoneCallLayout = root.findViewById(R.id.contact_us_call_layout);
        websiteLayout.setOnClickListener(this);
        phoneCallLayout.setOnClickListener(this);
        mailLayout.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.contact_us_website_layout:
                Intent webIntent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.citycenteroutlet.com"));
                startActivity(webIntent);
                break;
            case R.id.contact_us_mail_layout:
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"info@citycenteroutlet.com"});
                startActivity(emailIntent);
                break;
            case R.id.contact_us_call_layout:
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(+90)2126992515"));
                startActivity(callIntent);
                break;
        }


    }
}
