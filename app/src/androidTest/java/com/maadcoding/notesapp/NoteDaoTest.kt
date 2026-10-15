package com.maadcoding.notesapp

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.maadcoding.notesapp.database.Note
import com.maadcoding.notesapp.database.NoteDao
import com.maadcoding.notesapp.database.RoomDBHelper
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NoteDaoTest {

    private lateinit var db: RoomDBHelper
    private lateinit var dao: NoteDao


    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context,
            RoomDBHelper::class.java
        )
            .allowMainThreadQueries()
            .build()

        dao = db.dao
    }


    @After
    fun closeDb() {
        db.close()
    }


    @Test
    fun insertAndSelectNote_returnsInsertedNote() = runBlocking {

        val note = Note(id = 1, content = "Ahmed")

        dao.upsertNote(note)

        val allNotes = dao.getNotes().first()

        assertEquals(note, allNotes[0])
    }
}