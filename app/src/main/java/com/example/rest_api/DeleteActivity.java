package com.example.rest_api;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class DeleteActivity extends AppCompatActivity {


    private EditText etUserId;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);


        etUserId = findViewById(R.id.etUserId);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = etUserId.getText().toString().trim();

                // Check if any of the fields are empty
                if (userId.isEmpty()) {
                    Toast.makeText(DeleteActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                RequestQueue queue = Volley.newRequestQueue(DeleteActivity.this);

                StringRequest stringRequest = new StringRequest(Request.Method.DELETE, Api_Endpoint.DELETE + userId, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(DeleteActivity.this, "Data deleted successfully", Toast.LENGTH_SHORT).show();

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(DeleteActivity.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
                queue.add(stringRequest);
            }
        });
    }
}