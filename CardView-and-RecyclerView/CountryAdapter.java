package com.pf.tutorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.MyViewHolder> {

    private List<Country> countries;
    private Context context;

    public CountryAdapter(List<Country> countries, Context context) {
        this.countries = countries;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_country, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Country country = countries.get(position);
        Picasso.get().load(country.getFlag()).into(holder.imageViewFlag);
        holder.textViewName.setText(country.getName());
        holder.textViewCapital.setText(country.getCapital());
        holder.textViewCurrency.setText(country.getCurrency());

        holder.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countries.remove(country);
                notifyDataSetChanged();
                Toast.makeText(context, "Delete Function Call", Toast.LENGTH_SHORT).show();
            }
        });
        holder.buttonDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, country.getName()+" is Selected..!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewName, textViewCapital, textViewCurrency;
        public ImageView imageViewFlag;
        public Button buttonDetail, buttonDelete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewCountryCardName);
            textViewCapital = itemView.findViewById(R.id.textViewCountryCardCapital);
            textViewCurrency = itemView.findViewById(R.id.textViewCountryCardCurrency);
            imageViewFlag = itemView.findViewById(R.id.imageViewCountryCardFlag);
            buttonDetail = itemView.findViewById(R.id.buttonCountryCardDetail);
            buttonDelete = itemView.findViewById(R.id.buttonCountryCardDelete);
        }
    }
}
