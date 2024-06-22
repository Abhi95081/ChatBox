package com.example.chatbox

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.chatbox.components.api
import com.google.ai.client.generativeai.Chat
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.launch

class ChatBotVM : ViewModel() {
    val list by lazy {
        mutableStateListOf<ChatData>()
    }
    private  val genAI by lazy {
     GenerativeModel(

         modelName = "gemini-pro",
         apiKey = api
     )
    }

    fun sendMessage(message:String) = viewModelScope.launch {

        val chat : Chat = genAI.startChat()

        list.add(ChatData(message,chatRoleenum.USER.role))

        chat.sendMessage(
            content(chatRoleenum.USER.role){text(message)}
        ).text?.let{
            list.add(ChatData(it,chatRoleenum.MODEL.role))
        }



    }
}