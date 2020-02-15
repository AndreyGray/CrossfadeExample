package andreyskakunenko.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    View mContentView;
    View mLoadingView;
    int mShortAnimationDuration;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContentView = findViewById(R.id.content);
        mLoadingView = findViewById(R.id.loading_spinner);

        mContentView.setVisibility(View.GONE);

        mShortAnimationDuration = getResources().getInteger(android.R.integer.config_longAnimTime);//config_shortAnimTime);
        crossfade();
    }

    private void crossfade(){

        mContentView.setAlpha(0f);
        mContentView.setVisibility(View.VISIBLE);

        mContentView.animate()
                .alpha(1f)
                .setDuration(mShortAnimationDuration)
                .setListener(null);

        mLoadingView.animate()
                .alpha(0f)
                .setDuration(mShortAnimationDuration)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        mLoadingView.setVisibility(View.GONE);
                    }
                });
    }
}
