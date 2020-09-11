package hustle.sims.inc.gadsleadership;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity implements Animation.AnimationListener {

    Animation mAnimation;
    ImageView splashImage;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        splashImage = findViewById(R.id.my_animation);

        mAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        mAnimation.setAnimationListener(this);

        splashImage.startAnimation(mAnimation);

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
