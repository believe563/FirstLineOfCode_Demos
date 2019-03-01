package com.example.test.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.test.uidemo.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends Activity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        //初始化水果数据
        initFruit();

        //开始使用RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        //LayoutManager用于指定RecyclerView的布局方式，这里指定线性布局，可以实现和ListView类似的效果,
        //如果不指定，界面会一片空白
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //这句是使屏幕变为横向滚动的关键
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter fruitAdapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(fruitAdapter);

    }

    private void initFruit() {
        Fruit apple = new Fruit("apple", R.drawable.apple);
        fruitList.add(apple);
        Fruit banana = new Fruit("banana", R.drawable.banana);
        fruitList.add(banana);
        Fruit grape = new Fruit("grape", R.drawable.grape);
        fruitList.add(grape);
        Fruit orange = new Fruit("orange", R.drawable.orange);
        fruitList.add(orange);
        Fruit peach = new Fruit("peach", R.drawable.peach);
        fruitList.add(peach);
        Fruit pear = new Fruit("pear", R.drawable.pear);
        fruitList.add(pear);
        Fruit pineapple = new Fruit("pineapple", R.drawable.pineapple);
        fruitList.add(pineapple);
        Fruit watermelon = new Fruit("watermelon", R.drawable.watermelon);
        fruitList.add(watermelon);
    }
}
