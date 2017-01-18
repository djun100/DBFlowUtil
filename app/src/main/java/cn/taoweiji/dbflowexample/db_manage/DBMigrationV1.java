package cn.taoweiji.dbflowexample.db_manage;

import com.raizlabs.android.dbflow.annotation.Migration;
import com.raizlabs.android.dbflow.sql.SQLiteType;
import com.raizlabs.android.dbflow.sql.migration.AlterTableMigration;

import cn.taoweiji.dbflowexample.db.People;

/**
 * 升级数据库0-1
 * Created by Wiki on 16/2/13.
 */
@Migration(version = 1, database = AppDatabase.class)
public class DBMigrationV1 extends AlterTableMigration<People> {

    public DBMigrationV1(Class<People> table) {
        super(table);
    }

    @Override
    public void onPreMigrate() {
//        addColumn(SQLiteType.TEXT, People_Table.email.getNameAlias().name());
    }
}