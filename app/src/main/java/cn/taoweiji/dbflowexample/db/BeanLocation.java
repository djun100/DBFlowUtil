package cn.taoweiji.dbflowexample.db;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;

import cn.taoweiji.dbflowexample.db_manage.AppDatabase;

/**
 * Created by cy on 2017/1/14.
 */
@Table(database = AppDatabase.class)
public class BeanLocation {
    //自增ID
    @PrimaryKey(autoincrement = true)
    public Long id;
    @Column
    public double lat;
    @Column
    public double lon;
    @Column
    public String location;
}
