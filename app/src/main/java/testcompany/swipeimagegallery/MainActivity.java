package testcompany.swipeimagegallery;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Code for adapter for viewpager
        viewPager = (ViewPager) findViewById(R.id.pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter();
        viewPager.setAdapter(adapter);

    }


    //Class for ViewPager
    private class ViewPagerAdapter extends PagerAdapter {
        
        //Out of memory error when using higher resolution images, app crashes
        private int[] images = new int[] {
                R.drawable.image1,
                R.drawable.image2,
                R.drawable.image3
        };

        @Override
        public int getCount(){
            return images.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object){
            return view == object;
        }

        public Object instantiateItem(ViewGroup container, int position){
            Context context = MainActivity.this;
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setImageResource(images[position]);
            container.addView(imageView, 0);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object){
            container.removeView((ImageView) object);
        }
    }
}
