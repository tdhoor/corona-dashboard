package com.example.corona_dashboard.ui.continents;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.corona_dashboard.R;

public class ContinentsFragment extends Fragment {
    private static String TAG = ContinentsFragment.class.getSimpleName();
    private ContinentsViewModel continentsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        continentsViewModel = new ViewModelProvider(this).get(ContinentsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_continents, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        continentsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}