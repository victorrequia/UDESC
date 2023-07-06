package com.example.otes06.view.fragment;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.otes06.R;
import com.example.otes06.models.Question;


public class QuestionFragment extends Fragment {

    private Question question;
    private AppCompatButton btnop1;
    private AppCompatButton btnop2;
    private AppCompatButton btnop3;
    private AppCompatButton btnop4;
    private AppCompatButton btnop5;

    private TextView txt;

    public QuestionFragment() {
        // Required empty public constructor
    }

    public QuestionFragment(Question question) {
        this.question = question;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question, container, false);
        txt = view.findViewById(R.id.txtPergunta);
        txt.setText(question.getQuestion_text());


        btnop1 = view.findViewById(R.id.btn_op1);
        btnop2 = view.findViewById(R.id.btn_op2);
        btnop3 = view.findViewById(R.id.btn_op3);
        btnop4 = view.findViewById(R.id.btn_op4);
        btnop5 = view.findViewById(R.id.btn_op5);


        btnop1.setText(question.getAnswers().get(0).getAnswer_text());
        btnop2.setText(question.getAnswers().get(1).getAnswer_text());
        btnop3.setText(question.getAnswers().get(2).getAnswer_text());
        btnop4.setText(question.getAnswers().get(3).getAnswer_text());
        btnop5.setText(question.getAnswers().get(4).getAnswer_text());

        btnop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnop1.setBackgroundResource(R.drawable.bg_btn_selected);
                btnop5.setBackgroundResource(R.drawable.bg_btn_default);
                btnop2.setBackgroundResource(R.drawable.bg_btn_default);
                btnop3.setBackgroundResource(R.drawable.bg_btn_default);
                btnop4.setBackgroundResource(R.drawable.bg_btn_default);

            }});

        btnop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnop1.setBackgroundResource(R.drawable.bg_btn_default);
                btnop5.setBackgroundResource(R.drawable.bg_btn_default);
                btnop2.setBackgroundResource(R.drawable.bg_btn_selected);
                btnop3.setBackgroundResource(R.drawable.bg_btn_default);
                btnop4.setBackgroundResource(R.drawable.bg_btn_default);

            }});

        btnop3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnop1.setBackgroundResource(R.drawable.bg_btn_default);
                btnop5.setBackgroundResource(R.drawable.bg_btn_default);
                btnop2.setBackgroundResource(R.drawable.bg_btn_default);
                btnop3.setBackgroundResource(R.drawable.bg_btn_selected);
                btnop4.setBackgroundResource(R.drawable.bg_btn_default);

            }});

        btnop4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnop1.setBackgroundResource(R.drawable.bg_btn_default);
                btnop5.setBackgroundResource(R.drawable.bg_btn_default);
                btnop2.setBackgroundResource(R.drawable.bg_btn_default);
                btnop3.setBackgroundResource(R.drawable.bg_btn_default);
                btnop4.setBackgroundResource(R.drawable.bg_btn_selected);

            }});

        btnop5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnop1.setBackgroundResource(R.drawable.bg_btn_default);
                btnop5.setBackgroundResource(R.drawable.bg_btn_selected);
                btnop2.setBackgroundResource(R.drawable.bg_btn_default);
                btnop3.setBackgroundResource(R.drawable.bg_btn_default);
                btnop4.setBackgroundResource(R.drawable.bg_btn_default);

            }});


        return  view;
    }
}