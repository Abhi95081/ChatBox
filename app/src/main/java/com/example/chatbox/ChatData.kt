package com.example.chatbox

 data class ChatData (
     val message : String,
     val role : String
 )

enum class chatRoleenum(val role : String){

    USER("user"),
    MODEL("Model")
}
