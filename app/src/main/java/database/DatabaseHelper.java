package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import model.Employee;

/**
 * Created by husen on 26/11/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    public static final int database_version=1;
    public static final String database_name="db.db";
    public static final String table_user="user_list";
    public static final String col1= "user_id";
    public static final String col2= "username";
    public static final String col3= "userpassword";
    public static final String col4= "name";
    public static final String col5= "address";
    public static final String col6= "user_level";


    public DatabaseHelper(Context context){
        super(context, database_name, null, database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable= "CREATE TABLE " + table_user + "(user_id INTEGER PRIMARY KEY, " +
                "username TEXT, " +
                "userpassword TEXT, " +
                "name TEXT, " +
                "address TEXT, " +
                "user_level INTEGER";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String query= "DROP IF TABLE EXIST" + table_user;
        db.execSQL(query);
        this.onCreate(db);

    }
    public Employee selectEmployee(int id){
        Cursor cursor= getReadableDatabase().rawQuery("SELECT * FROM user_list ", null);
        cursor.moveToFirst();
        int eid=-99;
        while(!cursor.isAfterLast() && eid!=id){
            try {
                id=Integer.parseInt(cursor.getString(cursor.getColumnIndex("user_id")));
            } catch(NumberFormatException nfe) {
                System.out.println("Could not parse " + nfe);
            }
            cursor.moveToNext();
        }
        if(eid==id){
            int eid2= Integer.parseInt(cursor.getString(cursor.getColumnIndex("user_id")));
            String e_username= cursor.getString(cursor.getColumnIndex("username"));
            String e_password= cursor.getString(cursor.getColumnIndex("userpassword"));
            String e_name= cursor.getString(cursor.getColumnIndex("name"));
            String e_address= cursor.getString(cursor.getColumnIndex("address"));
            int e_level= Integer.parseInt(cursor.getString(cursor.getColumnIndex("user_level")));
            Employee e= new Employee(e_level, e_username, e_password, e_name, e_address);
            e.seteID(eid2);
            cursor.close();
            return e;
        }else{
            cursor.close();
            return null;
        }

    }

    public ArrayList<Employee> selectAllEmployee(){
        Cursor cursor= getReadableDatabase().rawQuery("SELECT * FROM user_list", null);
        cursor.moveToFirst();
        ArrayList<Employee> emp= new ArrayList<>();
        while(!cursor.isAfterLast()){
            int eid2= Integer.parseInt(cursor.getString(cursor.getColumnIndex("user_id")));
            String e_username= cursor.getString(cursor.getColumnIndex("username"));
            String e_password= cursor.getString(cursor.getColumnIndex("userpassword"));
            String e_name= cursor.getString(cursor.getColumnIndex("name"));
            String e_address= cursor.getString(cursor.getColumnIndex("address"));
            int e_level= Integer.parseInt(cursor.getString(cursor.getColumnIndex("user_level")));
            Employee e= new Employee(e_level, e_username, e_password, e_name, e_address);
            e.seteID(eid2);
            emp.add(e);
            cursor.moveToNext();
        }
        cursor.close();
        return emp;
    }


    public boolean addEmployee(Employee m) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col1, m.geteID());
        contentValues.put(col2, m.getUsername());
        contentValues.put(col3, m.getPassword());
        contentValues.put(col4, m.getName());
        contentValues.put(col5, m.getAddress());
        contentValues.put(col6, m.getLevel());

        db.insert(table_user, null, contentValues);

        return true;
    }
}
