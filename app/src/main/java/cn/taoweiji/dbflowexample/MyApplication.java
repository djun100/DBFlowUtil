package cn.taoweiji.dbflowexample;

import android.app.Application;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by Wiki on 16/3/6.
 */
public class MyApplication extends Application {

  @Override public void onCreate() {
    super.onCreate();
    //初始化数据库
    FlowManager.init(this);
  }
}
