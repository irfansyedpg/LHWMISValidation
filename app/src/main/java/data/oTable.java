package data;

import com.irfansyed.umeedenau.validation.Global;

/**
 * Created by Umeed-e-Nau on 12/24/2016.
 */
public class oTable {
    public static String TABLE_NAME = "tabl1";

    public static String getCreateQuery() {
        String query;
        query = "CREATE TABLE '" + TABLE_NAME + "' ('id' INTEGER PRIMARY KEY AUTOINCREMENT,  " +


                Global.	Q11	+ " TEXT," +
                Global.	Q12	+ " TEXT," +
                Global.	Q1_1	+ " TEXT," +
                Global.	Q1	+ " TEXT," +
                Global.	Q2	+ " TEXT," +
                Global.	Q3	+ " TEXT," +
                Global.	Q4	+ " TEXT," +


                Global.datee + " Text," +
                Global.timee + " Text," +
                Global.userid + " Text," +
                Global.type_interview + " Text," +
                Global.Interview_status + " Text " +






                ')';


        return query;
    }
}
