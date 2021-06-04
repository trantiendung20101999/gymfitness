package com.example.fitnessproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.fitnessproject.model.BaiTap;
import com.example.fitnessproject.model.BuoiTap;
import com.example.fitnessproject.model.BuoiTap_BaiTap;
import com.example.fitnessproject.model.NhomCo;

import java.util.ArrayList;
import java.util.List;


public class SQLiteHelper extends SQLiteOpenHelper {

    static final String DATABASE_NAME = "FitnessDB.db";
    static final int DATABASE_VERSION = 1;


    public SQLiteHelper(@Nullable Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_NHOMCO_SQL ="CREATE TABLE `nhomco` (" +
                "  id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ," +
                "  name TEXT DEFAULT NULL" +
                " " +
                ")";
        db.execSQL(CREATE_NHOMCO_SQL);
        String CREATE_BAITAP_SQL = "CREATE TABLE   baitap (" +
                "  id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "  nhomcoid INTEGER NOT NULL," +
                "  name TEXT DEFAULT NULL," +
                "  image INTEGER NOT NULL," +
                "  video TEXT DEFAULT NULL," +
                "  time INTEGER NOT NULL," +
                "" +
                "" +
                "  CONSTRAINT `FKBaiTap154733` FOREIGN KEY (`NhomCoID`) REFERENCES `NhomCo` (`ID`)" +
                ")";
        db.execSQL(CREATE_BAITAP_SQL);
        String CREATE_BUOITAP_SQL ="CREATE TABLE buoitap (" +
                "  id INTEGER NOT NULL PRIMARY KEY," +
                "  time INTEGER NOT NULL," +
                "  time_stop INTEGER NOT NULL," +
                "  date TEXT DEFAULT NULL" +
                "" +
                ")";
        db.execSQL(CREATE_BUOITAP_SQL);
        String CREATE_BUOITAP_BAITAP_SQL = "CREATE TABLE buoitap_baitap (" +
                "  buoitapid INTEGER NOT NULL," +
                "  baitapid INTEGER NOT NULL," +
                "  PRIMARY KEY (`buoitapid`,`baitapid`)," +
                "  " +
                "  CONSTRAINT `FKBuoiTap_Ba306349` FOREIGN KEY (`baitapid`) REFERENCES `baitap` (`ID`)," +
                "  CONSTRAINT `FKBuoiTap_Ba634398` FOREIGN KEY (`buoitapid`) REFERENCES `buoitap` (`ID`)" +
                ")";
        db.execSQL(CREATE_BUOITAP_BAITAP_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    // INSERT TO TABLE

    public long addNhomCo(NhomCo nhomCo)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",nhomCo.getName());

        SQLiteDatabase statement = getWritableDatabase();
        return statement.insert("nhomco",null,contentValues);
    }

    public long addBaiTap(BaiTap baiTap)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",baiTap.getId());
        contentValues.put("nhomcoid",baiTap.getNhomco().getId());
        contentValues.put("name",baiTap.getName());
        contentValues.put("image",baiTap.getImage());
        contentValues.put("video",baiTap.getVideo());
        contentValues.put("time",baiTap.getTime());

        SQLiteDatabase statement = getWritableDatabase();
        return statement.insert("baitap",null,contentValues);
    }

    public long addBuoiTap(BuoiTap buoiTap)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("time",buoiTap.getTime());
        contentValues.put("time_stop",buoiTap.getTime_stop());
        contentValues.put("date",buoiTap.getDate());

