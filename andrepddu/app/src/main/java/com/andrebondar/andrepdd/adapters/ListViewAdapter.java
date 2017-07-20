package com.andrebondar.andrepdd.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.andrebondar.andrepdd.R;
import com.andrebondar.andrepdd.screens.fragments.BookListFragment;
import com.andrebondar.andrepdd.entities.BookRulsEntity;

import java.util.List;

/**
 * Created by Andre on 09.01.2017.
 */

public class ListViewAdapter extends BaseAdapter {

    List<BookRulsEntity> bookRulsEntityList;
    BookListFragment bookListFragment;

    //receive BookListAdapter object and List object of items, from which we will create visual list
    public ListViewAdapter(BookListFragment bookListFragment, List<BookRulsEntity> bookRulsEntityList) {
        this.bookRulsEntityList = bookRulsEntityList;
        this.bookListFragment = bookListFragment;
    }

    //this method return size of List, whose items will be in our visual list
    @Override
    public int getCount() {
        return bookRulsEntityList.size();
    }

    @Override
    public Object getItem(int position) {
        return bookRulsEntityList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    /*
    convertView - наш один элемент
    parent - родитель нашего элемента, т.е. разметка, в которой он находиться (файл)
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        HolderView holder;

        //revision, was the our View created
        if(row == null) {
            //here we get context from our derived BookListFragment object
            LayoutInflater inflater = LayoutInflater.from(bookListFragment.getContext());
            /*
            В первом параметре указывается идентификатор ресурса разметки, который мы
            собираемся заполнить(надуть). Во втором параметре указывается корневой компонент, к
            которому нужно присоединить заполненные объекты. В третьем параметре (если он
            используется) указывается, нужно ли присоединять заполненные объекты к корневому
            элементу.
            Тогда зачем нам этот родительский элемент? Проблемы могут возникнуть при использовании
            атрибутов android:layout_xxx в родительском элементе. В результате, не зная ничего о
            родителе, мы не можем использовать его LayoutParams и система будет игнорировать вашу
            разметку. А вы будете думать, что это баг.
             */
            row = inflater.inflate(R.layout.item_list_view, parent, false);
            holder = new HolderView();
            holder.imageView = (ImageView) row.findViewById(R.id.item_list_view_image_view);
            holder.textView = (TextView) row.findViewById(R.id.item_list_view_text_view_name);

            row.setTag(holder);
        } else {
            //приводим уже созданный элемент к ViewHolder и присваемваем его holder
            //с текущими значениями
            holder = (HolderView) convertView.getTag();
        }

        //а здесь уже устанавливаем новые значения из нашего списка
        holder.textView.setText(bookRulsEntityList.get(position).getParagraph());

        return row;
    }

    class HolderView {
        ImageView imageView;
        TextView textView;
    }
}
