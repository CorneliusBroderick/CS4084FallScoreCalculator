package e.nbroder.scorecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private int mColorIdentificationScore = 0;
    private int mTotalScore = 0;
    private TextView mMessageTextView;

    private EditText mNearBallDistanceEditText;
    private EditText mFarBallDistanceEditText;
    private EditText mRobotHomeDistanceEditText;

    private TextView mNearBallDistanceTextView;
    private TextView mFarBallDistanceTextView;
    private TextView mRobotHomeDistanceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // This method is called when the app launches
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Code you add goes after the setContentView
        mMessageTextView = findViewById(R.id.message_color_points_initial);

        mNearBallDistanceEditText = findViewById(R.id.mNearBallDistanceEditText);
        mFarBallDistanceEditText = findViewById(R.id.mFarBallDistanceEditText);
        mRobotHomeDistanceEditText = findViewById(R.id.mRobotHomeDistanceEditText);

        mNearBallDistanceTextView = findViewById(R.id.mFarBallDistanceTextView);
        mFarBallDistanceTextView = findViewById(R.id.mFarBallDistanceTextView);
        mRobotHomeDistanceTextView = findViewById(R.id.mRobotHomeDistanceTextView);

        final Button resetButton = findViewById(R.id.reset_button);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mColorIdentificationScore = 0;
                updateView();
            }
        });

        int nearBallDistance;
        try {
            nearBallDistance = Integer.parseInt(mNearBallDistanceEditText.getText().toString());
        } catch (NumberFormatException e) {
            nearBallDistance = 100; //Some big number
        }

        nearBallDistance += 5;
        mNearBallDistanceTextView.setText("" + nearBallDistance);

        int farBallDistance;
        try {
            farBallDistance= Integer.parseInt(mFarBallDistanceEditText.getText().toString());
        } catch (NumberFormatException e) {
            farBallDistance = 100; //Some big number
        }
        farBallDistance += 5;
        mFarBallDistanceTextView.setText("" + farBallDistance);

        int robotHomeDistance;
        try {
            robotHomeDistance = Integer.parseInt(mRobotHomeDistanceEditText.getText().toString());
        } catch (NumberFormatException e) {
            robotHomeDistance = 100; //Some big number
        }
        robotHomeDistance += 5;
        mRobotHomeDistanceTextView.setText("" + robotHomeDistance);

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
        mTotalScore = mColorIdentificationScore;

    }
}
