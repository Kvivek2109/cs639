package com.example.myfirstapp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;

import java.util.Locale;

public class FirstFragment extends Fragment {

    ImageView showSrcImageView;
    TextView showCountTextView;
    TextView showTitleTextView;
    private boolean img = true;
    final Handler rotationHandler = new Handler(Looper.getMainLooper());
    private float currentRotation = 0;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View fragmentFirstLayout = inflater.inflate(R.layout.fragment_first, container, false);
        // Get the count text view
        showCountTextView = fragmentFirstLayout.findViewById(R.id.textview_first);
        showTitleTextView = fragmentFirstLayout.findViewById(R.id.textView_title);
        showSrcImageView = fragmentFirstLayout.findViewById(R.id.image_view);
        Log.i("CreateView", "onCreateView: fragment first layout created");

        rotateTitleView();
        return fragmentFirstLayout;
    }

    private void rotateTitleView() {
        currentRotation += 1;
        if (currentRotation > 360) {
            currentRotation = -360;
        }
        showTitleTextView.setRotationX(currentRotation);
        rotationHandler.postDelayed(this::rotateTitleView, 100);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.random_button).setOnClickListener((v) -> {
            int currentCount = Integer.parseInt(showCountTextView.getText().toString());
            Log.i("RandomButton", "onClick: current count after clicking random button is " + currentCount);
            FirstFragmentDirections.ActionFirstFragmentToSecondFragment action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount);
            NavHostFragment.findNavController(FirstFragment.this).navigate(action);
        });

        view.findViewById(R.id.toast_button).setOnClickListener((v) -> {
            Toast myToast = Toast.makeText(getActivity(), R.string.toast_click_message, Toast.LENGTH_SHORT);
            myToast.show();
            Log.i("ToastButton", "onClick: Toast message displayed ");
        });

        view.findViewById(R.id.count_button).setOnClickListener((v) -> {
            Log.i("CountButton", "onClick: Count button clicked ");
            String countString = showCountTextView.getText().toString();
            // Convert value to a number and increment it
            int count = Integer.parseInt(countString);
            count++;
            Log.i("Count", "onCount: Count incremented to " + count);
            // Display the new value in the text view.
            showCountTextView.setText(String.format(Locale.US, "%d", count));
        });

        view.findViewById(R.id.image_button).setOnClickListener((v) -> {
            if(img) {
                showSrcImageView.setImageResource(R.drawable.ironmantwo);
                img = false;
            } else {
                showSrcImageView.setImageResource(R.drawable.ironmanone);
                img = true;
            }
            Log.i("ImageButton", "onClick: image changed with new image");
        });
    }
}