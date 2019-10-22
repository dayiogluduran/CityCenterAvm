package com.avm.citycenter.fragments_ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import com.avm.citycenter.LoginActivity;
import com.avm.citycenter.R;

import java.util.Objects;

public class ChangePasswordFragment extends Fragment {
    private EditText oldPassword, newPasswordAgain, newPassword;
    private TextView saveButton;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_change_password, container, false);
        oldPassword = root.findViewById(R.id.oldPasswordEditText);
        newPasswordAgain = root.findViewById(R.id.newPasswordAgainEditText);
        oldPassword = root.findViewById(R.id.newPasswordEditText);
        saveButton = root.findViewById(R.id.change_password_save_button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Şifre değiştirildi", Toast.LENGTH_SHORT).show();
            }
        });

        return root;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

}
