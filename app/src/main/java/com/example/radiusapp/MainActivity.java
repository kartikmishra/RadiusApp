package com.example.radiusapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.radiusapp.Model.Main;
import com.example.radiusapp.Retrofit.ApiClient;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private CircleImageView profileImageView;
    private TextView name_textView, rides_textView, free_rides_textView, credits_textView;
    private TextView location_textView;
    private RecyclerView trips_recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpViews();

        setUpData();
    }


    public void setUpViews() {
        trips_recyclerView = findViewById(R.id.trips_recyclerView);
        location_textView = findViewById(R.id.location_textView);
        name_textView = findViewById(R.id.profile_name_textView);
        rides_textView = findViewById(R.id.rides_textView);
        free_rides_textView = findViewById(R.id.free_rides_textView);
        credits_textView = findViewById(R.id.credits_rides_textView);
        profileImageView = findViewById(R.id.profile_image);
    }

    public void setUpData() {

        ApiClient.getmInstance().getApi().getData().enqueue(new Callback<Main>() {
            @Override
            public void onResponse(Call<Main> call, Response<Main> response) {
                if (response.isSuccessful()) {
                    Picasso.get().load(response.body().getData().getProfile()
                            .getMiddleName()).into(profileImageView);
                    name_textView.setText(response.body().getData().getProfile().getFirstName());

                    location_textView.setText(response.body().getData().getProfile().getCity()+", "
                            +response.body().getData().getProfile().getCountry());


                    free_rides_textView.setText(String.valueOf(response.body()
                            .getData().getStats().getFreeRides()));

                    rides_textView.setText(String.valueOf(response.body()
                            .getData().getStats().getRides()));

                    credits_textView.setText("$" + String.valueOf(response.body()
                            .getData().getStats().getCredits().getValue()));

                    TripsAdapter tripsAdapter = new TripsAdapter(getApplicationContext(),
                            response.body().getData().getTrips());

                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                            getApplicationContext(), RecyclerView.VERTICAL, false);
                    trips_recyclerView.setLayoutManager(linearLayoutManager);
                    trips_recyclerView.setHasFixedSize(true);
                    trips_recyclerView.setAdapter(tripsAdapter);
                    tripsAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<Main> call, Throwable t) {

            }
        });

    }
}
