package com.path.android.jobqueue.examples.twitter.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoConfig;
import de.greenrobot.dao.Property;

import com.path.android.jobqueue.examples.twitter.entities.Tweet;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/**
 * DAO for table TWEET.
*/
public class TweetDao extends AbstractDao<Tweet, Long> {

    public static final String TABLENAME = "TWEET";

    /**
     * Properties of entity Tweet.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property LocalId =new Property(0, Long.class , "localId", true, "LOCAL_ID");
        public final static Property ServerId =new Property(1, Long.class , "serverId", false, "SERVER_ID");
        public final static Property Text =new Property(2, String.class , "text", false, "TEXT");
        public final static Property UserId =new Property(3, Long.class , "userId", false, "USER_ID");
        public final static Property CreatedAt =new Property(4, java.util.Date.class , "createdAt", false, "CREATED_AT");
    };


    public TweetDao(DaoConfig config) {
        super(config);
    }

    public TweetDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'TWEET' (" + //
                "'LOCAL_ID' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: localId
                "'SERVER_ID' INTEGER UNIQUE ," + // 1: serverId
                "'TEXT' TEXT," + // 2: text
                "'USER_ID' INTEGER," + // 3: userId
                "'CREATED_AT' INTEGER);"); // 4: createdAt
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'TWEET'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Tweet entity) {
        stmt.clearBindings();
        entity.onBeforeSave();
 
        Long localId = entity.getLocalId();
        if (localId != null) {
            stmt.bindLong(1, localId);

        }
 
        Long serverId = entity.getServerId();
        if (serverId != null) {
            stmt.bindLong(2, serverId);

        }
 
        String text = entity.getText();
        if (text != null) {
            stmt.bindString(3, text);

        }
 
        Long userId = entity.getUserId();
        if (userId != null) {
            stmt.bindLong(4, userId);

        }
 
        java.util.Date createdAt = entity.getCreatedAt();
        if (createdAt != null) {
            stmt.bindLong(5, createdAt.getTime());

        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }

    /** @inheritdoc */
    @Override
    public Tweet readEntity(Cursor cursor, int offset) {
        Tweet entity = new Tweet( //

            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0) , // localId
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1) , // serverId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2) , // text
            cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3) , // userId
            cursor.isNull(offset + 4) ? null : new java.util.Date( cursor.getLong(offset + 4) ) // createdAt
        );
        return entity;
    }

    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Tweet entity, int offset) {
        entity.setLocalId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0) );
        entity.setServerId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1) );
        entity.setText(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2) );
        entity.setUserId(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3) );
        entity.setCreatedAt(cursor.isNull(offset + 4) ? null : new java.util.Date( cursor.getLong(offset + 4) ) );
     }

    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Tweet entity, long rowId) {
        entity.setLocalId(rowId);
        return rowId;
    }

    /** @inheritdoc */
    @Override
    public Long getKey(Tweet entity) {
        if(entity != null) {
            return entity.getLocalId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override
    protected boolean isEntityUpdateable() {
        return true;
    }

}