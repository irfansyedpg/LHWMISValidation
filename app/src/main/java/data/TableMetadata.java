package data;

import com.irfansyed.umeedenau.validation.Global;


public class TableMetadata {
    public static String TABLE_NAME = "TableMetadata";

    public static String getCreateQuery() {
        String query;
        query = "CREATE TABLE '" + TABLE_NAME + "' ('id' INTEGER PRIMARY KEY AUTOINCREMENT,  " +


                Global.projectname+"  Text, "+
                Global.id+"  Text, "+
                Global.uid+"  Text, "+
                Global.uuid +"  Text, "+
                Global.user+"  Text, "+
                Global.deviceid+"  Text, "+
                Global.devicetagid+"  Text, "+
                Global.appversion+"  Text, "+
                Global.formdate+"  Text, "+
                Global.gpslat+"  Text, "+
                Global.gpslng+"  Text, "+
                Global.gpsacc+"  Text, "+
                Global.gpsdate+"  Text, "+
                Global.gpsaltitude+"  Text, "+
                Global.endtime+"  Text, "+
                Global.istatus+"  Text, "+
                Global.istatus88x+"  Text, "+
                Global.synced+"  Text, "+
                Global.synceddate+"  Text "+









                ')';


        return query;
    }
}
