package cn.taoweiji.dbflowexample.db;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import cn.taoweiji.dbflowexample.db_manage.AppDatabase;

/**
 * People
 * Created by Wiki on 16/3/2.
 */
@ModelContainer
@Table(database = AppDatabase.class)
public class People extends BaseModel {
    //自增ID
    @PrimaryKey(autoincrement = true)
    public Long id;
    @Column
    public String name;
    @Column
    public int gender;
    @Column
    public String email;
}
