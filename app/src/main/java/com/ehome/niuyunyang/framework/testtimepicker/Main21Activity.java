package com.ehome.niuyunyang.framework.testtimepicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.ehome.niuyunyang.framework.R;
import com.ehome.niuyunyang.nyylib.widget.metaldesign_timepicker.date.DatePickerDialog;
import com.ehome.niuyunyang.nyylib.widget.metaldesign_timepicker.time.RadialPickerLayout;
import com.ehome.niuyunyang.nyylib.widget.metaldesign_timepicker.time.TimePickerDialog;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main21Activity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {
    @BindView(R.id.tv_picktime1)
    TextView tvPicktime1;
    @BindView(R.id.tv_picktime2)
    TextView tvPicktime2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main21);
        ButterKnife.bind(this);
    }


    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth, int yearEnd, int monthOfYearEnd, int dayOfMonthEnd) {
        tvPicktime1.setText("int year, int monthOfYear, int dayOfMonth, int yearEnd, int monthOfYearEnd, int dayOfMonthEnd" + "\n" +
                year + monthOfYear + dayOfMonth + dayOfMonthEnd + monthOfYearEnd + dayOfMonthEnd);
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int hourOfDayEnd, int minuteEnd) {
        tvPicktime2.setText("int hourOfDay, int minute, int hourOfDayEnd, int minuteEnd" + "\n" + hourOfDay + minute + hourOfDayEnd + minuteEnd);
    }

    @OnClick({R.id.tv_picktime1, R.id.tv_picktime2})
    public void onViewClicked(View view) {
        Calendar now = Calendar.getInstance();
        switch (view.getId()) {
            case R.id.tv_picktime1:
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        Main21Activity.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getFragmentManager(), "Datepickerdialog");
                break;
            case R.id.tv_picktime2:
                TimePickerDialog timePickerDialog = TimePickerDialog.newInstance(
                        Main21Activity.this,
                        now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE),
                        true
                );
                timePickerDialog.show(getFragmentManager(),"TimeDatepickerdialog");
                break;
        }
    }
}
