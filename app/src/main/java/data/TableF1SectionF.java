package data;

import com.irfansyed.umeedenau.validation.Global;


public class TableF1SectionF {
    public static String TABLE_NAME = "TableF1SectionF";

    public static String getCreateQuery() {
        String query;
        query = "CREATE TABLE '" + TABLE_NAME + "' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'FK_id' INTEGER,   " +


                Global.LhwSectionPKId+"  Text, "+
                "Status  Text, "+
                Global.lhwf1f1+"  Text, "+
                Global.lhwf1f2+"  Text, "+
                Global.lhwf1f3+"  Text, "+
                Global.lhwf1f4+"  Text, "+
                Global.lhwf1f5+"  Text, "+
                Global.lhwf1f6 +"  Text, "+
                Global.lhwf1f7+"  Text, "+
                Global.lhwf1f8+"  Text, "+
                Global.lhwf1f9+"  Text, "+
                Global.lhwf1f10+"  Text "+







                ')';


        return query;
    }
}