        SQLiteDatabase statement = getWritableDatabase();
        return statement.insert("buoitap",null,contentValues);
    }

    public long addBuoiTap_BaiTap(BuoiTap_BaiTap buoiTap_baiTap)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("buoitapid",buoiTap_baiTap.getBuoitap().getId());
        contentValues.put("baitapid",buoiTap_baiTap.getBaitap().getId());

        SQLiteDatabase statement = getWritableDatabase();
        return statement.insert("buoitap_baitap",null,contentValues);
    }

    // GET ALL IN TABLE

    public List<NhomCo> getAll_Nhomco()
    {
        List<NhomCo> list = new ArrayList<>();

        SQLiteDatabase statement = getReadableDatabase();

        Cursor cursor = statement.query("nhomco",null,null,null,null,null,null);
        while (cursor!=null && cursor.moveToNext())
        {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            NhomCo nhomCo = new NhomCo(id,name);
            list.add(nhomCo);
        }

        return list;
    }

    public List<BaiTap> getAll_Baitap()
    {
        List<BaiTap> list = new ArrayList<>();

        SQLiteDatabase statement = getReadableDatabase();

        Cursor cursor = statement.query("baitap",null,null,null,null,null,null);
        while (cursor!=null && cursor.moveToNext())
        {
            int id = cursor.getInt(0);
            int nhomcoid = cursor.getInt(1);
            String name = cursor.getString(2);
            int image = cursor.getInt(3);
            String video = cursor.getString(4);
            int time = cursor.getInt(5);
            BaiTap baiTap = new BaiTap(id,searchNhomCoById(nhomcoid),name,image,video,time);
            list.add(baiTap);
        }

        return list;
    }
    public List<BuoiTap>getAll_BuoiTap()
    {
        List<BuoiTap> list = new ArrayList<>();

        SQLiteDatabase statement = getReadableDatabase();

        Cursor cursor = statement.query("buoitap",null,null,null,null,null,"date ASC");
        while (cursor!=null && cursor.moveToNext())
        {
            int id = cursor.getInt(0);
            int time = cursor.getInt(1);
            int time_stop = cursor.getInt(2);
            String date = cursor.getString(3);
            BuoiTap buoiTap = new BuoiTap(id,time,time_stop,date);
            list.add(buoiTap);
        }

        return list;
    }

    //
//        String whereClause = "name LIKE ?";
//        String[] whereArgs= {"%"+key+"%"};
//
//        SQLiteDatabase statement = getReadableDatabase();
//
//        Cursor cursor = statement.query("nhomco",null,whereClause,whereArgs,null,null,null);
//        while (cursor!=null && cursor.moveToNext())
//        {
//            int id = cursor.getInt(0);
//            String name = cursor.getString(1);
//            NhomCo nhomCo = new NhomCo(id,name);
//            list.add(nhomCo);
//        }
//
//        return list;
    public List<BaiTap> getBaiTapByNhomCo(NhomCo nhomCo)
    {
        List<BaiTap> list = new ArrayList<>();

        String whereClause = "nhomcoid = ? ";
        String[] whereArgs = {String.valueOf(nhomCo.getId())};

        SQLiteDatabase statement = getReadableDatabase();
        Cursor cursor = statement.query("baitap",null,whereClause,whereArgs,null,null,null);
        while(cursor!=null && cursor.moveToNext())
        {
            int id = cursor.getInt(0);
            int nhomcoid = cursor.getInt(1);
            String name = cursor.getString(2);
            int image = cursor.getInt(3);
            String video = cursor.getString(4);
            int time = cursor.getInt(5);
            BaiTap baiTap = new BaiTap(id,searchNhomCoById(nhomcoid),name,image,video,time);
            list.add(baiTap);
        }
        return list;

    }
    public List<BuoiTap_BaiTap> getBTBTByBuoiTap(BuoiTap buoiTap)
    {
        List<BuoiTap_BaiTap> lists = new ArrayList<>();
        String whereClause = "buoitapid=?";
        String[] whereArgs = {String.valueOf(buoiTap.getId())};
        SQLiteDatabase statement = getReadableDatabase();
        Cursor cursor = statement.query("buoitap_baitap",null,whereClause,whereArgs,null,null,null);
        while(cursor!=null && cursor.moveToNext())
        {
            int buoitapid = cursor.getInt(0);
            int baitapid = cursor.getInt(1);
            BuoiTap_BaiTap buoiTap_baiTap = new BuoiTap_BaiTap();
            buoiTap_baiTap.setBuoitap(searchBuoiTapById(buoitapid));
            buoiTap_baiTap.setBaitap(searchBaiTapById(baitapid));
            lists.add(buoiTap_baiTap);
        }
        return lists;
    }



    //UPDATE IN TABLE

    public int update_Nhomco(NhomCo nhomco  ){
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",nhomco.getId());
        contentValues.put("name",nhomco.getName());
        SQLiteDatabase statement = getWritableDatabase();
        String whereClause = "id = ?";
        String[] whereArgs={Integer.toString(nhomco.getId())};
        return  statement.update("nhomco",contentValues,whereClause,whereArgs);
    }

    public  int update_Buoitap(BuoiTap buoiTap)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",buoiTap.getId());
        contentValues.put("time",buoiTap.getTime());
        contentValues.put("time_stop",buoiTap.getTime_stop());
        contentValues.put("date",buoiTap.getDate());
        SQLiteDatabase statement = getWritableDatabase();
        String whereClause = "id = ?";
        String[] whereArgs={Integer.toString(buoiTap.getId())};
        return  statement.update("buoitap",contentValues,whereClause,whereArgs);
    }

    //DELETE IN TABLE

    public int delete_Nhomco (int id)
    {
        SQLiteDatabase statement = getWritableDatabase();
        String whereClause = "id = ?";
        String[] whereArgs = {Integer.toString(id)};
        return statement.delete("nhomco",whereClause,whereArgs);
    }
    public int deleteall()
    {
        SQLiteDatabase statement = getWritableDatabase();
        return statement.delete("baitap",null,null);
    }

    public int deleteall_buoitap()
    {
        SQLiteDatabase statement = getWritableDatabase();
        return statement.delete("buoitap",null,null);
    }
    public int delete_buoitap(int id)
    {
        SQLiteDatabase statement = getWritableDatabase();
        String whereClause = "id = ?";
        String[] whereArgs = {Integer.toString(id)};
        return statement.delete("buoitap",whereClause,whereArgs);
    }


    //SEARCH IN TABLE

