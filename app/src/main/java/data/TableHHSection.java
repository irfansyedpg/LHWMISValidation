package data;

import com.irfansyed.umeedenau.validation.Global;


public class TableHHSection {
    public static String TABLE_NAME = "TableHHSection";

    public static String getCreateQuery() {
        String query;
        query = "CREATE TABLE '" + TABLE_NAME + "' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'FK_id' INTEGER,   " +


                Global.lhwf1b1+"  Text, "+
                Global.lhwf1b2+"  Text, "+
                Global.lhwf1b3+"  Text "+





                ')';


        return query;
    }
}
