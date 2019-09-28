package com.wits.project.witsfreelancing;

import android.content.ContentValues;

import org.json.JSONException;
import org.json.JSONObject;

public class AccountManager {

    private static JSONObject userP;

    public static void logIn(String user, String pass){
        ContentValues cv = new ContentValues();
        cv.put("USERNAME", user);
        cv.put("PASSWORD", pass);

        new ServerCommunicator(cv) {
            @Override
            protected void onPostExecute(String output) {
                if (output.equals("{}")) userP = new JSONObject();
                else {
                    try {
                        userP = new JSONObject(output);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.execute("http://1627982.ms.wits.ac.za/~student/auth.php");
    }
    //public logIn_notLoggedIn_loginFails(){}
}
