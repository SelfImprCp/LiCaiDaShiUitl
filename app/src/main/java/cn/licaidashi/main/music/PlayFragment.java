package cn.licaidashi.main.music;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.cp.mylibrary.base.MyBaseFragment;
import com.cp.mylibrary.utils.LogCp;
import com.cp.mylibrary.utils.ScreenUtils;


import org.kymjs.kjframe.ui.BindView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import cn.licaidashi.main.R;

/**
 * Created by Jerry on 2018/3/2.
 */

public class PlayFragment extends MyBaseFragment implements View.OnClickListener, SeekBar.OnSeekBarChangeListener,
        OnPlayerEventListener {


    private ImageView iv_play_page_bg;


    private TextView tv_title;


    private ImageView iv_back;

    private LinearLayout llContent;

    private ViewPager vp_play_page;

    private SeekBar sb_progress;

    private TextView tv_current_time;

    private TextView tv_total_time;


    private ImageView iv_play;

    private ImageView iv_next;

    private ImageView iv_prev;


    private List<View> mViewPagerContent;


    private AudioManager mAudioManager;

    private int mLastProgress;
    private boolean isDraggingProgress;

    @Override
    protected View inflaterView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View view = inflater.inflate(R.layout.fragment_play, container, false);
        iv_play_page_bg = (ImageView) view.findViewById(R.id.iv_play_page_bg);
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        iv_back = (ImageView) view.findViewById(R.id.iv_back);
        vp_play_page = (ViewPager) view.findViewById(R.id.vp_play_page);

        sb_progress = (SeekBar) view.findViewById(R.id.sb_progress);
        tv_current_time = (TextView) view.findViewById(R.id.tv_current_time);
        tv_total_time = (TextView) view.findViewById(R.id.tv_total_time);

        iv_play = (ImageView) view.findViewById(R.id.iv_play);
        iv_next = (ImageView) view.findViewById(R.id.iv_next);
        iv_prev = (ImageView) view.findViewById(R.id.iv_prev);


        iv_play.setOnClickListener(this);
        iv_next.setOnClickListener(this);
        iv_prev.setOnClickListener(this);
        sb_progress.setOnSeekBarChangeListener(this);

        llContent = (LinearLayout) view.findViewById(R.id.ll_content);


        return view;
    }

    @Override
    public void initView(View view) {
        super.initView(view);


    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initSystemBar();
        initViewPager();

        onChangeImpl(AudioPlayer.get().getPlayMusic());
        AudioPlayer.get().addOnPlayEventListener(this);
    }

    private void initSystemBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int top = ScreenUtils.getStatusHeight(getActivity());
            llContent.setPadding(0, top, 0, 0);
        }
    }


    private void initViewPager() {
        View coverView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_play_page_cover, null);


        initVolume();

        mViewPagerContent = new ArrayList<>(2);
        mViewPagerContent.add(coverView);

        vp_play_page.setAdapter(new PlayPagerAdapter(mViewPagerContent));
    }


    private void initVolume() {
        mAudioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);
        sb_progress.setMax(mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        sb_progress.setProgress(mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
    }

    private void onChangeImpl(Music music) {


        if (music == null) {
            return;
        }

        tv_title.setText(music.getTitle());

        sb_progress.setProgress((int) AudioPlayer.get().getAudioPosition());
        sb_progress.setSecondaryProgress(0);
        sb_progress.setMax(music.getDuration());
        mLastProgress = 0;
        tv_current_time.setText("00:00");
        tv_total_time.setText(formatTime(music.getDuration()));
//        setCoverAndBg(music);
//        setLrc(music);
        if (AudioPlayer.get().isPlaying() || AudioPlayer.get().isPreparing()) {
            iv_play.setSelected(true);
            //    mAlbumCoverView.start();
        } else {
            iv_play.setSelected(false);
            //  mAlbumCoverView.pause();
        }
    }


    @Override
    protected void widgetClick(View v) {
        super.widgetClick(v);

        switch (v.getId()) {
            case R.id.iv_back:

                break;

            case R.id.iv_play:

                play();
                break;
            case R.id.iv_next:
                next();
                break;
            case R.id.iv_prev:
                prev();
                break;
        }
    }

    private void play() {
        AudioPlayer.get().playPause();
    }

    private void next() {
        AudioPlayer.get().next();
    }

    private void prev() {
        AudioPlayer.get().prev();
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (seekBar == sb_progress) {

            tv_current_time.setText(formatTime(progress));

            if (Math.abs(progress - mLastProgress) >= DateUtils.SECOND_IN_MILLIS) {


                mLastProgress = progress;
            }
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        if (seekBar == sb_progress) {
            isDraggingProgress = true;
        }
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (seekBar == sb_progress) {
            isDraggingProgress = false;
            if (AudioPlayer.get().isPlaying() || AudioPlayer.get().isPausing()) {
                int progress = seekBar.getProgress();
                AudioPlayer.get().seekTo(progress);


            } else {
                seekBar.setProgress(0);
            }
        }
    }

    @Override
    public void onChange(Music music) {
        onChangeImpl(music);
    }

    @Override
    public void onPlayerStart() {
        iv_prev.setSelected(true);
    }

    @Override
    public void onPlayerPause() {
        iv_prev.setSelected(false);

    }

    @Override
    public void onPublish(int progress) {

        LogCp.i(LogCp.CP, PlayFragment.class + " 播放的 进度 " + progress + isDraggingProgress);


        if (!isDraggingProgress) {
            sb_progress.setProgress(progress);
        }
    }


    @Override
    public void onBufferingUpdate(int percent) {

        if (percent == 0)
            percent = 1;
        sb_progress.setSecondaryProgress(sb_progress.getMax() * 100 / percent);
    }

    private String formatTime(long time) {
        return formatTime("mm:ss", time);
    }


    public String formatTime(String pattern, long milli) {
        int m = (int) (milli / DateUtils.MINUTE_IN_MILLIS);
        int s = (int) ((milli / DateUtils.SECOND_IN_MILLIS) % 60);
        String mm = String.format(Locale.getDefault(), "%02d", m);
        String ss = String.format(Locale.getDefault(), "%02d", s);
        return pattern.replace("mm", mm).replace("ss", ss);
    }
}
