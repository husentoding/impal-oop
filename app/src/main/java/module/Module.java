/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module;

import android.content.Context;

/**
 *
 * @author Jorgie Bartelsi P
 */
public abstract class Module {
    public static DatabaseModule db;
    public final static LoginModule   login = new LoginModule(db);

    public Module(Context context) {
        db= new DatabaseModule(context);
    }
}
