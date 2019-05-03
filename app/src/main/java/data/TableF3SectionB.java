package data;

import com.irfansyed.umeedenau.validation.Global;


public class TableF3SectionB {
    public static String TABLE_NAME = "TableF3SectionB";

    public static String getCreateQuery() {
        String query;
        query = "CREATE TABLE '" + TABLE_NAME + "' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'FK_id' INTEGER,   " +






                Global.lhwf3b1+"  Text, "+
                Global.lhwf3b2+"  Text, "+
                Global.lhwf3b3+"  Text, "+
                Global.lhwf3b4+"  Text, "+
                Global.lhwf3b5+"  Text, "+
                Global.lhwf3b6+"  Text "+







                ')';


        return query;
    }
}
