package balyas.sasha.tablayoutsample;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.ViewPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.ViewPagerItems;

import balyas.sasha.tablayoutsample.ui.TintableImageView;


public class MainActivity extends FragmentActivity {

    private SmartTabLayout tabs;
    private ViewPager pager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabs = (SmartTabLayout) findViewById(R.id.sliding_tabs);
        pager = (ViewPager) findViewById(R.id.pager);

        ViewPagerItemAdapter pagerAdapter = new ViewPagerItemAdapter(ViewPagerItems.with(this)
                .add("first_layout", R.layout.test1)
                .add("second_layout", R.layout.test2)
                .add("third_layout", R.layout.test2)
                .add("fourth_layout", R.layout.test2)
                .create());
        pager.setAdapter(pagerAdapter);

        final LayoutInflater inflater = LayoutInflater.from(tabs.getContext());
        final Resources res = tabs.getContext().getResources();

        tabs.setCustomTabView(new SmartTabLayout.TabProvider() {
            @Override
            public View createTabView(ViewGroup container, int position, PagerAdapter adapter) {
                LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.custom_tab_title, container, false);
                ImageView icon = (ImageView) layout.findViewById(R.id.custom_tab_icon);
                TextView text = (TextView) layout.findViewById(R.id.custom_tab_text);
                switch (position) {
                    case 0:
                        icon.setImageDrawable(res.getDrawable(R.drawable.icon1));
                        text.setText("Українська мова та література");
                        break;
                    case 1:
                        icon.setImageDrawable(res.getDrawable(R.drawable.icon2));
                        text.setText("Математика");
                        break;
                    case 2:
                        icon.setImageDrawable(res.getDrawable(R.drawable.icon3));
                        text.setText("Історія України");
                        break;
                    case 3:
                        icon.setImageDrawable(res.getDrawable(R.drawable.icon4));
                        text.setText("Фізика");
                        break;
                    default:
                        throw new IllegalStateException("Invalid position: " + position);
                }
                return layout;
            }
        });
        tabs.setViewPager(pager);


    }


}
