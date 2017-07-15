package com.ehome.niuyunyang.framework.testimg;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.ehome.niuyunyang.framework.R;
import com.ehome.niuyunyang.nyylib.imageloader.glidepalette.BitmapPalette;
import com.ehome.niuyunyang.nyylib.imageloader.glidepalette.GlidePalette;
import com.ehome.niuyunyang.nyylib.util.StringUtils;

public class Main4Activity extends AppCompatActivity {

    private ImageView img;
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;
    private TextView text5;
    private TextView text6;
    public static final String URL = "http://i.huffpost.com/gen/2299606/images/n-STARRY-NIGHT-628x314.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        img = (ImageView)findViewById(R.id.testimg);
        text1= (TextView) findViewById(R.id.text1);
        text2= (TextView) findViewById(R.id.text2);
        text3= (TextView) findViewById(R.id.text3);
        text4= (TextView) findViewById(R.id.text4);
        text5= (TextView) findViewById(R.id.text5);
        text6= (TextView) findViewById(R.id.text6);
       /* Glide.with(this).load(Uri.parse("http://avatar.csdn.net/F/F/5/1_lmj623565791.jpg"))
                //.placeholder(R.drawable.ic_launcher)
                //.diskCacheStrategy(DiskCacheStrategy.RESULT)
                //.override(400,400)
                // .fitCenter()
                //.bitmapTransform(new CropCircleTransformation(this))
                // .bitmapTransform(new BlurTransformation(this,3))
                // ==>
                .apply(new RequestOptions().placeholder(R.drawable.ic_launcher))
                .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.AUTOMATIC))
                .apply(new RequestOptions().override(1000,1000))
                .apply(new RequestOptions().centerCrop())
                .apply(new RequestOptions().bitmapTransform(new CropCircleTransformation(this)))
                .apply(new RequestOptions().bitmapTransform(new BlurTransformation(this)))
                .apply(new RequestOptions().bitmapTransform(new RoundedCornersTransformation(this,500,0)))
                .transition(new DrawableTransitionOptions().crossFade(500))
                .into(img);*/
      //  Glide.with(this).load(R.drawable.background2).into(img);
        Glide.with(this).load(R.drawable.background2)
                .listener(
                        GlidePalette.with(StringUtils.getUriFromDrawableResouce(R.drawable.background2,this).toString()).use(GlidePalette.Profile.VIBRANT)
                        .intoBackground(text1, GlidePalette.Swatch.RGB)
                        .intoTextColor(text1, GlidePalette.Swatch.BODY_TEXT_COLOR)
                        .crossfade(true)
                        .use(GlidePalette.Profile.VIBRANT_DARK)
                        .intoBackground(text2, GlidePalette.Swatch.RGB)
                        .intoTextColor(text2, GlidePalette.Swatch.BODY_TEXT_COLOR)
                        .crossfade(false)
                        .use(GlidePalette.Profile.VIBRANT_LIGHT)
                        .intoBackground(text3, GlidePalette.Swatch.RGB)
                        .intoTextColor(text3, GlidePalette.Swatch.BODY_TEXT_COLOR)
                        .crossfade(true, 1000)

                        .use(GlidePalette.Profile.MUTED)
                        .intoBackground(text4, GlidePalette.Swatch.RGB)
                        .intoTextColor(text4, GlidePalette.Swatch.BODY_TEXT_COLOR)
                        .use(GlidePalette.Profile.MUTED_DARK)
                        .intoBackground(text5, GlidePalette.Swatch.RGB)
                        .intoTextColor(text5, GlidePalette.Swatch.BODY_TEXT_COLOR)
                        .crossfade(true, 2000)
                        .use(GlidePalette.Profile.MUTED_LIGHT)
                        .intoBackground(text6, GlidePalette.Swatch.RGB)
                        .intoTextColor(text6, GlidePalette.Swatch.BODY_TEXT_COLOR)

                        // optional
                        .intoCallBack(new BitmapPalette.CallBack() {
                            @Override
                            public void onPaletteLoaded(@Nullable Palette palette) {
                                //specific task
                            }
                        })

                        // optional
                        .setGlideListener(new RequestListener<Drawable>() {
                            @Override public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                                return false;
                            }

                            @Override public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                return false;
                            }
                        })
                        // optional: do stuff with the builder
                        .setPaletteBuilderInterceptor(new BitmapPalette.PaletteBuilderInterceptor() {
                            @NonNull
                            @Override
                            public Palette.Builder intercept(Palette.Builder builder) {
                                return builder.resizeBitmapArea(300 * 100);
                            }
                        })
                )
                .into(img);
    }
}
