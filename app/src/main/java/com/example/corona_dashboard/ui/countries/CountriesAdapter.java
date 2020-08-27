package com.example.corona_dashboard.ui.countries;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.corona_dashboard.R;
import com.example.corona_dashboard.data.CountryStatistic;
import com.example.corona_dashboard.helpers.Converter;

import java.util.ArrayList;
import java.util.List;


public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountryHolder> implements Filterable {
    private List<CountryStatistic> countryStatisticList;
    private List<CountryStatistic> countryStatisticListFull;

    CountriesAdapter(){
        countryStatisticList = new ArrayList<>();
        countryStatisticListFull = new ArrayList<>();
    }

    @NonNull
    @Override
    public CountryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_country, parent, false);
        return new CountryHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryHolder holder, int position) {
        CountryStatistic currentCountryStatistic = countryStatisticList.get(position);
        holder.countryName.setText(currentCountryStatistic.getName());
        holder.countryTodayCases.setText(Converter.formatNumberToLocal(currentCountryStatistic.getTodayCases()));
        holder.countryTodayDeaths.setText(Converter.formatNumberToLocal(currentCountryStatistic.getTodayDeaths()));
        holder.countryTodayRecovered.setText(Converter.formatNumberToLocal(currentCountryStatistic.getTodayRecovered()));
        holder.countryPopulation.setText(Converter.formatNumberToLocal(currentCountryStatistic.getPopulation()));
    }

    public void setCountries(List<CountryStatistic> countryStatistics){
        this.countryStatisticList = countryStatistics;
        this.countryStatisticListFull = new ArrayList<>(this.countryStatisticList);
        notifyDataSetChanged();
    }

    public void addCountries(CountryStatistic countryStatistic){
        this.countryStatisticList.add(countryStatistic);
        this.countryStatisticListFull.add(countryStatistic);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return countryStatisticList.size();
    }

    @Override
    public Filter getFilter() {
        return countryFiler;
    }

    private Filter countryFiler = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<CountryStatistic> filteredList = new ArrayList<>();

            if(charSequence == null || charSequence.length() == 0){
                filteredList.addAll(countryStatisticListFull);
                Log.e("Hääää","wos");
            } else {
                String filterPattern = charSequence.toString().toLowerCase().trim();
                Log.e("TEST",filterPattern);// -------------------------------------------------- REMOVEME ------------------------------------------- //
                for (CountryStatistic item : countryStatisticList) {
                    String countryName = item.getName().trim().toLowerCase();

                    if (countryName.contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            countryStatisticList.clear();
            countryStatisticList.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };

    class CountryHolder extends RecyclerView.ViewHolder{
        private TextView countryName;
        private TextView countryTodayCases;
        private TextView countryTodayDeaths;
        private TextView countryTodayRecovered;
        private TextView countryPopulation;

        public CountryHolder(@NonNull View itemView) {
            super(itemView);
            this.countryName = itemView.findViewById(R.id.country_name);
            this.countryTodayCases = itemView.findViewById(R.id.country_today_cases);
            this.countryTodayDeaths = itemView.findViewById(R.id.country_today_deaths);
            this.countryTodayRecovered = itemView.findViewById(R.id.counrty_today_recovered);
            this.countryPopulation = itemView.findViewById(R.id.country_population);
        }
    }
}
