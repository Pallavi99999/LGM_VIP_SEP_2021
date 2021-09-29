package com.example.covid19tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressDialog dialog;

    private static String JSON_URL = "https://data.covid19india.org/district_wise.json";

    List<Model> modelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading....");
        dialog.show();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        modelList = new ArrayList<>();

        StringRequest request = new StringRequest(JSON_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                parseJsonData(string);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getApplicationContext(), "Some error occurred!!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(MainActivity.this);
        rQueue.add(request);


    }

    void parseJsonData(String jsonString) {
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray jsonArray = jsonObject.getJSONArray("districts");

            for (int i = 0; i < jsonArray.length(); ++i) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                Model model = new Model();
                model.setDistrict(jsonObject1.getString("district"));
                model.setActive(jsonObject1.getString("active"));
                model.setRecovered(jsonObject1.getString("recovered"));
                model.setDeceased(jsonObject1.getString("deceased"));
                model.setDeltaactive(jsonObject1.getString("deltaactive"));
                model.setDeltarecovered(jsonObject1.getString("deltarecovered"));
                model.setDeltadeceased(jsonObject1.getString("deltadeceased"));

                modelList.add(model);
            }

            MyAdapter myAdapter = new MyAdapter(getApplicationContext(), modelList);
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            recyclerView.setAdapter(myAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        dialog.dismiss();
    }

}