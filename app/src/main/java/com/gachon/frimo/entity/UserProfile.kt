package com.gachon.frimo.entity

data class UserProfile (
    var profileImage: Int, // Todo: 현재는 저장된 그림 파일을 가져오나, 추후 인터넷에서 가져오도록 작업
    var name: String,
    var desc: String
)