package data;

import com.irfansyed.umeedenau.validation.Global;

public class activity3 {

    public static String TABLE_NAME = "activity3";

    public static String getCreateQuery() {
        String query;
        query = "CREATE TABLE '" + TABLE_NAME + "' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'pk_pk' INTEGER,   " +


                Global.G1_1 + " TEXT," +
                Global.G2_1 + " TEXT," +
                Global.G3_1 + " TEXT," +
                Global.G4_1 + " TEXT," +
                Global.G5_1 + " TEXT," +
                Global.G6_1 + " TEXT," +
                Global.G6_1_1 + " TEXT," +
                Global.G7_1 + " TEXT," +
                Global.G8_1 + " TEXT," +
                Global.H1_1 + " TEXT," +
                Global.H2_1 + " TEXT," +
                Global.H3_1 + " TEXT," +
                Global.H4_1 + " TEXT," +
                Global.H5_1 + " TEXT," +
                Global.H6_1 + " TEXT," +
                Global.H7_1 + " TEXT," +
                Global.H8_1 + " TEXT," +
                Global.I1_1 + " TEXT," +
                Global.I2_1 + " TEXT," +
                Global.I3_1 + " TEXT," +
                Global.I4_1 + " TEXT," +
                Global.J1_1 + " TEXT," +
                Global.J2_1 + " TEXT," +
                Global.J3_1 + " TEXT," +
                Global.J4_1 + " TEXT," +
                Global.J5_1 + " TEXT," +
                Global.J6_1 + " TEXT," +
                Global.J7_1 + " TEXT," +
                Global.K1_1 + " TEXT," +
                Global.K2_1 + " TEXT," +
                Global.K3_1 + " TEXT," +
                Global.K4_1 + " TEXT," +
                Global.K5_1 + " TEXT," +
                Global.K6_1 + " TEXT," +
                Global.K7_1 + " TEXT," +


                Global.G1_2 + " TEXT," +
                Global.G2_2 + " TEXT," +
                Global.G3_2 + " TEXT," +
                Global.G4_2 + " TEXT," +
                Global.G5_2 + " TEXT," +
                Global.G6_2 + " TEXT," +
                Global.G6_1_2 + " TEXT," +
                Global.G7_2 + " TEXT," +
                Global.G8_2 + " TEXT," +
                Global.H1_2 + " TEXT," +
                Global.H2_2 + " TEXT," +
                Global.H3_2 + " TEXT," +
                Global.H4_2 + " TEXT," +
                Global.H5_2 + " TEXT," +
                Global.H6_2 + " TEXT," +
                Global.H7_2 + " TEXT," +
                Global.H8_2 + " TEXT," +
                Global.I1_2 + " TEXT," +
                Global.I2_2 + " TEXT," +
                Global.I3_2 + " TEXT," +
                Global.I4_2 + " TEXT," +
                Global.J1_2 + " TEXT," +
                Global.J2_2 + " TEXT," +
                Global.J3_2 + " TEXT," +
                Global.J4_2 + " TEXT," +
                Global.J5_2 + " TEXT," +
                Global.J6_2 + " TEXT," +
                Global.J7_2 + " TEXT," +
                Global.K1_2 + " TEXT," +
                Global.K2_2 + " TEXT," +
                Global.K3_2 + " TEXT," +
                Global.K4_2 + " TEXT," +
                Global.K5_2 + " TEXT," +
                Global.K6_2 + " TEXT," +
                Global.K7_2 + " TEXT," +

                Global.G1_3 + " TEXT," +
                Global.G2_3 + " TEXT," +
                Global.G3_3 + " TEXT," +
                Global.G4_3 + " TEXT," +
                Global.G5_3 + " TEXT," +
                Global.G6_3 + " TEXT," +
                Global.G6_1_3 + " TEXT," +
                Global.G7_3 + " TEXT," +
                Global.G8_3 + " TEXT," +
                Global.H1_3 + " TEXT," +
                Global.H2_3 + " TEXT," +
                Global.H3_3 + " TEXT," +
                Global.H4_3 + " TEXT," +
                Global.H5_3 + " TEXT," +
                Global.H6_3 + " TEXT," +
                Global.H7_3 + " TEXT," +
                Global.H8_3 + " TEXT," +
                Global.I1_3 + " TEXT," +
                Global.I2_3 + " TEXT," +
                Global.I3_3 + " TEXT," +
                Global.I4_3 + " TEXT," +
                Global.J1_3 + " TEXT," +
                Global.J2_3 + " TEXT," +
                Global.J3_3 + " TEXT," +
                Global.J4_3 + " TEXT," +
                Global.J5_3 + " TEXT," +
                Global.J6_3 + " TEXT," +
                Global.J7_3 + " TEXT," +
                Global.K1_3 + " TEXT," +
                Global.K2_3 + " TEXT," +
                Global.K3_3 + " TEXT," +
                Global.K4_3 + " TEXT," +
                Global.K5_3 + " TEXT," +
                Global.K6_3 + " TEXT," +
                Global.K7_3 + " TEXT," +


                Global.G1_rem + " TEXT," +
                Global.G2_rem + " TEXT," +
                Global.G3_rem + " TEXT," +
                Global.G4_rem + " TEXT," +
                Global.G5_rem + " TEXT," +
                Global.G6_rem + " TEXT," +
                Global.G6_1_rem + " TEXT," +
                Global.G7_rem + " TEXT," +
                Global.G8_rem + " TEXT," +
                Global.H1_rem + " TEXT," +
                Global.H2_rem + " TEXT," +
                Global.H3_rem + " TEXT," +
                Global.H4_rem + " TEXT," +
                Global.H5_rem + " TEXT," +
                Global.H6_rem + " TEXT," +
                Global.H7_rem + " TEXT," +
                Global.H8_rem + " TEXT," +
                Global.I1_rem + " TEXT," +
                Global.I2_rem + " TEXT," +
                Global.I3_rem + " TEXT," +
                Global.I4_rem + " TEXT," +
                Global.J1_rem + " TEXT," +
                Global.J2_rem + " TEXT," +
                Global.J3_rem + " TEXT," +
                Global.J4_rem + " TEXT," +
                Global.J5_rem + " TEXT," +
                Global.J6_rem + " TEXT," +
                Global.J7_rem + " TEXT," +
                Global.K1_rem + " TEXT," +
                Global.K2_rem + " TEXT," +
                Global.K3_rem + " TEXT," +
                Global.K4_rem + " TEXT," +
                Global.K5_rem + " TEXT," +
                Global.K6_rem + " TEXT," +
                Global.K7_rem + " TEXT," +


                Global.G3_2_1 + " TEXT," +
                Global.G3_2_2 + " TEXT," +
                Global.G3_2_3 + " TEXT," +
                Global.G3_2_rem + " TEXT," +
                Global.G9_1 + " TEXT," +
                Global.G9_2 + " TEXT," +
                Global.G9_3 + " TEXT," +
                Global.G9_rem + " TEXT," +
                Global.H1_2_1 + " TEXT," +
                Global.H1_2_2 + " TEXT," +
                Global.H1_2_3 + " TEXT," +
                Global.H1_2_rem + " TEXT," +
                Global.H4_1_1 + " TEXT," +
                Global.H4_1_2 + " TEXT," +
                Global.H4_1_3 + " TEXT," +
                Global.H4_1_rem + " TEXT," +
                Global.H4_2_1 + " TEXT," +
                Global.H4_2_2 + " TEXT," +
                Global.H4_2_3 + " TEXT," +
                Global.H4_2_rem + " TEXT," +
                Global.H8_2_1 + " TEXT," +
                Global.H8_2_2 + " TEXT," +
                Global.H8_2_3 + " TEXT," +
                Global.H8_2_rem + " TEXT," +



        Global.interview_status + " TEXT" +
                ')';

        return query;
    }
}
