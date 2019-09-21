package com.wits.project.witsfreelancing;

import android.content.ContentValues;
import android.content.Context;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class ServerCommunicatorTest {

    @Test
    public void connectToServer(){
        try {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    new ServerCommunicator(new ContentValues()) {
                        @Override
                        protected void onPostExecute(String output) {

                        }
                    }.execute("");
                }
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}