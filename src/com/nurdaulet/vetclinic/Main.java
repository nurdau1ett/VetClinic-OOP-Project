package com.nurdaulet.vetclinic;

import com.nurdaulet.vetclinic.menu.Menu;
import com.nurdaulet.vetclinic.menu.VetClinicMenu;

public class Main {
    public static void main(String[] args) {
        Menu menu = new VetClinicMenu();
        menu.run();
    }
}