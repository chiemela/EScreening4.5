package net.smallacademy.authenticatorapp.ui.validID;

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

public class ValidIDFragment extends Fragment {

    private ValidIDViewModel validIDViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        validIDViewModel =
                ViewModelProviders.of(this).get(ValidIDViewModel.class);
        View root = inflater.inflate(R.layout.fragment_valid_id, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        validIDViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}