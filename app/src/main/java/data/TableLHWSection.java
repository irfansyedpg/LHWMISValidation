package data;

import com.irfansyed.umeedenau.validation.Global;


public class TableLHWSection {
    public static String TABLE_NAME = "TableLHWSection";

    public static String getCreateQuery() {
        String query;
        query = "CREATE TABLE '" + TABLE_NAME + "' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'FK_id' INTEGER,   " +


                Global.lhwf1a1+"  Text, "+
                Global.lhwf1a2+"  Text, "+
                Global.lhwf1a3+"  Text, "+
                Global.lhwf1a4+"  Text "+




                ')';


        return query;
    }
}
