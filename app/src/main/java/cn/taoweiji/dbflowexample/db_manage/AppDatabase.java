package cn.taoweiji.dbflowexample.db_manage;

import com.raizlabs.android.dbflow.annotation.Database;
/**
 * 数据库定义类
 * Created by Wiki on 16/3/2.
 */
@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION)
public class AppDatabase {
  //数据库名称
  public static final String NAME = "AppDatabase";
  //数据库版本号
  public static final int VERSION = 2;
}
