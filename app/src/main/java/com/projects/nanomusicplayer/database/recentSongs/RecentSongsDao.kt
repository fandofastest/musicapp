package com.projects.nanomusicplayer.database.recentSongs

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface RecentSongsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addRecentSong(recentSongEntity: RecentSongEntity)


    @Delete
    suspend fun removeRecentSong(recentSongEntity: RecentSongEntity)


    @get:Query("SELECT * from recent_songs_table order by lastPlayed desc")
    val allSongs: LiveData<List<RecentSongEntity>>


}
