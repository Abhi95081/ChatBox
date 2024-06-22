package com.example.chatbox

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.chatbox.components.ChatFooter
import com.example.chatbox.components.ChatHeader
import com.example.chatbox.components.Chatlist
import com.example.chatbox.components.rotateAnimation

@Composable
fun ChatBot(
    viewModel: ChatBotVM=  viewModel()
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        ChatHeader()

        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center

        ){
            if(viewModel.list.isEmpty()){
              rotateAnimation()
            }
            Chatlist(list = viewModel.list)

        }

        ChatFooter {
            if(it.isNotEmpty()){
            viewModel.sendMessage(it)
            }
        }
    }
    
}