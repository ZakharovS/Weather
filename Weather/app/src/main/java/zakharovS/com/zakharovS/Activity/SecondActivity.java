package zakharovS.com.zakharovS.Activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import zakharovS.com.zakharovS.Fragment.Fragment2;

public class SecondActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        boolean landscapeOrientation = (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE);
        boolean displayLargeSize = (getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= (Configuration.SCREENLAYOUT_SIZE_LARGE);

        if (landscapeOrientation && displayLargeSize) {
            finish();
            return;
        }

        if (savedInstanceState == null) {
            int itemPosition = getIntent().getIntExtra("itemPosition", 0);
            Fragment2 fragment2 = Fragment2.newInstance(itemPosition);
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().add(android.R.id.content, fragment2).commit();
        }
    }
}
