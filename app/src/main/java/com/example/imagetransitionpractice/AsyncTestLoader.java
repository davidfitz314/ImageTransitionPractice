package com.example.imagetransitionpractice;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class AsyncTestLoader extends AsyncTask<Void, Integer, Void> {

    @Override
    protected Void doInBackground(Void... voids) {
        int count = 10000;
        for (int i = 0; i<count; i++){
            publishProgress((int)(( i / (float) count) * 100));
        }
        onPostExecute(null);
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        setProgressPercent(values[0]);
    }

    public void setProgressPercent(Integer value_in){
        Log.d("PROGRESS: ", ""+value_in);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        showDialog();
    }

    protected void showDialog(){
        Log.d("PROGRESS: ", "COMPLETED");
    }
}
