package data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Umeed-e-Nau on 12/21/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "LHWMIS.db";
    private static final int VERSION = 1;

    Context mContext;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.beginTransaction();

        //db.execSQL(activity1.getCreateQuery());
        db.execSQL(TableF1SectionC.getCreateQuery());
        db.execSQL(TableF1SectionD.getCreateQuery());
        db.execSQL(TableF1SectionE.getCreateQuery());
        db.execSQL(TableF1SectionF.getCreateQuery());
        db.execSQL(TableF1SectionG.getCreateQuery());
        db.execSQL(TableF1SectionH.getCreateQuery());


        db.execSQL(TableF2SectionC.getCreateQuery());
        db.execSQL(TableF2SectionD.getCreateQuery());
        db.execSQL(TableF2SectionE.getCreateQuery());
        db.execSQL(TableF2SectionF.getCreateQuery());
        db.execSQL(TableF2SectionG.getCreateQuery());
        db.execSQL(TableF2SectionH.getCreateQuery());

        db.execSQL(TableF3SectionB.getCreateQuery());
        db.execSQL(TableF4SectionB.getCreateQuery());

        db.execSQL(TableF5SectionB.getCreateQuery());
        db.execSQL(TableF6SectionB.getCreateQuery());


        db.execSQL(TableLoginData.getCreateQuery());

        db.execSQL(TableLHWSection.getCreateQuery());
        db.execSQL(TableHHSection.getCreateQuery());







        db.setTransactionSuccessful();
        db.endTransaction();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String query="";
        db.beginTransaction();
       // query = "DROP TABLE IF EXISTS " + validationactivity2.TABLE_NAME;
        db.execSQL(query);

        db.setTransactionSuccessful();
        db.endTransaction();
    }

    public Cursor execRAW(String query) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = null;
        try {
            cursor = db.rawQuery(query, null);
        } catch (SQLiteException e) {
            e.printStackTrace();
            Log.d(DBHelper.class.getName(), " Exception while executing Query");
        }
        return cursor;
    }
}
