package com.ehome.niuyunyang.nyylib.util;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;

/**
 * Created by NewYyoung on 2017/7/7.
 * version 2.8
 */

public class StringUtils {
    /**
     * 从资源文件获取某一文件的uri
     * @param drawableId
     * @param context
     * @return
     */
    public static  Uri getUriFromDrawableResouce(int drawableId, Context context){
        Resources r = context.getResources();
        Uri uri =  Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                + r.getResourcePackageName(drawableId) + "/"
                + r.getResourceTypeName(drawableId) + "/"
                + r.getResourceEntryName(drawableId));
        return uri;
    }
}
