package cn.licaidashi.main.music;

import android.text.TextUtils;

import java.io.Serializable;

/**
 * 单曲信息
 * Created by wcy on 2015/11/27.
 */

public class Music implements Serializable {
    private static final long serialVersionUID = 536871008;
   private  Long id;
    private String title;

    private String path;
    private int duration;


    public Music(long  id, String title,

                 String path,int duration ) {
        this.id = id;
        this.title = title;

        this.path = path;
        this.duration = duration;

    }

    public interface Type {
        int LOCAL = 0;
        int ONLINE = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Music)) {
            return false;
        }
        Music music = (Music) o;

        if (TextUtils.equals(music.title, this.title)
                && TextUtils.equals(music.path, this.path))

        {
            return true;
        }
        return false;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}
