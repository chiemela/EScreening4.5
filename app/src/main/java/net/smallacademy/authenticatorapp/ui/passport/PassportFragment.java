package net.smallacademy.authenticatorapp.ui.passport;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import net.smallacademy.authenticatorapp.R;

public class PassportFragment extends Fragment {

    private PassportViewModel passportViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        passportViewModel =
                ViewModelProviders.of(this).get(PassportViewModel.class);
        View root = inflater.inflate(R.layout.fragment_passport, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        passportViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}