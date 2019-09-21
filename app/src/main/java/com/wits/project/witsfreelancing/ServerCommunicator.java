package com.wits.project.witsfreelancing;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.WindowManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Objects;

@SuppressLint("StaticFieldLeak")
public abstract class ServerCommunicator extends AsyncTask<String, String, String> {

    private static final String TAG = "SERVER_COMMUNICATOR";
    private final ContentValues params;

    protected ServerCommunicator(ContentValues params) {
        this.params = params;
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            Log.d(TAG, "started");
            Log.d(TAG, "address = " + strings[0]);
            URL url = new URL(strings[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setConnectTimeout(2000);
            if (params.size() > 0) {
                Uri.Builder builder = new Uri.Builder();
                for (String s : params.keySet())
                    builder.appendQueryParameter(s, params.getAsString(s));
                String query = builder.build().getEncodedQuery();
                OutputStream os = connection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, Charset.forName("UTF-8")));
                assert query != null;
                writer.write(query);
                writer.flush();
                writer.close();
                os.close();
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String response = br.readLine();
            br.close();
            return response;
        } catch (IOException e) {
            Log.d(TAG, "Failed to connect to server.", e);
        }
        return "";
    }

    @Override
    protected abstract void onPostExecute(String output);

}
