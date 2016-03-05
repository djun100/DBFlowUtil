package cn.taoweiji.dbflowexample.db;

import android.util.Log;

import com.raizlabs.android.dbflow.runtime.transaction.process.ProcessModelInfo;
import com.raizlabs.android.dbflow.runtime.transaction.process.SaveModelTransaction;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.ArrayList;
import java.util.List;

import cn.taoweiji.dbflowexample.ApplicationTest;

/**
 * Created by Wiki on 16/3/6.
 */
public class PeopleTest extends ApplicationTest {
    /**
     * This will do the work to instantiate the Application under test.  After this, your test
     * code must also start and stop the Application.
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        createApplication();
        Thread.sleep(1000);
    }

    public void testSave() {

//        People people = new People();
//        people.id = 2l;
//        people.name = "Wiki";
//        people.gender = 1;
//        people.update();
//        people.delete();
//        people.save();
//        Log.e("Test", String.valueOf(people.id));

        List<People> peoples = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            People people = new People();
            people.name = "Wiki";
            people.gender = 1;
            people.email = "taoweiji@qq.com";
            peoples.add(people);
        }
        //实时保存，马上保存
        new SaveModelTransaction<>(ProcessModelInfo.withModels(peoples)).onExecute();
        //异步保存，使用异步，如果立刻查询可能无法查到结果
        //TransactionManager.getInstance().addTransaction(new SaveModelTransaction<>(ProcessModelInfo.withModels(peoples)));
        List<People> peoples2 = new Select().from(People.class).queryList();
        Log.e("Test-peoples", String.valueOf(peoples2.size()));
    }

    public void testFind() {
        //返回所有查询结果
//        List<People> peoples = new Select().from(People.class).queryList();
//        //返回单个查询结果
//        People people = new Select().from(People.class).querySingle();
//        //查询gender = 1的所有People
//        List<People> peoples2 = new Select().from(People.class).where(People_Table.gender.eq(1)).queryList();
//
//
//        Log.e("Test-peoples", String.valueOf(peoples.size()));
    }

}