package com.ehome.niuyunyang.nyylib.http.builder;

import com.ehome.niuyunyang.nyylib.http.OkHttpUtils;
import com.ehome.niuyunyang.nyylib.http.request.OtherRequest;
import com.ehome.niuyunyang.nyylib.http.request.RequestCall;

/**
 * Created by zhy on 16/3/2.
 */
public class HeadBuilder extends GetBuilder
{
    @Override
    public RequestCall build()
    {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers,id).build();
    }
}
