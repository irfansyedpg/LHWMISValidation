package data;

import com.irfansyed.umeedenau.validation.Global;

public class db_class {
    public static String TABLE_NAME = "validationactivity";

    public static String getCreateQuery() {
        String query;
        query = "CREATE TABLE '" + TABLE_NAME + "' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'pk_pk' INTEGER,   " +

                Global.A1 + "TEXT," +
                Global.A2 + "TEXT," +
                Global.B1 + "TEXT," +
                Global.B2 + "TEXT," +
                Global.B3 + "TEXT," +
                Global.B4 + "TEXT," +
                Global.B5 + "TEXT," +
                Global.B6 + "TEXT," +
                Global.B7 + "TEXT," +
                Global.C1 + "TEXT," +
                Global.C2 + "TEXT," +
                Global.C3 + "TEXT," +
                Global.C4 + "TEXT," +
                Global.C5 + "TEXT," +
                Global.D1 + "TEXT," +
                Global.D2 + "TEXT," +
                Global.D3 + "TEXT," +
                Global.D4 + "TEXT," +
                Global.D5 + "TEXT," +
                Global.D6 + "TEXT," +
                Global.E1 + "TEXT," +
                Global.E2 + "TEXT," +
                Global.E3 + "TEXT," +
                Global.E4 + "TEXT," +
                Global.E4_1 + "TEXT," +
                Global.E4_2 + "TEXT," +
                Global.E4_3 + "TEXT," +
                Global.E4_4 + "TEXT," +
                Global.E4_5 + "TEXT," +
                Global.E4_6 + "TEXT," +
                Global.E4_7 + "TEXT," +
                Global.E4_8 + "TEXT," +
                Global.E4_9 + "TEXT," +
                Global.E4_10 + "TEXT," +
                Global.E4_11 + "TEXT," +
                Global.E4_12 + "TEXT," +
                Global.E4_13 + "TEXT," +
                Global.E5 + "TEXT," +
                Global.E6 + "TEXT," +
                Global.E7 + "TEXT," +
                Global.E8 + "TEXT," +
                Global.E9 + "TEXT," +
                Global.E10 + "TEXT," +
                Global.E11 + "TEXT," +
                Global.F1 + "TEXT," +
                Global.F2 + "TEXT," +
                Global.F3 + "TEXT," +
                Global.F4 + "TEXT," +
                Global.F5 + "TEXT," +
                Global.F6 + "TEXT," +
                Global.F7a + "TEXT," +
                Global.F7b + "TEXT," +
                Global.F8 + "TEXT," +
                Global.F9 + "TEXT" +

                ')';

        return query;
    }
}
