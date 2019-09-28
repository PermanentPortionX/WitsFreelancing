package com.wits.project.witsfreelancing;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(AndroidJUnit4.class)
public class JobManagerTest {

    @Test
    public void postJob_jobNotPosted_postJobPass() {
        try {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JobManager.postJob(anyInt(), anyString(), anyString(), anyInt(), anyInt(), anyString(), anyString(), anyString());
                }
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Test
    public void viewAllJobs_jobsNotRetrieved_viewAllJobsPass() {
        try{
            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                }
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Test
    public void assignJob() {
    }

    @Test
    public void pay() {
    }

    @Test
    public void jobComplete() {
    }

    @Test
    public void viewMyJobs() {
    }

    @Test
    public void viewOfferedJobs() {
    }
}