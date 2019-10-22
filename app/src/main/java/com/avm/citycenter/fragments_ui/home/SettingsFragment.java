package com.avm.citycenter.fragments_ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.avm.citycenter.LoginActivity;
import com.avm.citycenter.R;

import java.util.Objects;

public class SettingsFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_settings, container, false);

        root.findViewById(R.id.frag_settings_change_password_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangePasswordFragment changePasswordFragment = new ChangePasswordFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, changePasswordFragment, "changePasswordFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        SwitchCompat notificationSwitch = root.findViewById(R.id.settings_notifications_switch);
        notificationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Toast.makeText(getContext(), "Bildirimler açıldı", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getContext(), "Bildirimler kapatıldı", Toast.LENGTH_SHORT).show();

            }
        });

        root.findViewById(R.id.settings_frag_logout_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Çıkış yapıldı", Toast.LENGTH_SHORT).show();
                Intent logout = new Intent(getActivity(), LoginActivity.class);
                logout.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                Objects.requireNonNull(getActivity()).startActivity(logout);
            }
        });
        return root;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}
