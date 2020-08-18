package com.example.corona_dashboard.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.corona_dashboard.R;

public class DashboardFragment extends Fragment {
    private static String TAG = DashboardFragment.class.getSimpleName();
    private DashboardViewModel dashboardViewModel;
    private TextView title, totalCases, totalRecovery, totalDeathCases, totalInfected,
            totalCasesOutcome, totalCasesMildConditions, totalCasesCriticalConditions, totalCasesDeathPercentage,
            totalCasesGeneralDeathRate, totalCasesLastUpdated;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        initTextViews(root);

        getActivity().findViewById(R.id.btn_refresh).setOnClickListener(click -> dashboardViewModel.update());

        return root;
    }

    private void initTextViews(View root){
        title = root.findViewById(R.id.total_cases_title);
        totalCases = root.findViewById(R.id.total_cases);
        totalRecovery = root.findViewById(R.id.total_recovery_cases);
        totalDeathCases = root.findViewById(R.id.total_deaths);
        totalInfected = root.findViewById(R.id.total_infected);
        totalCasesOutcome = root.findViewById(R.id.total_cases_with_outcome);
        totalCasesMildConditions = root.findViewById(R.id.total_cases_mild_conditions);
        totalCasesCriticalConditions = root.findViewById(R.id.total_cases_critical_conditions);
        totalCasesDeathPercentage = root.findViewById(R.id.total_death_percentage);
        totalCasesGeneralDeathRate = root.findViewById(R.id.general_death_rate);
        totalCasesLastUpdated = root.findViewById(R.id.total_last_update);

        dashboardViewModel.getTotalCasesTitle().observe(getViewLifecycleOwner(),(Observer<String>) s -> title.setText(s));
        dashboardViewModel.getTotalCases().observe(getViewLifecycleOwner(),(Observer<String>) s -> totalCases.setText(s));
        dashboardViewModel.getTotalRecovery().observe(getViewLifecycleOwner(),(Observer<String>) s -> totalRecovery.setText(s));
        dashboardViewModel.getTotalDeathCases().observe(getViewLifecycleOwner(),(Observer<String>) s -> totalDeathCases.setText(s));
        dashboardViewModel.getTotalInfected().observe(getViewLifecycleOwner(),(Observer<String>) s -> totalInfected.setText(s));
        dashboardViewModel.getTotalCasesOutcome().observe(getViewLifecycleOwner(),(Observer<String>) s -> totalCasesOutcome.setText(s));
        dashboardViewModel.getTotalCasesMildConditions().observe(getViewLifecycleOwner(),(Observer<String>) s -> totalCasesMildConditions.setText(s));
        dashboardViewModel.getTotalCasesCriticalConditions().observe(getViewLifecycleOwner(),(Observer<String>) s -> totalCasesCriticalConditions.setText(s));
        dashboardViewModel.getTotalCasesDeathPercentage().observe(getViewLifecycleOwner(),(Observer<String>) s -> totalCasesDeathPercentage.setText(s));
        dashboardViewModel.getTotalCasesGeneralDeathRate().observe(getViewLifecycleOwner(),(Observer<String>) s -> totalCasesGeneralDeathRate.setText(s));
        dashboardViewModel.getTotalCasesLastUpdate().observe(getViewLifecycleOwner(),(Observer<String>) s -> totalCasesLastUpdated.setText(s));

        dashboardViewModel.update();
    }
}