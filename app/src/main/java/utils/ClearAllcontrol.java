package utils;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import java.util.List;

/**
 * Created by irfansyed on 3/28/2017.
 */

public class ClearAllcontrol {



    public static void ClearAll(LinearLayout lv) {

        /// Checkbox Celar*************************************

        try {

            for (int i = 0, count = lv.getChildCount(); i < count; ++i) {
                View view = lv.getChildAt(i);
                if (view instanceof CheckBox) {
                    ((CheckBox) view).setChecked(false);
                }
                else   if (view instanceof RadioGroup) {
                    ((RadioGroup) view).clearCheck();
                }

                else  if (view instanceof EditText) {
                    ((EditText) view).setText("");
                }

            }
        }
        catch (Exception e) {

        }




    }



    public static void ClearAll_GoneAll(List<LinearLayout> lvv,Boolean show) {

        /// Checkbox Celar*************************************

        try {


            for(LinearLayout lv:lvv) {

                for (int i = 0, count = lv.getChildCount(); i < count; ++i) {
                    View view = lv.getChildAt(i);
                    if (view instanceof CheckBox) {
                        ((CheckBox) view).setChecked(false);
                    } else if (view instanceof RadioGroup) {
                        ((RadioGroup) view).clearCheck();
                    } else if (view instanceof EditText) {
                        ((EditText) view).setText("");
                    }

                }
                if(show==false) {
                    lv.setVisibility(View.GONE);
                }
                else
                {
                    lv.setVisibility(View.VISIBLE);
                }
            }
        }
        catch (Exception e) {

        }




    }
}
