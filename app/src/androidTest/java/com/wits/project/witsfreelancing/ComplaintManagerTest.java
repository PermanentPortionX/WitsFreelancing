package com.wits.project.witsfreelancing;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class ComplaintManagerTest {

    @Test
    public void postComplaint_complaintNotPosted_ComplaintPostPass() {
        try {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                }
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}