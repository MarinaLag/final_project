package by.itclass.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor  // конструктор не совсеми полями,обозначили их как  @NonNull
// (для создания с поролем и без пороля)
@Data // геттеры и сеттеры
public class User {
    private int id;
    @NonNull    // не может быть null
    private String login;
    @NonNull
    private String name;
    @NonNull
    private String email;
    // пороль храним в базе данных, НО пороль в поля не пишем !!!!
    // т.е. будем запрашиваь в БД и сверять с тем, что ввел пользователь



}
