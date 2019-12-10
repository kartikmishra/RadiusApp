package com.example.radiusapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.radiusapp.Model.Trip;

import java.util.List;


public class TripsAdapter extends RecyclerView.Adapter<TripsAdapter.TripsAdapterViewHolder> {


    private Context mContext;
    private List<Trip> mTripList;

    public TripsAdapter(Context mContext, List<Trip> mTripList) {
        this.mContext = mContext;
        this.mTripList = mTripList;
    }

    @NonNull
    @Override
    public TripsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.trips_recycler_view_item, parent, false);
        return new TripsAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TripsAdapterViewHolder holder, int position) {

        if (mTripList.size() > 0) {

            holder.from_textView.setText(mTripList.get(position).getFrom());
            int numberOfHours = (mTripList.get(position).getFromTime() % 86400 ) / 3600 ;
            int numberOfMinutes = ((mTripList.get(position).getFromTime() % 86400 ) % 3600 ) / 60;
            String curFromTime = String.format("%02d:%02d", numberOfHours, numberOfMinutes);
            holder.from_time_textView.setText(curFromTime);
            holder.to_textView.setText(mTripList.get(position).getTo());
            int numberOfHour = (mTripList.get(position).getToTime() % 86400 ) / 3600 ;
            int numberOfMinute = ((mTripList.get(position).getToTime() % 86400 ) % 3600 ) / 60;
            String curToTime = String.format("%02d:%02d", numberOfHour, numberOfMinute);
            holder.to_time_textView.setText(curToTime);
            holder.price_textView.setText(String.valueOf(mTripList.get(position).getCost().getValue()));
            int hours = mTripList.get(position).getTripDurationInMins() / 60;
            int minutes = mTripList.get(position).getTripDurationInMins() % 60;
            holder.travel_duration_textView.setText("Travel time: "+hours+"h " +minutes+"mins");
        }
    }




    @Override
    public int getItemCount() {
        return mTripList.size();
    }

    class TripsAdapterViewHolder extends RecyclerView.ViewHolder {

        private TextView from_textView, to_textView, from_time_textView, to_time_textView;
        private TextView travel_duration_textView, price_textView;

        public TripsAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            from_textView = itemView.findViewById(R.id.from_textView);
            to_textView = itemView.findViewById(R.id.to_textView);
            from_time_textView = itemView.findViewById(R.id.from_time_textView);
            to_time_textView = itemView.findViewById(R.id.to_time_textView);
            travel_duration_textView = itemView.findViewById(R.id.travel_duration_textView);
            price_textView = itemView.findViewById(R.id.price_textView);
        }
    }
}
