package com.example.corona_dashboard.ui.countries;

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
import com.example.corona_dashboard.ui.continents.ContinentsFragment;
import com.example.corona_dashboard.ui.continents.ContinentsViewModel;

public class CountriesFragment extends Fragment {
    private static String TAG = CountriesFragment.class.getSimpleName();
    private CountriesViewModel countriesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        countriesViewModel = new ViewModelProvider(this).get(CountriesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_countries, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        countriesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}