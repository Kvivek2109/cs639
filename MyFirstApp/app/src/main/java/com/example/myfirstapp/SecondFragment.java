package com.example.myfirstapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Locale;
import java.util.Random;

public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        // Inflate the layout for this fragment
        View fragmentSecondLayout = inflater.inflate(R.layout.fragment_second, container, false);
        // Get the count text view
        Log.i("CreateView", "onCreateView: fragment second layout created");
        return fragmentSecondLayout;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int count = SecondFragmentArgs.fromBundle(getArguments()).getMyArg();
        Log.i("CreateView", "Number passed to second fragment is " + count);
        String countText = getString(R.string.random_heading, count);
        TextView headerView = view.getRootView().findViewById(R.id.textview_header);
        headerView.setText(countText);
        Random random = new java.util.Random();
        int randomNumber = 0;
        if (count > 0) {
            randomNumber = random.nextInt(count + 1);
        }
        TextView randomView = view.getRootView().findViewById(R.id.textview_random);
        randomView.setText(String.format(Locale.US, "%d",randomNumber));
        Log.i("RandomNumber", "Random number generated is " + randomNumber);

        view.findViewById(R.id.previous_button).setOnClickListener((v)  -> {
            NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            Log.i("PreviousButton", "onClick: Previous button clicked");
        });
    }
}