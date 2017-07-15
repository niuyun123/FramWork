package com.ehome.niuyunyang.framework.testdb;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.ehome.niuyunyang.framework.R;
import com.ehome.niuyunyang.nyylib.util.log.LogUtil;
import com.ehome.niuyunyang.nyylib.widget.list_grid_view.baseadapter.CommonAdapter;
import com.ehome.niuyunyang.nyylib.widget.list_grid_view.baseadapter.ViewHolder;

import org.litepal.crud.DataSupport;
import org.litepal.crud.callback.FindMultiCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main10Activity extends AppCompatActivity {

    @BindView(R.id.lv_news)
    ListView lvNews;
    private List<News> data=new ArrayList<>();
    private NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        ButterKnife.bind(this);
        // saveData();
        //findSeries();
        newsAdapter = new NewsAdapter(this,data, R.layout.item_news);
        lvNews.setAdapter(newsAdapter);
       // data = findData();
        findDataScyn();
    }

    private void findSeries() {
        List<Series> series = DataSupport.findAll(Series.class, true);
        LogUtil.json(series);
    }

    private List<News> findData() {
        List<News> newsList = DataSupport.findAll(News.class, true);
        LogUtil.json(newsList);
        return newsList;
    }
   private void findDataScyn(){
       DataSupport.findAllAsync(News.class,true).listen(new FindMultiCallback() {
           @Override
           public <T> void onFinish(List<T> list) {
                data.addAll((List<News>)list);
                LogUtil.json(list);
                newsAdapter.notifyDataSetChanged();
           }
       });
   }
    private void saveData() {
        List<News> newses = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            News news = new News("武大郎暴打西门庆!!!", "北京时间上午十点五十分钟西门庆在家门口被武大郎比动了!!!");
            Introduction introduction = new Introduction("武大郎外传", "新奇武大郎拳踢郑冠喜");
            introduction.save();
            news.setIntroduction(introduction);
            List<Comments> commentses = Arrays.asList(new Comments("张三", "66666+++"), new Comments("李四", "不要太膨胀"), new Comments("王武", "武大郎你变了"));
            DataSupport.saveAll(commentses);
            news.setCommentsList(commentses);
            List<Series> series = Arrays.asList(new Series("八卦"), new Series("猎奇"), new Series("亮瞎狗眼"));
            DataSupport.saveAll(series);
            news.setSeries(series);
            newses.add(news);
        }

        DataSupport.saveAll(newses);
       /* Series series1 = new Series("这是科技吗");
        series1.setNewses(newses);
        series1.save();*/
    }
    public class NewsAdapter extends CommonAdapter<News>{

        public NewsAdapter(Context context, List<News> datas, int layoutId) {
            super(context, datas, layoutId);
        }

        @Override
        public void convert(ViewHolder holder, News news) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < news.getSeries().size(); i++) {
                stringBuffer.append(news.getSeries().get(i).getName()+"文  ");
            }
            holder.setText(R.id.tvcategory,stringBuffer.toString());
            holder.setText(R.id.tvguider,news.getIntroduction().getGuide()+"("+news.getIntroduction().getDigest()+")");
            holder.setText(R.id.tv_title,news.getTitle());
            holder.setText(R.id.tv_content,news.getContent());
            StringBuffer stringBuffer1 = new StringBuffer();
            for (int i = 0; i < news.getCommentsList().size(); i++) {
                stringBuffer1.append(news.getCommentsList().get(i).getName()+":"+news.getCommentsList().get(i).getContent()+"\n");
            }
            holder.setText(R.id.tv_comment,stringBuffer1.toString());
        }
    }
}
