package com.pf.tutorial;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewCountry;
    CountryAdapter adapter;
    List<Country> countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCountry = findViewById(R.id.recyclerViewMainActivityCountry);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerViewCountry.setLayoutManager(mLayoutManager);

        countries = new ArrayList<>();
        adapter=new CountryAdapter(countries, this);
        recyclerViewCountry.setAdapter(adapter);

        setApiData();
    }

    private void setApiData(){
        ApiInterface apiService = APIClient.getClient().create(ApiInterface.class);

        Call<List<Country>> call = apiService.getCountries();
        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                if(response.isSuccessful()) {
                    countries.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                Log.e("custom_tag", t.getMessage());
            }
        });
    }

}