//    public List<NhomCo> searchByName(String key)
//    {
//        List<NhomCo> list = new ArrayList<>();
//
//        String whereClause = "name LIKE ?";
//        String[] whereArgs= {"%"+key+"%"};
//
//        SQLiteDatabase statement = getReadableDatabase();
//
//        Cursor cursor = statement.query("nhomco",null,whereClause,whereArgs,null,null,null);
//        while (cursor!=null && cursor.moveToNext())
//        {
//            int id = cursor.getInt(0);
//            String name = cursor.getString(1);
//            NhomCo nhomCo = new NhomCo(id,name);
//            list.add(nhomCo);
//        }
//
//        return list;
//    }

    public NhomCo searchNhomCoById(int id)
    {
        NhomCo nhomCo = new NhomCo();
        nhomCo.setId(id);
        String whereClause = "id=?";
        String[] whereArgs= {String.valueOf(id)};

        SQLiteDatabase statement = getReadableDatabase();

        Cursor cursor = statement.query("nhomco",null,whereClause,whereArgs,null,null,null);

        if(cursor.moveToNext())
        {
            String name = cursor.getString(1);
            nhomCo.setName(name);
        }
        return nhomCo;
    }

    public NhomCo searchNhomCoByName(String name)
    {
        NhomCo nhomCo = new NhomCo();

        String whereClause = "name=?";
        String[] whereArgs= {name};

        SQLiteDatabase statement = getReadableDatabase();

        Cursor cursor = statement.query("nhomco",null,whereClause,whereArgs,null,null,null);

        if(cursor.moveToNext())
        {
            int id = cursor.getInt(0);
            nhomCo.setId(id);
            nhomCo.setName(name);
        }
        return nhomCo;
    }

    public BaiTap searchBaiTapById(int id)
    {
        BaiTap baiTap = null;
        String whereClause = "id=?";
        String[] whereArgs= {String.valueOf(id)};

        SQLiteDatabase statement = getReadableDatabase();

        Cursor cursor = statement.query("baitap",null,whereClause,whereArgs,null,null,null);

        if(cursor.moveToNext())
        {
            int nhomcoid = cursor.getInt(1);
            String name = cursor.getString(2);
            int image = cursor.getInt(3);
            String video = cursor.getString(4);
            int time = cursor.getInt(5);
            baiTap = new BaiTap(id,searchNhomCoById(nhomcoid),name,image,video,time);

        }
        return baiTap;
    }

    public BuoiTap searchBuoiTapById(int id)
    {
        BuoiTap buoiTap = null;
        String whereClause = "id=?";
        String[] whereArgs= {String.valueOf(id)};

        SQLiteDatabase statement = getReadableDatabase();

        Cursor cursor = statement.query("buoitap",null,whereClause,whereArgs,null,null,null);

        if(cursor.moveToNext())
        {
            int time = cursor.getInt(1);
            int time_stop = cursor.getInt(2);
            String date = cursor.getString(3);
            buoiTap = new BuoiTap(id,time,time_stop,date);

        }
        return buoiTap;
    }


}
