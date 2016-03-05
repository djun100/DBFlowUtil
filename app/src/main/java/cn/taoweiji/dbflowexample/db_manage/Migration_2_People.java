package cn.taoweiji.dbflowexample.db_manage;

import com.raizlabs.android.dbflow.annotation.Migration;
import com.raizlabs.android.dbflow.sql.SQLiteType;
import com.raizlabs.android.dbflow.sql.migration.AlterTableMigration;

import cn.taoweiji.dbflowexample.db.People;
import cn.taoweiji.dbflowexample.db.People_Table;

/**
 * 升级数据库
 * Created by Wiki on 16/2/13.
 */
@Migration(version = 2, database = AppDatabase.class)
public class Migration_2_People extends AlterTableMigration<People> {

    public Migration_2_People(Class<People> table) {
        super(table);
    }

    @Override
    public void onPreMigrate() {
        addColumn(SQLiteType.TEXT, People_Table.email.getNameAlias().getName());
    }
}