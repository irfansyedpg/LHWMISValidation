package data;

import com.irfansyed.umeedenau.validation.Global;

public class validationactivity2 {

    public static String TABLE_NAME = "activity1";

    public static String getCreateQuery() {
        String query;
        query = "CREATE TABLE '" + TABLE_NAME + "' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'pk_pk' INTEGER,   " +

                Global.A1 + " TEXT," +
                Global.A2 + " TEXT," +
                Global.B1 + " TEXT," +
                Global.B2 + " TEXT," +
                Global.B3 + " TEXT," +
                Global.B4 + " TEXT," +
                Global.B5 + " TEXT," +
                Global.B5_d + " TEXT," +
                Global.B6 + " TEXT," +
                Global.B7 + " TEXT," +
                Global.C1 + " TEXT," +
                Global.C2 + " TEXT," +
                Global.C3 + " TEXT," +
                Global.C4 + " TEXT," +
                Global.C5 + " TEXT," +
                Global.D1 + " TEXT," +
                Global.D2 + " TEXT," +
                Global.D2_d + " TEXT," +
                Global.D3 + " TEXT," +
                Global.D4 + " TEXT," +
                Global.D5 + " TEXT," +
                Global.D6 + " TEXT," +
                Global.E1 + " TEXT," +
                Global.E2 + " TEXT," +
                Global.E3 + " TEXT," +
                Global.E4 + " TEXT," +
                Global.E4_1 + " TEXT," +
                Global.E4_2 + " TEXT," +
                Global.E4_3 + " TEXT," +
                Global.E4_4 + " TEXT," +
                Global.E4_5 + " TEXT," +
                Global.E4_6 + " TEXT," +
                Global.E4_7 + " TEXT," +
                Global.E4_8 + " TEXT," +
                Global.E4_9 + " TEXT," +
                Global.E4_10 + " TEXT," +
                Global.E4_11 + " TEXT," +
                Global.E4_12 + " TEXT," +
                Global.E4_13 + " TEXT," +
                Global.E5 + " TEXT," +
                Global.E6 + " TEXT," +
                Global.E7 + " TEXT," +
                Global.E8 + " TEXT," +
                Global.E9 + " TEXT," +
                Global.E10 + " TEXT," +
                Global.E11 + " TEXT," +
                Global.F1 + " TEXT," +
                Global.F2 + " TEXT," +
                Global.F3 + " TEXT," +
                Global.F4 + " TEXT," +
                Global.F5 + " TEXT," +
                Global.F6 + " TEXT," +
                Global.F7a + " TEXT," +
                Global.F7b + " TEXT," +
                Global.F8 + " TEXT," +
                Global.F9 + " TEXT," +


                Global.act_gps_lat + " TEXT, " +
                Global.act_gps_long + " TEXT, " +
                Global.V_H_B1 + " TEXT, " +
                Global.V_V_B1 + " TEXT, " +
                Global.V_R_B1 + " TEXT, " +
                Global.V_H_B2 + " TEXT, " +
                Global.V_V_B2 + " TEXT, " +
                Global.V_R_B2 + " TEXT, " +
                Global.V_H_B3 + " TEXT, " +
                Global.V_V_B3 + " TEXT, " +
                Global.V_R_B3 + " TEXT, " +
                Global.V_H_B4 + " TEXT, " +
                Global.V_V_B4 + " TEXT, " +
                Global.V_R_B4 + " TEXT, " +
                Global.V_H_B5 + " TEXT, " +
                Global.V_V_B5 + " TEXT, " +
                Global.V_R_B5 + " TEXT, " +
                Global.V_H_B6 + " TEXT, " +
                Global.V_V_B6 + " TEXT, " +
                Global.V_R_B6 + " TEXT, " +
                Global.V_H_B7 + " TEXT, " +
                Global.V_V_B7 + " TEXT, " +
                Global.V_R_B7 + " TEXT, " +
                Global.V_H_C1 + " TEXT, " +
                Global.V_V_C1 + " TEXT, " +
                Global.V_R_C1 + " TEXT, " +
                Global.V_H_C2 + " TEXT, " +
                Global.V_V_C2 + " TEXT, " +
                Global.V_R_C2 + " TEXT, " +
                Global.V_H_C3 + " TEXT, " +
                Global.V_V_C3 + " TEXT, " +
                Global.V_R_C3 + " TEXT, " +
                Global.V_H_C4 + " TEXT, " +
                Global.V_V_C4 + " TEXT, " +
                Global.V_R_C4 + " TEXT, " +
                Global.V_H_C5 + " TEXT, " +
                Global.V_V_C5 + " TEXT, " +
                Global.V_R_C5 + " TEXT, " +
                Global.V_H_D1 + " TEXT, " +
                Global.V_V_D1 + " TEXT, " +
                Global.V_R_D1 + " TEXT, " +
                Global.V_H_D2 + " TEXT, " +
                Global.V_V_D2 + " TEXT, " +
                Global.V_R_D2 + " TEXT, " +
                Global.V_H_D3 + " TEXT, " +
                Global.V_V_D3 + " TEXT, " +
                Global.V_R_D3 + " TEXT, " +
                Global.V_H_D4 + " TEXT, " +
                Global.V_V_D4 + " TEXT, " +
                Global.V_R_D4 + " TEXT, " +
                Global.V_H_D5 + " TEXT, " +
                Global.V_V_D5 + " TEXT, " +
                Global.V_R_D5 + " TEXT, " +
                Global.V_H_D6 + " TEXT, " +
                Global.V_V_D6 + " TEXT, " +
                Global.V_R_D6 + " TEXT, " +
                Global.V_H_E1 + " TEXT, " +
                Global.V_V_E1 + " TEXT, " +
                Global.V_R_E1 + " TEXT, " +
                Global.V_H_E2 + " TEXT, " +
                Global.V_V_E2 + " TEXT, " +
                Global.V_R_E2 + " TEXT, " +
                Global.V_H_E3 + " TEXT, " +
                Global.V_V_E3 + " TEXT, " +
                Global.V_R_E3 + " TEXT, " +
                Global.V_H_E4 + " TEXT, " +
                Global.V_V_E4 + " TEXT, " +
                Global.V_R_E4 + " TEXT, " +
                Global.V_H_E4_1 + " TEXT, " +
                Global.V_V_E4_1 + " TEXT, " +
                Global.V_R_E4_1 + " TEXT, " +
                Global.V_H_E4_2 + " TEXT, " +
                Global.V_V_E4_2 + " TEXT, " +
                Global.V_R_E4_2 + " TEXT, " +
                Global.V_H_E4_3 + " TEXT, " +
                Global.V_V_E4_3 + " TEXT, " +
                Global.V_R_E4_3 + " TEXT, " +
                Global.V_H_E4_4 + " TEXT, " +
                Global.V_V_E4_4 + " TEXT, " +
                Global.V_R_E4_4 + " TEXT, " +
                Global.V_H_E4_5 + " TEXT, " +
                Global.V_V_E4_5 + " TEXT, " +
                Global.V_R_E4_5 + " TEXT, " +
                Global.V_H_E4_6 + " TEXT, " +
                Global.V_V_E4_6 + " TEXT, " +
                Global.V_R_E4_6 + " TEXT, " +
                Global.V_H_E4_7 + " TEXT, " +
                Global.V_V_E4_7 + " TEXT, " +
                Global.V_R_E4_7 + " TEXT, " +
                Global.V_H_E4_8 + " TEXT, " +
                Global.V_V_E4_8 + " TEXT, " +
                Global.V_R_E4_8 + " TEXT, " +
                Global.V_H_E4_9 + " TEXT, " +
                Global.V_V_E4_9 + " TEXT, " +
                Global.V_R_E4_9 + " TEXT, " +
                Global.V_H_E4_10 + " TEXT, " +
                Global.V_V_E4_10 + " TEXT, " +
                Global.V_R_E4_10 + " TEXT, " +
                Global.V_H_E4_11 + " TEXT, " +
                Global.V_V_E4_11 + " TEXT, " +
                Global.V_R_E4_11 + " TEXT, " +
                Global.V_H_E4_12 + " TEXT, " +
                Global.V_V_E4_12 + " TEXT, " +
                Global.V_R_E4_12 + " TEXT, " +
                Global.V_H_E4_13 + " TEXT, " +
                Global.V_V_E4_13 + " TEXT, " +
                Global.V_R_E4_13 + " TEXT, " +
                Global.V_H_E5 + " TEXT, " +
                Global.V_V_E5 + " TEXT, " +
                Global.V_R_E5 + " TEXT, " +
                Global.V_H_E6 + " TEXT, " +
                Global.V_V_E6 + " TEXT, " +
                Global.V_R_E6 + " TEXT, " +
                Global.V_H_E7 + " TEXT, " +
                Global.V_V_E7 + " TEXT, " +
                Global.V_R_E7 + " TEXT, " +
                Global.V_H_E8 + " TEXT, " +
                Global.V_V_E8 + " TEXT, " +
                Global.V_R_E8 + " TEXT, " +
                Global.V_H_E9 + " TEXT, " +
                Global.V_V_E9 + " TEXT, " +
                Global.V_R_E9 + " TEXT, " +
                Global.V_H_E10 + " TEXT, " +
                Global.V_V_E10 + " TEXT, " +
                Global.V_R_E10 + " TEXT, " +
                Global.V_H_E11 + " TEXT, " +
                Global.V_V_E11 + " TEXT, " +
                Global.V_R_E11 + " TEXT, " +
                Global.V_H_F1 + " TEXT, " +
                Global.V_V_F1 + " TEXT, " +
                Global.V_R_F1 + " TEXT, " +
                Global.V_H_F2 + " TEXT, " +
                Global.V_V_F2 + " TEXT, " +
                Global.V_R_F2 + " TEXT, " +
                Global.V_H_F3 + " TEXT, " +
                Global.V_V_F3 + " TEXT, " +
                Global.V_R_F3 + " TEXT, " +
                Global.V_H_F4 + " TEXT, " +
                Global.V_V_F4 + " TEXT, " +
                Global.V_R_F4 + " TEXT, " +
                Global.V_H_F5 + " TEXT, " +
                Global.V_V_F5 + " TEXT, " +
                Global.V_R_F5 + " TEXT, " +
                Global.V_H_F6 + " TEXT, " +
                Global.V_V_F6 + " TEXT, " +
                Global.V_R_F6 + " TEXT, " +
                Global.V_H_F7a + " TEXT, " +
                Global.V_V_F7a + " TEXT, " +
                Global.V_R_F7a + " TEXT, " +
                Global.V_H_F7b + " TEXT, " +
                Global.V_V_F7b + " TEXT, " +
                Global.V_R_F7b + " TEXT, " +
                Global.V_H_F8 + " TEXT, " +
                Global.V_V_F8 + " TEXT, " +
                Global.V_R_F8 + " TEXT, " +
                Global.V_H_F9 + " TEXT, " +
                Global.V_V_F9 + " TEXT, " +
                Global.V_R_F9 + " TEXT, " +


                Global.interview_status + " TEXT" +
                        ')';

        return query;
    }
}












