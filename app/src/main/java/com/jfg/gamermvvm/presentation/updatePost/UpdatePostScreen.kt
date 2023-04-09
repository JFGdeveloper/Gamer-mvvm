package com.jfg.gamermvvm.presentation.updatePost

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jfg.gamermvvm.domain.model.Post
import com.jfg.gamermvvm.presentation.screens.Composables.DefaultButton
import com.jfg.gamermvvm.presentation.screens.Composables.DefaultTopAppbar
import com.jfg.gamermvvm.presentation.screens.new_post.components.OnValidateNewPost
import com.jfg.gamermvvm.presentation.screens.posts.components.ValidateMyPost
import com.jfg.gamermvvm.presentation.updatePost.components.UpdatePostContent
import com.jfg.gamermvvm.presentation.updatePost.components.ValidateUpdatePost

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun UpdatePostScreen(controller: NavHostController, post: String, viewModel: UpdatePostViewModel = hiltViewModel()) {
    Scaffold(
            topBar = {
                DefaultTopAppbar(title = "Update post", backAvailable = true, controller = controller)
            },
             content = {
                UpdatePostContent(vm = viewModel)
             },
            bottomBar = {
                DefaultButton(
                        text = "Update",
                        icon = Icons.Default.ArrowForward,
                        modifier = Modifier.fillMaxWidth()
                ) {
                    viewModel.onUpdatePost()
                }
            }
    )

    ValidateUpdatePost()
}