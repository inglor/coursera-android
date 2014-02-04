package course.labs.activitylab;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends Activity {

	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityTwo";

	// Lifecycle counters

	// TOD O:
	// Create counter variables for onCreate(), onRestart(), onStart() and
	// onResume(), called mCreate, etc.
	// You will need to increment these variables' values when their
	// corresponding lifecycle methods get called
    private int mCreate = 0;
    private int mRestart= 0;
    private int mStart = 0;
    private int mResume = 0;


	// TOD O: Create variables for each of the TextViews, called
        // mTvCreate, etc. 
    private TextView mTvCreate;
    private TextView mTvRestart;
    private TextView mTvResume;
    private TextView mTvStart;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);

		// TOD O: Assign the appropriate TextViews to the TextView variables
		// Hint: Access the TextView by calling Activity's findViewById()
		// textView1 = (TextView) findViewById(R.id.textView1);
        mTvCreate = (TextView) findViewById(R.id.create);
        mTvRestart = (TextView) findViewById(R.id.restart);
        mTvResume = (TextView) findViewById(R.id.resume);
        mTvStart = (TextView) findViewById(R.id.start);




		Button closeButton = (Button) findViewById(R.id.bClose); 
		closeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// TOD O:
				// This function closes Activity Two
				// Hint: use Context's finish() method
                finish();
			}
		});

		// Check for previously saved state
		if (savedInstanceState != null) {

			// TOD O:
			// Restore value of counters from saved state
			// Only need 4 lines of code, one for every count variable
            mCreate = savedInstanceState.getInt(CREATE_KEY);
            mRestart = savedInstanceState.getInt(RESTART_KEY);
            mResume = savedInstanceState.getInt(RESUME_KEY);
            mStart = savedInstanceState.getInt(START_KEY);


		}

		// TOD O: Emit LogCat message
        Log.i(TAG, "Executing onCreate method");


		// TOD O:
		// Update the appropriate count variable
		// Update the user interface via the displayCounts() method
        mCreate++;
        displayCounts();


	}

	// Lifecycle callback methods overrides

	@Override
	public void onStart() {
		super.onStart();

		// TOD O: Emit LogCat message
        Log.i(TAG, "Executing onStart method");

		// TOD O:
		// Update the appropriate count variable
		// Update the user interface
        mStart++;
        displayCounts();

	}

	@Override
	public void onResume() {
		super.onResume();

		// TOD O: Emit LogCat message
        Log.i(TAG, "Executing onResume method");

		// TOD O:
		// Update the appropriate count variable
		// Update the user interface
        mResume++;
        displayCounts();


	}

	@Override
	public void onPause() {
		super.onPause();

		// TOD O: Emit LogCat message
        Log.i(TAG, "Executing onPause method");


	}

	@Override
	public void onStop() {
		super.onStop();

		// TOD O: Emit LogCat message
        Log.i(TAG, "Executing onStop method");



	}

	@Override
	public void onRestart() {
		super.onRestart();

		// TOD O: Emit LogCat message
        Log.i(TAG, "Executing onRestart method");

		// TOD O:
		// Update the appropriate count variable
		// Update the user interface
        mRestart++;
        displayCounts();

	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		// TOD O: Emit LogCat message
        Log.i(TAG, "Executing onDestroy method");

	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {

		// TOD O:
		// Save counter state information with a collection of key-value pairs
		// 4 lines of code, one for every count variable
        savedInstanceState.putInt(CREATE_KEY, mCreate);
        savedInstanceState.putInt(RESTART_KEY, mRestart);
        savedInstanceState.putInt(RESUME_KEY, mResume);
        savedInstanceState.putInt(START_KEY, mStart);

	}

	// Updates the displayed counters
	public void displayCounts() {

		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);
	
	}
}
