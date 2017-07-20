package com.andrebondar.andrepdd.screens.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.andrebondar.andrepdd.Constants;
import com.andrebondar.andrepdd.adapters.ListViewAdapter;
import com.andrebondar.andrepdd.R;
import com.andrebondar.andrepdd.entities.BookRulsEntity;

import java.util.ArrayList;

/**
 * Created by Andre on 23.01.2017.
 */

public class BookListFragment extends Fragment {

    private ListView listView;
    private ArrayList<BookRulsEntity> bookRulsEntityArrayList;

    private FragmentTransaction transaction;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.book_list_fragment, null);

        bookRulsEntityArrayList = new ArrayList<>();
        bookRulsEntityArrayList.add(new BookRulsEntity(1, "Общие положения"));
        bookRulsEntityArrayList.add(new BookRulsEntity(2, "Обязанности и права водителей механических транспортных средств"));
        bookRulsEntityArrayList.add(new BookRulsEntity(3, "Движение транспортных средств со специальными сигналами"));
        bookRulsEntityArrayList.add(new BookRulsEntity(4, "Обязанности и права пешеходов"));
        bookRulsEntityArrayList.add(new BookRulsEntity(5, "Обязанности и права пассажиров"));
        bookRulsEntityArrayList.add(new BookRulsEntity(6, "Требования к велосипедистам"));
        bookRulsEntityArrayList.add(new BookRulsEntity(7, "Требования к лицам, управляющим гужевым транспортом, и погонщикам животных"));
        bookRulsEntityArrayList.add(new BookRulsEntity(8, "Регулирование дорожного движения"));
        bookRulsEntityArrayList.add(new BookRulsEntity(9, "Предупреждающие сигналы"));
        bookRulsEntityArrayList.add(new BookRulsEntity(10, "Начало движения и изменение его направления"));
        bookRulsEntityArrayList.add(new BookRulsEntity(11, "Расположение транспортных средств на дороге"));
        bookRulsEntityArrayList.add(new BookRulsEntity(12, "Скорость движения"));
        bookRulsEntityArrayList.add(new BookRulsEntity(13, "Дистанция, интервал, встречный разъезд"));
        bookRulsEntityArrayList.add(new BookRulsEntity(14, "Обгон"));
        bookRulsEntityArrayList.add(new BookRulsEntity(15, "Остановка и стоянка"));
        bookRulsEntityArrayList.add(new BookRulsEntity(16, "Проезд перекрестков"));
        bookRulsEntityArrayList.add(new BookRulsEntity(17, "Преимущества маршрутных транспортных средств"));
        bookRulsEntityArrayList.add(new BookRulsEntity(18, "Проезд пешеходных переходов и остановок транспортных средств"));
        bookRulsEntityArrayList.add(new BookRulsEntity(19, "Использование внешних световых приборов"));
        bookRulsEntityArrayList.add(new BookRulsEntity(20, "Движение через железнодорожные переезды"));
        bookRulsEntityArrayList.add(new BookRulsEntity(21, "Перевозка пассажиров"));
        bookRulsEntityArrayList.add(new BookRulsEntity(22, "Перевозка груза"));
        bookRulsEntityArrayList.add(new BookRulsEntity(23, "Буксировка и эксплуатация транспортных средств"));
        bookRulsEntityArrayList.add(new BookRulsEntity(24, "Учебная езда"));
        bookRulsEntityArrayList.add(new BookRulsEntity(25, "Движение транспортных средств"));
        bookRulsEntityArrayList.add(new BookRulsEntity(26, "Движение в жилой и пешеходной зоне"));
        bookRulsEntityArrayList.add(new BookRulsEntity(27, "Движение по автомагистралям и дорогам для автомобилей"));
        bookRulsEntityArrayList.add(new BookRulsEntity(28, "Движение по горным дорогам и на крутых спусках"));
        bookRulsEntityArrayList.add(new BookRulsEntity(29, "Международное движение"));
        bookRulsEntityArrayList.add(new BookRulsEntity(30, "Номерные, опозновательные знаки, надписи и обозночения"));
        bookRulsEntityArrayList.add(new BookRulsEntity(31, "Техническое состояние транспортных средств и их оснащение"));
        bookRulsEntityArrayList.add(new BookRulsEntity(32, "Вопросы, требующие согласования с ГАИ"));
        bookRulsEntityArrayList.add(new BookRulsEntity(33, "Дорожные знаки"));
        bookRulsEntityArrayList.add(new BookRulsEntity(34, "Дорожная разметка"));

        //receive ListView from our layout
        listView = (ListView) v.findViewById(R.id.book_list_fragment_list_view);

        //here we create object of our BookListFragment class and set it in our ListView
        listView.setAdapter(new ListViewAdapter(BookListFragment.this, bookRulsEntityArrayList));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                if(position == 0) {
//                    BookParagraphFragment bookParagraphFragment = new BookParagraphFragment();
//                    transaction = getFragmentManager().beginTransaction();
//                    transaction.replace(R.id.content_main, bookParagraphFragment);
//                    transaction.addToBackStack(null);
//                    transaction.commit();
//                }
//                if(position == 1) {
//                    MyFragment myFragment = new MyFragment();
//                    transaction = getFragmentManager().beginTransaction();
//                    transaction.replace(R.id.content_main, myFragment);
//                    transaction.addToBackStack(null);
//                    transaction.commit();
//                }
//                if(position == 2) {
//                }
//                if(position == 3) {
//
//                }
//                if(position == 4) {
//                }
                BookParagraphFragment bookParagraphFragment = new BookParagraphFragment();
                Bundle bundle = new Bundle();
                bundle.putInt(Constants.CURRENT_PARAGRAPH, position);
                bookParagraphFragment.setArguments(bundle);
                transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.content_main, bookParagraphFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return v;
    }
}
