package androidbootcamp.net;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Community extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    private String myText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);
        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setBackground(null);

        TextView textView = findViewById(R.id.clickable);
        String text = "Community    |     Follow";
        SpannableString ss = new SpannableString(text);
        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        };
        ClickableSpan clickableSpan2 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                startActivity(new Intent(getApplicationContext(),Community.class));
            }
        };

        ss.setSpan(clickableSpan1,0,10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(clickableSpan2,19,25,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.addPost);
        if(floatingActionButton != null)
            floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder mydialog = new AlertDialog.Builder(Community.this);
                    mydialog.setTitle("Share a new memory with those you follow!");

                    final EditText editText = new EditText(Community.this);
                    editText.setInputType(InputType.TYPE_CLASS_TEXT);
                    mydialog.setView(editText);

                    mydialog.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            myText=editText.getText().toString();
                            Toast.makeText(Community.this, "Created: "+myText, Toast.LENGTH_LONG).show();
                        }
                    });
                    mydialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    mydialog.show();
                }
            });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.event:
                        startActivity(new Intent(getApplicationContext(),Events.class));
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
                    case R.id.home:
                        return true;
                    case R.id.addPost:
                }
                return false;
            }
        });
    }
}