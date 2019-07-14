package com.example.test.datastoragedemo;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.test.datastoragedemo.beans.Book;

import org.litepal.LitePal;
import org.litepal.LitePalDB;
import org.litepal.crud.LitePalSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

/**
 * demo5-LitePal操作数据库
 * <p>
 * 该Activity作为启动Activity时，需要将Application的name设置为：org.litepal.LitePalApplication
 * (原先没有设置name属性)
 */
public class LitePalActivity extends Activity implements View.OnClickListener {

    private Button lp_create;
    private Button lp_upgrade;
    private Button lp_add;
    private Button lp_update;
    private Button lp_del;
    private Button lp_query;
    public final String TAG = "String";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lite_pal);
        initView();
        setClick();

    }

    private void setClick() {
        lp_create.setOnClickListener(this);
        lp_upgrade.setOnClickListener(this);
        lp_add.setOnClickListener(this);
        lp_update.setOnClickListener(this);
        lp_del.setOnClickListener(this);
        lp_query.setOnClickListener(this);
    }

    private void initView() {
        lp_create = findViewById(R.id.lp_create);
        lp_upgrade = findViewById(R.id.lp_upgrade);
        lp_add = findViewById(R.id.lp_add);
        lp_update = findViewById(R.id.lp_update);
        lp_del = findViewById(R.id.lp_del);
        lp_query = findViewById(R.id.lp_query);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lp_create:
                // 点击按钮时，数据库自动创建完成
                Connector.getDatabase();
                break;
            case R.id.lp_upgrade:
                // upgrade只需要添加bean类和将其添加到
                break;
            case R.id.lp_add:
                // 向数据库中添加一行数据
                Book book = new Book();
                book.setId(123456);
                book.setName("第一行代码");
                book.setPages(30);
                book.setPrice(79.00);
                book.setPress("出版社1");
                book.setAuthor("郭霖");
                book.save();

                break;
            case R.id.lp_update:
//                // 1-更新单个属性，对已存储的对象进行操作
//                Book book1 = new Book();
//                book1.setId(123457);
//                book1.setName("第二行代码");
//                book1.setPages(30);
//                book1.setPrice(79.00);
//                book1.setPress("出版社1");
//                book1.setAuthor("郭霖");
//                book1.save();
//                // 更新了price
//                book1.setPrice(80);
//                book1.save();

                // 2-更灵活的更新方式
                Book book1 = new Book();

                // 更新的属性
                book1.setPrice(79);
                book1.setPress("出版社2");

                // 该方法中指定约束条件
                book1.updateAll("name = ? and author = ?", "第一行代码", "郭霖");

                // 3-为字段设置默认值
//                Book book1=new Book();
//                book1.setToDefault("pages");
//                book1.updateAll();
                break;
            case R.id.lp_del:
                // 方法1-调用已存储对象的delete方法，在此之前先查询数据库中存在的条目
                List<Book> books0 = LitePal.findAll(Book.class);
                for (Book book0 : books0) {
                    book0.delete();
                }

                // 方法2-用LitePal调用deleteAll方法
                // 原先的DataSupport已弃用，改用LitePal调用deleteAll方法
                LitePal.deleteAll(Book.class, "price > ?", "15");
                break;
            case R.id.lp_query:
                // 1-查询所有--无条件查询
                List<Book> books = LitePal.findAll(Book.class);

                for (Book book3 : books) {
                    Log.d(TAG, "book name is " + book3.getName());
                    Log.d(TAG, "book author is " + book3.getAuthor());
                    Log.d(TAG, "book pages is " + book3.getPages());
                    Log.d(TAG, "book price is " + book3.getPrice());
                    Log.d(TAG, "book press is " + book3.getPress());
                }

                // 查询表中的第一条数据
                Book firstBook = LitePal.findFirst(Book.class);

                // 查询表中的最后一条数据
                Book lastBook = LitePal.findLast(Book.class);

                // 2-各种连缀查询功能--有条件查询，对以下几种功能进行连缀组合
                // 查询某几列
                List books1 = LitePal.select("price, press").find(Book.class);

                // 指定查询条件
                List books2 = LitePal.where("pages > ?", "400").find(Book.class);

                // 指定结果的排序方式
                List books3 = LitePal.order("price desc").find(Book.class);

                // 指定查询的数量
                List books4 = LitePal.limit(3).find(Book.class);

                // 指定查询结果的偏移量
                List books5 = LitePal.limit(3).offset(0).find(Book.class);

                // eg. 一个连缀的例子：
                List bookExample = LitePal.where("price > ?", "30").limit(3).find(Book.class);

                // 3-用原生的SQL来查询
                Cursor c = LitePal.findBySQL("select * from Book where pages > ? and price < ?", "20", "400");
                break;
        }
    }
}
