package com.kn.paper_foss_theme.activities;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kn.paper_foss_theme.utils.PaperImageUtils;
import com.kn.paper_foss_theme.utils.PaperScreenUtils;
import com.kn.paper_foss_theme.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createLayout();
    }

    private void createLayout() {
        LinearLayout.LayoutParams smallLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
        float scale = PaperScreenUtils.densityScale(getApplicationContext());
        ViewGroup.LayoutParams buttonParams = new ViewGroup.LayoutParams(Math.round(48 * scale), Math.round(48 * scale));

        LinearLayout frameLayout = new LinearLayout(this);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        frameLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent));
        frameLayout.setGravity(Gravity.CENTER);
        setContentView(frameLayout);

        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        baseLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
        baseLayout.setGravity(Gravity.LEFT);
        frameLayout.addView(baseLayout);

        // icons
        LinearLayout iconLayout = new LinearLayout(this);
        iconLayout.setOrientation(LinearLayout.HORIZONTAL);
        iconLayout.setLayoutParams(smallLayoutParams);
        iconLayout.setGravity(Gravity.CENTER_VERTICAL);
        baseLayout.addView(iconLayout);

        LinearLayout iconClickLayout = new LinearLayout(this);
        iconClickLayout.setOrientation(LinearLayout.HORIZONTAL);
        iconClickLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        iconClickLayout.setGravity(Gravity.CENTER);
        iconLayout.addView(iconClickLayout);
        iconClickLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iconActivity(v);
            }
        });

        Button iconButton = new Button(this);
        iconButton.setLayoutParams(buttonParams);
        iconButton.setBackground(new BitmapDrawable(getResources(), PaperImageUtils.bitmapLoad(getApplicationContext().getResources(), R.drawable.ic_icon_button, Math.round(48 * scale), Math.round(48 * scale))));
        iconClickLayout.addView(iconButton);

        TextView iconText = new TextView(this);
        iconText.setText("icons");
        iconText.setTextSize(35);
        iconText.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
        iconText.setPadding(64, 64, 64, 64);
        iconClickLayout.addView(iconText);

        // source
        LinearLayout sourceLayout = new LinearLayout(this);
        sourceLayout.setOrientation(LinearLayout.HORIZONTAL);
        sourceLayout.setLayoutParams(smallLayoutParams);
        sourceLayout.setGravity(Gravity.CENTER_VERTICAL);
        baseLayout.addView(sourceLayout);

        LinearLayout sourceClickLayout = new LinearLayout(this);
        sourceClickLayout.setOrientation(LinearLayout.HORIZONTAL);
        sourceClickLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        sourceClickLayout.setGravity(Gravity.CENTER);
        sourceLayout.addView(sourceClickLayout);
        sourceClickLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gitLink(v);
            }
        });

        Button sourceButton = new Button(this);
        sourceButton.setLayoutParams(buttonParams);
        sourceButton.setBackground(new BitmapDrawable(getResources(), PaperImageUtils.bitmapLoad(getApplicationContext().getResources(), R.drawable.ic_source_button, Math.round(48 * scale), Math.round(48 * scale))));
        sourceClickLayout.addView(sourceButton);

        TextView sourceText = new TextView(this);
        sourceText.setText("source");
        sourceText.setTextSize(35);
        sourceText.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
        sourceText.setPadding(64, 64, 64, 64);
        sourceClickLayout.addView(sourceText);

        // license button
        LinearLayout aboutLayout = new LinearLayout(this);
        aboutLayout.setOrientation(LinearLayout.HORIZONTAL);
        aboutLayout.setLayoutParams(smallLayoutParams);
        aboutLayout.setGravity(Gravity.CENTER_VERTICAL);
        baseLayout.addView(aboutLayout);

        LinearLayout aboutClickLayout = new LinearLayout(this);
        aboutClickLayout.setOrientation(LinearLayout.HORIZONTAL);
        aboutClickLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        aboutClickLayout.setGravity(Gravity.CENTER);
        aboutLayout.addView(aboutClickLayout);
        aboutClickLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                licenseActivity(v);
            }
        });

        Button aboutButton = new Button(this);
        aboutButton.setLayoutParams(buttonParams);
        aboutButton.setBackground(new BitmapDrawable(getResources(), PaperImageUtils.bitmapLoad(getApplicationContext().getResources(), R.drawable.ic_license_button, Math.round(48 * scale), Math.round(48 * scale))));
        aboutClickLayout.addView(aboutButton);

        TextView aboutText = new TextView(this);
        aboutText.setText("license");
        aboutText.setTextSize(35);
        aboutText.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
        aboutText.setPadding(64, 64, 64, 64);
        aboutClickLayout.addView(aboutText);
    }

    public void gitLink(View v) {
        Uri uri = Uri.parse("https://github.com/beli3ver/Paper-FOSS-Theme");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void iconActivity(View v) {
        Intent intent = new Intent(this, IconActivity.class);
        startActivity(intent);
    }

    public void licenseActivity(View v) {
        Intent intent = new Intent(this, LicenseActivity.class);
        startActivity(intent);
    }
}
