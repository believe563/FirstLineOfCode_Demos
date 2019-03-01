package com.example.test.RecyclerView;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.test.uidemo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 瀑布流布局，也是用RecyclerView实现
 */
public class StaggeredGridLayoutActivity extends Activity {

    List<Fruit> fruitList = new ArrayList<>();
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered_grid_layout);
        recyclerView = findViewById(R.id.recycler_viewforstaggeredGridlayout);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        initFruit();
        FruitAdapter fruitAdapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(fruitAdapter);
    }

    private void initFruit() {
        Fruit apple = new Fruit(getRandomLengthName("apple"), R.drawable.apple);
        fruitList.add(apple);
        Fruit banana = new Fruit(getRandomLengthName("banana"), R.drawable.banana);
        fruitList.add(banana);
        Fruit grape = new Fruit(getRandomLengthName("grape"), R.drawable.grape);
        fruitList.add(grape);
        Fruit orange = new Fruit(getRandomLengthName("orange"), R.drawable.orange);
        fruitList.add(orange);
        Fruit peach = new Fruit(getRandomLengthName("peach"), R.drawable.peach);
        fruitList.add(peach);
        Fruit pear = new Fruit(getRandomLengthName("pear"), R.drawable.pear);
        fruitList.add(pear);
        Fruit pineapple = new Fruit(getRandomLengthName("pineapple"), R.drawable.pineapple);
        fruitList.add(pineapple);
        Fruit watermelon = new Fruit(getRandomLengthName("watermelon"), R.drawable.watermelon);
        fruitList.add(watermelon);
    }

    public String getRandomLengthName(String name) {
        Random random = new Random();
        int length=random.nextInt(20);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<length;i++){
            stringBuilder.append(name);
        }
        return stringBuilder.toString();
    }
}
