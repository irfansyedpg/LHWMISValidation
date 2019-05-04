package data;

import com.irfansyed.umeedenau.validation.Global;


public class TableLoginData {
    public static String TABLE_NAME = "TableLoginData";

    public static String getCreateQuery() {
        String query;
        query = "CREATE TABLE '" + TABLE_NAME + "' ('id' INTEGER PRIMARY KEY AUTOINCREMENT,    " +


               "District  Text, "+
               "Tehsil  Text, "+
               "Reporting_LHS  Text, "+
               "Reporting_HF  Text, "+
               "LHW_Name  Text, "+
               "LHW_Ids "+

                ')';


        return query;
    }
}
