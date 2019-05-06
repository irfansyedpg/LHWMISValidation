package com.irfansyed.umeedenau.validation;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.irfansyed.validation.ClearClass;

import static com.irfansyed.validation.ValidatorClass.EmptyRadioButton;
import static com.irfansyed.validation.ValidatorClass.EmptySpinner;
import static com.irfansyed.validation.ValidatorClass.getIDComponent;

/**
 * Created by irfansyed on 3/28/2017.
 */

public class Gothrough {



    public static boolean IamHiden(LinearLayout lv) {








        /// Checkbox Celar*************************************

      try {


            if (lv.getVisibility() != View.VISIBLE)
            {
                return true;


            }

            for (int i = 0, count = lv.getChildCount(); i < count; ++i) {
                View view = lv.getChildAt(i);
                if (view instanceof CheckBox) {
                   if (((CheckBox) view).isChecked())
                    {
                        return true;
                    }

                    ((CheckBox) view).setError(null);
                    if(i==count-1)
                    {
                        ((CheckBox) view).setError("Select Atleast One");
                    }
                }
                else   if (view instanceof RadioGroup)
                {
                   if(((RadioGroup) view).getCheckedRadioButtonId() != -1)

                    //if(((RadioButton) view).isChecked())
                   {

                       return true;
                   }


                }

                else  if (view instanceof EditText) {
                   if(((EditText) view).getText().length()>0)
                   {
                       return true;
                   }

                    ((EditText) view).setError(null);
                    if(i==count-1)
                    {
                        ((EditText) view).setError("Enter Text");
                    }

                }

            }
        }
        catch (Exception e) {

      //      return true;

        }


        lv.requestFocus();


        return false;




    }



     static int  tricker=0;

    public static boolean IamHiden_special(LinearLayout lv) {

        /// Checkbox Celar*************************************

        try {


            if (lv.getVisibility() != View.VISIBLE)
            {
                return true;


            }

            for (int i = 0, count = lv.getChildCount(); i < count; ++i) {
                View view = lv.getChildAt(i);
                if (view instanceof CheckBox) {
                    if (((CheckBox) view).isChecked())
                    {
                        return true;
                    }

                    ((CheckBox) view).setError(null);
                    if(i==count-1)
                    {
                        ((CheckBox) view).setError("Select Atleast One");
                    }
                }
                else   if (view instanceof RadioGroup)
                {
                    if(((RadioGroup) view).getCheckedRadioButtonId() != -1)

                        tricker++;
                    //if(((RadioButton) view).isChecked())

                        if(tricker==2 )
                    {

                           tricker=0;
                            return true;

                    }


                }

                else  if (view instanceof EditText) {
                    if(((EditText) view).getText().length()>0)
                    {
                        return true;
                    }

                    ((EditText) view).setError(null);
                    if(i==count-1)
                    {
                        ((EditText) view).setError("Enter Text");
                    }

                }

            }
        }
        catch (Exception e) {

            //      return true;

        }


        lv.requestFocus();


        return false;




    }




}
