package com.kn.paper_foss_theme.activities;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.ArrayList;

import com.kn.paper_foss_theme.utils.PaperImageUtils;
import com.kn.paper_foss_theme.utils.PaperScreenUtils;
import com.kn.paper_foss_theme.R;
public class IconActivity extends AppCompatActivity {

    private Integer[] mImages = {
            R.drawable.adaway,
    };

    private ArrayList<LinearLayout> layoutList = new ArrayList<>();
    private ArrayList<ImageView> imageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (PaperScreenUtils.isPortrait(getApplicationContext())) {
            createLayout(7);
        } else {
            createLayout(12);
        }
    }

    private void createLayout(int width) {
        float scale = PaperScreenUtils.densityScale(getApplicationContext());
        int margin = 16 * Math.round(scale);

        LinearLayout.LayoutParams baseParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams containerParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);

        ScrollView baseScroller = new ScrollView(this);
        baseScroller.setLayoutParams(baseParams);
        baseScroller.setBackgroundColor(0xff000000);
        setContentView(baseScroller);
        baseScroller.setVisibility(View.VISIBLE);

        // display width hack
        Rect windowRect = new Rect();
        baseScroller.getWindowVisibleDisplayFrame(windowRect);
        int windowWidth = windowRect.right - windowRect.left;

        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        baseLayout.setLayoutParams(layoutParams);
        baseLayout.setPadding(margin, margin, 0, 0);
        baseScroller.addView(baseLayout);

        for (int i = 0; i < mImages.length; i++) {
            if ((i % width) == 0) {
                layoutList.add((i / width), new LinearLayout(this));
                layoutList.get(i / width).setOrientation(LinearLayout.HORIZONTAL);
                layoutList.get(i / width).setGravity(Gravity.LEFT);
                layoutList.get(i / width).setLayoutParams(containerParams);

                baseLayout.addView(layoutList.get(i / width));
            }
            imageList.add(i, new ImageView(this));
            imageList.get(i).setLayoutParams(imageParams);
            imageList.get(i).setScaleType(ImageView.ScaleType.FIT_XY);
            imageList.get(i).setPadding(0, 0, margin, margin);
            PaperImageUtils.bitmapLoadAsync(imageList.get(i), getApplicationContext().getResources(), mImages[i], (windowWidth / width) - (margin * width + margin) / width, (windowWidth / width) - (margin * width + margin) / width);
            imageList.get(i).setAdjustViewBounds(true);
            layoutList.get(i / width).addView(imageList.get(i));
        }
    }
}
