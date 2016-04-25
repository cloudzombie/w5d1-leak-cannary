package saulo.com.w5d1_leak_cannary;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static Drawable sBackground;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView view = new TextView(this);
        setContentView(view);

        new SampleTask().execute();
    }

    private class SampleTask extends AsyncTask<Void, Void, Void> {

        private long mStartTime;

        @Override
        protected void onPreExecute() {
            mStartTime = System.currentTimeMillis();
        }

        @Override
        protected Void doInBackground(Void... params) {
            doBackgroundWork();
            return null;
        }

        private void doBackgroundWork() {
            long timeNow;
            do {
                timeNow = System.currentTimeMillis();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (timeNow - mStartTime < (1 * 60 * 1000));
        }
        
    }
}
