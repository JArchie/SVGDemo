package com.jarchie.svg;

import android.content.Context;
import android.graphics.Typeface;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.typeface.ITypeface;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Jarchie on 2018\1\12.
 * 自定义字体图标库
 */

@SuppressWarnings("WeakerAccess")
public class MyIconFont implements ITypeface{

    private static final String TTF_FILE = "iconfont.ttf"; //字体名称

    private static Typeface typeface = null;

    private static HashMap<String, Character> mChars;

    @Override
    public IIcon getIcon(String key) { //通过key拿到内部类中的Icon
        return Icon.valueOf(key);
    }

    @Override
    public HashMap<String, Character> getCharacters() { //将字符串存到HashMap中
        if (mChars == null) {
            HashMap<String, Character> aChars = new HashMap<>();
            for (Icon v : Icon.values()) {
                aChars.put(v.name(), v.character); //字符串的名字和值put进去，一一对应
            }
            mChars = aChars;
        }
        return mChars;
    }

    @Override
    public String getMappingPrefix() { //这个是Icon类中你自己定义的字体的前缀，一定不能搞错，否则找不到对应的字体
        return "archie";
    }

    @Override
    public String getFontName() { //字体名字，可以随便写
        return "JarchieFont";
    }

    @Override
    public String getVersion() { //版本号
        return "1.0.0";
    }

    @Override
    public int getIconCount() { //字体数量
        return mChars.size();
    }

    @Override
    public Collection<String> getIcons() { //返回一个有序集合
        Collection<String> icons = new LinkedList<>();
        for (Icon value : Icon.values()) {
            icons.add(value.name());
        }
        return icons;
    }

    @Override
    public String getAuthor() { //作者
        return "Jarchie";
    }

    @Override
    public String getUrl() { //域名URL，可以随便写，也可不写
        return "https://github.com/JArchie/SVGDemo";
    }

    @Override
    public String getDescription() { //描述内容
        return "The custom icon font for Iconics";
    }

    @Override
    public String getLicense() { //授权
        return "XXX Licensed";
    }

    @Override
    public String getLicenseUrl() { //授权地址
        return "https://github.com/JArchie/SVGDemo";
    }

    @Override
    public Typeface getTypeface(Context context) { //获取Typeface对象
        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(), TTF_FILE);
            } catch (Exception e) {
                return null;
            }
        }
        return typeface;
    }

    @SuppressWarnings({"WeakerAccess", "unused"})
    public enum Icon implements IIcon {
        archie_all('\ue696'),
        archie_back('\ue697'),
        archie_cart('\ue698'),
        archie_category('\ue699'),
        archie_close('\ue69a'),
        archie_comments('\ue69b'),
        archie_cry('\ue69c'),
        archie_delete('\ue69d'),
        archie_edit('\ue69e'),
        archie_form('\ue6a2'),
        archie_qrcoed('\ue6a9'),
        archie_search('\ue6ac'),
        archie_selected('\ue6ad'),
        archie_set('\ue6ae'),
        archie_success('\ue6b1');

        char character;

        Icon(char character) {
            this.character = character;
        }

        public String getFormattedName() {
            return "{" + name() + "}";
        }

        public char getCharacter() {
            return character;
        }

        public String getName() {
            return name();
        }

        // remember the typeface so we can use it later
        private static ITypeface typeface;

        public ITypeface getTypeface() {
            if (typeface == null) {
                typeface = new MyIconFont();
            }
            return typeface;
        }
    }

}
