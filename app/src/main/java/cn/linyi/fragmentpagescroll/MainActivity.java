package cn.linyi.fragmentpagescroll;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements View.OnClickListener{
    private Button btn_per,btn_songs,btn_radio,btn_chart;
    private ViewPager pager;
    private PagerAdapter adapter;
    private ImageView red_line ;
    private int imageWidth;//图片宽度
    private int width;
    private int height;

    private LinearLayout.LayoutParams layoutParams;
/*    private Fragment_per_recommend fragment_per_recommend;
    private Fragment_songs_list fragment_songs_list;
    private Fragment_radio fragment_radio;
    private Fragment_charts fragment_charts;*/
    private List<Fragment> list_fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initContent();
    }

    private void initView() {
        btn_per = (Button) findViewById(R.id.main_btn_1);
        btn_songs = (Button) findViewById(R.id.main_btn_2);
        btn_radio = (Button) findViewById(R.id.main_btn_3);
        btn_chart = (Button) findViewById(R.id.main_btn_4);
        pager = (ViewPager) findViewById(R.id.vp_content);
        red_line = (ImageView) findViewById(R.id.red_line);
        //获取屏幕尺寸
        WindowManager wm = this.getWindowManager();
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;
        width = dm.widthPixels;

        Log.i("LIN",width+"");
        imageWidth = (int) (width/4.0);
        Log.i("LIN",imageWidth+"width+");
        //设置图片位置属性
        layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.LEFT;
        layoutParams.leftMargin =0;
        layoutParams.width = imageWidth;
        layoutParams.height = 15;
        //设置图片初始值
        red_line.setLayoutParams(layoutParams);

        btn_per.setOnClickListener(this);
        btn_songs.setOnClickListener(this);
        btn_radio.setOnClickListener(this);
        btn_chart.setOnClickListener(this);

    }

    private void initContent() {
        list_fragments = new ArrayList<Fragment>();
        list_fragments.add(new Fragment_per_recommend());
        list_fragments.add(new Fragment_songs_list());
        list_fragments.add(new Fragment_radio());
        list_fragments.add(new Fragment_charts());
        adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.setList_fragments(list_fragments);
        pager.setAdapter(adapter);
        Log.i("LIN", adapter.getCount()+"   ");
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
               Log.i("LIN","position:"+position+"\n"+positionOffset);
                Log.i("LIN","imageWIdth:"+imageWidth);
                int i = (int)((position + positionOffset)*imageWidth);
                layoutParams.leftMargin = i;
                Log.i("LIN","leftdsdadad:"+i);
                Log.i("LIN","leftMargin:"+layoutParams.leftMargin);
                red_line.setLayoutParams(layoutParams);
            }
            @Override
            public void onPageSelected(int position) {
                setCurrentPage(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setCurrentPage(0);//默认选中样式
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_btn_1:
                setCurrentPage(0);
                break;
            case R.id.main_btn_2:
                setCurrentPage(1);
                break;
            case R.id.main_btn_3:
                setCurrentPage(2);
                break;
            case R.id.main_btn_4:
                setCurrentPage(3);
                break;
            default:
                break;
        }
    }

    private void setCurrentPage(int item) {
        FragmentManager fm = getSupportFragmentManager();
        switch (item) {
            case 0:
                pager.setCurrentItem(0, true);
//                fm.getFragments().get(0).getView().findViewById()
                break;
            case 1:
                pager.setCurrentItem(1,true);
                break;
            case 2:
                pager.setCurrentItem(2,true);
                break;
            case 3:
                pager.setCurrentItem(3,true);
                break;
            default:
                break;
        }
    }
}
