package com.example.otes06.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.otes06.R;
import com.example.otes06.models.User;


public class FinishFragment extends Fragment {
    private User user;
    private TextView txtName;
    private TextView score;

    public FinishFragment() {
        // Required empty public constructor
    }


    public FinishFragment(User user) {
        this.user = user;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_finish, container, false);

        txtName = view.findViewById(R.id.name_congra);
        score = view.findViewById(R.id.score);
//
        txtName.setText(user.getName());
        score.setText(String.valueOf(user.getScore()));

        return view;
    }
}