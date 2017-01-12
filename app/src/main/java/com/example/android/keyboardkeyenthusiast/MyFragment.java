package com.example.android.keyboardkeyenthusiast;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFragment extends Fragment {

    private View root;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_test, parent, false);
        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        makeCall();
    }

    private void makeCall() {
        final TextView mTextView = (TextView) root.findViewById(R.id.text);

        RequestQueue queue = Volley.newRequestQueue(root.getContext());
        String url = "http://jsjrobotics.nyc/cgi-bin/1_11_2017_exam.pl";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        mTextView.setText("Response is: " + response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText("That didn't work!");
            }
        });
        queue.add(stringRequest);
    }

}