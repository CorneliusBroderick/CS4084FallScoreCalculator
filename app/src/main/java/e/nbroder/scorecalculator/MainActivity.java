package e.nbroder.scorecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mColorIdentificationScore = 0;
    private int mWhiteBlackMissionScore = 0;
    private int mTotalScore = 0;
    private int scoreForNearBallDistance = 0;
    private int scoreForFarBallDistance = 0;
    private int scoreForRobotHomeDistance = 0;
    private TextView mMessageTextView;
    private TextView mMessageTotalScore;
    private TextView mMessageWBScore;
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
        mMessageTotalScore = findViewById(R.id.message_total_score_initial);
        mMessageWBScore = findViewById(R.id.message_white_black_points);

        mNearBallDistanceEditText = findViewById(R.id.mNearBallDistanceEditText);
        mFarBallDistanceEditText = findViewById(R.id.mFarBallDistanceEditText);
        mRobotHomeDistanceEditText = findViewById(R.id.mRobotHomeDistanceEditText);

        mNearBallDistanceTextView = findViewById(R.id.mNearBallPointsTextView);
        mFarBallDistanceTextView = findViewById(R.id.mFarBallDistanceTextView);
        mRobotHomeDistanceTextView = findViewById(R.id.mRobotHomeDistanceTextView);

        final Button updateButton = findViewById(R.id.update_button);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleFarBallDistance(v);
                handleNearBallDistance(v);
                handleRobotHomeDistance(v);
                updateView();
            }
        });

        final Button resetButton = findViewById(R.id.reset_button);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mColorIdentificationScore = 0;
                mWhiteBlackMissionScore = 0;
                scoreForFarBallDistance = 0;
                scoreForNearBallDistance = 0;
                scoreForRobotHomeDistance = 0;
                mFarBallDistanceTextView.setText("" + scoreForFarBallDistance);
                mNearBallDistanceTextView.setText("" + scoreForNearBallDistance);
                mRobotHomeDistanceTextView.setText("" + scoreForRobotHomeDistance);
                mFarBallDistanceEditText.setText("");
                mNearBallDistanceEditText.setText("");
                mRobotHomeDistanceEditText.setText("");

                updateView();
            }
        });

        final Button WBSuccess = findViewById(R.id.button_wb_success);
        WBSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWhiteBlackMissionScore = 60;
                updateView();
            }
        });

        final Button WBFailure = findViewById(R.id.button_wb_failure);
        WBFailure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWhiteBlackMissionScore = 0;
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

    public void handleNearBallDistance(View view) {
        int nearBallDistance;


        try
        {
            nearBallDistance = Integer.parseInt(mNearBallDistanceEditText.getText().toString());
        }
        catch (NumberFormatException e)
        {
            nearBallDistance = 100; //Some big number
        }
        // test code
        //nearBallDistance += 5;
        //mNearBallDistanceTextView.setText("" + nearBallDistance);

        if (nearBallDistance > 45) {
            scoreForNearBallDistance = 0;
        }
        else if (nearBallDistance <=5){
            scoreForNearBallDistance = 110;
        }
        else if (nearBallDistance <=10){
            scoreForNearBallDistance = 100;
        }
        else if (nearBallDistance <=20){
            scoreForNearBallDistance = 80;
        }
        else if (nearBallDistance <=30){
            scoreForNearBallDistance = 50;
        }
        else if (nearBallDistance <=45){
            scoreForNearBallDistance = 10;
        }


        mNearBallDistanceTextView.setText("" + scoreForNearBallDistance);


    }

    public void handleFarBallDistance(View view) {
        int farBallDistance;
        try {
            farBallDistance = Integer.parseInt(mFarBallDistanceEditText.getText().toString());
        } catch (NumberFormatException e)
        {
            farBallDistance = 200; //Some big number
        }
        // test code
        //farBallDistance += 5;
        //mFarBallDistanceTextView.setText("" + farBallDistance);



        if (farBallDistance > 45) {
            scoreForFarBallDistance = 0;
        }
        else if (farBallDistance <=5){
            scoreForFarBallDistance = 220;
        }
        else if (farBallDistance <=10){
            scoreForFarBallDistance = 200;
        }
        else if (farBallDistance <=20){
            scoreForFarBallDistance = 160;
        }
        else if (farBallDistance <=30){
            scoreForFarBallDistance = 100;
        }
        else if (farBallDistance <=45){
            scoreForFarBallDistance = 20;
        }


        mFarBallDistanceTextView.setText("" + scoreForFarBallDistance);
    }

    public void handleRobotHomeDistance(View view) {
        int robotHomeDistance;
        try {
            robotHomeDistance = Integer.parseInt(mRobotHomeDistanceEditText.getText().toString());
        } catch (NumberFormatException e)
        {
            robotHomeDistance = 300; //Some big number
        }

        //test code
        //robotHomeDistance += 5;
        //mRobotHomeDistanceTextView.setText("" + robotHomeDistance);

        if (robotHomeDistance > 45) {
            scoreForRobotHomeDistance = 0;
        }
        else if (robotHomeDistance <=5){
            scoreForRobotHomeDistance = 110;
        }
        else if (robotHomeDistance <=10){
            scoreForRobotHomeDistance = 100;
        }
        else if (robotHomeDistance <=20){
            scoreForRobotHomeDistance = 80;
        }
        else if (robotHomeDistance <=30){
            scoreForRobotHomeDistance = 50;
        }
        else if (robotHomeDistance <=45){
            scoreForRobotHomeDistance = 10;
        }


        mRobotHomeDistanceTextView.setText("" + scoreForRobotHomeDistance);
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
        mMessageWBScore.setText(getString(R.string.message_white_black_points,mWhiteBlackMissionScore));
        mTotalScore = mColorIdentificationScore + mWhiteBlackMissionScore + scoreForRobotHomeDistance + scoreForNearBallDistance + scoreForFarBallDistance;
        mMessageTotalScore.setText(getString(R.string.message_total_score, mTotalScore));
    }
}
