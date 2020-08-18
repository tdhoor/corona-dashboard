package com.example.corona_dashboard.ui.countries;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.corona_dashboard.R;
import com.example.corona_dashboard.data.CountryStatistic;
import com.example.corona_dashboard.service.NetworkService;

import java.util.List;

public class CountriesFragment extends Fragment {
    private static String TAG = CountriesFragment.class.getSimpleName();
    private CountriesViewModel countriesViewModel;
    private List<CountryStatistic> countryStatistics;
    private CountriesAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        countriesViewModel = new ViewModelProvider(this).get(CountriesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_countries, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.country_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        recyclerView.setHasFixedSize(true);

        adapter = new CountriesAdapter();
        recyclerView.setAdapter(adapter);

        NetworkService.getInstance(root.getContext());

        NetworkService.getInstance().getAllCountriesStatistics(response -> adapter.addCountries(response));

        getActivity().findViewById(R.id.btn_refresh).setVisibility(View.VISIBLE);
        getActivity().findViewById(R.id.btn_refresh).setOnClickListener(click -> NetworkService.getInstance().getAllCountriesStatistics(response -> adapter.addCountries(response)));

        return root;
    }
}