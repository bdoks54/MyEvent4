package kr.co.my.myevent4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button birthDatePicker, specifiedDatePicker;
    //Button showbio;
    int b = 10;
    EditText txtbirthdate, txtthedate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showComponent();
    }
    public void showComponent() {
        //layout에 있는 컴포넌트 객체 생성
        birthDatePicker = findViewById(R.id.birthDatePicker);
        specifiedDatePicker = findViewById(R.id.specifiedDatePicker);
        final Button showbio = findViewById(R.id.showbio);
        txtbirthdate = findViewById(R.id.txtbirthdate);
        txtthedate = findViewById(R.id.txtthedate);

        //int a = 15; //지역변수는 Nested에서 직접 사용할 수 없다.
        final String temps = "Hello";

        //중첩, 내부 클래스, MainActivity안에 선언 - 멤버처럼 사용
        View.OnClickListener omylietener  = new View.OnClickListener(){
            //인터페이스인 자신이 구현
            @Override
            public void onClick(View v){
                if(v==birthDatePicker){
                    txtbirthdate.setText(temps); //final 지역 참조타입 접근 가능
                    //MainActivity.this.txtbirthdate.setText(temps);
                    //txtbirthdate.setText(s+" "+a); // 지역 기본타입 접근 불가
                    //txtbirthdate.setText(s+" "+b); // 멤버 접근 가능
                }
            }

        };
        birthDatePicker.setOnClickListener(omylietener);
        //익명 중첩, 내부 클래스, MainActivity 안에 선언 - 멤버처럼 사용
        specifiedDatePicker.setOnClickListener(new View.OnClickListener(){
            //익명 내부 클래스
            @Override
            public void onClick(View v){
                if(v==specifiedDatePicker){
                    txtthedate.setText(new Date().toString());
                }
            }
        });
        //showbio가 생성되어있다는 보장이 없음
        if(showbio!=null)
            showbio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(v==showbio){
                        String st = String.format("%s! 오늘은 %s다.",txtbirthdate.getText()
                        ,txtthedate.getText());
                        txtbirthdate.setText("");
                        txtthedate.setText("");
                        Toast.makeText(getBaseContext(),st,Toast.LENGTH_LONG).show();
                    }
                }
            });
    }
}