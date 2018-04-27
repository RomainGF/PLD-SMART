package com.h4413.recyclyon.Utilities;

import android.app.Activity;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;

public class HttpClient {

    private final static String SERVER_IP = "pld-smart.azurewebsites.net";

    public interface OnResponseCallback {
        void onJSONResponse(int statusCode, JSONObject response);
    }

    public static void GET(String relativePath, String parameter, final Activity activity, final OnResponseCallback callback) {
        String url = "https://"+SERVER_IP+relativePath;
        if(parameter != null && !parameter.equals("")) {
            url += "/"+parameter;
        }
        OkHttpClient mClient = new OkHttpClient();
        Request myGetRequest = new Request.Builder()
                .url(url)
                .build();

        mClient.newCall(myGetRequest).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                final String text = response.body().string();
                final int statusCode = response.code();

                Object json = null;
                try {
                    json = new JSONTokener(text).nextValue();
                    JSONObject obj = new JSONObject();
                    if (json instanceof JSONObject) {
                        obj = new JSONObject(text);
                    }
                    else if (json instanceof JSONArray) {
                        obj.putOpt("data", new JSONArray(text));
                    }
                    final JSONObject finalObj = obj;
                    activity.runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            callback.onJSONResponse(statusCode, finalObj);
                        }
                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void POST(String relativePath, String body, final Activity activity, final OnResponseCallback callback) {
        OkHttpClient mClient = new OkHttpClient();
        CookieHandler cookieHandler = new CookieManager();
        mClient.setCookieHandler(cookieHandler);
        MediaType JSON_TYPE = MediaType.parse("application/json");
        Request myGetRequest = new Request.Builder()
                .url("https://"+SERVER_IP+relativePath)
                .addHeader("Content-Type", "application/json")
                .post(RequestBody.create(JSON_TYPE, body))
                .build();

        mClient.newCall(myGetRequest).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                final String text = response.body().string();
                final int statusCode = response.code();

                Object json = null;
                try {
                    json = new JSONTokener(text).nextValue();
                    JSONObject obj = new JSONObject();
                    if (json instanceof JSONObject) {
                        obj = new JSONObject(text);
                    }
                    else if (json instanceof JSONArray) {
                        obj.putOpt("data", new JSONArray(text));
                    }
                    final JSONObject finalObj = obj;
                    activity.runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            callback.onJSONResponse(statusCode, finalObj);
                        }
                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void PUT(String relativePath, String parameter, String body, final Activity activity, final OnResponseCallback callback) {
        String url = "https://"+SERVER_IP+relativePath;
        if(parameter != null && !parameter.equals("")) {
            url += "/"+parameter;
        }
        OkHttpClient mClient = new OkHttpClient();
        CookieHandler cookieHandler = new CookieManager();
        mClient.setCookieHandler(cookieHandler);
        MediaType JSON_TYPE = MediaType.parse("application/json");
        Request myGetRequest = new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/json")
                .put(RequestBody.create(JSON_TYPE, body))
                .build();

        mClient.newCall(myGetRequest).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                final String text = response.body().string();
                final int statusCode = response.code();

                Object json = null;
                try {
                    json = new JSONTokener(text).nextValue();
                    JSONObject obj = new JSONObject();
                    if (json instanceof JSONObject) {
                        obj = new JSONObject(text);
                    }
                    else if (json instanceof JSONArray) {
                        obj.putOpt("data", new JSONArray(text));
                    }
                    final JSONObject finalObj = obj;
                    activity.runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            callback.onJSONResponse(statusCode, finalObj);
                        }
                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void DELETE(String relativePath, String parameter, final Activity activity, final OnResponseCallback callback) {
        String url = "https://"+SERVER_IP+relativePath;
        if(parameter != null && !parameter.equals("")) {
            url += "/"+parameter;
        }
        OkHttpClient mClient = new OkHttpClient();
        CookieHandler cookieHandler = new CookieManager();
        mClient.setCookieHandler(cookieHandler);
        Request myGetRequest = new Request.Builder()
                .url(url)
                .delete()
                .build();

        mClient.newCall(myGetRequest).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                final String text = response.body().string();
                final int statusCode = response.code();

                Object json = null;
                try {
                    json = new JSONTokener(text).nextValue();
                    JSONObject obj = new JSONObject();
                    if (json instanceof JSONObject) {
                        obj = new JSONObject(text);
                    }
                    else if (json instanceof JSONArray) {
                        obj.putOpt("data", new JSONArray(text));
                    }
                    final JSONObject finalObj = obj;
                    activity.runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            callback.onJSONResponse(statusCode, finalObj);
                        }
                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}