package com.ehome.niuyunyang.framework.testdb;

import org.litepal.crud.DataSupport;

/**
 * Created by NewYyoung on 2017/7/15.
 * version 2.8
 */

public class Introduction extends DataSupport{
    private String guide;
    private String digest;

    public Introduction(String guide, String digest) {
        this.guide = guide;
        this.digest = digest;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }
}
