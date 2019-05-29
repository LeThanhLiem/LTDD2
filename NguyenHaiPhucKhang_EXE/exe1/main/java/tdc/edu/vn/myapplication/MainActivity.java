package tdc.edu.vn.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    EditText ed1, ed2;
    Button bt1;
    String value, value1;
    RecyclerView rc;
    RecyclerView.LayoutManager rclm;
    Adapter ad;
    ArrayList<PhepTinh> data = new ArrayList<>();
    String h;
    RadioButton r1,r2,r3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setAdapter();
        setEvent();
    }

    private void setEvent() {

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kiemTra()) return;

                value1 = ed1.getText().toString();
                value = ed2.getText().toString();
                PhepTinh pt = new PhepTinh();
                pt.setTxtSo1("Người viết :" + value1);
                pt.setTxtSo2(value);

                pt.setTxtKQ("Ngày viết : "+ h);
                Toast.makeText(getApplicationContext(), "Đã lưu thành công ! ", Toast.LENGTH_LONG).show();
               if(r1.isChecked()){
                   pt.setAnh(R.drawable.smile);
                   pt.setTxtPhepTinh("Vui");
               }
               else if(r2.isChecked()){
                   pt.setAnh(R.drawable.images);
                   pt.setTxtPhepTinh("Bình Thường");
               }
               else if(r3.isChecked()){
                   pt.setAnh(R.drawable.sad);
                   pt.setTxtPhepTinh("Buồn");
               }
                data.add(pt);
                ad.notifyDataSetChanged();

            }
        });


    }

    private void setControl() {

        tv1 = findViewById(R.id.tv1);
        ed1 = findViewById(R.id.sothu1);
        ed2 = findViewById(R.id.sothu2);
        bt1 = findViewById(R.id.bt1);

        r1 = findViewById(R.id.rdvui);
        r2 = findViewById(R.id.rdbth);
        r3 = findViewById(R.id.rdbuon);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm - dd/MM/yyyy");
         h = sdf.format(new Date());
        tv1.setText("Bây giờ là :" + h);
    }

    public boolean kiemTra() {
        if (ed1.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Nhập tên vào bạn ơi", Toast.LENGTH_LONG).show();
            ed1.requestFocus();
            return true;
        }
        if (ed2.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Nhập nội dung vào bạn ey", Toast.LENGTH_LONG).show();
            ed2.requestFocus();
            return true;
        }

        return false;
    }

    void setAdapter(){
        rc = findViewById(R.id.rv1);
        rclm = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rc.setLayoutManager(rclm);
        ad = new Adapter(this,data,R.layout.listviewitem);
        rc.setAdapter(ad);

    }


}
