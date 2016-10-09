package com.example.toni.pruebatabs;

/**
 * Created by Toni on 08/10/2016.
 */

public class Casillas {

    private static Casilla[] personal = {
            new Casilla(
                    "Personal list",
                    R.drawable.shop),
            new Casilla(
                    "Tutorials",
                    R.drawable.washing),

            new Casilla("Here you can prepare your own shopping list, and consult many useful " +
                    "tutorials.")
    };

    private static Casilla[] home = {
            new Casilla(
                    "Home list",
                    R.drawable.shop),
            new Casilla(
                    "Home tasks",
                    R.drawable.list),
            new Casilla(
                    "Home events",
                    R.drawable.calendar),
            new Casilla(
                    "Naughty night ;)",
                    R.drawable.heart),

            new Casilla("Here you can planify the tasks of the week, prepare the shopping list," +
                    "create and consult events of your mates that are celebrating at the " +
                    "apartament.")
    };

    public static Casilla[] getPersonal() {
        return personal;
    }

    public static Casilla[] getHome() {
        return home;
    }
}
