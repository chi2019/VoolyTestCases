package com.example.ramharshini.myapplication;


import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Utils {

        public static void makeCall(Context context,String name1, final ApiCallBack callback) {

            Map<String, String> postParam = new HashMap<>();
            postParam.put(name1, "Name");
            postParam.put("client_id1", "CID");
            postParam.put("email1", "Email");
            //postParam.put("mobile1", "Mobile");
            //postParam.put("password1", "Password");
            // postParam.put("device_id1", "123456");

            String url = "http://www.mocky.io/v2/5c19be34320000570064ad14";



            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                    url, new JSONObject(postParam),
                    new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            Log.d("sucess", response.toString());
                            try {
                                ArrayList<String> result = new ArrayList<>();
                                result.add(response.getString("str"));
                                callback.onSuccess((ArrayList<String>) result, "tag");
                            } catch (JSONException e) {
                                e.printStackTrace();
                                callback.onError(e, "tag");
                            }
                            // msgResponse.setText(response.toString());
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    callback.onError(error.getCause(),"error");
                }
            });


            RequestQueue requestQueue = Volley.newRequestQueue(context);
            requestQueue.add(jsonObjReq);

        }

    }