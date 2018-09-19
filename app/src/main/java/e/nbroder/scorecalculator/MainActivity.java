package e.nbroder.scorecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mColorIdentificationScore = 0;
    private TextView mMessageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // This method is called when the app launches
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Code you add goes after the setContentView
        mMessageTextView = findViewById(R.id.message_textview2);

        final Button resetButton = findViewById(R.id.reset_button);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mColorIdentificationScore = 0;
                updateView();
            }
        });


        // temp area
        //mMessageTextView.setText("Niall is the coolest programmer ever!!!!!");
        //Log.d("HB", "This is a log cat log. Logs are important!");

        //  Example crash!!!
        //mMessageTextView = findViewById(0);
        //mMessageTextView.setText("This will crash!");

    }


    public void handle3fixes(View view) {
        mColorIdentificationScore = 0;
        updateView();
    }

    public void handle2fixes(View view) {
        mColorIdentificationScore = 25;
        updateView();
    }

    public void handle1fixes(View view) {
        mColorIdentificationScore = 75;
        updateView();
    }

    public void handle0fixes(View view) {
        mColorIdentificationScore = 150;
        updateView();
    }




    private void updateView() {

         mMessageTextView.setText(getString(R.string.message_color_points, mColorIdentificationScore));
         mMessageTextView.setText(getString(R.string.message_total_score, mColorIdentificationScore));
    }
}
