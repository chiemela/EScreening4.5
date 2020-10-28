package net.smallacademy.authenticatorapp.ui.birthcertificate;

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


public class BirthCertificateFragment extends Fragment {

    private BirthCertificateViewModel birthCertificateViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        birthCertificateViewModel =
                ViewModelProviders.of(this).get(BirthCertificateViewModel.class);
        View root = inflater.inflate(R.layout.fragment_birth_certificate, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        birthCertificateViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}