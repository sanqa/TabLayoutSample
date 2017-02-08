package balyas.sasha.tablayoutsample;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import balyas.sasha.tablayoutsample.ui.SlidingTabLayout;

public class MainActivity extends FragmentActivity {

    private SlidingTabLayout tabs;
    private ViewPager pager;
    private MyPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabs = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        pager = (ViewPager) findViewById(R.id.pager);
        adapter = new MyPagerAdapter(getSupportFragmentManager());

        pager.setAdapter(adapter);
        tabs.setCustomTabView(R.layout.custom_tab_title, R.id.tabtext, R.id.tabimage);

        tabs.setViewPager(pager);

    }





    public class MyPagerAdapter extends FragmentPagerAdapter {

        private final String[] TITLES = { "Українська мова та література", "Математика", "Географія", "Фізика" };
        private final Drawable[] icons = {getResources().getDrawable(R.drawable.icon1),
                getResources().getDrawable(R.drawable.icon2),
                getResources().getDrawable(R.drawable.icon3),
                getResources().getDrawable(R.drawable.icon4)} ;

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return TITLES[position];
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }

        @Override
        public Fragment getItem(int position) {
            return SuperAwesomeCardFragment.newInstance(position);
        }

        public Drawable getLogo(final int i) {
            return icons[i];
        }
    }

}
