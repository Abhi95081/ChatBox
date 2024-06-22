package com.example.chatbox;

sealed interface ChatBotState {

    data object ideal : ChatBotState

    data object loading: ChatBotState

    data class success (val chatData : String) : ChatBotState

    data class error(val chaterror: String) : ChatBotState
}
