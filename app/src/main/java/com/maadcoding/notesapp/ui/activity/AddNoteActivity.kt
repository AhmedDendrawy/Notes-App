package com.maadcoding.notesapp.ui.activity

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.input.clearText
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.maadcoding.notesapp.database.Note
import com.maadcoding.notesapp.ui.viewmodel.NoteViewModel

@Composable
fun AddNoteScreen(
    modifier: Modifier = Modifier,
    viewModel: NoteViewModel = viewModel(),
    onBack: () -> Unit
) {
    val context = LocalContext.current
    val noteFieldState = rememberTextFieldState()

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

        OutlinedButton(
            onClick = {
                val content = noteFieldState.text.toString()
                if (content.isNotBlank()) {
                    val note = Note(content = content)
                    viewModel.upsert(note)
                    Toast.makeText(context, "Saved", Toast.LENGTH_LONG).show()
                    noteFieldState.clearText()
                    onBack()
                }
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 32.dp)
        ) {
            Text(text = "Save")
        }
    }
}