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
            R.drawable.addresstogps,
            R.drawable.apktrack,
            R.drawable.audiofx,
            R.drawable.batteryfu,
            R.drawable.batterylevel,
            R.drawable.bible,
            R.drawable.browser,
            R.drawable.btc,
            R.drawable.cal_color,
            R.drawable.calculator,
            R.drawable.camera,
            R.drawable.cert,
            R.drawable.chromium,
            R.drawable.clock,
            R.drawable.contacts,
            R.drawable.conversation,
            R.drawable.davdroid,
            R.drawable.document_viewer,
            R.drawable.documents,
            R.drawable.downloads,
            R.drawable.facebook,
            R.drawable.fdroid,
            R.drawable.feed,
            R.drawable.filemanager,
            R.drawable.firefox,
            R.drawable.firewall,
            R.drawable.ftp,
            R.drawable.gallery,
            R.drawable.game2048,
            R.drawable.getchromium,
            R.drawable.git,
            R.drawable.habit,
            R.drawable.irc,
            R.drawable.jabber,
            R.drawable.kalarm,
            R.drawable.keepass,
            R.drawable.keychain,
            R.drawable.lightning,
            R.drawable.linphone,
            R.drawable.litecoin,
            R.drawable.mail,
            R.drawable.mail_secure,
            R.drawable.mapsme,
            R.drawable.mc,
            R.drawable.mumble,
            R.drawable.music,
            R.drawable.netguard,
            R.drawable.nextcloud,
            R.drawable.notes,
            R.drawable.owncloud,
            R.drawable.passwordstore,
            R.drawable.pdf,
            R.drawable.phone,
            R.drawable.podcast,
            R.drawable.printer,
            R.drawable.qtqr,
            R.drawable.radio,
            R.drawable.recorder,
            R.drawable.reddit,
            R.drawable.scope,
            R.drawable.seafile,
            R.drawable.sealnote,
            R.drawable.settings,
            R.drawable.sim,
            R.drawable.sms,
            R.drawable.sms_secure,
            R.drawable.supersu,
            R.drawable.syncthing,
            R.drawable.telegram,
            R.drawable.terminal,
            R.drawable.themes,
            R.drawable.todo,
            R.drawable.tor,
            R.drawable.tox,
            R.drawable.videoeditor,
            R.drawable.vim,
            R.drawable.vlc,
            R.drawable.vpn,
            R.drawable.wallpaper,
            R.drawable.weather,
            R.drawable.xabber,
            R.drawable.youtube,
            R.drawable.zip,
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
