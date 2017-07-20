package com.andrebondar.andrepdd;

import android.content.Context;
import android.content.SharedPreferences;

import com.andrebondar.andrepdd.entities.UserEntity;
import com.google.gson.Gson;

/**
 * Created by Andre on 08.01.2017.
 */

public class Utils {

    public static void saveUserEntity(Context context, UserEntity userEntity) {
        //получаем некий объект, который позволяет сохранять нам данные
        final SharedPreferences prefs = context.getSharedPreferences(Constants.USER_ENTITY, Context.MODE_PRIVATE);
        //используем Editor, к-рый позволяет записывать и читать данные (Builder?)
        SharedPreferences.Editor editor = prefs.edit();
        //создаем объект, в к-рый будем ложить инфу о пользователе
        Gson gson = new Gson();
        //переобразовываем инфу - объект -  в строку (что тут происходит???)
        String json = gson.toJson(userEntity);
        editor.putString(Constants.USER_ENTITY, json);
        editor.commit();
    }

    public static UserEntity loadUserEntity(Context context) {
        final SharedPreferences prefs = context.getSharedPreferences(Constants.USER_ENTITY, Context.MODE_PRIVATE);
        //создаем объкт класса Gson, в котором мы сожем распарсить данные из JSON
        Gson gson = new Gson();
        /*
        берем из SharedPreferences строку по ключу USER_ENTITY
        пустые кавычки говорят, что может быть такое состояние, что объекта там
        не будет. И если его нет, то метод возвращает эти пустые кавычки.
         */
        String json = prefs.getString(Constants.USER_ENTITY, "");
        //gson может обратиться к полям нашего UserEntity и сообщить, что эти
        //поля, которые были в json, мы можем восстановить по таким же полям,
        //которые есть у нас в классе.
        /*
        gson говорит, что из Json'а (метод fromJson), из строки json берутся поля
        и мапингуются (отображаются) в полях класса UserEntity (соответственно:
        id - id, name - name, etc) - этот процесс называется мапингом
         */
        return gson.fromJson(json, UserEntity.class);
    }

}
