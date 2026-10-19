package com.maadcoding.notesapp.ui.navigation

import com.maadcoding.notesapp.ui.activity.HomeScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import kotlinx.serialization.Serializable
import com.maadcoding.notesapp.database.Note
import com.maadcoding.notesapp.ui.activity.AddNoteScreen
import com.maadcoding.notesapp.ui.activity.EditNoteScreen

@Serializable
object HomeRoute : NavKey

@Serializable
object AddNoteRoute : NavKey

@Serializable
class EditNoteRoute(val note: Note) : NavKey

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val backStack = rememberNavBackStack(HomeRoute)

    NavDisplay(
        backStack = backStack,
        entryProvider = entryProvider {

            entry<HomeRoute> {
                HomeScreen(
                    onNavigateToAdd = {
                        backStack.add(AddNoteRoute)
                    },
                    onNavigateToEdit = { note ->
                        backStack.add(EditNoteRoute(note))
                    }
                )
            }

            entry<AddNoteRoute> {
                AddNoteScreen(
                    onBack = { backStack.removeLastOrNull() }
                )
            }

            entry<EditNoteRoute> {

                EditNoteScreen(
                    note = it.note,
                    onBack = { backStack.removeLastOrNull() }
                )
            }

        },
        modifier = modifier
    )
}