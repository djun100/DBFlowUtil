package cn.taoweiji.dbflowexample.db_manage;

import android.content.Context;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.transaction.FastStoreModelTransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.ITransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;


/**
 * Created by admin on 2017/1/17.
 */

public class UtilDBFlow {

    public static void initDB(Context context){
        FlowManager.init(new FlowConfig.Builder(context).build());
    }

    public static <T> void save(Class clazz,T obj){
//        Class<T> entityClass;
//        Type genType = obj.getClass().getGenericSuperclass();
//        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
//        entityClass = (Class) params[0];
        FlowManager.getModelAdapter(clazz).save(obj);
    }

    /**同步事务
     * @param classDb
     * @param iTransaction
     */
    public static void execTransactionSync(Class classDb, ITransaction iTransaction){
        FlowManager.getDatabase(classDb).executeTransaction(iTransaction);
    }

    /**异步事务
     * @param classDb
     * @param iTransaction
     */
    public static void execTransactionAsync(Class classDb, ITransaction iTransaction){
        FlowManager.getDatabase(classDb)
                .beginTransactionAsync(iTransaction)  // add elements (can also handle multiple)
                .error(new Transaction.Error() {
                    @Override
                    public void onError(Transaction transaction, Throwable error) {}
                })
                .success(new Transaction.Success() {
                    @Override
                    public void onSuccess(Transaction transaction) {}
                })
                .build()
                .execute();
    }

    public static ITransaction getTransaction(List<? extends BaseModel> baseModels){
        ProcessModelTransaction processModelTransaction= new ProcessModelTransaction.Builder<>(
                new ProcessModelTransaction.ProcessModel<BaseModel>() {

                    @Override
                    public void processModel(BaseModel baseModel, DatabaseWrapper wrapper) {
                        baseModel.save();
                    }
                }
        )
                .addAll(baseModels)
                .build();
        return processModelTransaction;
    }

    public static <T> ITransaction getFastStoreTrans(List<? extends BaseModel> baseModels){
        Class<T> entityClass;
        Type genType = baseModels.get(0).getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        entityClass = (Class) params[0];

        ITransaction transaction= FastStoreModelTransaction
                .insertBuilder(FlowManager.getModelAdapter(entityClass))
                .addAll((Collection<? extends T>) baseModels)
                .build();
        return transaction;
    }
}
