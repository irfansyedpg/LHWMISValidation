package data;

import com.irfansyed.umeedenau.validation.Global;


public class TableF2SectionC {
    public static String TABLE_NAME = "TableF2SectionC";

    public static String getCreateQuery() {
        String query;
        query = "CREATE TABLE '" + TABLE_NAME + "' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'FK_id' INTEGER,   " +


                Global.lhwf2c2+"  Text, "+
                Global.lhwf2c3+"  Text, "+
                Global.lhwf2c4+"  Text, "+
                Global.lhwf2c5+"  Text, "+
                Global.lhwf2c6+"  Text, "+
                Global.lhwf2c7+"  Text, "+
                Global.lhwf2c8+"  Text, "+
                Global.lhwf2c9+"  Text, "+
                Global.lhwf2c10+"  Text, "+
                Global.lhwf2c11+"  Text"+







                ')';


        return query;
    }
}
