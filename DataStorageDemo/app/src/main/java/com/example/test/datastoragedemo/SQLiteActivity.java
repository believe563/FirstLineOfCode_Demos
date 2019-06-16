package com.example.test.datastoragedemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.test.datastoragedemo.utils.MyDatabaseHelper;

/**
 * demo3-SQLite数据库增删改查操作
 */
public class SQLiteActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btcreate;
    private Button btupgrade;
    private Button btadddata;
    private Button btupdatedata;
    private Button btdeldata;
    private Button btquerydata;
    private Button btstraightSQL;

    private MyDatabaseHelper dbHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        initView();

        setListener();


    }

    /**
     * 初始化点击事件
     */
    private void setListener() {
        btcreate.setOnClickListener(this);
        btupgrade.setOnClickListener(this);
        btadddata.setOnClickListener(this);
        btupdatedata.setOnClickListener(this);
        btdeldata.setOnClickListener(this);
        btquerydata.setOnClickListener(this);
        btstraightSQL.setOnClickListener(this);
    }

    /**
     * 初始化按钮
     */
    private void initView() {
        btcreate = findViewById(R.id.bt_create_database);
        btupgrade = findViewById(R.id.bt_upgrade_database);
        btadddata = findViewById(R.id.bt_add_data);
        btupdatedata = findViewById(R.id.bt_update_data);
        btdeldata = findViewById(R.id.bt_del_data);
        btquerydata = findViewById(R.id.bt_query_data);
        btstraightSQL = findViewById(R.id.bt_straight_Database);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_create_database:
//              初次创建时，没有该数据库BookStore.db，会创建并调用onCreate()方法，book表也得到创建
                dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 1);
                db=dbHelper.getWritableDatabase();
                break;
            case R.id.bt_upgrade_database:
//              如果想让DBHelper中的onUpgrade方法执行，就需要将版本号改为初次设置的比1大的数
                dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);
                db=dbHelper.getWritableDatabase();
                break;
            case R.id.bt_add_data:

                dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);
                db=dbHelper.getWritableDatabase();
//                插入数据
                insertValues();
                break;
            case R.id.bt_update_data:
                dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);
                db=dbHelper.getWritableDatabase();
                updateValue();
                break;
            case R.id.bt_del_data:
                dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);
                db=dbHelper.getWritableDatabase();

                db.delete("Book","id=?",new String[]{"2"});
                break;
            case R.id.bt_query_data:
                dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);
                db=dbHelper.getWritableDatabase();

                queryValues();
                break;
            case R.id.bt_straight_Database:
                dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);
                db=dbHelper.getWritableDatabase();

                straightOprations();
                break;
            default:
                break;
        }
    }

    private void straightOprations() {
//        添加数据的方法
        db.execSQL("insert into Book(name,author,pages,price) values(?,?,?,?)", new String[]{"The Da Vinci Code", "Dan Brown", "454", "16.96"});
        db.execSQL("insert into Book(name,author,pages,price) values(?,?,?,?)", new String[]{"The Da Vinci Code", "Dan Brown", "454", "16.96"});

//        更新数据的方法
        db.execSQL("update Book set price=? where name=?", new String[]{"10.98", "The Da Vinci Code"});

//        删除数据的方法
        db.execSQL("delete from Book where id=?", new String[]{"2"});

//        查询数据的方法
        db.rawQuery("select * from Book", null);
    }

    /**
     * 最短的参数有7个
     */
    private void queryValues() {
//        查询Book表中的所有数据
        Cursor cursor = db.query("Book", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
//                遍历Cursor对象，取出并打印
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String author = cursor.getString(cursor.getColumnIndex("author"));
                int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                double prices = cursor.getDouble(cursor.getColumnIndex("price"));

                String TAG = "MainActivity";
                Log.d(TAG, "book name is " +name);
                Log.d(TAG, "book author is " +author);
                Log.d(TAG, "book pages is " +pages);
                Log.d(TAG, "book price is " +prices);

            } while (cursor.moveToNext());
        }
    }

    private void updateValue() {
        ContentValues values = new ContentValues();
        values.put("price", 10.99);
        db.update("Book",values,"id=?",new String[]{"1"});
    }

    private void insertValues() {
        ContentValues values = new ContentValues();
        values.put("name","First Lines Of Code");
        values.put("author","Guo lin");
        values.put("pages",450);
        values.put("price",16.96);
//        第二个参数：在未指定添加数据的情况下给某些可为空的列赋值NULL
        db.insert("Book", null, values);
//        如果需要装第二条数据，用如下语句清空values中的数据
//        values.clear();
    }
}
