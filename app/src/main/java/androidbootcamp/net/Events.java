package androidbootcamp.net;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Events extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setBackground(null);

        TextView tv = (TextView) findViewById(R.id.hack);
        tv.setText("Hack-a-Thon");
        tv.setPaintFlags(tv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        TextView tv1 = (TextView) findViewById(R.id.jsp);
        tv1.setText("Job Shadow Program");
        tv1.setPaintFlags(tv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        TextView tv2 = (TextView) findViewById(R.id.cfam);
        tv2.setText("CFAM Mobility");
        tv2.setPaintFlags(tv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        TextView tv3 = (TextView) findViewById(R.id.cdc);
        tv3.setText("CDC Resume WorkShop");
        tv3.setPaintFlags(tv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.game:
                        startActivity(new Intent(getApplicationContext(),Games.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.jamBoard:
                        startActivity(new Intent(getApplicationContext(),BlackBoard.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.event:
                        return true;
                }
                return false;
            }
        });
    }
}