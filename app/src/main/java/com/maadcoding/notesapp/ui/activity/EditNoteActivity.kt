package com.maadcoding.notesapp.ui.activity

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.maadcoding.notesapp.database.Note
import com.maadcoding.notesapp.ui.viewmodel.NoteViewModel

@Composable
fun EditNoteScreen(
    note: Note,
    modifier: Modifier = Modifier,
    viewModel: NoteViewModel = viewModel(),
    onBack: () -> Unit
) {
    val context = LocalContext.current

    val noteFieldState = rememberTextFieldState(initialText = note.content)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp)
    ) {
        OutlinedTextField(
            state = noteFieldState,
            label = { Text("Note details") },
            modifier = Modifier
                .padding(top = 64.dp)
                .fillMaxWidth()
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp)
        ) {
            OutlinedButton(
                onClick = {
                    val updatedNote = Note(note.id, noteFieldState.text.toString())
                    viewModel.upsert(updatedNote)
                    Toast.makeText(context, "Updated!", Toast.LENGTH_SHORT).show()
                    onBack()
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Update")
            }
            OutlinedButton(
                onClick = {
                    viewModel.delete(note)
                    Toast.makeText(context, "Deleted!", Toast.LENGTH_SHORT).show()
                    onBack()
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
            ) {
                Text(text = "Delete")
            }
        }
    }
}